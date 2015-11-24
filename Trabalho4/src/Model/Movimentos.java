package Model;

	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.util.ArrayList;
	import java.util.LinkedList;
	import java.util.Date;

	public class Movimentos{
		protected String operacao;
		protected double valor;
		protected DateFormat date;
		public Movimentos(String operacao, double valor){
		this.operacao = operacao;
		this.valor = valor;
		DateFormat date = new SimpleDateFormat("dd/MM/YYYY  hh/mm/ss");
		String formattedDate = date.format(date);
		
	}
	public DateFormat getDate() {
		return date;
	}
	public String getOperacao() {
		return operacao;
	}
	public double getValor() {
		return valor;
	}
	@Override
	public String toString(){
		return "Data e hora:" + getDate() +"Operação: "+ getOperacao() + "Valor:" + getValor();
	}

	}
