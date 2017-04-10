package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class AnagrammaDAO {

	
	/**
	 * Tramite una query SQL permette di verificare se l’anagramma calcolato è presente nel dizionario
	 * @param anagramma
	 * @return
	 */
	public boolean isCorrect(String anagramma){
		try{
			final String sql="SELECT * "+
					"FROM parola "+
					"WHERE nome=? ";
			Connection conn= ConnectDB.getConnection();
			PreparedStatement st= conn.prepareStatement(sql);
			
			st.setString(1, anagramma);
			
			ResultSet rs= st.executeQuery();
			boolean trovato=false;
			if(rs.next()){
				/*se si entra una volta qui dentro, vuol dire che la query è andata a buon fine
				 *e che quindi la parola anagramma è presente nel dizionario*/
				trovato=true;
			}
			return trovato;
		}catch (SQLException e){
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	
}
