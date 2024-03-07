package com.example.hwrestteamplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;



import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.Async;

@Service
public class SearchCountryServiceImpl implements SearchCountryService{

    private RestTemplate restTemplate;
    String resourceUrl = "http://universities.hipolabs.com/search";

    @Autowired
    public SearchCountryServiceImpl(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Override
    public String findAll() {
        ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
        return response.getBody();
    }

    @Override
    public String findByCountry(String country) {
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(resourceUrl)
                .queryParam("country",country).build();
        ResponseEntity<String> response = restTemplate.getForEntity(uriComponents.toUriString(), String.class);
        return response.getBody();
    }

    @Override
    public List<String> findByCountries(List<String> countries) {
        List<String> responseList = new LinkedList<>();
        for (String country : countries) {
            responseList.add(findByCountry(country));
        }
        return responseList;
    }

    @Override
    public List<String> findByCountriesAsync(List<String> countries) {
        List<CompletableFuture<String>> futuresList = new LinkedList<>();
        for (String country : countries) {
            futuresList.add(findByCountryAsync(country));
        }
        return futuresList.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    @Async
    public CompletableFuture<String> findByCountryAsync(String country) {
        return CompletableFuture.completedFuture(findByCountry(country));
    }

}
