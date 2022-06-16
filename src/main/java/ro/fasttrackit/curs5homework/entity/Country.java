package ro.fasttrackit.curs5homework.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Country {
  private final int id;
  private final String name;
  private final String capital;
  private final long population;
  private final long area;
  private final String continent;
  private final List<String> neighbours;

  public Country(int id, String name, String capital, long population, long area, String continent, List<String> neighbours) {
    this.id = id;
    this.name = name;
    this.capital = capital;
    this.population = population;
    this.area = area;
    this.continent = continent;
    this.neighbours = neighbours;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getCapital() {
    return capital;
  }

  public long getPopulation() {
    return population;
  }

  public long getArea() {
    return area;
  }

  public String getContinent() {
    return continent;
  }

  public List<String> getNeighbours() {
    return new ArrayList<> (neighbours);
  }
}
