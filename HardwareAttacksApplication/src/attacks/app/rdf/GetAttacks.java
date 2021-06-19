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
import org.apache.jena.rdf.model.Resource;

import attacks.app.model.Attack;



public class GetAttacks {
	

	private static final String QUERY_URL = "http://localhost:3030/inzenjeringznanja/sparql";
	private static final String PREFIX = "PREFIX na: <http://www.inzenjeringznanja.com/na#> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";
	private Attacks attacks;
	private ArrayList<String> attacksName;
	public GetAttacks() {
	this.attacks = attacks;
		this.attacksName = attacksName;
	}

	public void action() {

		

		String queryString = PREFIX + " SELECT ?id ?name " + "WHERE {"
				+ "	    na:id ?id; " + "    na:name ?name; . } ";
		Query query = QueryFactory.create(queryString) ;
		try {
			QueryExecution qexec = QueryExecutionFactory.sparqlService(QUERY_URL, query);

			ResultSet results = qexec.execSelect() ;
			while (results.hasNext()) {
				QuerySolution solution = results.nextSolution() ;
				Resource resource = solution.getResource("attack");
				Literal literal = solution.getLiteral("name");
				System.out.println(resource.getURI());
				System.out.println(literal.getString());
				this.attacksName.add(literal.getString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
				
	}
}
