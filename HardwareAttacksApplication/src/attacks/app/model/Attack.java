package attacks.app.model;

import java.util.ArrayList;


public class Attack {
	private int id;
	private String name;
	private Characteristics characteristics;
	
	
	public Attack() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Attack(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public Characteristics getCharacteristics() {
		return characteristics;
	}


	public void setCharacteristics(Characteristics characteristics) {
		this.characteristics = characteristics;
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
		return "Attack [id=" + id + ", name=" + name + "]";
	}
	
	

}