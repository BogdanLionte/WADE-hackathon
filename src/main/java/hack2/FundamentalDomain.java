package hack2;

public class FundamentalDomain {

    Integer id;

    String name;

    Integer year;

    public FundamentalDomain(Integer id, String name, Integer year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
