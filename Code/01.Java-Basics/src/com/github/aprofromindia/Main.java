package com.github.aprofromindia;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        double amount = 0;
        Account account = new Account(amount);
        String input;

        do {
            System.out.println("Please enter you next choice - open('o')/deposit('d')/withdraw('w')/quit('q') ");
            input = scanner.next();
            switch (input) {
                case "o":
                    System.out.println("Please enter initial balance.");
                    amount = scanner.nextDouble();
                    account = new Account(amount);
                    System.out.println(account);
                    break;
                case "d":
                    System.out.println("Please enter the deposit amount.");
                    amount = scanner.nextDouble();
                    account.deposit(amount);
                    System.out.println(account);
                    break;
                case "w":
                    System.out.println("Please enter the withdrawal amount.");
                    amount = scanner.nextDouble();
                    account.withdraw(amount);
                    System.out.println(account);
                    break;
                default:
            }

        } while (!input.equals("q"));
    }
}
