package peaksoft;

public class City {
   private int id;
   private String name;
    private double population;
    private String sightCity;
    private int mayorId;

    public City(int id, String name,double population,String sightCity, int mayorId) {
        this.id = id;
        this.name=name;
        this.population=population;
        this.sightCity=sightCity;
        this.mayorId = mayorId;
    }

    public City() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String namee) {
        this.name = name;
    }

    public int getMayorId() {
        return mayorId;
    }

    public void setMayorId(int mayorId) {
        this.mayorId = mayorId;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public String getSightCity() {
        return sightCity;
    }

    public void setSightCity(String sightCity) {
        this.sightCity = sightCity;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", sightCity='" + sightCity + '\'' +
                ", mayorId=" + mayorId +
                '}';
    }
}
