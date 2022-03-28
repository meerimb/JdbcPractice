package peaksoft;

public class Country {
    private int id;
    private String countryName;
    private int population;
    private String language;
    private String currencyName;
    private int cityId;

    public Country() {
    }

    public Country(int id,String countryName, int population, String language, String currencyName, int cityId) {
        this.id=id;
        this.countryName=countryName;
        this.population = population;
        this.language = language;
        this.currencyName = currencyName;
        this.cityId = cityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName=countryName;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                ", population=" + population +
                ", language='" + language + '\'' +
                ", currencyName='" + currencyName + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}
