package ro.fasttrackit.curs5homework.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.curs5homework.entity.Country;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Service
public class CountryService {
  private final CountryReader countryReader;

  @Resource(name = "myCountryBean")
  private MyCountryBean myCountryBean;

  public CountryService(CountryReader countryReader) {
    this.countryReader = countryReader;
  }

  public Optional<Country> getMyCountry(String myCountry) {
    return myCountryBean.myCountry (myCountry);
  }

  public List<Country> getAllCountries() {
    return countryReader.getCountries ();
  }

  public List<String> getAllCountryNames() {
    return countryReader.getCountries ().stream ()
      .map (country -> country.getName ())
      .collect (toList ());
  }

  public List<Country> getCountriesWhiteNeighbourXWithoutNeighbourY(String neighbourX, String neighbourY) {
    return List.of ();
  }

  public Optional<String> getCountryCapital(int countryId) {
    return countryReader.getCountries ()
      .stream ()
      .filter (country -> country.getId () == countryId)
      .map (country -> country.getCapital ())
      .findFirst ();
  }

  public boolean countryContainsNeighbours(Country country, String neighbours) {
    return country.getNeighbours ()
      .stream ()
      .anyMatch (neigh -> neigh.equals (neighbours));
  }

  public Optional<Long> getCountryPopulation(int countryId) {
    return countryReader.getCountries ()
      .stream ()
      .filter (country -> country.getId () == countryId)
      .map (country -> country.getPopulation ())
      .findFirst ();
  }

  public Optional<List<String>> getCountryNeighbours(int countryId) {
    return countryReader.getCountries ()
      .stream ()
      .filter (country -> country.getId () == countryId)
      .map (country -> country.getNeighbours ())
      .findFirst ();
  }

  public Map<String, Long> getPopulationsForCountries() {
    return countryReader.getCountries ()
      .stream ()
      .collect (toMap (Country::getName, Country::getPopulation));
  }

  public List<Country> getCountriesByContinent(String continentName) {
    return countryReader.getCountries ()
      .stream ()
      .filter (country -> country.getContinent ().equals (continentName))
      .collect (toList ());
  }

  public List<Country> getCountriesByContinentAndPopulation(String continent, Long population) {
    return countryReader.getCountries ()
      .stream ()
      .filter (country -> country.getContinent ().equals (continent))
      .filter (country -> country.getPopulation () > population)
      .collect (toList ());

  }

  public Map<String, List<Country>> getAllCountriesMappedToContinent() {
    return countryReader.getCountries ()
      .stream ()
      .collect (groupingBy (country -> country.getContinent ()));
  }
}
