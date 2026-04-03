package aisco.beneficiary.group;

import aisco.beneficiary.core.BeneficiaryComponent;
import aisco.beneficiary.core.BeneficiaryDecorator;

public class BeneficiaryImpl extends BeneficiaryDecorator {
    private String groupType;
    private int memberCount;
    private String institutionName;

    public BeneficiaryImpl(BeneficiaryComponent beneficiary, String groupType, int memberCount, String institutionName) {
        super(beneficiary);
        this.groupType = groupType;
        this.memberCount = memberCount;
        this.institutionName = institutionName;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String toString() {
        return beneficiary.toString()
            + " Group Type: " + groupType
            + ", Member Count: " + memberCount
            + ", Institution Name: " + institutionName + ".";
    }
}