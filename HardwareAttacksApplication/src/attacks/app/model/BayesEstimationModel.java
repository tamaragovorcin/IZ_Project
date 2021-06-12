package attacks.app.model;

public class BayesEstimationModel implements Comparable<BayesEstimationModel>{	
	private int id;
	private String attackName;
	private float attackPercentage;

	public BayesEstimationModel() {
		attackPercentage = 0;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAttackName() {
		return attackName;
	}


	public void setAttackName(String attackName) {
		this.attackName = attackName;
	}


	public float getAttackPercentage() {
		return attackPercentage;
	}


	public void setAttackPercentage(float attackPercentage) {
		this.attackPercentage = attackPercentage;
	}


	public BayesEstimationModel(int id, String attackName, float attackPercentage) {
		super();
		this.id = id;
		this.attackName = attackName;
		this.attackPercentage = attackPercentage;
	}



	@Override
	public int compareTo(BayesEstimationModel o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
