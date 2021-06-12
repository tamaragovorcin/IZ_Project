package attacks.app.model;

import java.util.ArrayList;



public class Risk {
	private int id;
	private Attack attack;;
	private AdditionalRisk additionalRisk;
	private ArrayList<Prerequisite> prerequistes = new ArrayList<>();
	
	
	public Risk() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Risk(int id, Attack attack, AdditionalRisk additionalRisk, ArrayList<Prerequisite> prerequistes) {
		super();
		this.id = id;
		this.attack = attack;
		this.additionalRisk = additionalRisk;
		this.prerequistes = prerequistes;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Attack getAttack() {
		return attack;
	}


	public void setAttack(Attack attack) {
		this.attack = attack;
	}


	public AdditionalRisk getAdditionalRisk() {
		return additionalRisk;
	}


	public void setAdditionalRisk(AdditionalRisk additionalRisk) {
		this.additionalRisk = additionalRisk;
	}


	public ArrayList<Prerequisite> getPrerequistes() {
		return prerequistes;
	}


	public void setPrerequistes(ArrayList<Prerequisite> prerequistes) {
		this.prerequistes = prerequistes;
	}
	
	

}
