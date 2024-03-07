package com.example.hwrestteamplate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hipolabs")
public class SearchCountryController {

    private SearchCountryService searchCountryService;

    @Autowired
    public SearchCountryController(@Qualifier("searchCountryServiceImpl") SearchCountryService searchCountryService) {
        this.searchCountryService = searchCountryService;
    }

    @GetMapping()
    public ResponseEntity<String> getAllCountry() {
        String responseStr = searchCountryService.findAll();
        return new ResponseEntity<>(responseStr, HttpStatus.OK);
    }

    @GetMapping("/countries")
    public ResponseEntity<String> getByCountry(@RequestParam("country") String country) {
        String responseStr = searchCountryService.findByCountry(country);
        return new ResponseEntity<>(responseStr, HttpStatus.OK);
    }

    @GetMapping("/search/countries")
    public ResponseEntity<List<String>> getByCountries(@RequestParam("country") List<String> countries) {
        List<String> responseList = searchCountryService.findByCountries(countries);
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @GetMapping("/search/async/countries")
    public ResponseEntity<List<String>> getByCountriesAsync(@RequestParam("country") List<String> countries) {
        List<String> responseList = searchCountryService.findByCountriesAsync(countries);
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

}
