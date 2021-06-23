package attacks.app.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import attacks.app.enumerations.Prerequisites;
import attacks.app.model.AttackCaseComponent;
import attacks.app.model.TableSimilarity;
import ucm.gaia.jcolibri.casebase.LinealCaseBase;
import ucm.gaia.jcolibri.cbraplications.StandardCBRApplication;
import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CBRCaseBase;
import ucm.gaia.jcolibri.cbrcore.CBRQuery;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.ExecutionException;
import ucm.gaia.jcolibri.method.retrieve.RetrievalResult;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Equal;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Interval;
import ucm.gaia.jcolibri.method.retrieve.selection.SelectCases;

public class CbrController implements StandardCBRApplication {
	Connector _connector;
	/** Connector object */
	CBRCaseBase _caseBase;
	/** CaseBase object */

	NNConfig simConfig;
	
	public int flag = 0;

	/** KNN configuration */

	public void configure() throws ExecutionException {
		//_connector = new CsvConnector();
		_connector = new CsvConnector();
		_caseBase = new LinealCaseBase(); // Create a Lineal case base for in-memory organization
		setSimilarityAttacks();
	}
	
	public void postCycle() throws ExecutionException {
		
	}

	public CBRCaseBase preCycle() throws ExecutionException {
		_caseBase.init(_connector);
		java.util.Collection<CBRCase> cases = _caseBase.getCases();
//		for (CBRCase c: cases)
//			System.out.println(c.getDescription());
		return _caseBase;
	}

	@Override
	public void cycle(CBRQuery query) throws ExecutionException {
		Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(_caseBase.getCases(), query, simConfig);
		eval = SelectCases.selectTopKRR(eval, 5);
		System.out.println("Retrieved cases:");
		for (RetrievalResult nse : eval) {
		
		
			if (nse.get_case().getDescription().getClass() == AttackCaseComponent.class) {
				AttackCaseComponent ed = (AttackCaseComponent) nse.get_case().getDescription();

				if (!CbrResult.potentialAttacks.containsKey(ed.getName())) {
					if(!CbrResult.attackName.equals(ed.getName())) {
						CbrResult.potentialAttacks.put(ed.getName(), nse.getEval());
						System.out.println(ed.getName() + "   -     " + nse.getEval());
					}
					
				}
				
			}
		}
		
	}
	public void setSimilarityAttacks() {
		simConfig = new NNConfig(); // KNN configuration
		simConfig.setDescriptionSimFunction(new Average());  // global similarity function = average
	
		simConfig.addMapping(new Attribute("weaknesse", AttackCaseComponent.class), new Equal());
		simConfig.addMapping(new Attribute("prerequisites", AttackCaseComponent.class), new Equal());
		simConfig.addMapping(new Attribute("mitigations", AttackCaseComponent.class), new Equal());

		TableSimilarity severitySimilarity = new TableSimilarity((Arrays.asList(new String[] {"Low","Medium","High", "VeryHigh"})));
		severitySimilarity.setSimilarity("Low", "Medium", .9);
		severitySimilarity.setSimilarity("Low", "High", .7);
		severitySimilarity.setSimilarity("Low", "VeryHigh", .7);
		severitySimilarity.setSimilarity("Medium", "VeryHigh", .5);
		severitySimilarity.setSimilarity("Medium", "High", .7);
		severitySimilarity.setSimilarity("High", "VeryHigh", .9);
		simConfig.addMapping(new Attribute("severity", AttackCaseComponent.class), severitySimilarity);
		
		TableSimilarity likelihoodSimilarity = new TableSimilarity((Arrays.asList(new String[] {"Low","Medium","High"})));
		likelihoodSimilarity.setSimilarity("Low", "Medium", .9);
		likelihoodSimilarity.setSimilarity("Low", "High", .7);
		likelihoodSimilarity.setSimilarity("Medium", "High", .7);
		simConfig.addMapping(new Attribute("likelihood", AttackCaseComponent.class), likelihoodSimilarity);
	}

	private List<String> getPrerequisitesEnums() {
		List<String> prerequisites = new ArrayList();
		
		prerequisites.add(Prerequisites.A_SIM_card_that_relies_on_the_DES_cipher.toString());
		
		prerequisites.add(Prerequisites.Access_to_the_component_currently_deployed_at_a_victim_location.toString());
		prerequisites.add(Prerequisites.Access_to_the_software_during_the_development_phase.toString());
		prerequisites.add(Prerequisites.An_attacker_and_the_victim_are_both_using_the_same_WiFi_network.toString());
		prerequisites.add(Prerequisites.Application_is_connected_to_the_Windows_domain.toString());
		prerequisites.add(Prerequisites.Configuration_files_must_be_modifiable_by_the_attacker.toString());
		prerequisites.add(Prerequisites.HTTP_TRACE_is_enabled_on_the_web_server.toString());
		prerequisites.add(Prerequisites.Physical_access_to_the_system.toString());
		prerequisites.add(Prerequisites.Requires_the_existence_of_a_physical_target.toString());
		prerequisites.add(Prerequisites.Session_identifiers_that_remain_unchanged_when_the_privilege_levels_change.toString());
		prerequisites.add(Prerequisites.Targeted_software_is_utilizing_application_framework_APIs.toString());
		prerequisites.add(Prerequisites.The_ability_to_calculate_a_card_checksum_and_write_out_a_valid_checksum_value.toString());
		prerequisites.add(Prerequisites.The_adversary_requires_knowledge_of_and_access_to_network_route.toString());
		prerequisites.add(Prerequisites.The_attacker_must_have_direct_access_to_the_target_server.toString());
		prerequisites.add(Prerequisites.The_target_host_is_logging_the_action_and_data_of_the_user.toString());
		prerequisites.add(Prerequisites.The_target_must_use_the_affected_file_without_verifying_its_integrity.toString());
		prerequisites.add(Prerequisites.The_targeted_site_must_contain_hidden_fields_to_be_modified.toString());
		prerequisites.add(Prerequisites.The_various_resources_must_be_discoverable_by_the_attacker.toString());
		prerequisites.add(Prerequisites.Advanced_knowledge_about_the_target_system_and_sub_components.toString());
		return prerequisites;
	}




}
