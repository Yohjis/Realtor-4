package com.example.clientservice.Services;

import com.example.clientservice.Models.Payment;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class PaymentService {
    public void createPayment() {
        String address = "http://localhost:8080/payments/";
        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).queryParam("desk", 5)
                .queryParam("estateBalance", 50);
        System.out.println("The new payment desk was opened.");
        HttpEntity<Payment> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, null,
                Payment.class);
        System.out.println(response.getBody());

        builder = UriComponentsBuilder.fromHttpUrl(address).queryParam("desk", 6).queryParam("estateBalance", 60);
        System.out.println("The new payment desk was opened.");
        response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, null, Payment.class);
        System.out.println(response.getBody());

        builder = UriComponentsBuilder.fromHttpUrl(address).queryParam("desk", 7).queryParam("estateBalance", 70);
        System.out.println("The new payment desk was opened.");
        response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, null, Payment.class);
        System.out.println(response.getBody());

        builder = UriComponentsBuilder.fromHttpUrl(address).queryParam("desk", 8).queryParam("estateBalance", 80);
        System.out.println("The new payment desk was opened.");
        response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, null, Payment.class);
        System.out.println(response.getBody());
    }

    public void paymentReview() {
        String address = "http://localhost:8080/payments/";
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("Payments (registers) review:");

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address);

        HttpEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);
        System.out.println(response.getBody());
    }
}
