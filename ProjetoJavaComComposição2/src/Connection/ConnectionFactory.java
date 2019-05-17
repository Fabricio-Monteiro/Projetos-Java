/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabricio
 */
public class ConnectionFactory {
	
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");//força o carregamento do Driver.
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbmarket", "postgres", "silent");
			System.out.println("Conectado!");
			
		} catch (SQLException e) {
			///catch do driver manager 
			System.out.println("Não foi possivel conectar: " + e.getMessage()); 
		} catch (ClassNotFoundException e) {
			
			System.out.println("Driver não encontrado");
		}
		return con;
	}
        
        public static void closeConnection(Connection con){
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        public static void closeConnection(Connection con, PreparedStatement preparador){
            closeConnection(con);
            
            if(preparador != null){
                try {
                    preparador.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        public static void closeConnection(Connection con, PreparedStatement preparador, ResultSet resultado){
         
            if(resultado != null){
                try {
                    resultado.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            closeConnection(con, preparador);
            
            
            
        }

}
