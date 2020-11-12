package hack2;

public class ScienceBranch {

    Integer id;

    String name;

    FundamentalDomain fundamentalDomain;

    public ScienceBranch(Integer id, String name, FundamentalDomain fundamentalDomain) {
        this.id = id;
        this.name = name;
        this.fundamentalDomain = fundamentalDomain;
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

    public FundamentalDomain getFundamentalDomain() {
        return fundamentalDomain;
    }

    public void setFundamentalDomain(FundamentalDomain fundamentalDomain) {
        this.fundamentalDomain = fundamentalDomain;
    }
}
