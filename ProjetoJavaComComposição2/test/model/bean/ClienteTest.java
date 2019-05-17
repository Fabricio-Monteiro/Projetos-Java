/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import model.dao.ClienteDAO;
import model.dao.ProdutoDAO;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Fabricio
 */
public class ClienteTest {
    
    public ClienteTest() {
    }

    
    
    @Test
    @Ignore
    public void cadastrar(){
        
        Cliente c = new Cliente();
        c.setNome("Carlos da Silva");
        c.setTelefone("66666666");
        c.setEndereco("Rua da Silva Sauro");
        
        ClienteDAO dao = new ClienteDAO();
        dao.cadastrar(c);   
    }
    
    @Test
    @Ignore
    public void listarTodos(){
        
        ClienteDAO dao = new ClienteDAO();
        
        for(Cliente c: dao.listarTodos()){
            System.out.println("Nome: " +c.getNome()+ " Telefone: " + c.getTelefone()+ " Endereço: " + c.getEndereco());
        }
    }
    
    @Test
    @Ignore
    public void atualizar(){
        Cliente c = new Cliente();
        ClienteDAO dao = new ClienteDAO();
        
        c.setNome("John da Silva");
        c.setEndereco("Rua X");
        c.setTelefone("999999999");
        c.setIdcliente(2);
        dao.atualizar(c);
    }
    
    @Test
    public void delete(){
        Cliente c = new Cliente();
        c.setIdcliente(2);
        ClienteDAO dao = new ClienteDAO();
        dao.delete(c);
    }
    
    
    
}
