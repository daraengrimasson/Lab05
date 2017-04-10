package it.polito.tdp.anagrammi.model;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	
	private List<String> parole=new LinkedList<String>();
	
	
	
	public void anagramma(String prefisso, String parola) {
		/*condizione di terminazone*/
 		if(parola.length() <= 1) {
			/*ho trovato l'anagramma-->lo aggiungo ad una lista*/
			if(!parole.contains(prefisso+parola))
				parole.add(prefisso+parola)  ;
	 	} else{
             for(int i = 0; i < parola.length(); i++) {
                 String cur = parola.substring(i, i + 1);
                 String before = parola.substring(0, i); // lettere che precedono cur
                 String after = parola.substring(i + 1); // lettere che seguono cur                  
                 anagramma(prefisso+cur, before + after);
             }
            
             
            
         }
		
	}

	public List<String> getParole(){
		return parole;
	}
	
	public boolean isCorrect(String anagramma) {
		AnagrammaDAO dao=new AnagrammaDAO();
		return dao.isCorrect(anagramma);
	}

	public void clearListaParole() {
		parole.clear();
	}

	
	
	

}
