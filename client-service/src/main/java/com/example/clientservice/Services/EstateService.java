package com.example.clientservice.Services;

import com.example.clientservice.Enums.EstateAddress;
import com.example.clientservice.Enums.EstateBuilding;
import com.example.clientservice.Enums.EstateDistrict;

import com.example.clientservice.Models.Payment;

import com.example.clientservice.Enums.EstateRooms;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class EstateService {
    public void createEstates() {
        String address = "http://localhost:8080/estates/";
        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address)
                .queryParam("district", EstateDistrict.Solomianskyi)
                .queryParam("Address", EstateAddress.Metalistiv)
                .queryParam("Building", EstateBuilding.Stalin_project)
                .queryParam("Rooms", EstateRooms.one_room)
                .queryParam("price", 2100);
        System.out.println("New estate was posted to feed.");
        HttpEntity<Payment> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, null,
                Payment.class);
        System.out.println(response.getBody());

        builder = UriComponentsBuilder.fromHttpUrl(address)
                .queryParam("District", EstateDistrict.Holosiivskyi)
                .queryParam("Address", EstateAddress.Lisogorska)
                .queryParam("Building", EstateBuilding.Stalin_project)
                .queryParam("Rooms", EstateRooms.two_rooms)
                .queryParam("price", 3600);
        System.out.println("New estate was posted to feed.");
        response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, null, Payment.class);
        System.out.println(response.getBody());

        builder = UriComponentsBuilder.fromHttpUrl(address)
                .queryParam("District", EstateDistrict.Shevchenkivskyi)
                .queryParam("Address", EstateAddress.Viborsga)
                .queryParam("Building", EstateBuilding.Khrushev_project)
                .queryParam("Rooms", EstateRooms.three_rooms)
                .queryParam("price", 53600);
        System.out.println("New estate was posted to feed.");
        response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, null, Payment.class);
        System.out.println(response.getBody());

        builder = UriComponentsBuilder.fromHttpUrl(address)
                .queryParam("District", EstateDistrict.Dniprovskyi)
                .queryParam("Address", EstateAddress.Nishneyrkovska)
                .queryParam("Building", EstateBuilding.new_building)
                .queryParam("Rooms", EstateRooms.one_room)
                .queryParam("price", 46600);
        System.out.println("New estate was posted to feed.");
        response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, null, Payment.class);
        System.out.println(response.getBody());

    }

    public void estateReview() {
        String address = "http://localhost:8080/estates/";
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("Estates list:");

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address);

        HttpEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null,
                String.class);
        System.out.println(response.getBody());
    }

    public void sellEstate(String paymentId, String estateId) {
        String address = "http://localhost:8080/estates";
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address)
                .queryParam("paymentId", paymentId).queryParam("estateId", estateId);
        HttpEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.DELETE, null,
                String.class);
        System.out.println(response.getBody());
    }
}