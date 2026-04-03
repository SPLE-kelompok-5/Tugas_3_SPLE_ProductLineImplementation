package aisco.beneficiary.core;

public abstract class BeneficiaryDecorator extends BeneficiaryComponent {

    protected BeneficiaryComponent beneficiary;

    public BeneficiaryDecorator() {
    }

    public BeneficiaryDecorator(BeneficiaryComponent beneficiary) {
        this.beneficiary = beneficiary;
    }

    public String toString() {
        return beneficiary.getBeneficiaryName();
    }
}