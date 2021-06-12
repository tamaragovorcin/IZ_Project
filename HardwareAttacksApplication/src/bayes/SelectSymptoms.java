package bayes;


import bayes.CalculationOfTopAttack;
import bayes.RankingList;

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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.*;

public class SelectSymptoms extends JFrame {
    public static String attack1 = "";
    public static String attack2 = "";
    public static String attack3 = "";
    public static ArrayList<String> selected = new ArrayList<>();
    public static boolean rbr = true;
    public Map<String, Float> sortedMapRBR = new HashMap<>();
    String navedeniSimptomi = "";
    ArrayList<String> simpto = new ArrayList<>();
    private JFrame mainFrame = new JFrame("Hardware attacks");
    private JPanel checkPanel = new JPanel();
    private JPanel mainPanel = new JPanel(new BorderLayout());
    private JPanel descPanel = new JPanel(new BorderLayout());
    private ArrayList<HashMap<String, Map<String, Float>>> sveRangListe = new ArrayList<HashMap<String, Map<String, Float>>>();


    public SelectSymptoms() {

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
            checkPanel.setSize(new Dimension(500, 450));
            checkPanel.setPreferredSize(new Dimension(500, 450));
            JCheckBox Lack_Of_Unserstanding_of_Cyber_Security_Incidents = new JCheckBox("Lack_Of_Unserstanding_of_Cyber_Security_Incidents");
            JCheckBox Incorrectly_configured_firewalls = new JCheckBox("Incorrectly_configured_firewalls");
            JCheckBox Improper_data_classification = new JCheckBox("Improper_data_classification");
            JCheckBox Lack_of_employee_awareness = new JCheckBox("Lack_of_employee_awareness");
            JCheckBox Phishing_Emails = new JCheckBox("Phishing_Emails");
            JCheckBox Unpatched_operating_systems = new JCheckBox("Unpatched_operating_systems");
            JCheckBox Unsecured_networks = new JCheckBox("Unsecured_networks");
            JCheckBox Outdated_antivirus = new JCheckBox("Outdated_antivirus");
            JCheckBox Authentication = new JCheckBox("Authentication");
            JCheckBox Access_Complexity = new JCheckBox("Access_Complexity");
            JCheckBox Requires_prerequisites = new JCheckBox("Prerequisites");
            JCheckBox Skill = new JCheckBox("Skill");
            JCheckBox Likelyhood = new JCheckBox("Likelyhood");
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
                } else if (s.equals("Access_Complexity")) {
                	Access_Complexity.setSelected(true);
                } else if (s.equals("Requires_prerequisites")) {
                	Requires_prerequisites.setSelected(true);
                } else if (s.equals("Skill")) {
                	Skill.setSelected(true);
                } else if (s.equals("Likelyhood")) {
                	Likelyhood.setSelected(true);
                }
            }

            ImageIcon fin = new ImageIcon("./finish.png");
            Image finIm = fin.getImage(); // transform it
            Image newimgF = finIm.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            fin = new ImageIcon(newimgF);
            JButton rbrBtn = new JButton("Estimate ", fin);

            

            String[] diseaseStrings = { "blepharitis", "chronic glaucoma", "cataract",
                    "macular degeneration", "dry eye of unknown cause", "eye alignment disorder", "corneal abrasion",
                    "cornea infection", "retinal detachment", "optic neuritis", "iridocyclitis",
                    "subconjunctival hemorrhage", "floaters"
            };
            JPanel combo = new JPanel();
            combo.setVisible(false);
            // combo.setLayout(new FlowLayout());
            combo.setLayout(new BoxLayout(combo, BoxLayout.X_AXIS));
            combo.setSize(new Dimension(400, 40));
            combo.setPreferredSize(new Dimension(400, 40));
            JComboBox diseaseList = new JComboBox(diseaseStrings);
            diseaseList.setSize(new Dimension(250, 20));
            diseaseList.setPreferredSize(new Dimension(250, 20));
            diseaseList.setSelectedIndex(0);
            JLabel diagnosis = new JLabel("      Diagnosis:   ");
            combo.add(diagnosis);
            combo.add(diseaseList);

            rbrBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {

                    // TODO Auto-generated method stub
                    rbr = true;
                    done.setVisible(false);
                    combo.setVisible(true);

                    Set<String> selektovaniSimptomi = new HashSet<String>();
                    sveRangListe = new ArrayList<>();
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
                        if (Likelyhood.isSelected()) {
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
                        if (Access_Complexity.isSelected()) {
                            selektovaniSimptomi.add("Access_Complexity");
                            if (node.getName().equals("Access_Complexity")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Access_Complexity");
                                 godine.addFinding(0);
                                 System.out.println(((ProbabilisticNode) node).getMarginalAt(0));
                                
                            }
                        }
                        if (Requires_prerequisites.isSelected()) {
                            selektovaniSimptomi.add("Requires_prerequisites");
                            if (node.getName().equals("Requires_prerequisites")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Requires_prerequisites");
                                 godine.addFinding(0);
                                 
                            }
                        }
                        if (Skill.isSelected()) {
                            selektovaniSimptomi.add("Skill");
                            if (node.getName().equals("Skill")) {
                            	 ProbabilisticNode godine = (ProbabilisticNode) net.getNode("Skill");
                                 godine.addFinding(0);
                                
                            }
                        }


                    }
                  
                    System.out.println("-----------------------------");
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
                    HashMap<String, Float> map = new HashMap<String, Float>();
                    for (Node node : nodeList) {
                    	for(String selektovan : simptoms) {
                    		if(!node.getName().equals(selektovan))
                    			map.put(node.getName(), ((ProbabilisticNode) node).getMarginalAt(0));
                    	}
                    }

                    for(String naziv : map.keySet()) {
                    	for(Float procenat : map.values()) {
                    		System.out.println(naziv+" ::::::::: " +procenat);
                    	}
                    }
                    
                    
                    CalculationOfTopAttack calculationTop = new CalculationOfTopAttack(sveRangListe);
                    HashMap<String, Float> calculatedMap = calculationTop.calculation();
                    sortedMapRBR = RankingList.sortByComparator(calculatedMap, false);
                    RankingList.printMap(sortedMapRBR);
                    konacneVrv.setText(calculationTop.printOfProbabilitiesRBR(sortedMapRBR));

                    RankingList rg = new RankingList();
                    //predlog.setText(rg.prve2Naziv(sortedMapRBR, selektovaniSimptomi));
                   
                }
            });


            JLabel simpt = new JLabel("Symptoms: ");
            checkPanel.add(simpt);
            checkPanel.add(Lack_of_employee_awareness);
            checkPanel.add(Lack_Of_Unserstanding_of_Cyber_Security_Incidents);
            checkPanel.add(Skill);
            checkPanel.add(Requires_prerequisites);
            checkPanel.add(Access_Complexity);
            checkPanel.add(Authentication);
            checkPanel.add(Likelyhood);
            checkPanel.add(Outdated_antivirus);
            checkPanel.add(Unsecured_networks);
            checkPanel.add(Unpatched_operating_systems);
            checkPanel.add(Outdated_antivirus);
            checkPanel.add(Phishing_Emails);
            checkPanel.add(Incorrectly_configured_firewalls);
            checkPanel.add(Improper_data_classification);
            JPanel ispitivanja = new JPanel();
            ispitivanja.setLayout(new FlowLayout());
            ispitivanja.add(rbrBtn);
            ispitivanja.add(done);
            checkPanel.add(ispitivanja);

           

            checkPanel.add(combo);

           
            JPanel tug = new JPanel(new BorderLayout());
            tug.add(checkPanel, BorderLayout.WEST);
            tug.add(descPanel, BorderLayout.EAST);
            JPanel proba = new JPanel(new BorderLayout());
            proba.add(tug, BorderLayout.NORTH);
            //proba.add(pr, BorderLayout.SOUTH);
            mainPanel.add(proba, BorderLayout.CENTER);
            mainFrame.add(mainPanel);
            mainFrame.setSize(1100, 600);
        } catch (LoadException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

}
