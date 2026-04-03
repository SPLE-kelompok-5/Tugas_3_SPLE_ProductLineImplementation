package aisco.beneficiary.core;

public abstract class BeneficiaryComponent implements Beneficiary {

    protected int idBeneficiary;
    protected String name;
    protected String address;
    protected String description;

    public BeneficiaryComponent() {
    }

    public BeneficiaryComponent(int idBeneficiary, String name, String address, String description) {
        this.idBeneficiary = idBeneficiary;
        this.name = name;
        this.address = address;
        this.description = description;
    }

    public void setIdBeneficiary(int idBeneficiary) {
        this.idBeneficiary = idBeneficiary;
    }

    public int getIdBeneficiary() {
        return idBeneficiary;
    }

    public void setBeneficiaryName(String name) {
        this.name = name;
    }

    public String getBeneficiaryName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}