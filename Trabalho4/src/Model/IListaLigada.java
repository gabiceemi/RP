package Model;
public interface IListaLigada {
	
	public boolean isEmpty();
	public void add(Object movimento);
	public IListaLigada subList(String dataInicial, String dataFinal);
	public int size();
	public Object get(int i);
	public int indexOf(Object obj);
	

}
