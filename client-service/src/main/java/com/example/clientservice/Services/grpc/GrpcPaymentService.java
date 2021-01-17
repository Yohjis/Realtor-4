package com.example.clientservice.Services.grpc;


import com.example.grpc.server.grpcserver.payment.CreateRequest;
import com.example.grpc.server.grpcserver.payment.DeleteRequest;
import com.example.grpc.server.grpcserver.payment.GetRequest;
import com.example.grpc.server.grpcserver.payment.GetResponse;
import com.example.grpc.server.grpcserver.payment.PaymentServiceGrpc;
import com.example.grpc.server.grpcserver.payment.ProtoPayment;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.List;

public class GrpcPaymentService {
    public void paymentReview() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091).usePlaintext().build();
        PaymentServiceGrpc.PaymentServiceBlockingStub stub = PaymentServiceGrpc.newBlockingStub(channel);

        GetResponse response = stub.get(GetRequest.newBuilder().build());
        channel.shutdown();

        List<ProtoPayment> payments = response.getPaymentsList();
        String review = "PAYMENTS REVIEW:";

        for (ProtoPayment payment : payments) {
            review += payment.getDesk() + " " + payment.getAddedQuantity();
        }

        System.out.println(review);
    }

    public void createPayments() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091).usePlaintext().build();
        PaymentServiceGrpc.PaymentServiceBlockingStub stub = PaymentServiceGrpc.newBlockingStub(channel);

        ProtoPayment protoPayment = ProtoPayment.newBuilder().setDesk(3).setAddedQuantity(0).build();

        stub.create(CreateRequest.newBuilder().setPayment(protoPayment).build());
        channel.shutdown();
    }

    public void deletePayment(String id) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091).usePlaintext().build();
        PaymentServiceGrpc.PaymentServiceBlockingStub stub = PaymentServiceGrpc.newBlockingStub(channel);

        stub.delete(DeleteRequest.newBuilder().setPaymentId(id).build());
        channel.shutdown();
    }

}