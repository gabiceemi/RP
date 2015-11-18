package Model;
public class No {
	  private Object movimento;
	    private No prox;
	    
	    public No () {
	        this.movimento = null;
	        this.prox = null;
	    }
	    
	    public No (Object movimento, No prox) {
	        this.movimento = movimento;
	        this.prox = prox;
	    }

	    public void setMovimento (Object movimento) {
	        this.movimento = movimento;
	    }

	    public Object getMovimento () {
	        return this.movimento;
	    }
	    
	    public void setProx (No prox) {
	        this.prox = prox;
	    }

	    public No getProx () {
	        return this.prox;
	    }
}
