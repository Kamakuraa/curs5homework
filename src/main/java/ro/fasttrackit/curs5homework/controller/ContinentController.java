package ro.fasttrackit.curs5homework.controller;

import org.apache.catalina.LifecycleState;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.curs5homework.entity.Country;
import ro.fasttrackit.curs5homework.service.CountryService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("continents")
public class ContinentController {
  private final CountryService service;

  public ContinentController(CountryService service) {
    this.service = service;
  }
  @GetMapping("{continentName}/countries")
  List<Country> getCountriesByContinent(@PathVariable String continentName,
                                        @RequestParam(required = false) Long minPopulation){
    if (minPopulation==null){
      return service.getCountriesByContinent(continentName);
    } else {
      return service.getCountriesByContinentAndPopulation(continentName, minPopulation);
    }
  }

  @GetMapping("/countries")
  Map<String, List<Country>> getAllCountriesMappedToContinent(){
    return service.getAllCountriesMappedToContinent();
  }


}
