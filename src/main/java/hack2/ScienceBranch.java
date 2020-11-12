package hack2;

public class ScienceBranch {

    Integer id;

    String name;

    Integer fundamentalDomainId;
    String fundamentalDomainName;

    public ScienceBranch(Integer id, String name, Integer fundamentalDomainId, String fundamentalDomainName) {
        this.id = id;
        this.name = name;
        this.fundamentalDomainId = fundamentalDomainId;
        this.fundamentalDomainName = fundamentalDomainName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFundamentalDomainId() {
        return fundamentalDomainId;
    }

    public void setFundamentalDomainId(Integer fundamentalDomainId) {
        this.fundamentalDomainId = fundamentalDomainId;
    }

    public String getFundamentalDomainName() {
        return fundamentalDomainName;
    }

    public void setFundamentalDomainName(String fundamentalDomainName) {
        this.fundamentalDomainName = fundamentalDomainName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }


}
