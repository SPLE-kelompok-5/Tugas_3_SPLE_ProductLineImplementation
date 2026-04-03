package aisco.product.customcharity;

import aisco.program.core.Program;
import aisco.program.ProgramFactory;
import aisco.financialreport.core.FinancialReport;
import aisco.financialreport.FinancialReportFactory;
import java.util.ArrayList;
import java.util.List;

public class CustomCharity {
	private static final int INDEX_PRIMARY = 0;
	private static FinancialReport incomeTracker;

	public static List<Program> setupPrograms() {
		System.out.println("\nInitializing Custom Programs: ");
		List<Program> programs = new ArrayList<>();

		// Example: Creating an Activity program using the ProgramFactory
		Program activity = ProgramFactory.createProgram(
				"aisco.program.activity.ProgramImpl",
				1, "Community Outreach", "General Support", "Local Partners", "https://logo.url");

		programs.add(INDEX_PRIMARY, activity);
		return programs;
	}

	public static List<FinancialReport> setupIncome(List<Program> programs) {
		List<FinancialReport> incomes = new ArrayList<>();

		// Note: FinancialReport objects are often created by wrapping a 'core'
		// implementation
		// with a specific decorator like 'income'
		FinancialReport coreReport = FinancialReportFactory.createFinancialReport(
				"aisco.financialreport.core.FinancialReportImpl",
				"INC-001", "2025-04-03", 5000000, "Initial Funding", programs.get(INDEX_PRIMARY),
				"101");

		incomeTracker = FinancialReportFactory.createFinancialReport(
				"aisco.financialreport.income.FinancialReportImpl",
				coreReport, "Bank Transfer");

		incomes.add(incomeTracker);
		return incomes;
	}

	public static void main(String[] args) {
		System.out.println("Starting Product: Custom Charity");

		// 1. Initialize Programs
		List<Program> programs = setupPrograms();
		System.out.println("Programs loaded: " + programs);

		// 2. Initialize and Process Income
		List<FinancialReport> incomes = setupIncome(programs);
		incomeTracker.printHeader();
		System.out.println("Income Records: " + incomes);

		// 3. Calculate Total (Handling specific implementations like Income Report)
		if (incomeTracker instanceof aisco.financialreport.income.FinancialReportImpl) {
			int total = ((aisco.financialreport.income.FinancialReportImpl) incomeTracker).total(incomes);
			System.out.println("Net Income (after fees): " + total);
		}
	}
}
