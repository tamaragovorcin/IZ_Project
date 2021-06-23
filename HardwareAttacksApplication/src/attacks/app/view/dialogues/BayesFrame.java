package attacks.app.view.dialogues;


import ucm.gaia.jcolibri.exception.ExecutionException;
import unbbayes.io.BaseIO;
import unbbayes.io.NetIO;
import unbbayes.io.exception.LoadException;
import unbbayes.prs.Node;
import unbbayes.prs.bn.JunctionTreeAlgorithm;
import unbbayes.prs.bn.ProbabilisticNetwork;
import unbbayes.prs.bn.ProbabilisticNode;
import unbbayes.util.extension.bn.inference.IInferenceAlgorithm;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import org.apache.jena.sparql.function.library.max;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.*;

public class BayesFrame extends JFrame {
    public static ArrayList<String> selected = new ArrayList<>();
    public static boolean rbr = true;
    private JFrame mainFrame = new JFrame("Hardware attacks");
    private JPanel checkPanel = new JPanel();
    private JPanel mainPanel = new JPanel(new BorderLayout());
    private JPanel descPanel = new JPanel(new BorderLayout());
    public static Map.Entry<String, Float> maxEntry = null;
    public static String attack = "";


    public BayesFrame() {

        try {
            ProbabilisticNetwork net = new ProbabilisticNetwork("app");

            BaseIO io = new NetIO();


            net = (ProbabilisticNetwork) io.load(new File("data/bajesMreze/bajes.net"));


            IInferenceAlgorithm algorithm = new JunctionTreeAlgorithm();
            algorithm.setNetwork(net);
            algorithm.run();

            try {
                net.updateEvidences();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            List<Node> nodeList = net.getNodes();

            Border blackline2 = BorderFactory.createLineBorder(Color.BLACK);
            TitledBorder title2 = BorderFactory.createTitledBorder(blackline2, "Probability of attack");
            title2.setTitleJustification(TitledBorder.CENTER);

          

            JTextArea konacneVrv = new JTextArea();
            konacneVrv.setBorder(title2);
            konacneVrv.setEditable(false);
            descPanel.add(konacneVrv, BorderLayout.CENTER);
            ImageIcon donIm2 = new ImageIcon("./done.png");
            Image doneImg2 = donIm2.getImage(); // transform it
            Image newDoneImg2 = doneImg2.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            donIm2 = new ImageIcon(newDoneImg2);
            JButton done = new JButton("DoneCBR", donIm2);
            done.setVisible(false);



          

            checkPanel.setLayout(new BoxLayout(checkPanel, BoxLayout.Y_AXIS));
            checkPanel.setAutoscrolls(true);
            checkPanel.setPreferredSize(new Dimension(500,700));
            JCheckBox Lack_Of_Unserstanding_of_Cyber_Security_Incidents = new JCheckBox("Lack_Of_Unserstanding_of_Cyber_Security_Incidents");
            JCheckBox Incorrectly_configured_firewalls = new JCheckBox("Incorrectly_configured_firewalls");
            JCheckBox Improper_data_classification = new JCheckBox("Improper_data_classification");
            JCheckBox Lack_of_employee_awareness = new JCheckBox("Lack_of_employee_awareness");
            JCheckBox Phishing_Emails = new JCheckBox("Phishing_Emails");
            JCheckBox Unpatched_operating_systems = new JCheckBox("Unpatched_operating_systems");
            JCheckBox Unsecured_networks = new JCheckBox("Unsecured_networks");
            JCheckBox Outdated_antivirus = new JCheckBox("Outdated_antivirus");
            JCheckBox Authentication = new JCheckBox("Authentication");
            JCheckBox Requires_prerequisites = new JCheckBox("Prerequisites");
            JLabel Skill = new JLabel("Skill level:");
            JCheckBox Low_Skill = new JCheckBox("Low");
            JCheckBox Medium_Skill = new JCheckBox("Medium");
            JCheckBox High_Skill = new JCheckBox("High");

            JLabel Likelyhood = new JLabel("Likelyhood level:");
            JCheckBox Low_Likelyhood = new JCheckBox("Low");
            JCheckBox Medium_Likelyhood = new JCheckBox("Medium");
            JCheckBox High_Likelyhood = new JCheckBox("High");
            
            JLabel Access_Complexity = new JLabel("Access_Complexity level:");
            JCheckBox Low_Access_Complexity = new JCheckBox("Low");
            JCheckBox Medium_Access_Complexity= new JCheckBox("Medium");
            JCheckBox High_Access_Complexity = new JCheckBox("High");
            
            JLabel Country_region = new JLabel("Country region:");
            JCheckBox North_America = new JCheckBox("North_America");
            JCheckBox South_America = new JCheckBox("South_America");
            JCheckBox Asia = new JCheckBox("Asia");
            JCheckBox Africa = new JCheckBox("Africa");
            JCheckBox Australia = new JCheckBox("Australia");
            JCheckBox Northwestern_Europe = new JCheckBox("Northwestern_Europe");
            JCheckBox Southeast_Europe  = new JCheckBox("Southeast_Europe");
            
            JLabel Number_of_empoyees = new JLabel("Number of empoyees:");
            JCheckBox one_five = new JCheckBox("1-5");
            JCheckBox five_twenty= new JCheckBox("5-20");
            JCheckBox twenty_fifty = new JCheckBox("20-50");
            JCheckBox fifty_plus= new JCheckBox("50+");


            JLabel napad = new JLabel();
            JLabel procenat =  new JLabel();
            for (String s : selected) {
                if (s.equals("Incorrectly_configured_firewalls")) {
                	Incorrectly_configured_firewalls.setSelected(true);
                } else if (s.equals("Incorrectly_configured_firewalls")) {
                	Incorrectly_configured_firewalls.setSelected(true);
                } else if (s.equals("Improper_data_classification")) {
                	Improper_data_classification.setSelected(true);
                } else if (s.equals("Lack_of_employee_awareness")) {
                	Lack_of_employee_awareness.setSelected(true);
                } else if (s.equals("Phishing_Emails")) {
                	Phishing_Emails.setSelected(true);
                } else if (s.equals("Unpatched_operating_systems")) {
                	Unpatched_operating_systems.setSelected(true);
                } else if (s.equals("Unsecured_networks")) {
                	Unsecured_networks.setSelected(true);
                } else if (s.equals("Outdated_antivirus")) {
                	Outdated_antivirus.setSelected(true);
                } else if (s.equals("Authentication")) {
                	Authentication.setSelected(true);
                } else if (s.equals("Low_Access_Complexity")) {
                	Low_Access_Complexity.setSelected(true);
                } else if (s.equals("Requires_prerequisites")) {
                	Requires_prerequisites.setSelected(true);
                } else if (s.equals("Low_Likelyhood")) {
                	Low_Likelyhood.setSelected(true);
                } else if (s.equals("Low_Skill")) {
                	Low_Skill.setSelected(true);
                } else if (s.equals("Medium_Access_Complexity")) {
                	Medium_Access_Complexity.setSelected(true);
                } else if (s.equals("Medium_Likelyhood")) {
                	Medium_Likelyhood.setSelected(true);
                } else if (s.equals("Medium_Skill")) {
                	Medium_Skill.setSelected(true);
                } else if (s.equals("High_Access_Complexity")) {
                	High_Access_Complexity.setSelected(true);
                } else if (s.equals("High_Skill")) {
                	High_Skill.setSelected(true);
                } else if (s.equals("High_Likelyhood")) {
                	High_Likelyhood.setSelected(true);
                } else if (s.equals("North_America")) {
                	North_America.setSelected(true);
                } else if (s.equals("South_America")) {
                	South_America.setSelected(true);
                } else if (s.equals("Southeast_Europe")) {
                	Southeast_Europe.setSelected(true);
                } else if (s.equals("Northwestern_Europe")) {
                	Northwestern_Europe.setSelected(true);
                } else if (s.equals("Asia")) {
                	Asia.setSelected(true);
                } else if (s.equals("Africa")) {
                	Africa.setSelected(true);
                } else if (s.equals("Australia")) {
	                	Australia.setSelected(true);
	            } else if (s.equals("one_five")) {
	            	one_five.setSelected(true);
	            } else if (s.equals("five_twenty")) {
	            	five_twenty.setSelected(true);
	            } else if (s.equals("twenty_fifty")) {
	            	twenty_fifty.setSelected(true);
	            } else if (s.equals("fifty_plus")) {
	            	fifty_plus.setSelected(true);
	            }
                
            }
            ImageIcon fin = new ImageIcon("./finish.png");
            Image finIm = fin.getImage(); // transform it
            Image newimgF = finIm.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            fin = new ImageIcon(newimgF);
            JButton rbrBtn = new JButton("Estimate ", fin);

            

          

            rbrBtn.addActionListener(new ActionListener() {
                @Override
                public  void actionPerformed(ActionEvent arg0) {

                    // TODO Auto-generated method stub
                    rbr = true;
                    done.setVisible(false);

                    Set<String> selektovaniSimptomi = new HashSet<String>();
                    ProbabilisticNetwork net = new ProbabilisticNetwork("app");

                    BaseIO io = new NetIO();


                    try {
						net = (ProbabilisticNetwork) io.load(new File("data/bajesMreze/bajes.net"));
					} catch (LoadException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}


                    IInferenceAlgorithm algorithm = new JunctionTreeAlgorithm();
                    algorithm.setNetwork(net);
                    algorithm.run();

                   
                    for (Node node : nodeList) {
                        if (Lack_Of_Unserstanding_of_Cyber_Security_Incidents.isSelected()) {
                            selektovaniSimptomi.add("Lack_Of_Unserstanding_of_Cyber_Security_Incidents");
                            if (node.getName().equals("Lack_Of_Unserstanding_of_Cyber_Security_Incidents")) {
                                ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Lack_Of_Unserstanding_of_Cyber_Security_Incidents");
                                godine.addFinding(0);
                              
                               
                                
                            }
                        }
                        if (Incorrectly_configured_firewalls.isSelected()) {
                            selektovaniSimptomi.add("Incorrectly_configured_firewalls");
                            if (node.getName().equals("Incorrectly_configured_firewalls")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Incorrectly_configured_firewalls");
                                 godine.addFinding(0);
                                
                            }
                        }
                        if (Improper_data_classification.isSelected()) {
                            selektovaniSimptomi.add("Improper_data_classification");
                            if (node.getName().equals("Improper_data_classification")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Improper_data_classification");
                                 godine.addFinding(0);
                                
                            }
                        }
                        if (Lack_of_employee_awareness.isSelected()) {
                            selektovaniSimptomi.add("Lack_of_employee_awareness");
                            if (node.getName().equals("Lack_of_employee_awareness")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Lack_of_employee_awareness");
                                 godine.addFinding(0);
                               
                            }
                        }
                        if (Phishing_Emails.isSelected()) {
                            selektovaniSimptomi.add("Phishing_Emails");
                            if (node.getName().equals("Phishing_Emails")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Phishing_Emails");
                                 godine.addFinding(0);
                                
                            }
                        }
                        if (Unpatched_operating_systems.isSelected()) {
                            selektovaniSimptomi.add("Unpatched_operating_systems");
                            if (node.getName().equals("Unpatched_operating_systems")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Unpatched_operating_systems");
                                 godine.addFinding(0);
                                
                            }
                        }
                        if (Unsecured_networks.isSelected()) {
                            selektovaniSimptomi.add("Unsecured_networks");
                            if (node.getName().equals("Unsecured_networks")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Unsecured_networks");
                                 godine.addFinding(0);
                                
                            }
                        }
                        if (Outdated_antivirus.isSelected()) {
                            selektovaniSimptomi.add("Outdated_antivirus");
                            if (node.getName().equals("Outdated_antivirus")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Outdated_antivirus");
                                 godine.addFinding(0);
                                
                            }
                        }
                        if (Low_Likelyhood.isSelected()) {
                            selektovaniSimptomi.add("Likelyhood");
                            if (node.getName().equals("Likelyhood")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Likelyhood");
                                 godine.addFinding(0);
                                
                            }
                        }
                        if (Authentication.isSelected()) {
                            selektovaniSimptomi.add("Authentication");
                            if (node.getName().equals("Authentication")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Authentication");
                                 godine.addFinding(0);
                                 
                                
                            }
                        }
                        if (Low_Access_Complexity.isSelected()) {
                            selektovaniSimptomi.add("Low_Access_Complexity");
                            if (node.getName().equals("Access_Complexity")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Access_Complexity");
                                 godine.addFinding(0);
                                
                            }
                        }
                        if (Requires_prerequisites.isSelected()) {
                            selektovaniSimptomi.add("Requires_prerequisites");
                            if (node.getName().equals("Requires_prerequisites")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Requires_prerequisites");
                                 godine.addFinding(0);
                                 
                            }
                        }
                        if (Low_Skill.isSelected()) {
                            selektovaniSimptomi.add("Low_Skill");
                            if (node.getName().equals("Skill")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Skill");
                                 godine.addFinding(0);
                                
                            }
                        }
                        if (Medium_Access_Complexity.isSelected()) {
                            selektovaniSimptomi.add("Medium_Access_Complexity");

                            if (node.getName().equals("Access_Complexity")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Access_Complexity");
                                 godine.addFinding(1);
                                
                            }
                        }
                        if (Medium_Likelyhood.isSelected()) {
                            selektovaniSimptomi.add("Medium_Likelyhood");
                            if (node.getName().equals("Likelyhood")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Likelyhood");
                                 godine.addFinding(1);
                                
                            }
                        }
                        if (Medium_Skill.isSelected()) {
                            selektovaniSimptomi.add("Medium_Skill");
                            if (node.getName().equals("Skill")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Skill");
                                 godine.addFinding(1);
                                
                            }
                        }
                        if (High_Access_Complexity.isSelected()) {
                            selektovaniSimptomi.add("High_Access_Complexity");
                            if (node.getName().equals("Access_Complexity")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Access_Complexity");
                                 godine.addFinding(2);
                                
                            }
                        }
                        if (High_Likelyhood.isSelected()) {
                            selektovaniSimptomi.add("High_Likelyhood");
                            if (node.getName().equals("Likelyhood")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Likelyhood");
                                 godine.addFinding(2);
                                
                            }
                        }
                        if (High_Skill.isSelected()) {
                            selektovaniSimptomi.add("High_Skill");
                            if (node.getName().equals("Skill")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Skill");
                                 godine.addFinding(2);
                                
                            }
                        }
                        if (High_Skill.isSelected()) {
                            selektovaniSimptomi.add("High_Skill");
                            if (node.getName().equals("Country_region")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Skill");
                                 godine.addFinding(2);
                                
                            }
                        }
                        if (North_America.isSelected()) {
                            selektovaniSimptomi.add("North_America");
                            if (node.getName().equals("Country_region")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Country_region");
                                 godine.addFinding(0);
                                
                            }
                        }
                        if (South_America.isSelected()) {
                            selektovaniSimptomi.add("South_America");
                            if (node.getName().equals("Country_region")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Country_region");
                                 godine.addFinding(1);
                                
                            }
                        }
                        if (Africa.isSelected()) {
                            selektovaniSimptomi.add("Africa");
                            if (node.getName().equals("Country_region")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Country_region");
                                 godine.addFinding(2);
                                
                            }
                        }
                        if (Northwestern_Europe.isSelected()) {
                            selektovaniSimptomi.add("Northwestern_Europe");
                            if (node.getName().equals("Country_region")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Country_region");
                                 godine.addFinding(3);
                                
                            }
                        }
                        if (Southeast_Europe.isSelected()) {
                            selektovaniSimptomi.add("Southeast_Europe");
                            if (node.getName().equals("Country_region")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Country_region");
                                 godine.addFinding(4);
                                
                            }
                        }
                        if (Asia.isSelected()) {
                            selektovaniSimptomi.add("Asia");
                            if (node.getName().equals("Country_region")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Country_region");
                                 godine.addFinding(5);
                                
                            }
                        }
                        if (Australia.isSelected()) {
                            selektovaniSimptomi.add("Australia");
                            if (node.getName().equals("Country_region")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Country_region");
                                 godine.addFinding(6);
                                
                            }
                        }
                        if (one_five.isSelected()) {
                            selektovaniSimptomi.add("one_five");
                            if (node.getName().equals("Number_of_empoyees")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Number_of_empoyees");
                                 godine.addFinding(0);
                                
                            }
                        }
                        if (five_twenty.isSelected()) {
                            selektovaniSimptomi.add("five_twenty");
                            if (node.getName().equals("Number_of_empoyees")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Number_of_empoyees");
                                 godine.addFinding(1);
                                
                            }
                        }
                        if (twenty_fifty.isSelected()) {
                            selektovaniSimptomi.add("twenty_fifty");
                            if (node.getName().equals("Number_of_empoyees")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Number_of_empoyees");
                                 godine.addFinding(2);
                                
                            }
                        }
                        if (fifty_plus.isSelected()) {
                            selektovaniSimptomi.add("fifty_plus");
                            if (node.getName().equals("Number_of_empoyees")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Number_of_empoyees");
                                 godine.addFinding(3);
                                
                            }
                        }


                    }
                  
                    try {
                        net.updateEvidences();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    
                 


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
                    
                    HashMap<String,Float> attacks = new HashMap<>();
                    attacks.put("Obstruction", ((ProbabilisticNode) net.getNode("Obstruction")).getMarginalAt(0));
                    attacks.put("Cellular_Jamming", ((ProbabilisticNode) net.getNode("Cellular_Jamming")).getMarginalAt(0));
                    attacks.put("File_Manipulation", ((ProbabilisticNode) net.getNode("File_Manipulation")).getMarginalAt(0));
                    attacks.put("Configaration_Environment_Manipulation", ((ProbabilisticNode) net.getNode("Configaration_Environment_Manipulation")).getMarginalAt(0));
                    attacks.put("Infrastructure_Manipulation", ((ProbabilisticNode) net.getNode("Infrastructure_Manipulation")).getMarginalAt(0));
                    attacks.put("Software_Integrity_Attack", ((ProbabilisticNode) net.getNode("Software_Integrity_Attack")).getMarginalAt(0));
                    attacks.put("Modification_During_Manufacture", ((ProbabilisticNode) net.getNode("Modification_During_Manufacture")).getMarginalAt(0));
                    attacks.put("Manipulation_During_Distribution", ((ProbabilisticNode) net.getNode("Manipulation_During_Distribution")).getMarginalAt(0));
                    attacks.put("Hardware_Integrity_Attack", ((ProbabilisticNode) net.getNode("Hardware_Integrity_Attack")).getMarginalAt(0));
                    attacks.put("Malicious_Logic_Insertion", ((ProbabilisticNode) net.getNode("Malicious_Logic_Insertion")).getMarginalAt(0));
                    attacks.put("Exploitation_of_Trusted_Identifiers", ((ProbabilisticNode) net.getNode("Exploitation_of_Trusted_Identifiers")).getMarginalAt(0));
                    attacks.put("Contaminate_Resource", ((ProbabilisticNode) net.getNode("Contaminate_Resource")).getMarginalAt(0));
                    attacks.put("Authentication_Abuse", ((ProbabilisticNode) net.getNode("Authentication_Abuse")).getMarginalAt(0));
                    attacks.put("Authentication_Bypass", ((ProbabilisticNode) net.getNode("Authentication_Bypass")).getMarginalAt(0));
                    attacks.put("Physical_Theft", ((ProbabilisticNode) net.getNode("Physical_Theft")).getMarginalAt(0));
                    attacks.put("Use_of_Known_Domain_Credentials", ((ProbabilisticNode) net.getNode("Use_of_Known_Domain_Credentials")).getMarginalAt(0));
                    attacks.put("Infected_Memory", ((ProbabilisticNode) net.getNode("Infected_Memory")).getMarginalAt(0));
                    attacks.put("Bypassing_Physical_Security", ((ProbabilisticNode) net.getNode("Bypassing_Physical_Security")).getMarginalAt(0));
                    attacks.put("Man_in_the_Middle_Attack", ((ProbabilisticNode) net.getNode("Man_in_the_Middle_Attack")).getMarginalAt(0));
                    attacks.put("Privilege_Abuse", ((ProbabilisticNode) net.getNode("Privilege_Abuse")).getMarginalAt(0));
                    attacks.put("Cache_poisoning", ((ProbabilisticNode) net.getNode("Cache_poisoning")).getMarginalAt(0));
                    attacks.put("Audit_Log_Manipulation", ((ProbabilisticNode) net.getNode("Audit_Log_Manipulation")).getMarginalAt(0));
                    attacks.put("DNS_Cache_Poisoning", ((ProbabilisticNode) net.getNode("DNS_Cache_Poisoning")).getMarginalAt(0));
                    attacks.put("Web_Logs_Tampering", ((ProbabilisticNode) net.getNode("Web_Logs_Tampering")).getMarginalAt(0));
                    attacks.put("Artificially_Inflate_File_Sizes", ((ProbabilisticNode) net.getNode("Artificially_Inflate_File_Sizes")).getMarginalAt(0));
                    attacks.put("Use_of_Captured_Hashes", ((ProbabilisticNode) net.getNode("Use_of_Captured_Hashes")).getMarginalAt(0));
                    attacks.put("Modification_of_Registry_Run_Keys", ((ProbabilisticNode) net.getNode("Modification_of_Registry_Run_Keys")).getMarginalAt(0));
                    attacks.put("Schema_Poisoning", ((ProbabilisticNode) net.getNode("Schema_Poisoning")).getMarginalAt(0));
                    attacks.put("Design_Alteration", ((ProbabilisticNode) net.getNode("Design_Alteration")).getMarginalAt(0));
                    attacks.put("IP_Address_Blocking", ((ProbabilisticNode) net.getNode("IP_Address_Blocking")).getMarginalAt(0));
                    attacks.put("Route_Disabling", ((ProbabilisticNode) net.getNode("Route_Disabling")).getMarginalAt(0));
                    attacks.put("Jamming", ((ProbabilisticNode) net.getNode("Jamming")).getMarginalAt(0));
                    attacks.put("Disabling_Network_Hardware", ((ProbabilisticNode) net.getNode("Disabling_Network_Hardware")).getMarginalAt(0));
                    attacks.put("USB_Memory_Attacks", ((ProbabilisticNode) net.getNode("USB_Memory_Attacks")).getMarginalAt(0));
                    attacks.put("Infected_Hardware", ((ProbabilisticNode) net.getNode("Infected_Hardware")).getMarginalAt(0));

                    for(Map.Entry<String, Float> entry : attacks.entrySet()) {
                        //System.out.println("Key: " + entry.getKey() + " Value: " + (entry.getValue()));
                    }


                    for (Map.Entry<String, Float> entry : attacks.entrySet())
                    {
                        if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                        {
                            maxEntry = entry;
                        }
                    }
                                 napad.setText(maxEntry.getKey());
                                 procenat.setText(maxEntry.getValue().toString());
                }


            });
            
            
          
            
            
           
           
            
            System.out.println(attack);
            JLabel simpt = new JLabel("Symptoms: ");
            checkPanel.add(simpt);
            checkPanel.add(Lack_of_employee_awareness);
            checkPanel.add(new JSeparator());

            checkPanel.add(Lack_Of_Unserstanding_of_Cyber_Security_Incidents);
            checkPanel.add(new JSeparator());

            checkPanel.add(Authentication);
            checkPanel.add(new JSeparator());
            
            checkPanel.add(Outdated_antivirus);
            checkPanel.add(new JSeparator());

            checkPanel.add(Unsecured_networks);
            checkPanel.add(new JSeparator());

            checkPanel.add(Unpatched_operating_systems);
            checkPanel.add(new JSeparator());

            checkPanel.add(Outdated_antivirus);
            checkPanel.add(new JSeparator());

            checkPanel.add(Phishing_Emails);
            checkPanel.add(new JSeparator());

            checkPanel.add(Incorrectly_configured_firewalls);
            checkPanel.add(new JSeparator());

            checkPanel.add(Improper_data_classification);
            checkPanel.add(new JSeparator());
        
            checkPanel.add(Access_Complexity);
            checkPanel.add(Low_Access_Complexity);
            checkPanel.add(Medium_Access_Complexity);
            checkPanel.add(High_Access_Complexity);
            checkPanel.add(new JSeparator());

            checkPanel.add(Skill);
            checkPanel.add(Low_Skill);
            checkPanel.add(Medium_Skill);
            checkPanel.add(High_Skill);
            checkPanel.add(new JSeparator());

         

            checkPanel.add(Country_region);
            checkPanel.add(North_America);
            checkPanel.add(South_America);
            checkPanel.add(Northwestern_Europe);
            checkPanel.add(Southeast_Europe);
            checkPanel.add(Africa);
            checkPanel.add(Australia);
            checkPanel.add(Asia);
            checkPanel.add(new JSeparator());

            checkPanel.add(Number_of_empoyees);
            checkPanel.add(one_five);
            checkPanel.add(five_twenty);
            checkPanel.add(twenty_fifty);
            checkPanel.add(fifty_plus);
            JPanel ispitivanja = new JPanel();
            ispitivanja.setLayout(new FlowLayout());
            ispitivanja.add(rbrBtn);
            ispitivanja.add(done);
            
            
            
            JPanel combo = new JPanel();
            combo.setVisible(true);
            combo.setSize(new Dimension(400, 40));
            combo.setPreferredSize(new Dimension(400, 40));
            JLabel diagnosis = new JLabel("      Most likely attack: ");
            JLabel razmak =  new JLabel(": ");
            JLabel proc = new JLabel("%");
            combo.add(diagnosis);
            combo.add(napad);
            combo.add(razmak);
            combo.add(procenat);
            combo.add(proc);
            
           
            JPanel tug = new JPanel(new BorderLayout());
            tug.setPreferredSize(new Dimension(1050, 900));

            tug.add(checkPanel, BorderLayout.NORTH);
            tug.add(ispitivanja);
            tug.add(combo, BorderLayout.EAST);
            JPanel proba = new JPanel(new BorderLayout());
            proba.setPreferredSize(new Dimension(1050, 900));

            proba.add(tug, BorderLayout.NORTH);
            mainPanel.add(proba, BorderLayout.CENTER);
            mainPanel.setPreferredSize(new Dimension(1050, 900));

            mainFrame.add(mainPanel);
            mainFrame.setSize(1100, 1000);
        } catch (LoadException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mainFrame.setVisible(true);
    }
    public static String getMaxAttack(String max) {
    	attack = max;
    	return attack;
    }

}