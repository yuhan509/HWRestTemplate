package com.example.hwrestteamplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface SearchCountryService {
    String findAll();
    String findByCountry(String country);
    List<String> findByCountries(List<String> countries);
    List<String> findByCountriesAsync(List<String> countries);
}
