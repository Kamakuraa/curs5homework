package ro.fasttrackit.curs5homework.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ro.fasttrackit.curs5homework.entity.Country;

import java.util.List;
@Component
@Profile ("memory")
public class InMemoryCountryReader implements CountryReader{

  @Override
  public List<Country> getCountries() {
    return List.of(new Country(1,"Afghanistan","Kabul",27657145L,652230L,"Asia",List.of("IRN","PAK","TKM","UZB","TJK","CHN")),
      new Country(2,"Åland Islands","Mariehamn",28875L,1580L,"Europe",List.of("")),
      new Country(3,"Albania","Tirana",2886026L,28748L,"Europe",List.of("MNE","GRC","MKD","KOS")),
      new Country(4,"Algeria","Algiers",40400000L,2381741L,"Africa",List.of("TUN","LBY","NER","ESH","MRT","MLI","MAR")),
      new Country(5,"American Samoa","Pago Pago",57100L,199L,"Oceania",List.of("")),
      new Country(6,"Andorra","Andorra la Vella",78014L,468L,"Europe",List.of("FRA","ESP")),
      new Country(7,"Angola","Luanda",25868000L,1246700L,"Africa",List.of("COG","COD","ZMB","NAM")),
      new Country(8,"Anguilla","The Valley",13452L,91L,"Americas",List.of("")),
      new Country(9,"Antigua and Barbuda","Saint John's",86295L,442L,"Americas",List.of("")),
      new Country(10,"Azerbaijan","Baku",9730500L,86600L,"Asia",List.of("ARM","GEO","IRN","RUS","TUR")));
  }
}
