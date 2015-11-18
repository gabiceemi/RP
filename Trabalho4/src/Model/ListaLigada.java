package Model;
import java.util.*;
public class ListaLigada implements IListaLigada{
	No inicio;
	public ListaLigada(){
		this.inicio = null;		
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
	public void add(Object movimento) {
		 No aux = this.inicio;
	        
	        if (!this.isEmpty()) {
	            while (aux.getProx() != null)
	                aux = aux.getProx();
	            aux.setProx(new No (movimento, null));
	        }else{
	            this.inicio = new No (movimento, null);
	        }
	}

	@Override
	public IListaLigada subList(String dataInicial, String dataFinal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object get(int i) {
		return null;
	}

	@Override
	public int indexOf(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

}