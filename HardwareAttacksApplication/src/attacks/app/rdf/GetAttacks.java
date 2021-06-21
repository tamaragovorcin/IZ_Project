package attacks.app.rdf;

import java.util.ArrayList;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFactory;
import org.apache.jena.query.ResultSetRewindable;
import org.apache.jena.rdf.model.Literal;

import attacks.app.Singleton;
import attacks.app.enumerations.Likelihood;
import attacks.app.enumerations.Prerequisites;
import attacks.app.enumerations.Severity;
import attacks.app.model.Attack;




public class GetAttacks {

    private static final String QUERY_URL = "http://localhost:3030/inzenjeringznanja/sparql";
    private static final String PREFIX = "PREFIX na: <http://www.inzenjeringznanja.com/na#> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";

    private Attacks attacks;

    public GetAttacks() {
        this.attacks = new Attacks();
    }
    
    public ArrayList<Attack> getAttacks() {
        ArrayList<Attack> attacks = new ArrayList();
     //  this.attacks.getAttacks().clear();
        
        String selectString = PREFIX + " SELECT ?id ?name ?likelihood ?weaknesses ?severity ?mitigations ?prerequisites " + "WHERE { "
                + "    ?attack a na:Attack; " 
                + "    na:id ?id ; " 
                + "       na:name ?name; "
                + "       na:likelihood ?likelihood; "
                + "       na:weaknesses ?weaknesses; "
                + "       na:severity ?severity; "
                + "       na:prerequisites ?prerequisites; "
                + "       na:mitigations ?mitigations . }";

        Query query = QueryFactory.create(selectString);
        try {
            QueryExecution qexec = QueryExecutionFactory.sparqlService(QUERY_URL, query);
            ResultSet results = qexec.execSelect();
            ResultSetRewindable resultSetRewindble = ResultSetFactory.copyResults(results);
            qexec.close();
            while (resultSetRewindble.hasNext()) {
                QuerySolution solution = resultSetRewindble.nextSolution();
                Literal literalId = solution.getLiteral("id");
                Literal literalName = solution.getLiteral("name");
                Literal literalLikelihood = solution.getLiteral("likelihood");
                Literal literalWeaknesses = solution.getLiteral("weaknesses");
                Literal literalSeverity= solution.getLiteral("severity");
                Literal literalMitigations = solution.getLiteral("mitigations");
                Literal literalPrerequisites = solution.getLiteral("prerequisites");
                Attack newAttack = new Attack();
                newAttack.setId(literalId.getString());
                newAttack.setName(literalName.getString());
                
                
                if (literalLikelihood.getString().equals("Low")) {
					newAttack.setLikelihood(Likelihood.Low);
				} else if (literalLikelihood.getString().equals("Medium")) {
					newAttack.setLikelihood(Likelihood.Medium);
				}else {
					newAttack.setLikelihood(Likelihood.High);
				}
                
                
                if (literalSeverity.getString().equals("Low")) {
					newAttack.setSeverity(Severity.Low);
				} else if (literalSeverity.getString().equals("Medium")) {
					newAttack.setSeverity(Severity.Medium);
				}else if (literalSeverity.getString().equals("High")) {
					newAttack.setSeverity(Severity.High);
				}else {
					newAttack.setSeverity(Severity.Very_high);
				}
                
                System.out.println("preres: "+literalPrerequisites.toString());
                
                if(literalPrerequisites.getString().equals("The_target_host_is_logging_the_action_and_data_of_the_user")) {
                    
        			newAttack.setPrerequisites(Prerequisites.The_target_host_is_logging_the_action_and_data_of_the_user);

                }else if(literalPrerequisites.getString().equals("The_target_must_use_the_affected_file_without_verifying_its_integrity")) {
        			newAttack.setPrerequisites(Prerequisites.The_target_must_use_the_affected_file_without_verifying_its_integrity);

                }
                else if(literalPrerequisites.getString().equals("Configuration_files_must_be_modifiable_by_the_attacker")) {
        			newAttack.setPrerequisites(Prerequisites.Configuration_files_must_be_modifiable_by_the_attacker);

                }else if(literalPrerequisites.getString().equals("A_SIM_card_that_relies_on_the_DES_cipher")) {
        			newAttack.setPrerequisites(Prerequisites.A_SIM_card_that_relies_on_the_DES_cipher);

                }else if(literalPrerequisites.getString().equals("Access_to_the_software_during_the_development_phase")) {
        			newAttack.setPrerequisites(Prerequisites.Access_to_the_software_during_the_development_phase);

                }else if(literalPrerequisites.getString().equals("Physical_access_to_the_system")) {
        			newAttack.setPrerequisites(Prerequisites.Physical_access_to_the_system);

                }else if(literalPrerequisites.getString().equals("Advanced_knowledge_about_the_target_system_and_sub_components")) {
        			newAttack.setPrerequisites(Prerequisites.Advanced_knowledge_about_the_target_system_and_sub_components);

                }else if(literalPrerequisites.getString().equals("Access_to_the_component_currently_deployed_at_a_victim_location")) {
        			newAttack.setPrerequisites(Prerequisites.Access_to_the_component_currently_deployed_at_a_victim_location);

                }else if(literalPrerequisites.getString().equals("The_adversary_requires_knowledge_of_and_access_to_network_route")) {
        			newAttack.setPrerequisites(Prerequisites.The_adversary_requires_knowledge_of_and_access_to_network_route);

                }else if(literalPrerequisites.getString().equals("An_attacker_and_the_victim_are_both_using_the_same_WiFi_network")) {
        			newAttack.setPrerequisites(Prerequisites.An_attacker_and_the_victim_are_both_using_the_same_WiFi_network);

                }else if(literalPrerequisites.getString().equals("HTTP_TRACE_is_enabled_on_the_web_server")) {
        			newAttack.setPrerequisites(Prerequisites.HTTP_TRACE_is_enabled_on_the_web_server);

                }else if(literalPrerequisites.getString().equals("Session_identifiers_that_remain_unchanged_when_the_privilege_levels_change")) {
        			newAttack.setPrerequisites(Prerequisites.Session_identifiers_that_remain_unchanged_when_the_privilege_levels_change);

                }else if(literalPrerequisites.getString().equals("The_targeted_site_must_contain_hidden_fields_to_be_modified")) {
        			newAttack.setPrerequisites(Prerequisites.The_targeted_site_must_contain_hidden_fields_to_be_modified);

                }
                else if(literalPrerequisites.getString().equals("The_targeted_site_must_contain_hidden_fields_to_be_modified")) {
        			newAttack.setPrerequisites(Prerequisites.The_targeted_site_must_contain_hidden_fields_to_be_modified);

                }else if(literalPrerequisites.getString().equals("Targeted_software_is_utilizing_application_framework_APIs")) {
        			newAttack.setPrerequisites(Prerequisites.Targeted_software_is_utilizing_application_framework_APIs);

                }else if(literalPrerequisites.getString().equals("The_attacker_must_have_direct_access_to_the_target_server")) {
        			newAttack.setPrerequisites(Prerequisites.The_attacker_must_have_direct_access_to_the_target_server);

                }else if(literalPrerequisites.getString().equals("Web_services_check_the_signature_of_the_API_calls")) {
        			newAttack.setPrerequisites(Prerequisites.Web_services_check_the_signature_of_the_API_calls);

                }else if(literalPrerequisites.getString().equals("The_various_resources_must_be_discoverable_by_the_attacker")) {
        			newAttack.setPrerequisites(Prerequisites.The_various_resources_must_be_discoverable_by_the_attacker);

                }else if(literalPrerequisites.getString().equals("The_ability_to_calculate_a_card_checksum_and_write_out_a_valid_checksum_value")) {
        			newAttack.setPrerequisites(Prerequisites.The_ability_to_calculate_a_card_checksum_and_write_out_a_valid_checksum_value);

                }else if(literalPrerequisites.getString().equals("Requires_the_existence_of_a_physical_target")) {
        			newAttack.setPrerequisites(Prerequisites.Requires_the_existence_of_a_physical_target);

                }else if(literalPrerequisites.getString().equals("Application_is_connected_to_the_Windows_domain")) {
        			newAttack.setPrerequisites(Prerequisites.Application_is_connected_to_the_Windows_domain);

                }
                
                
                String mitigations = literalMitigations.getString();
               
             
            	newAttack.setMitigations(mitigations);
                
                String weaknesses = literalWeaknesses.getString();
                newAttack.setWeaknesse(weaknesses);
               
                ArrayList<Attack> attacksNova = new ArrayList();
            
                attacksNova.add(newAttack);
                
                this.attacks.setAttacks(attacksNova);
                for ( Attack at : this.attacks.getAttacks()) {
                   
                    attacks.add(newAttack);
                }
            }

           // Singleton.getInstance().setAttacks(attacks);
           
            return attacks;

        } catch (Exception e) {
            System.out.println("GRESKA SELECT NAREDBA EXAMINATIONS");
            e.printStackTrace();
        }

        return null;
    }

}