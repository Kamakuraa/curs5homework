package ro.fasttrackit.curs5homework.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ro.fasttrackit.curs5homework.entity.Country;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.toList;

//"src/main/resources/countries.txt";

@Component
@Profile("file")
public class FileCountryReader implements CountryReader{
  private List<Country> countries;
  private final String sourceFile = "src/main/resources/countries.txt";

  public FileCountryReader() {
    countries = read();
  }

  public List<Country> getCountries() {
    return countries;
  }

  private List<Country> read() {
    try {
      AtomicInteger id = new AtomicInteger(1);
      return Files.lines(Path.of(sourceFile))
        .map(line -> readOne(line, id.getAndIncrement()))
        .collect(toList());
    } catch (IOException e) {
      System.err.println("Could not read from file " + sourceFile);
    }
    return List.of();
  }

  private Country readOne(String line, int id){
    List<String> countryInfo = Arrays.asList(line.split("\\|"));
    return new Country(
      id,
      countryInfo.get(0),
      countryInfo.get(1),
      Long.parseLong(countryInfo.get(2)),
      Long.parseLong(countryInfo.get(3)),
      countryInfo.get(4),
      countryInfo.size() > 5 ? Arrays.asList(countryInfo.get(5).split("~")) : List.of()
    );
  }
}
