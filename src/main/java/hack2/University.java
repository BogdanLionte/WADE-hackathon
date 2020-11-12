package hack2;

public class University {

    private int rmuID;
    private String name;
    private String code;
    private String county;
    private int countyId;
    private String city;
    private int cityId;
    private int year;
    private String webAddress;

    public University(int rmuID, String name, String code, String county, int countyId, String city, int cityId, int year, String webAddress) {
        this.rmuID = rmuID;
        this.name = name;
        this.code = code;
        this.county = county;
        this.countyId = countyId;
        this.city = city;
        this.cityId = cityId;
        this.year = year;
        this.webAddress = webAddress;
    }

    public University() {
    }

    public String getType() {
        if (code != null && code.length() > 0) {
            return code.substring(0, 1);
        }

        return "n/a";

    }

    public University(int rmuID, String name) {
        this.rmuID = rmuID;
        this.name = name;
    }

    public int getRmuID() {
        return rmuID;
    }

    public void setRmuID(int rmuID) {
        this.rmuID = rmuID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public int getCountyId() {
        return countyId;
    }

    public void setCountyId(int countyId) {
        this.countyId = countyId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }
}
