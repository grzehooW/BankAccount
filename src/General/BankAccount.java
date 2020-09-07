package General;

import java.io.Console;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccount {

    Scanner scanner = new Scanner(System.in);
    Account[] accounts = new Account[3];
    char[] pinNoEntered;
    int amountToWithdraw;

    public static void main(String[] args) {

        BankAccount ba = new BankAccount();
        ba.createAccounts();

        do {
            System.out.println("\n************************************************************");
            System.out.println("\n****************Welcome to my Bank**************************");
            ba.validatePINno();
        }while (true);

    }

    public void createAccounts(){

        accounts[0] = new Account("45646432",new char[]{'3','4','3','5'},"Julian","King",100);
        accounts[1] = new Account("48593741",new char[]{'8','2','4','6'},"Anne","Williams",100);
        accounts[2] = new Account("15432432",new char[]{'6','1','5','7'},"Derek","James",100);

    }

    public void validatePINno(){

        Console console = System.console();
        boolean pinFound = false;

        do {

            System.out.print("\nEnter your PIN no: ");
            pinNoEntered = console.readPassword();

            for (Account account : accounts){
                if (Arrays.toString(pinNoEntered).equals(Arrays.toString(account.getPin()))){
                    pinFound = true;
                    break;
                }
            }
            if (!pinFound){
                System.out.println("Invalid Pin no. entered. ");
            }else {
                System.out.println("PIN validate!.");
                requestWithdrawal();
            }
        }while (pinFound != true);
    }

    private void requestWithdrawal() {

        boolean validWithdrawal = false;
        int withdrawalAmounts[] = {20,40,60,80,100,200};

        System.out.println("\nThe maximum withdrawal amount is 200");
        System.out.println("\nEnter an amount: 20 | 40 | 60 | 80 | 100 | 200 ");

        do {

            System.out.println("\nEnter amount to withdrawal: ");
            try{
                amountToWithdraw = scanner.nextInt();
                for (int valid_amount : withdrawalAmounts){
                    if (valid_amount == amountToWithdraw){
                        validWithdrawal = true;
                        break;
                    }
                }
                if (!validWithdrawal){
                    System.out.println("Valid data entered. ");
                }
            }catch (InputMismatchException ex){
                System.out.println("Data entry must be numeric and must not contain a decimal point.");
                scanner.nextLine();
            }


        }while (validWithdrawal != true);

        makeWithdrawal();
        scanner.nextLine();
    }

    private void makeWithdrawal() {

        for (Account account : accounts){
            if (account.getBalance() >= amountToWithdraw){
                System.out.println("Cash dispensed: " + amountToWithdraw);
                account.setBalance((account.getBalance() - amountToWithdraw));
                System.out.println("Your new Balance is : " + account.getBalance());
                System.out.println("Have nice day.");
            }else {
                System.out.println("Insufficient found. ");
                System.out.println("Existing balance is: " + account.getBalance());
                System.out.println("Try again");
                requestWithdrawal();
            }
        }

    }


}

class Account{

    private String account_number;
    private char[] pin;
    private String firstName;
    private String lastName;
    private float balance;

    public Account(String account_number, char[] pin, String firstName, String lastName, float balance) {
        this.account_number = account_number;
        this.pin = pin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public char[] getPin() {
        return pin;
    }

    public void setPin(char[] pin) {
        this.pin = pin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}