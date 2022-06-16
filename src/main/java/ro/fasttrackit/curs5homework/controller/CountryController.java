package ro.fasttrackit.curs5homework.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.curs5homework.entity.Country;
import ro.fasttrackit.curs5homework.service.CountryService;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("countries")
public class CountryController {
  private final CountryService countryService;

  public CountryController(CountryService countryService) {
    this.countryService = countryService;
  }

  @GetMapping
  List<Country> getAllCountries(@RequestParam(required = false) String includeNeighbour,
                                @RequestParam(required = false) String excludeNeighbour) {
    if (includeNeighbour != null && excludeNeighbour != null) {
      return countryService.getCountriesWhiteNeighbourXWithoutNeighbourY (includeNeighbour, excludeNeighbour);
    } else {
      return countryService.getAllCountries ();
    }
  }

  @GetMapping("/names")
  List<String> getAllCountryNames() {
    return countryService.getAllCountryNames ();
  }

  @GetMapping("{countryId}/capital")
  String getCountryCapital(@PathVariable int countryId) {
    return countryService.getCountryCapital (countryId)
      .orElseThrow (() -> new RuntimeException ("Could not find country with id" + countryId));
  }

  @GetMapping("{countryId}/population")
  Long getCountryPopulation(@PathVariable int countryId) {
    return countryService.getCountryPopulation (countryId)
      .orElseThrow (() -> new RuntimeException ("Could not find country with id" + countryId));
  }

  @GetMapping("{countryId}/neighbours")
  List<String> getCountryNeighbours(@PathVariable int countryId) {
    return countryService.getCountryNeighbours (countryId)
      .orElseThrow (() -> new RuntimeException ("Could not find country with id" + countryId));
  }

  @GetMapping("/population")
  Map<String, Long> getPopulationForCountries() {
    return countryService.getPopulationsForCountries ();
  }

  @GetMapping("/mine")
  Country myCountry(@RequestHeader(name = "X-country") String myCountry) {
    return countryService.getMyCountry (myCountry)
      .orElseThrow (() -> new RuntimeException ("Could not find country with id" + myCountry));
  }
}
