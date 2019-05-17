/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;


import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Cliente;



/**
 *
 * @author Fabricio
 */
public class ClienteDAO {
    
    public void cadastrar(Cliente cliente){
        Connection con = null;
        PreparedStatement preparador = null;
        
        String sql = "INSERT INTO cliente(nome, telefone, endereco) VALUES (?,?,?) ";
        
        con = ConnectionFactory.getConnection();
        
        try {
            preparador = con.prepareStatement(sql);
            preparador.setString(1, cliente.getNome());
            preparador.setString(2, cliente.getTelefone());
            preparador.setString(3, cliente.getEndereco());
            preparador.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cadastrado!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, preparador);
        }
        
    }
    
    
    
    public List<Cliente> listarTodos(){
        Connection con = null;
        PreparedStatement preparador = null;
        ResultSet resultado = null;
        
        String sql = "SELECT * FROM cliente";
        con = ConnectionFactory.getConnection();
        
        List<Cliente> lista = new ArrayList<>();
        
        try {
            preparador = con.prepareStatement(sql);
            resultado = preparador.executeQuery();
            
            while(resultado.next()){
                Cliente cliente = new Cliente();
                cliente.setIdcliente(resultado.getInt("idcliente"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setTelefone(resultado.getString("telefone"));
                cliente.setEndereco(resultado.getString("endereco"));
                
                lista.add(cliente);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, preparador, resultado);
        }
        return lista;
    }
    
    
    public void atualizar(Cliente cliente){
        Connection con = null;
        PreparedStatement preparador = null;
        
        String sql = "UPDATE cliente SET nome=?, endereco=?, telefone=? WHERE idcliente=? ";
        
        try {
            con = ConnectionFactory.getConnection();
            preparador = con.prepareStatement(sql);
            preparador.setString(1, cliente.getNome());
            preparador.setString(2, cliente.getEndereco());
            preparador.setString(3, cliente.getTelefone());
            preparador.setInt(4, cliente.getIdcliente());
            
            preparador.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, preparador);
        }
        
    }
    
    
    public void delete(Cliente cliente){
        Connection con = null;
        PreparedStatement preparador = null;
        
        String sql = "DELETE FROM cliente WHERE idcliente=?";
        
        try {
            con = ConnectionFactory.getConnection();
            preparador = con.prepareStatement(sql);
            preparador.setInt(1, cliente.getIdcliente());
            
            preparador.execute();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, preparador);
        }
        
    }
    
    
    
    public List<Cliente> buscaPorNome(String desc){
       
        Connection con = null;
        PreparedStatement preparador = null;
        ResultSet resultado = null;
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente WHERE nome LIKE ?";
        
        try {
            con = ConnectionFactory.getConnection();
            preparador = con.prepareStatement(sql);
            preparador.setString(1, desc+"%");
            resultado = preparador.executeQuery();
            
            while(resultado.next()){
                Cliente cliente = new Cliente();
                cliente.setIdcliente(resultado.getInt("idcliente"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setTelefone(resultado.getString("telefone"));
                cliente.setEndereco(resultado.getString("endereco"));
                
                
                lista.add(cliente);
            }
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " +ex);
        }finally{
            ConnectionFactory.closeConnection(con, preparador);
        }
       return lista;
    }
    
   
    
    
    
    
    
    
    



}
    

