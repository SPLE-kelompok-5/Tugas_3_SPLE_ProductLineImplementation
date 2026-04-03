package aisco.beneficiary.medical;

import aisco.beneficiary.core.BeneficiaryComponent;
import aisco.beneficiary.core.BeneficiaryDecorator;

public class BeneficiaryImpl extends BeneficiaryDecorator {
	private String medicalIssue;
	private PatientAcuity patientAcuity;

	private enum PatientAcuity {
		NonUrgent("non urgent"),
		LessUrgent("less urgent"),
		Urgent("urgent"),
		Emergent("emergent"),
		Resuscitative("resuscitative");

		private String description;

		private PatientAcuity(String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}
	}

	public BeneficiaryImpl(BeneficiaryComponent beneficiary, String medicalIssue, PatientAcuity patientAcuity) {
		super(beneficiary);
		this.medicalIssue = medicalIssue;
		this.patientAcuity = patientAcuity;
	}

	public PatientAcuity getPatientAcuity() {
		return patientAcuity;
	}

	public void setPatientAcuity(PatientAcuity patientAcuity) {
		this.patientAcuity = patientAcuity;
	}

	public String getMedicalIssue() {
		return medicalIssue;
	}

	public void setMedicalIssue(String medicalIssue) {
		this.medicalIssue = medicalIssue;
	}

	public String toString() {
		return beneficiary.toString() +
				", Medical Issue: " + medicalIssue +
				", Patient Acuity: " + patientAcuity.getDescription();
	}
}
