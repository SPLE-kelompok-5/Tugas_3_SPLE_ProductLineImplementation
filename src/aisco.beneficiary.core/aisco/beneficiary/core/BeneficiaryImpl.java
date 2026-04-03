package aisco.beneficiary.core;

public class BeneficiaryImpl extends BeneficiaryComponent {

    public BeneficiaryImpl(int idBeneficiary, String name, String address, String description) {
        super(idBeneficiary, name, address, description);
    }

    public String toString() {
        return "Beneficiary " + name + ", Address: " + address + ", Description: " + description + ".";
    }
}
