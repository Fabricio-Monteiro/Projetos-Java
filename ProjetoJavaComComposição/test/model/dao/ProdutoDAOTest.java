/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Cliente;
import model.bean.Produto;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Fabricio
 */
public class ProdutoDAOTest {
    
    public ProdutoDAOTest() {
    }

    @Test
    @Ignore
    public void cadastrar(){
        
        Cliente c = new Cliente();
        c.setIdcliente(1);
        
        Produto p = new Produto();
        p.setDescricao("Feijão");
        p.setQuantidade(20);
        p.setPreco(10);
        p.setCliente(c);
        
        ProdutoDAO dao = new ProdutoDAO();
        dao.cadastrar(p);
        
    }
    
    @Test
    @Ignore
    public void listar(){
        ProdutoDAO dao = new ProdutoDAO();
        for(Produto p: dao.listarTodos()){
            System.out.println("Descricao Produto: "+p.getDescricao()+ " Descricao categoria:" +p.getCliente().getNome());
        }
    }
    
    @Test
    @Ignore
    public void update(){
        Cliente c = new Cliente();
        c.setIdcliente(1);
        
        
        Produto p = new Produto();
        p.setDescricao("Coca Cola");
        p.setQuantidade(10);
        p.setPreco(8);
        p.setCliente(c);
        p.setIdproduto(8);
        
        ProdutoDAO dao = new ProdutoDAO();
        dao.update(p);
    }
    
    @Test
    public void delete(){
        Produto p = new Produto();
        p.setIdproduto(3);
        
        ProdutoDAO dao = new ProdutoDAO();
        dao.delete(p);
    }
    
    
    
}
