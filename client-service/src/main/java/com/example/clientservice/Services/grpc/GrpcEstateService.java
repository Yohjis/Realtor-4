package com.example.clientservice.Services.grpc;

import com.example.grpc.server.grpcserver.estate.CreateRequest;
import com.example.grpc.server.grpcserver.estate.DeleteRequest;
import com.example.grpc.server.grpcserver.estate.GetRequest;
import com.example.grpc.server.grpcserver.estate.GetResponse;
import com.example.grpc.server.grpcserver.estate.ProtoEstate;
import com.example.grpc.server.grpcserver.estate.EstateServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.List;

public class GrpcEstateService {
    public void estateReview() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091).usePlaintext().build();
        EstateServiceGrpc.EstateServiceBlockingStub stub = EstateServiceGrpc.newBlockingStub(channel);

        GetResponse response = stub.get(GetRequest.newBuilder().build());
        channel.shutdown();

        List<ProtoEstate> estates = response.getEstatesList();
        String review = "ESTATE REVIEW:";

        for (ProtoEstate estate : estates) {
            System.out.println(estate);
            review += estate.getDistrict() + " " + estate.getAddress() + estate.getBuilding() + " " + estate.getRooms() + " " + estate.getPrice();
        }

        System.out.println(review);
    }

    public void createEstates() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9089).usePlaintext().build();
        EstateServiceGrpc.EstateServiceBlockingStub stub = EstateServiceGrpc.newBlockingStub(channel);

        ProtoEstate protoEstate = ProtoEstate.newBuilder().setDistrict("Solomianskyi").setAddress("Metalistib").setBuilding("Stalin_project").setRooms("one_room")
                .setPrice(3700).build();

        stub.create(CreateRequest.newBuilder().setEstate(protoEstate).build());
        channel.shutdown();
    }

    public void sellEstate(String paymentId, String estateId) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9089).usePlaintext().build();
        EstateServiceGrpc.EstateServiceBlockingStub stub = EstateServiceGrpc.newBlockingStub(channel);

        stub.delete(DeleteRequest.newBuilder().setPaymentId(paymentId).setEstateId(estateId).build());
        channel.shutdown();
    }

}