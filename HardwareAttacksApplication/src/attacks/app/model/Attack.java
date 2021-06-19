package attacks.app.model;

import java.util.ArrayList;

import attacks.app.enumerations.Likelihood;
import attacks.app.enumerations.Prerequisites;
import attacks.app.enumerations.Severity;


public class Attack {
	private String id;
	private String name;
	private String weaknesses;
	private Prerequisites prerequisites;
	private String mitigations;
	private Severity severity;
	private Likelihood likelihood;

	public Attack() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeaknesses() {
		return weaknesses;
	}

	public void setWeaknesses(String weaknesses) {
		this.weaknesses = weaknesses;
	}

	public Prerequisites getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(Prerequisites prerequisites) {
		this.prerequisites = prerequisites;
	}

	public String getMitigations() {
		return mitigations;
	}

	public void setMitigations(String mitigations) {
		this.mitigations = mitigations;
	}

	public Severity getSeverity() {
		return severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	public Likelihood getLikelihood() {
		return likelihood;
	}

	public void setLikelihood(Likelihood likelihood) {
		this.likelihood = likelihood;
	}

	public Attack(String id, String name, String weaknesses, Prerequisites prerequisites, String mitigations,
			Severity severity, Likelihood likelihood) {
		super();
		this.id = id;
		this.name = name;
		this.weaknesses = weaknesses;
		this.prerequisites = prerequisites;
		this.mitigations = mitigations;
		this.severity = severity;
		this.likelihood = likelihood;
	}


	

}