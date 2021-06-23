package attacks.app.rdf;


import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;




public class DeleteAttack {
    
    private static final String UPDATE_URL = "http://localhost:3030/inzenjeringznanja/update";
    private static final String PREFIX = "PREFIX na: <http://www.inzenjeringznanja.com/na#> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";
    private String attackId;

    public DeleteAttack(String attackId) {
        this.attackId = attackId;
    }

    public void delete() {
    	
        //if (checkId(newAttack.getId())) {
    	String deleteString = PREFIX 
    			+ "DELETE"
    			+"WHERE{"
    			+"		?attack a na:Attack ;"
    			+"na:id \""+attackId+"\"^^xsd:string ;"
    					   + "       na:name ?name; "
    		                + "       na:likelihood ?likelihood; "
    		                + "       na:weaknesses ?weaknesses; "
    		                + "       na:severity ?severity; "
    		                + "       na:prerequisites ?prerequisites; "
    		                + "       na:mitigations ?mitigations . }";
    	UpdateRequest updateRequest = UpdateFactory.create(deleteString);
        UpdateProcessor updateProcessor = UpdateExecutionFactory.createRemote(updateRequest, UPDATE_URL);
        updateProcessor.execute();
        
      


        
    }

    
}