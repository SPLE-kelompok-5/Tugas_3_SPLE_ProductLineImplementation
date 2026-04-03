package aisco.product.puskesmas;

import aisco.program.core.Program;
import aisco.program.ProgramFactory;
import aisco.financialreport.core.FinancialReport;
import aisco.financialreport.FinancialReportFactory;
import java.util.ArrayList;
import java.util.List;

public class Puskesmas {
	private static final int INDEX_PRIMARY = 0;
	private static FinancialReport incomeTracker;

	public static List<Program> setupPrograms() {
		System.out.println("\nInitializing Custom Programs: ");
		List<Program> programs = new ArrayList<>();

		Program activity = ProgramFactory.createProgram(
				"aisco.program.activity.ProgramImpl",
				1, "Puskesmas", "Bebebnya Puskesneng", "Private Institution",
				"https://puskesmas.co.id");

		programs.add(INDEX_PRIMARY, activity);
		return programs;
	}

	public static List<FinancialReport> setupIncome(List<Program> programs) {
		List<FinancialReport> incomes = new ArrayList<>();

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
		System.out.println("Starting Product: Puskesmas");

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
