package com.example.clientservice.Services.grpc;

import com.example.grpc.server.grpcserver.realtor.CreateRequest;
import com.example.grpc.server.grpcserver.realtor.DeleteRequest;
import com.example.grpc.server.grpcserver.realtor.RealtorServiceGrpc;
import com.example.grpc.server.grpcserver.realtor.GetRequest;
import com.example.grpc.server.grpcserver.realtor.GetResponse;
import com.example.grpc.server.grpcserver.realtor.ProtoRealtor;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.List;

public class GrpcRealtorService {
    public void realtorReview() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091).usePlaintext().build();
        RealtorServiceGrpc.RealtorServiceBlockingStub stub = RealtorServiceGrpc.newBlockingStub(channel);

        GetResponse response = stub.get(GetRequest.newBuilder().build());
        channel.shutdown();

        List<ProtoRealtor> realtors = response.getRealtorsList();
        String review = "REALTORS REVIEW:";

        for (ProtoRealtor protoRealtor : realtors) {
            review += protoRealtor.getName() + " " + protoRealtor.getSurname();
        }

        System.out.println(review);
    }

    public void createRealtors() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091).usePlaintext().build();
        RealtorServiceGrpc.RealtorServiceBlockingStub stub = RealtorServiceGrpc.newBlockingStub(channel);

        ProtoRealtor protoRealtor = ProtoRealtor.newBuilder().setName("Maria").setSurname("Mariana").build();

        stub.create(CreateRequest.newBuilder().setRealtor(protoRealtor).build());
        channel.shutdown();
    }

    public void deleteRealtor(String id) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091).usePlaintext().build();
        RealtorServiceGrpc.RealtorServiceBlockingStub stub = RealtorServiceGrpc.newBlockingStub(channel);

        stub.delete(DeleteRequest.newBuilder().setId(id).build());
        channel.shutdown();
    }
}