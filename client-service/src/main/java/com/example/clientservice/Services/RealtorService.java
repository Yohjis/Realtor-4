package com.example.clientservice.Services;

import com.example.clientservice.Models.Payment;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class RealtorService {
    public void engageRealtor() {
        String address = "http://localhost:8080/realtors/";
        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).queryParam("name", "Alexx")
                .queryParam("surname", "Alexeev");
        System.out.println("New realtor was engaged to work.");
        HttpEntity<Payment> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, null,
                Payment.class);
        System.out.println(response.getBody());

        builder = UriComponentsBuilder.fromHttpUrl(address).queryParam("name", "Oleg").queryParam("surname", "Olegov");
        System.out.println("New realtor was engaged to work.");
        response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, null, Payment.class);
        System.out.println(response.getBody());

        builder = UriComponentsBuilder.fromHttpUrl(address).queryParam("name", "Ann").queryParam("surname", "Annovna");
        System.out.println("New realtor was engaged to work.");
        response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, null, Payment.class);
        System.out.println(response.getBody());
    }

    public void realtorReview() {
        String address = "http://localhost:8080/realtors/";
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("Realtors list:");

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address);

        HttpEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);
        System.out.println(response.getBody());
    }
}