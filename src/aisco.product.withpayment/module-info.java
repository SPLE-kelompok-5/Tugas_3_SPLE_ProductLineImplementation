module aisco.product.withpayment {
    requires aisco.program.core;
    requires aisco.financialreport.core;
    requires aisco.donation.core;
    requires aisco.beneficiary.core;

    requires aisco.program.activity;
    requires aisco.beneficiary.individu;

    requires aisco.financialreport.income;
    requires aisco.financialreport.expense;

    requires aisco.donation.directpayment;
}
