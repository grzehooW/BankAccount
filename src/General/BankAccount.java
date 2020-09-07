package General;

import java.util.Scanner;

public class BankAccount {

    Scanner scanner = new Scanner(System.in);
    Account[] accounts = new Account[3];
    char[] pinNoEntered;
    int amountToWithdraw;

    public static void main(String[] args) {



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