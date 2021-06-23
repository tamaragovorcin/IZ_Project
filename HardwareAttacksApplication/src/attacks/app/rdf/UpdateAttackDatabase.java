package attacks.app.rdf;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFactory;
import org.apache.jena.query.ResultSetRewindable;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.apache.jena.vocabulary.RDF;

import attacks.app.Singleton;
import attacks.app.model.Attack;



public class UpdateAttackDatabase {
    
    private static final String QUERY_URL = "http://localhost:3030/inzenjeringznanja/sparql";
    private static final String UPDATE_URL = "http://localhost:3030/inzenjeringznanja/update";
    private static final String PREFIX = "PREFIX na: <http://www.inzenjeringznanja.com/na#> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";
    private Attack newAttack;

    public UpdateAttackDatabase(Attack newAttack) {
        this.newAttack = newAttack;
    }

    public void insert() {
    	
        //if (checkId(newAttack.getId())) {
    /*	String deleteString = PREFIX 
    			+ "DELETE { ?IdAttack na:id '1413' }\r\n"
    			+ "INSERT { ?IdAttack na:id  '2' }\r\n"
    			+ "WHERE\r\n"
    			+ "  { ?IdAttack na:id '1413'\r\n"
    			+ "  } ";
    	System.out.println(deleteString);
    	UpdateRequest updateRequest = UpdateFactory.create(deleteString);
        UpdateProcessor updateProcessor = UpdateExecutionFactory.createRemote(updateRequest, UPDATE_URL);
        updateProcessor.execute();*/
        String insertString = PREFIX + " INSERT DATA { ";

        insertString += " na:" + newAttack.getId() + "attack a na:Attack; ";
        insertString += " na:id " + "\"" + newAttack.getId() + "\"^^xsd:string; ";
        insertString += " na:name " + "\"" + newAttack.getName() + "\"^^xsd:string; ";
        insertString += " na:mitigations " + "\"" + newAttack.getMitigations() + "\"^^xsd:string; ";
        insertString += " na:weaknesses " + "\"" + newAttack.getWeaknesse() + "\"^^xsd:string; ";
        insertString += " na:likelihood " + "\"" + newAttack.getLikelihood().toString() + "\"^^xsd:string;";
        insertString += " na:severity " + "\""  + newAttack.getSeverity().toString() + "\"^^xsd:string;";
        insertString += " na:prerequisites " + "\"" + newAttack.getPrerequisites().toString() + "\"^^xsd:string . } ";

        UpdateRequest updateRequest1 = UpdateFactory.create(insertString);
        UpdateProcessor updateProcessor1 = UpdateExecutionFactory.createRemote(updateRequest1, UPDATE_URL);
        updateProcessor1.execute();
        System.out.println("prodje upis");
        String insertIntoID = PREFIX + " INSERT DATA { ";
        insertIntoID += " na:IdAttack a na:AttackId ;";
        insertIntoID += " na:id na:" + newAttack.getId() + "Attack . }";
        UpdateRequest updateId = UpdateFactory.create(insertIntoID);
        UpdateProcessor updateProcessorId = UpdateExecutionFactory.createRemote(updateId, UPDATE_URL);
        updateProcessorId.execute();
        System.out.println("prodje update");


        
    }

    
}