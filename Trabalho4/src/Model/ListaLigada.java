package Model;
public class ListaLigada implements IListaLigada{
	No inicio;
	int size = 0;
	public ListaLigada(){
		this.inicio = null;	
		this.size = 0;
	}

	@Override
	public boolean isEmpty() {
		  if (this.inicio == null){
	            return true;
		  }
	        else{
	            return false;
	        }
	}

	@Override
	public void addLast(Object obj) {
		 No aux = this.inicio;
	        if(obj==null){
	        	throw new NullPointerException("Objeto nulo.");
	        }
	        if (!this.isEmpty()) {
	            while (aux.getProx() != null)
	                aux = aux.getProx();
	            aux.setProx(new No (obj, null));
	        }else{
	            this.inicio = new No (obj, null);
	        }
	        this.size = size+1;
	}


	@Override
	public int size() {
		return size;
	}


}