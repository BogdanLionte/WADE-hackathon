package hack2;

public class StudyDomain {

    Integer id;

    String name;

    Integer fundamentalDomainId;
    String fundamentalDomainName;

    Integer scienceBranchId;
    String scienceBranchName;

    Boolean isLicenta;

    Boolean isMaster;

    Boolean isDoctorat;

    Integer year;

    public StudyDomain(Integer id, String name, Integer fundamentalDomainId, String fundamentalDomainName, Integer scienceBranchId, String scienceBranchName, Boolean isLicenta, Boolean isMaster, Boolean isDoctorat, Integer year) {
        this.id = id;
        this.name = name;
        this.fundamentalDomainId = fundamentalDomainId;
        this.fundamentalDomainName = fundamentalDomainName;
        this.scienceBranchId = scienceBranchId;
        this.scienceBranchName = scienceBranchName;
        this.isLicenta = isLicenta;
        this.isMaster = isMaster;
        this.isDoctorat = isDoctorat;
        this.year = year;
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

    public Integer getScienceBranchId() {
        return scienceBranchId;
    }

    public void setScienceBranchId(Integer scienceBranchId) {
        this.scienceBranchId = scienceBranchId;
    }

    public String getScienceBranchName() {
        return scienceBranchName;
    }

    public void setScienceBranchName(String scienceBranchName) {
        this.scienceBranchName = scienceBranchName;
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
