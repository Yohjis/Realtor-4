package com.example.clientservice;

import java.util.Scanner;

import com.example.clientservice.Services.EstateService;
import com.example.clientservice.Services.PaymentService;
import com.example.clientservice.Services.RealtorService;
import com.example.clientservice.Services.grpc.GrpcEstateService;
import com.example.clientservice.Services.grpc.GrpcPaymentService;
import com.example.clientservice.Services.grpc.GrpcRealtorService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientServiceApplication {

    public static void main(String[] args) {

        Scanner yourInput = new Scanner(System.in);
        System.out.println("\nWELCOME TO THE REAL-ESTATE PROCESS!\n");

        // gRPC
        System.out.println("gRPC:");

        GrpcRealtorService realtors = new GrpcRealtorService();
        realtors.realtorReview();
        realtors.createRealtors();
        realtors.realtorReview();

        GrpcPaymentService payments = new GrpcPaymentService();
        payments.paymentReview();
        payments.createPayments();
        payments.paymentReview();

        GrpcEstateService estates = new GrpcEstateService();
        estates.estateReview();
        estates.createEstates();
        estates.estateReview();

        System.out.println("Enter ID of payment you're working with:");
        String paymentId = yourInput.nextLine();

        System.out.println("Now write an ID of the hookah, which should be sold:");
        String estateId = yourInput.nextLine();

        estates.sellEstate(paymentId, estateId);
        System.out.println("Money were added to the balance:");
        payments.paymentReview();


        // REST
        System.out.println("REST:");

        PaymentService newPayment = new PaymentService();
        RealtorService newRealtor = new RealtorService();
        EstateService newEstate = new EstateService();

        newPayment.createPayment();
        newRealtor.engageRealtor();
        newEstate.createEstates();

        newPayment.paymentReview();
        newRealtor.realtorReview();
        newEstate.estateReview();

        System.out.println("Let's try to sell some TOBAKKO.\n");
        System.out.println("You need to write an ID of the payment (desk) where the transaction will be processed :");
        String f_paymentId = yourInput.nextLine();

        System.out.println("Now write an ID of the hookah, which should be sold:");
        String f_estateId = yourInput.nextLine();

        newEstate.sellEstate(f_paymentId, f_estateId);
        System.out.println("Transaction occured.");
        newPayment.paymentReview();

        System.out.println("\nPROGRAM WORK WAS FINISHED!");

    }

}