package attacks.app.model;

public class Prerequisite {
	public Prerequisite(String name) {
		super();
		this.name = name;
	}


	private int id;
	private String name;
	
	
	public Prerequisite() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Prerequisite(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Prerequisites [id=" + id + ", name=" + name + "]";
	}
	
	

}
