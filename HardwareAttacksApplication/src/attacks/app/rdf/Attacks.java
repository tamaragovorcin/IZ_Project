package attacks.app.rdf;

import java.util.ArrayList;

import attacks.app.model.Attack;



public class Attacks {

	private ArrayList<Attack> attacks;


	public Attacks() {
		this.attacks = new ArrayList<Attack>();
	}

	public Attacks(ArrayList<Attack> attacks) {
		super();
		this.attacks = attacks;
	}

	public ArrayList<Attack> getAttacks() {
		return attacks;
	}

	public void setPatients(ArrayList<Attack> attacks) {
		this.attacks = attacks;
	}
	
}
