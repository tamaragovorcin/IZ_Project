package attacks.app.model;

import java.util.ArrayList;


public class Estimation {

	private int id;
	private ArrayList<Symptom> symptoms = new ArrayList<>();
	private BayesEstimationModel finalDiagnosisModel;


	public Estimation() {
	}

	public BayesEstimationModel getFinalDiagnosisModel() {
		return finalDiagnosisModel;
	}

	public void setFinalDiagnosisModel(BayesEstimationModel finalDiagnosisModel) {
		this.finalDiagnosisModel = finalDiagnosisModel;
	}

	public ArrayList<Symptom> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(ArrayList<Symptom> symptoms) {
		this.symptoms = symptoms;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}