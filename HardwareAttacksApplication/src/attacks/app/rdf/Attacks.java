package attacks.app.rdf;

import java.util.ArrayList;

import attacks.app.model.Attack;



public class Attacks {

	private ArrayList<Attack> patients;

	
	public Attacks(ArrayList<Attack> patients) {
		super();
		this.patients = patients;
	}

	public ArrayList<Attack> getAttacks() {
		return patients;
	}

	public void setPatients(ArrayList<Attack> patients) {
		this.patients = patients;
	}
	
}
