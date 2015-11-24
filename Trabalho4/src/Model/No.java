package Model;
public class No {
	  private Object obj;
	    private No prox;
	    
	    public No () {
	        this.obj = null;
	        this.prox = null;
	    }
	    
	    public No (Object obj, No prox) {
	        this.obj = obj;
	        this.prox = prox;
	    }

	    public void setObj (Object obj) {
	        this.obj = obj;
	    }

	    public Object getObj () {
	        return this.obj;
	    }
	    
	    public void setProx (No prox) {
	        this.prox = prox;
	    }

	    public No getProx () {
	        return this.prox;
	    }

		
}
