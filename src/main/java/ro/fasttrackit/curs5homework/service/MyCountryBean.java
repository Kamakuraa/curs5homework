package ro.fasttrackit.curs5homework.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import ro.fasttrackit.curs5homework.entity.Country;

import java.util.Optional;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyCountryBean {
  private final FileCountryReader countryFileReader;

  public MyCountryBean(FileCountryReader countryFileReader) {
    this.countryFileReader = countryFileReader;
  }

  public Optional<Country> myCountry(String countryName){
    return countryFileReader.getCountries()
      .stream ()
      .filter (country -> country.getName ().equalsIgnoreCase (countryName))
      .findFirst ();
  }
}
