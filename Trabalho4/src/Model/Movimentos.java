package Model;

	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.util.ArrayList;
	import java.util.LinkedList;
	import java.util.Date;

	public class Movimentos{
		protected String operacao;
		protected double valor;
		public Movimentos(String operacao, double valor){
		this.operacao = operacao;
		this.valor = valor;
		DateFormat date = new SimpleDateFormat("dd/MM/YYYY  hh/mm/ss");
		String formattedDate = date.format(date);
		
		}

	}

