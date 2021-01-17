package com.example.clientservice.Models;

import java.util.UUID;

public final class Payment {

    private String id;
    private int desk;
    private int estateBalance;

    public Payment(int desk, int hookahBalance) {
        this.id = UUID.randomUUID().toString();
        this.desk = desk;
        this.estateBalance = estateBalance;
    }

    public Payment() {

    }

    public String getId() {
        return id;
    }

    public int getEstateBalance() {
        return estateBalance;
    }

    public int getDesk() {
        return desk;
    }

    public void setEstateBalance(int estateBalance) {
        this.estateBalance = estateBalance;
        System.out.println(
                "Estate place balance: " + estateBalance + "\nPayment id: " + id + "\nPayment desk number: " + desk);
    }

    @Override
    public String toString() {
        return "Desk number: " + desk + ". Money balance: " + estateBalance + ". Desk id: " + id;
    }

}