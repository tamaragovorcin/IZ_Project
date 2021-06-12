package attacks.app.model;



public class AttackModel implements Comparable<AttackModel> {
	
	private int id;
	private String evidenteName;
	private float evidentePercentage;

	public AttackModel() {
		evidentePercentage = 0;
	}

	
	public AttackModel(int id, String evidenteName, float evidentePercentage) {
		super();
		this.id = id;
		this.evidenteName = evidenteName;
		this.evidentePercentage = evidentePercentage;
	}


	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getEvidenteName() {
		return evidenteName;
	}





	public void setEvidenteName(String evidenteName) {
		this.evidenteName = evidenteName;
	}





	public float getEvidentePercentage() {
		return evidentePercentage;
	}





	public void setEvidentePercentage(float evidentePercentage) {
		this.evidentePercentage = evidentePercentage;
	}





	@Override
	public int compareTo(AttackModel o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
