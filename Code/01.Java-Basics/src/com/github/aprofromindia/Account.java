package com.github.aprofromindia;

import java.math.BigDecimal;

/**
 * Created by Apro on 26.04.17.
 */

public class Account {

    private BigDecimal balance;

    Account(double balance) {
        this.balance = new BigDecimal(balance);
    }

    void deposit(double amount) {
        balance = balance.add(new BigDecimal(amount));
    }

    void withdraw(double amount) {
        balance = balance.subtract(new BigDecimal(amount));
    }

    @Override
    public String toString() {
        return "Current account balance is - " + balance.toString();
    }
}
