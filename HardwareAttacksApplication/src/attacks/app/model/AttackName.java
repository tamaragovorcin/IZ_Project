package attacks.app.model;

public class AttackName {

	private int id;
	private String attackName;
	
	
	public AttackName() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AttackName(int id, String attackName) {
		super();
		this.id = id;
		this.attackName = attackName;
	}
	public String getAttackName() {
		return attackName;
	}
	public void setAttackName(String attackName) {
		this.attackName = attackName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
