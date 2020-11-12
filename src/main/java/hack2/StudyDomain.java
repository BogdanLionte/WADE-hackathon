package hack2;

public class StudyDomain {

    Integer id;

    String name;

    FundamentalDomain fundamentalDomain;

    ScienceBranch scienceBranch;

    Boolean isLicenta;

    Boolean isMaster;

    Boolean isDoctorat;

    Integer year;

    public StudyDomain(Integer id, String name, FundamentalDomain fundamentalDomain, ScienceBranch scienceBranch, Boolean isLicenta, Boolean isMaster, Boolean isDoctorat, Integer year) {
        this.id = id;
        this.name = name;
        this.fundamentalDomain = fundamentalDomain;
        this.scienceBranch = scienceBranch;
        this.isLicenta = isLicenta;
        this.isMaster = isMaster;
        this.isDoctorat = isDoctorat;
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

    public FundamentalDomain getFundamentalDomain() {
        return fundamentalDomain;
    }

    public void setFundamentalDomain(FundamentalDomain fundamentalDomain) {
        this.fundamentalDomain = fundamentalDomain;
    }

    public ScienceBranch getScienceBranch() {
        return scienceBranch;
    }

    public void setScienceBranch(ScienceBranch scienceBranch) {
        this.scienceBranch = scienceBranch;
    }

    public Boolean getLicenta() {
        return isLicenta;
    }

    public void setLicenta(Boolean licenta) {
        isLicenta = licenta;
    }

    public Boolean getMaster() {
        return isMaster;
    }

    public void setMaster(Boolean master) {
        isMaster = master;
    }

    public Boolean getDoctorat() {
        return isDoctorat;
    }

    public void setDoctorat(Boolean doctorat) {
        isDoctorat = doctorat;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
