package aisco.beneficiary.individu;

import aisco.beneficiary.core.BeneficiaryComponent;

public class BeneficiaryImpl extends BeneficiaryComponent {
    private int age;

    public BeneficiaryImpl(int idBeneficiary, String name, String address, String description, int age) {
        super(idBeneficiary, name, address, description);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Individu Beneficiary " + name + ", Age: " + age + ", Address: " + address + ", Description: " + description + ".";
    }
}
