package attacks.app.rdf;

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
import attacks.app.model.Attack;



public class GetAttacks {

	private static final String QUERY_URL = "http://localhost:3030/inzenjeringznanja/sparql";
	private static final String PREFIX = "PREFIX na: <http://www.inzenjeringznanja.com/na#> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";

	private Attacks attacks;

	public GetAttacks() {
		this.attacks = new Attacks();
	}
	
	public boolean getAttacks() {
		System.out.println("usao u get");
		this.attacks.getAttacks().clear();
		
		String selectString = PREFIX + " SELECT ?id ?name ?likelihood ?mitigations " + "WHERE {"
				 + "    na:id ?id; " + " . } ";

		Query query = QueryFactory.create(selectString);
		try {
			QueryExecution qexec = QueryExecutionFactory.sparqlService(QUERY_URL, query);
			ResultSet results = qexec.execSelect();
			ResultSetRewindable resultSetRewindble = ResultSetFactory.copyResults(results);
			qexec.close();
			while (resultSetRewindble.hasNext()) {
				QuerySolution solution = resultSetRewindble.nextSolution();
				Literal literalId = solution.getLiteral("id");

				Attack newExamination = new Attack();
				newExamination.setId(literalId.getString());

				


				this.attacks.getAttacks().add(newExamination);
			}

			Singleton.getInstance().setAttacks(attacks);
			for (Attack attack : attacks.getAttacks()) {
				System.out.println(attack.getName());
			}
			System.out.println();
			
			return true;

		} catch (Exception e) {
			System.out.println("GRESKA SELECT NAREDBA EXAMINATIONS");
			e.printStackTrace();
		}

		return false;
	}

}
