package aisco.product.withbeneficiary;

import aisco.program.core.Program;
import aisco.program.ProgramFactory;
import aisco.financialreport.core.FinancialReport;
import aisco.financialreport.FinancialReportFactory;
import aisco.beneficiary.core.Beneficiary;
import aisco.beneficiary.BeneficiaryFactory;
import java.util.ArrayList;
import java.util.List;

public class WithBeneficiary {
    private static final int INDEX_SCHOOL = 0;
    private static final int INDEX_LIBRARY = 1;

    private static FinancialReport income1;
    private static FinancialReport expense1;

    public static List<Program> addProgram() {
        System.out.println("\n Programs: ");
        List<Program> programs = new ArrayList<>();
        Program schoolconstruction = ProgramFactory.createProgram(
            "aisco.program.activity.ProgramImpl",
            1, "School Construction", "Construct the building of elementary school",
            "100 students", "Government", "https://www.myschool.splelive.id/logo"
        );
        Program freelibrary = ProgramFactory.createProgram(
            "aisco.program.activity.ProgramImpl",
            2, "Free Library", "Library for underprivileged children",
            "children", "BeriBuku Community", "https://www.myschool.splelive.id/liblogo"
        );
        programs.add(INDEX_SCHOOL, schoolconstruction);
        programs.add(INDEX_LIBRARY, freelibrary);
        return programs;
    }

    public static List<Beneficiary> addBeneficiary() {
        System.out.println("\n Beneficiaries: ");
        List<Beneficiary> beneficiaries = new ArrayList<>();
        Beneficiary b1 = BeneficiaryFactory.createBeneficiary(
            "aisco.beneficiary.individu.BeneficiaryImpl",
            1, "Budi Santoso", "Jl. Merdeka No. 5, Jakarta", "Siswa kurang mampu", 12
        );
        Beneficiary b2 = BeneficiaryFactory.createBeneficiary(
            "aisco.beneficiary.individu.BeneficiaryImpl",
            2, "Sari Dewi", "Jl. Pahlawan No. 3, Bandung", "Anak yatim piatu", 10
        );
        beneficiaries.add(b1);
        beneficiaries.add(b2);
        return beneficiaries;
    }

    public static List<FinancialReport> addIncome(List<Program> programs) {
        List<FinancialReport> incomes = new ArrayList<>();
        income1 = FinancialReportFactory.createFinancialReport(
            "aisco.financialreport.income.FinancialReportImpl",
            FinancialReportFactory.createFinancialReport(
                "aisco.financialreport.core.FinancialReportImpl",
                "1", "23-10-2019", 100000, "Donation Ana", programs.get(INDEX_SCHOOL), "11000"
            ), "Transfer"
        );
        incomes.add(income1);
        incomes.add(FinancialReportFactory.createFinancialReport(
            "aisco.financialreport.income.FinancialReportImpl",
            FinancialReportFactory.createFinancialReport(
                "aisco.financialreport.core.FinancialReportImpl",
                "2", "24-10-2019", 3000000, "Donation Joni", programs.get(INDEX_LIBRARY), "11000"
            ), "Cash"
        ));
        return incomes;
    }

    public static List<FinancialReport> addExpense(List<Program> programs) {
        List<FinancialReport> expenses = new ArrayList<>();
        expense1 = FinancialReportFactory.createFinancialReport(
            "aisco.financialreport.expense.FinancialReportImpl",
            FinancialReportFactory.createFinancialReport(
                "aisco.financialreport.core.FinancialReportImpl",
                "10", "23-10-2019", 500000, "Buy Books", programs.get(INDEX_LIBRARY), "41000"
            )
        );
        expenses.add(expense1);
        return expenses;
    }

    public static void main(String[] args) {
        System.out.println("Product With Beneficiary");
        List<Program> programs = addProgram();
        System.out.println(programs);

        List<Beneficiary> beneficiaries = addBeneficiary();
        System.out.println(beneficiaries);

        List<FinancialReport> incomes = addIncome(programs);
        income1.printHeader();
        System.out.println(incomes);
        int totalincome = income1.total(incomes);

        List<FinancialReport> expenses = addExpense(programs);
        expense1.printHeader();
        System.out.println(expenses);
        int totalexpense = expense1.total(expenses);

        System.out.println("Balance: " + (totalincome - totalexpense));
    }
}
