package attacks.app.model;

public class Characteristics {
	double severity;
    double likelyhood;
    double exploitability;
    double authentication;
    double impact_bias; 
    double access_vector; 
    double access_complexity;
    double confidentiality_impact; 
    double availability_impact;  
    double remediation_level; 
    double report_confidence; 
    double collateral_damage_potential; 
    double target_distribution;
	public Characteristics(double severity, double likelyhood, double exploitability, double authentication,
			double impact_bias, double access_vector, double access_complexity, double confidentiality_impact,
			double availability_impact, double remediation_level, double report_confidence,
			double collateral_damage_potential, double target_distribution) {
		super();
		this.severity = severity;
		this.likelyhood = likelyhood;
		this.exploitability = exploitability;
		this.authentication = authentication;
		this.impact_bias = impact_bias;
		this.access_vector = access_vector;
		this.access_complexity = access_complexity;
		this.confidentiality_impact = confidentiality_impact;
		this.availability_impact = availability_impact;
		this.remediation_level = remediation_level;
		this.report_confidence = report_confidence;
		this.collateral_damage_potential = collateral_damage_potential;
		this.target_distribution = target_distribution;
	}
	public double getSeverity() {
		return severity;
	}
	public void setSeverity(double severity) {
		this.severity = severity;
	}
	public double getLikelyhood() {
		return likelyhood;
	}
	public void setLikelyhood(double likelyhood) {
		this.likelyhood = likelyhood;
	}
	public double getExploitability() {
		return exploitability;
	}
	public void setExploitability(double exploitability) {
		this.exploitability = exploitability;
	}
	public double getAuthentication() {
		return authentication;
	}
	public void setAuthentication(double authentication) {
		this.authentication = authentication;
	}
	public double getImpact_bias() {
		return impact_bias;
	}
	public void setImpact_bias(double impact_bias) {
		this.impact_bias = impact_bias;
	}
	public double getAccess_vector() {
		return access_vector;
	}
	public void setAccess_vector(double access_vector) {
		this.access_vector = access_vector;
	}
	public double getAccess_complexity() {
		return access_complexity;
	}
	public void setAccess_complexity(double access_complexity) {
		this.access_complexity = access_complexity;
	}
	public double getConfidentiality_impact() {
		return confidentiality_impact;
	}
	public void setConfidentiality_impact(double confidentiality_impact) {
		this.confidentiality_impact = confidentiality_impact;
	}
	public double getAvailability_impact() {
		return availability_impact;
	}
	public void setAvailability_impact(double availability_impact) {
		this.availability_impact = availability_impact;
	}
	public double getRemediation_level() {
		return remediation_level;
	}
	public void setRemediation_level(double remediation_level) {
		this.remediation_level = remediation_level;
	}
	public double getReport_confidence() {
		return report_confidence;
	}
	public void setReport_confidence(double report_confidence) {
		this.report_confidence = report_confidence;
	}
	public double getCollateral_damage_potential() {
		return collateral_damage_potential;
	}
	public void setCollateral_damage_potential(double collateral_damage_potential) {
		this.collateral_damage_potential = collateral_damage_potential;
	}
	public double getTarget_distribution() {
		return target_distribution;
	}
	public void setTarget_distribution(double target_distribution) {
		this.target_distribution = target_distribution;
	}
	public Characteristics() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
