package attacks.app.miscellaneous;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import attacks.app.model.BayesEstimationModel;
import attacks.app.model.Symptom;
import unbbayes.io.BaseIO;
import unbbayes.io.NetIO;
import unbbayes.io.exception.LoadException;
import unbbayes.prs.Node;
import unbbayes.prs.bn.JunctionTreeAlgorithm;
import unbbayes.prs.bn.ProbabilisticNetwork;
import unbbayes.prs.bn.ProbabilisticNode;
import unbbayes.util.extension.bn.inference.IInferenceAlgorithm;

public class BayesController {
	public BayesEstimationModel CreateBayesNet(String bajesFileName, ArrayList<Symptom> symptoms)
			throws LoadException, IOException {
		ProbabilisticNetwork net = new ProbabilisticNetwork("bayesNet");

		BaseIO io = new NetIO();
		String fileName = "data/bajesMreze/" + bajesFileName + ".net";
		net = (ProbabilisticNetwork) io.load(new File(fileName));

		// compiling
		IInferenceAlgorithm algorithm = new JunctionTreeAlgorithm();
		algorithm.setNetwork(net);
		algorithm.run();

		// states overview
		List<Node> nodeList = net.getNodes();
        ArrayList<String> simptoms = new ArrayList<>();
        simptoms.add("Lack_Of_Unserstanding_of_Cyber_Security_Incidents");
        simptoms.add("Incorrectly_configured_firewalls");
        simptoms.add("Improper_data_classification");
        simptoms.add("Lack_of_employee_awareness");
        simptoms.add("Phishing_Emails");
        simptoms.add("Unpatched_operating_systems");
        simptoms.add("Unsecured_networks");
        simptoms.add("Outdated_antivirus");
        simptoms.add("Exploitability");
        simptoms.add("Authentication");
        simptoms.add("Access_Complexity");
        simptoms.add("Requires_prerequisites");
        simptoms.add("Skill");
        simptoms.add("Likelyhood");
        

		for (Node node: nodeList) {
			for(String symptom: simptoms) {
				if(node.getName().equals(symptom)) {
					for (int i = 0; i < node.getStatesSize(); i++) {
						System.out.println(node.getName()+" "+node.getStateAt(i) + ": " + ((ProbabilisticNode)node).getMarginalAt(i));
					}
			}
			}
		}
		
	
			BayesEstimationModel dm = new BayesEstimationModel();
			dm.setAttackName("Empty");
			dm.setAttackPercentage(0);
			return dm;
		

		/*for (Node node : net.getNodes()) {
			boolean found = false;
			for (Symptom s : symptoms) {
				if (node.getName().equals(s.getName())) {
					found = true;
					break;
				}
			}

			// System.out.println("FAJLNAME");
			// System.out.println(bajesFileName);

			if (node.getName().toUpperCase().equals(bajesFileName.toUpperCase())) {
				found = true;
			}

			ProbabilisticNode factNode = (ProbabilisticNode) node;
			// if(node.getName().equals("imeNoda")) {
			if (!found) {
				int stateIndex = 1;
				factNode.addFinding(stateIndex);
			}
		}

		// propagation
		try {
			net.updateEvidences();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	

		BayesEstimationModel diagnosis = new BayesEstimationModel();

		//System.out.println("*******************");
		for (Node node : net.getNodes()) {
			//System.out.println(node.getName());
			//System.out.println(bajesFileName);
			if (node.getName().toUpperCase().equals(bajesFileName.toUpperCase())) {
				//System.out.println("DIJAGNOZA!!!!!!!!!!!!!!!!!!!!!");
				//System.out.println(bajesFileName);
				diagnosis.setAttackName(node.getName());
				diagnosis.setAttackPercentage(((ProbabilisticNode) node).getMarginalAt(0));
			}
		}

		// diagnosis.setDiagnosisName(nodeList.get(0).getName());
		// diagnosis.setDiagnosisPercentage(((ProbabilisticNode)
		// nodeList.get(0)).getMarginalAt(0));

		return diagnosis;*/
	}


}
