package application;

import java.util.List;

import model.Estado;

public class Main {

	public static void main(String[] args) {
		Estado sp = new Estado("SP", 67836.43);
		Estado rj = new Estado("RJ", 36678.66);
		Estado mg = new Estado("ES", 29229.88);
		Estado es = new Estado("ES", 27165.48);
		Estado outros = new Estado("Outros", 19849.53);
     
        double total = sp.getValorFaturamento() 
        		+ rj.getValorFaturamento() 
        		+ mg.getValorFaturamento() 
        		+ es.getValorFaturamento() 
        		+ outros.getValorFaturamento();
             
        for(Estado estado : List.of(sp, rj, mg, es, outros)) {
        	estado.calcularFaturamento(total);
        }
        
        System.out.println("Faturamento");
        for(Estado estado : List.of(sp, rj, mg, es, outros)) {
        	System.out.println(estado.imprimirResultado());
        }
                
	}

}
