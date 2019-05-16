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
import model.bean.Produto;

/**
 *
 * @author Fabricio
 */
public class ProdutoDAO {
    
   public void cadastrar(Produto produto){
        Connection con = null;
        PreparedStatement preparador = null;
        
        String sql = "INSERT INTO produto(idcompra, descricao, quantidade, preco) VALUES (?,?,?,?) ";
        
        try {
            con = ConnectionFactory.getConnection();
            preparador = con.prepareStatement(sql);
            preparador.setInt(1,produto.getCliente().getIdcliente());//composição
            preparador.setString(2, produto.getDescricao());
            preparador.setInt(3, produto.getQuantidade());
            preparador.setDouble(4, produto.getPreco());
            preparador.execute();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " +ex);
        }finally{
            ConnectionFactory.closeConnection(con, preparador);
        }
        
    }
   
   
   public List<Produto> listarTodos(){
        Connection con = null;
        PreparedStatement preparador = null;
        ResultSet resultado = null;
        
        String sql = "select * from produto p inner join cliente c on c.idcliente = p.idcompra";
        con = ConnectionFactory.getConnection();
        
        List<Produto> lista = new ArrayList<>();
        
        try {
            preparador = con.prepareStatement(sql);
            resultado = preparador.executeQuery();
            
            while(resultado.next()){
                Produto produto = new Produto();
                produto.setIdcompra(resultado.getInt("idcompra"));
                produto.setIdproduto(resultado.getInt("idproduto"));
                produto.setDescricao(resultado.getString("descricao"));
                produto.setQuantidade(resultado.getInt("quantidade"));
                produto.setPreco(resultado.getDouble("preco"));
                
                Cliente cliente = new Cliente();
                cliente.setIdcliente(resultado.getInt("idcliente"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setTelefone(resultado.getString("telefone"));
                cliente.setEndereco(resultado.getString("endereco"));
                produto.setCliente(cliente);
                
                lista.add(produto);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, preparador, resultado);
        }
        return lista;
    }
   
   
   
   public void update(Produto produto){
        Connection con = null;
        PreparedStatement preparador = null;
        
        String sql = "UPDATE produto SET descricao=?, quantidade=?, preco=?, idcompra=? WHERE idproduto=?";
        
        try {
            con = ConnectionFactory.getConnection();
            preparador = con.prepareStatement(sql);
            preparador.setString(1,produto.getDescricao());//composição
            preparador.setInt(2, produto.getQuantidade());
            preparador.setDouble(3, produto.getPreco());
            preparador.setInt(4, produto.getCliente().getIdcliente());
            preparador.setInt(5, produto.getIdproduto());
            preparador.execute();
            
             JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " +ex);
        }finally{
            ConnectionFactory.closeConnection(con, preparador);
        }
        
    }
   
   
   public void delete(Produto produto){
        Connection con = null;
        PreparedStatement preparador = null;
        
        String sql = "DELETE FROM produto WHERE idproduto=?";
        
        try {
            con = ConnectionFactory.getConnection();
            preparador = con.prepareStatement(sql);
            preparador.setInt(1, produto.getIdproduto());
            
            preparador.execute();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " +ex);
        }finally{
            ConnectionFactory.closeConnection(con, preparador);
        }
        
    }
   
   
   public List<Produto> buscaPorDesc(String desc){
       
        Connection con = null;
        PreparedStatement preparador = null;
        ResultSet resultado = null;
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produto WHERE descricao LIKE ?";
        
        try {
            con = ConnectionFactory.getConnection();
            preparador = con.prepareStatement(sql);
            preparador.setString(1, "%"+desc+"%");
            resultado = preparador.executeQuery();
            
            while(resultado.next()){
                Produto produto = new Produto();
                produto.setIdcompra(resultado.getInt("idcompra"));
                produto.setIdproduto(resultado.getInt("idproduto"));
                produto.setDescricao(resultado.getString("descricao"));
                produto.setQuantidade(resultado.getInt("quantidade"));
                produto.setPreco(resultado.getDouble("preco"));
                
               
                
               
                
                lista.add(produto);
            }
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " +ex);
        }finally{
            ConnectionFactory.closeConnection(con, preparador);
        }
       return lista;
    }
   
   
   public List<Produto> buscaPorId(String id){
       
        Connection con = null;
        PreparedStatement preparador = null;
        ResultSet resultado = null;
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produto WHERE idcompra = ?";
        
        try {
            con = ConnectionFactory.getConnection();
            preparador = con.prepareStatement(sql);
            preparador.setInt(1, Integer.parseInt(id));
            resultado = preparador.executeQuery();
            
            while(resultado.next()){
                Produto produto = new Produto();
                produto.setIdcompra(resultado.getInt("idcompra"));
                produto.setIdproduto(resultado.getInt("idproduto"));
                produto.setDescricao(resultado.getString("descricao"));
                produto.setQuantidade(resultado.getInt("quantidade"));
                produto.setPreco(resultado.getDouble("preco"));
                
                lista.add(produto);
            }
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " +ex);
        }finally{
            ConnectionFactory.closeConnection(con, preparador);
        }
       return lista;
    }
   
}
    
    
    

