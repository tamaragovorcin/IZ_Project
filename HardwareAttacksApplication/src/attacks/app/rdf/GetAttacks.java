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
        System.out.println("usao u get");
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

        System.out.println(selectString);
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
                
                
                if (literalLikelihood.getString().equals("low")) {
					newAttack.setLikelihood(Likelihood.low);
				} else if (literalLikelihood.getString().equals("Medium")) {
					newAttack.setLikelihood(Likelihood.Medium);
				}else {
					newAttack.setLikelihood(Likelihood.High);
				}
                
                
                if (literalSeverity.getString().equals("low")) {
					newAttack.setSeverity(Severity.low);
				} else if (literalSeverity.getString().equals("Medium")) {
					newAttack.setSeverity(Severity.Medium);
				}else if (literalSeverity.getString().equals("High")) {
					newAttack.setSeverity(Severity.High);
				}else {
					newAttack.setSeverity(Severity.Very_high);
				}
                
                
                String mitigationsList = literalMitigations.getString();
                mitigationsList = mitigationsList.substring(1,mitigationsList.length()-1);
                String[] splited = mitigationsList.split(",");
                for (String mit : splited) {
                	ArrayList<String> lista = new ArrayList<String>();
                	lista.add(mit);
                     newAttack.setMitigations(lista);

                }
                
                String weaknessList = literalWeaknesses.getString();
                weaknessList = weaknessList.substring(1,weaknessList.length()-1);
                String[] splited1 = weaknessList.split(",");
                for (String w : splited1) {
                	ArrayList<String> lista1 = new ArrayList<String>();
                	lista1.add(w);
                	  newAttack.setWeaknesses(lista1);

                }
                ArrayList<Attack> attacksNova = new ArrayList();
            
                attacksNova.add(newAttack);
                
                this.attacks.setAttacks(attacksNova);
                for ( Attack at : this.attacks.getAttacks()) {
                    System.out.println(at.getName());
                   
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
