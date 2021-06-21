package attacks.app.miscellaneous;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.JFuzzyLogic;

public class FuzzyController {
	
private static final String fclFilename = "data/fuzzy/template.fcl";
	
	public FuzzyController() {}
	
	public double calculate(double severity, 
			double likelyhood,
			double exploitability, 
			double authentication, 
			double impact_bias, 
			double access_vector, 
			double access_complexity,
			double confidentiality_impact,
			double availability_impact,
			double remediation_level,
			double report_confidence, 
			double collateral_damage_potential, 
			double target_distribution) {
		String args[] = { "-noCharts", "-e", fclFilename, ""+severity, ""+likelyhood, ""+exploitability, ""+authentication, ""+impact_bias, ""+access_vector,
				""+access_complexity, ""+confidentiality_impact, ""+availability_impact, ""+remediation_level, ""+report_confidence, ""+collateral_damage_potential,""+target_distribution};
		
		JFuzzyLogic jFuzzyLogic = new JFuzzyLogic(args);
		jFuzzyLogic.run();
		
		FIS fis = jFuzzyLogic.getFis();  // Fuzzy Inference System

        double result = fis.getVariable("risk_vulnerability").getValue();
        
        //System.out.println("Rezultat iz fuzzy logike je: " + result);
        return result;
    }

}
