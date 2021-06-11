package attacks.app.model;

import java.util.ArrayList;

public class MitigationsModels {
	private ArrayList<Mitigation> mitigationList;

	public MitigationsModels() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MitigationsModels(ArrayList<Mitigation> mitigationList) {
		super();
		this.mitigationList = mitigationList;
	}

	public ArrayList<Mitigation> getMitigationList() {
		return mitigationList;
	}

	public void setMitigationList(ArrayList<Mitigation> mitigationList) {
		this.mitigationList = mitigationList;
	}
	

}
