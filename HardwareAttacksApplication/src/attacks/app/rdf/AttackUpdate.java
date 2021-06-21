package attacks.app.rdf;
import java.util.ArrayList;

import attacks.app.enumerations.Likelihood;
import attacks.app.enumerations.Prerequisites;
import attacks.app.enumerations.Severity;
import attacks.app.model.Attack;

public class AttackUpdate{


    public AttackUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void action(Attack newAttack, String id, String name, String severity, String likelyhood, String weaknesses, String prerequisites, String mitigations) {
        newAttack.setId(id);
        newAttack.setName(name);
      
		        
        
        if (likelyhood.equals("Low")) {
			newAttack.setLikelihood(Likelihood.Low);
		} else if (likelyhood.equals("Medium")) {
			newAttack.setLikelihood(Likelihood.Medium);
		}else {
			newAttack.setLikelihood(Likelihood.High);
		}
        
        
        if (severity.equals("Low")) {
			newAttack.setSeverity(Severity.Low);
		} else if (severity.equals("Medium")) {
			newAttack.setSeverity(Severity.Medium);
		}else if (severity.equals("High")) {
			newAttack.setSeverity(Severity.High);
		}else {
			newAttack.setSeverity(Severity.Very_high);
		}
        
        
        if(prerequisites.equals("The_target_host_is_logging_the_action_and_data_of_the_user")) {
        
			newAttack.setPrerequisites(Prerequisites.The_target_host_is_logging_the_action_and_data_of_the_user);

        }else if(prerequisites.equals("The_target_must_use_the_affected_file_without_verifying_its_integrity")) {
			newAttack.setPrerequisites(Prerequisites.The_target_must_use_the_affected_file_without_verifying_its_integrity);

        }
        else if(prerequisites.equals("Configuration_files_must_be_modifiable_by_the_attacker")) {
			newAttack.setPrerequisites(Prerequisites.Configuration_files_must_be_modifiable_by_the_attacker);

        }else if(prerequisites.equals("A_SIM_card_that_relies_on_the_DES_cipher")) {
			newAttack.setPrerequisites(Prerequisites.A_SIM_card_that_relies_on_the_DES_cipher);

        }else if(prerequisites.equals("Access_to_the_software_during_the_development_phase")) {
			newAttack.setPrerequisites(Prerequisites.Access_to_the_software_during_the_development_phase);

        }else if(prerequisites.equals("Physical_access_to_the_system")) {
			newAttack.setPrerequisites(Prerequisites.Physical_access_to_the_system);

        }else if(prerequisites.equals("Advanced_knowledge_about_the_target_system_and_sub_components")) {
			newAttack.setPrerequisites(Prerequisites.Advanced_knowledge_about_the_target_system_and_sub_components);

        }else if(prerequisites.equals("Access_to_the_component_currently_deployed_at_a_victim_location")) {
			newAttack.setPrerequisites(Prerequisites.Access_to_the_component_currently_deployed_at_a_victim_location);

        }else if(prerequisites.equals("The_adversary_requires_knowledge_of_and_access_to_network_route")) {
			newAttack.setPrerequisites(Prerequisites.The_adversary_requires_knowledge_of_and_access_to_network_route);

        }else if(prerequisites.equals("An_attacker_and_the_victim_are_both_using_the_same_WiFi_network")) {
			newAttack.setPrerequisites(Prerequisites.An_attacker_and_the_victim_are_both_using_the_same_WiFi_network);

        }else if(prerequisites.equals("HTTP_TRACE_is_enabled_on_the_web_server")) {
			newAttack.setPrerequisites(Prerequisites.HTTP_TRACE_is_enabled_on_the_web_server);

        }else if(prerequisites.equals("Session_identifiers_that_remain_unchanged_when_the_privilege_levels_change")) {
			newAttack.setPrerequisites(Prerequisites.Session_identifiers_that_remain_unchanged_when_the_privilege_levels_change);

        }else if(prerequisites.equals("The_targeted_site_must_contain_hidden_fields_to_be_modified")) {
			newAttack.setPrerequisites(Prerequisites.The_targeted_site_must_contain_hidden_fields_to_be_modified);

        }
        else if(prerequisites.equals("The_targeted_site_must_contain_hidden_fields_to_be_modified")) {
			newAttack.setPrerequisites(Prerequisites.The_targeted_site_must_contain_hidden_fields_to_be_modified);

        }else if(prerequisites.equals("Targeted_software_is_utilizing_application_framework_APIs")) {
			newAttack.setPrerequisites(Prerequisites.Targeted_software_is_utilizing_application_framework_APIs);

        }else if(prerequisites.equals("The_attacker_must_have_direct_access_to_the_target_server")) {
			newAttack.setPrerequisites(Prerequisites.The_attacker_must_have_direct_access_to_the_target_server);

        }else if(prerequisites.equals("Web_services_check_the_signature_of_the_API_calls")) {
			newAttack.setPrerequisites(Prerequisites.Web_services_check_the_signature_of_the_API_calls);

        }else if(prerequisites.equals("The_various_resources_must_be_discoverable_by_the_attacker")) {
			newAttack.setPrerequisites(Prerequisites.The_various_resources_must_be_discoverable_by_the_attacker);

        }else if(prerequisites.equals("The_ability_to_calculate_a_card_checksum_and_write_out_a_valid_checksum_value")) {
			newAttack.setPrerequisites(Prerequisites.The_ability_to_calculate_a_card_checksum_and_write_out_a_valid_checksum_value);

        }else if(prerequisites.equals("Requires_the_existence_of_a_physical_target")) {
			newAttack.setPrerequisites(Prerequisites.Requires_the_existence_of_a_physical_target);

        }else if(prerequisites.equals("Application_is_connected_to_the_Windows_domain")) {
			newAttack.setPrerequisites(Prerequisites.Application_is_connected_to_the_Windows_domain);

        }
        
   

        if (severity.equals(Severity.Low.toString())) {
            newAttack.setSeverity(Severity.Low);
        } else {
            newAttack.setSeverity(Severity.High);
        }




        InsertAttack insert = new InsertAttack(newAttack);
        insert.insert();

    }
}
