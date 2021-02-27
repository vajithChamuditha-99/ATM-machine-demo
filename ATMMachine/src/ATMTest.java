import java.util.InputMismatchException;
import java.util.Scanner;

public class ATMTest {
    private static Scanner scanner = new Scanner(System.in);

    private static final String message = "\nPlease select one of the following options\n"
            + "1: View balance\n"
            + "2: Withdraw amount\n"
            + "3: Deposit amount\n"
            + "4: Quit\n";

//    private static int[] accountNumbers = {1000, 1001, 1002, 1003};
//    private static String[] accountHolders = {"Shalinie", "Dharana", "Sadesh", "Nadun"};
//    private static double[] accountBalances = {10000, 30000, 20000, 15000};

    private static Account[] accounts = new Account[2];

    public static void main(String[] args) {
        Account acc1 = new Account(1000, "Shalanie", 10000);

        Account acc2 = new Account();
        acc2.setAccountHolder("Dharana");
        acc2.setAccountNo(1001);
        acc2.setBalance(30000);

        accounts[0] = acc1;
        accounts[1] = acc2;

        while(true){
            System.out.println("Welcome to ABC bank !!!");
            System.out.print("Please enter your account number: ");
            int inputtedAccountNo = scanner.nextInt();
//            int indexOfInputtedAccountNo = getAccountIndex(inputtedAccountNo);
//
//            if(indexOfInputtedAccountNo == -1){
//                System.err.println("Account not found.");
//                continue;
//            }

            Account accountFound = getAccount(inputtedAccountNo);
            if(accountFound == null){
                System.err.println("Account not found.");
                continue;
            }

            System.out.printf("Hi %s\n", accountFound.getAccountHolder());
            int selectedOption = 0;
            do{
                selectedOption = getChoice();
                switch (selectedOption){
                    case 1:
                        //view balance
                        printBalance(accountFound);
                        break;
                    case 2:
                        //withdraw amount
                        break;
                    case 3:
                        //deposit amount
                        break;
                }
            } while(selectedOption != 4);
            System.out.println("-------------------------------------------");
        }
    }

//    private static int getAccountIndex(int accountNo) {
//        int index = -1;
//        for (int i = 0; i < accountNumbers.length; i++) {
//            if (accountNumbers[i] == accountNo) {
//                index = i;
//                break;
//            }
//        }
//        return index;
//    }

    private static Account getAccount(int accountNo) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getAccountNo() == accountNo) {
                return accounts[i];
            }
        }
        return null;
    }

    private static int getChoice() {
        do {
            System.out.println(message);
            int option = 0;
            try {
                option = scanner.nextInt();

                if (option < 1 || option > 4) {
                    System.err.println("Please choose a valid option");
                } else {
                    return option;
                }
            } catch (InputMismatchException ex) {
                System.err.println("Please choose a valid option");
                scanner.next();
            }
        } while (true);
    }

//    private static void printBalance(int index) {
//        System.out.printf("Your account balance is: %.2f \n", accountBalances[index]);
//    }

    private static void printBalance(Account account) {
        System.out.printf("Your account balance is: %.2f \n", account.getBalance());
    }
}
