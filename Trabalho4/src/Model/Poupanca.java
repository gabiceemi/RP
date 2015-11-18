package Model;

import java.util.*;

public class Poupanca extends Conta {
	
		
		private double[] rendimento;		
		protected int[] dataBase;

		//super e arrays//
		public Poupanca(Cliente cliente, boolean situacao, int senha, double rendimento,int dataBase){ 
			super(cliente, situacao, senha);	
				this.dataBase = new int [28] ;
				this.rendimento = new double [28];
				
		}
		

		public  double getRendimento(int data) {
			if(data>0 && data <29){
				return rendimento[data -1];
			}
			else{
				return rendimento [0];
			}
		}	
		public void setRendimento(int dataBase,double rendimento) {
		     if(dataBase>0 && dataBase<29){
		    	this. rendimento[dataBase -1 ]= rendimento;
		     }
		     else 
		    	 this. rendimento[0] = rendimento;
		     
		     }

		public boolean saque(double valor) {
			
			return false;
		}


		@Override
		public double getSaldoTotal() {
			// TODO Auto-generated method stub
			return 0;
		}

			
		}