package attacks.app.model;

import java.util.ArrayList;


public class BayesEstimationModels {

	private ArrayList<BayesEstimationModel> bayesEstimationModels;

	public BayesEstimationModels(ArrayList<BayesEstimationModel> bayesEstimationModels) {
		super();
		this.bayesEstimationModels = bayesEstimationModels;
	}

	public ArrayList<BayesEstimationModel> getBayesEstimationModels() {
		return bayesEstimationModels;
	}

	public void setBayesEstimationModels(ArrayList<BayesEstimationModel> bayesEstimationModels) {
		this.bayesEstimationModels = bayesEstimationModels;
	}
	
	
}
