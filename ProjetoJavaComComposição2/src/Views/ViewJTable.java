/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;


import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Cliente;
import model.bean.Produto;
import model.dao.ClienteDAO;
import model.dao.ProdutoDAO;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Fabricio
 */
public class ViewJTable extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewJTable
     */
    public ViewJTable() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jtproduto.getModel();
        jtproduto.setRowSorter(new TableRowSorter(modelo));
        readJtable();
        readJtableCliente();
        
        
    }
    
    public void readJtable(){
        DefaultTableModel modelo = (DefaultTableModel) jtproduto.getModel();
        modelo.setNumRows(0);
        ProdutoDAO dao = new ProdutoDAO();
        
        for(Produto p: dao.listarTodos()){
            
            modelo.addRow(new Object[]{
                p.getIdcompra(),
                p.getIdproduto(),
                p.getDescricao(),
                p.getQuantidade(),
                p.getPreco()
            });
            
        }
          
    }
    
    public void readJtableCliente(){
        DefaultTableModel modelo = (DefaultTableModel) jtbcliente.getModel();
        modelo.setNumRows(0);
        ClienteDAO dao = new ClienteDAO();
        
        for(Cliente c: dao.listarTodos()){
            
            modelo.addRow(new Object[]{
                c.getIdcliente(),
                c.getNome(),
                c.getTelefone(),
                c.getEndereco(),
            });
            
        }
          
    }
    
    public void readJtableForId(String id){
        DefaultTableModel modelo = (DefaultTableModel) jtproduto.getModel();
        modelo.setNumRows(0);
        ProdutoDAO dao = new ProdutoDAO();
        
        for(Produto p: dao.buscaPorId(id)){
            
            modelo.addRow(new Object[]{
                p.getIdcompra(),
                p.getIdproduto(),
                p.getDescricao(),
                p.getQuantidade(),
                p.getPreco()
            });
        }
    }
    
    public void readJtableForDesc(String desc){
        DefaultTableModel modelo = (DefaultTableModel) jtproduto.getModel();
        modelo.setNumRows(0);
        ProdutoDAO dao = new ProdutoDAO();
        
        for(Produto p: dao.buscaPorDesc(desc)){
            
            modelo.addRow(new Object[]{
                p.getIdcompra(),
                p.getIdproduto(),
                p.getDescricao(),
                p.getQuantidade(),
                p.getPreco()
            });
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
    
    
    public void readJtableForDescricao(String desc){
        DefaultTableModel modelo = (DefaultTableModel) jtbcliente.getModel();
        modelo.setNumRows(0);
        ClienteDAO dao = new ClienteDAO();
        
        for(Cliente c: dao.buscaPorNome(desc)){
            
            modelo.addRow(new Object[]{
                c.getIdcliente(),
                c.getNome(),
                c.getTelefone(),
                c.getEndereco(),
                
            });
        }
    }
        

    
    public void setar_campos(){
        int setar = jtbcliente.getSelectedRow();
        jtid.setText(jtbcliente.getModel().getValueAt(setar,0).toString());
    }
    
   
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jtp = new javax.swing.JPanel();
        jtdescricao = new javax.swing.JTextField();
        jtquantidade = new javax.swing.JTextField();
        jtpreco = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jbcadastrar = new javax.swing.JButton();
        jbexcluir = new javax.swing.JButton();
        jbatualizar = new javax.swing.JButton();
        jtid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtbuscar = new javax.swing.JTextField();
        jbbuscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbcliente = new javax.swing.JTable();
        jtcliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtproduto = new javax.swing.JTable();
        jtec = new javax.swing.JButton();
        jttotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfim = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jbc = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setDoubleBuffered(true);

        jtp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtpMouseClicked(evt);
            }
        });

        jtpreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtprecoActionPerformed(evt);
            }
        });

        jLabel1.setText("Descrição:");

        jLabel2.setText("Quantidade:");

        jLabel3.setText("Preço:");

        jbcadastrar.setText("Cadastrar Produto");
        jbcadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcadastrarActionPerformed(evt);
            }
        });

        jbexcluir.setText("Excluir Produto");
        jbexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbexcluirActionPerformed(evt);
            }
        });

        jbatualizar.setText("Atualizar Produto");
        jbatualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbatualizarActionPerformed(evt);
            }
        });

        jLabel4.setText("ID Cliente");

        jtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbuscarActionPerformed(evt);
            }
        });

        jbbuscar.setText("Buscar Produtos");
        jbbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbbuscarActionPerformed(evt);
            }
        });

        jButton1.setText("Limpar Campos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtbcliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Cliente", "Nome", "Telefone", "Endereço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbcliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbclienteMouseClicked(evt);
            }
        });
        jtbcliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtbclienteKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jtbcliente);

        jtcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtclienteActionPerformed(evt);
            }
        });
        jtcliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtclienteKeyReleased(evt);
            }
        });

        jLabel5.setText("Buscar Cliente:");

        jtproduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID do Cliente", "ID do Produto", "Descrição", "Quantidade", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtproduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtprodutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtproduto);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jtec.setText("Excluir Cliente");
        jtec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtecActionPerformed(evt);
            }
        });

        jttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jttotalActionPerformed(evt);
            }
        });

        jLabel6.setText("Valor total dos produtos:");

        jtfim.setText("TOTAL");
        jtfim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfimActionPerformed(evt);
            }
        });

        jButton2.setText("Produtos do Cliente");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jbc.setText("Buscar Cliente");
        jbc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jtpLayout = new javax.swing.GroupLayout(jtp);
        jtp.setLayout(jtpLayout);
        jtpLayout.setHorizontalGroup(
            jtpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jtpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jtpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jtpLayout.createSequentialGroup()
                        .addGroup(jtpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jtpLayout.createSequentialGroup()
                                .addComponent(jtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbc, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                .addComponent(jtid, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jtpLayout.createSequentialGroup()
                                .addGroup(jtpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jtpLayout.createSequentialGroup()
                                        .addComponent(jbcadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbatualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jtpLayout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbexcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(49, 49, 49)
                                .addGroup(jtpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jtpLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtfim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(4, 4, 4))
                                    .addGroup(jtpLayout.createSequentialGroup()
                                        .addComponent(jtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addContainerGap())
                    .addGroup(jtpLayout.createSequentialGroup()
                        .addGroup(jtpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jtpLayout.createSequentialGroup()
                                .addGroup(jtpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jtpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jtpLayout.createSequentialGroup()
                                        .addGap(211, 211, 211)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jtpLayout.createSequentialGroup()
                                        .addComponent(jtquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtpreco, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jtpLayout.createSequentialGroup()
                                .addComponent(jtec, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(47, 47, 47))))
        );
        jtpLayout.setVerticalGroup(
            jtpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jtpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jtpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jtpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbc))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jtpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtec)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jtpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jtpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtpreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jtpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbcadastrar)
                    .addComponent(jbatualizar)
                    .addComponent(jtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbbuscar))
                .addGap(28, 28, 28)
                .addGroup(jtpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jtfim)
                    .addComponent(jbexcluir))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbcadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcadastrarActionPerformed
        // TODO add your handling code here:
        
        Produto p = new Produto();
        ProdutoDAO dao = new ProdutoDAO();
        
        Cliente c = new Cliente();
        c.setIdcliente(Integer.parseInt(jtid.getText()));
        
        p.setDescricao(jtdescricao.getText());
        p.setQuantidade(Integer.parseInt(jtquantidade.getText()));
        p.setPreco(Double.parseDouble(jtpreco.getText()));
        p.setIdcompra(Integer.parseInt(jtid.getText()));
        p.setCliente(c);
        dao.cadastrar(p);
        
        
       
        
        
        
        jtdescricao.setText("");
        jtquantidade.setText("");
        jtpreco.setText("");
        
        
        
        readJtable();
        
        
        
    }//GEN-LAST:event_jbcadastrarActionPerformed

    private void jbatualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbatualizarActionPerformed
        // TODO add your handling code here:
        
        if(jtproduto.getSelectedRow() != -1){
            
            
            Produto p = new Produto();
            ProdutoDAO dao = new ProdutoDAO();
        
           Cliente c = new Cliente();
           c.setIdcliente(Integer.parseInt(jtid.getText()));
        
           p.setDescricao(jtdescricao.getText());
           p.setQuantidade(Integer.parseInt(jtquantidade.getText()));
           p.setPreco(Double.parseDouble(jtpreco.getText()));
           p.setIdproduto((int)jtproduto.getValueAt(jtproduto.getSelectedRow(), 1));
           p.setIdcompra(Integer.parseInt(jtid.getText()));
           p.setCliente(c);
          dao.update(p);
        
        jtdescricao.setText("");
        jtquantidade.setText("");
        jtpreco.setText("");
        
        readJtable();
            
        }
        
        
    }//GEN-LAST:event_jbatualizarActionPerformed

    private void jbexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbexcluirActionPerformed
        // TODO add your handling code here:
        
        if(jtproduto.getSelectedRow() != -1){
            
            
            Produto p = new Produto();
            ProdutoDAO dao = new ProdutoDAO();
        
           Cliente c = new Cliente();
           c.setIdcliente(Integer.parseInt(jtid.getText()));
        
           
           p.setIdproduto((int)jtproduto.getValueAt(jtproduto.getSelectedRow(), 1));
          
          
          dao.delete(p);
        
        jtdescricao.setText("");
        jtquantidade.setText("");
        jtpreco.setText("");
        
        readJtable();
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma linha para a exclusão");
        }
    }//GEN-LAST:event_jbexcluirActionPerformed

    private void jtprodutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtprodutoMouseClicked
        // TODO add your handling code here:
        
        if(jtproduto.getSelectedRow() != -1){
            
            jtdescricao.setText(jtproduto.getValueAt(jtproduto.getSelectedRow(),2).toString());
            jtquantidade.setText(jtproduto.getValueAt(jtproduto.getSelectedRow(),3).toString());
            jtpreco.setText(jtproduto.getValueAt(jtproduto.getSelectedRow(),4).toString());
        }
        
    }//GEN-LAST:event_jtprodutoMouseClicked

    private void jbbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbbuscarActionPerformed
        // TODO add your handling code here:
        
        
        readJtableForDesc(jtbuscar.getText());
    }//GEN-LAST:event_jbbuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) jtproduto.getModel();
        while (jtproduto.getModel().getRowCount()>0) 
            modelo.removeRow(0);
        jtdescricao.setText("");
        jtquantidade.setText("");
        jtpreco.setText("");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtclienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtclienteKeyReleased
        // TODO add your handling code here:
        
 
            
        
    }//GEN-LAST:event_jtclienteKeyReleased

    private void jtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbuscarActionPerformed

    private void jtbclienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbclienteKeyReleased
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jtbclienteKeyReleased

    private void jtclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtclienteActionPerformed
        // TODO add your handling code here:
        
      
    }//GEN-LAST:event_jtclienteActionPerformed

    private void jtbclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbclienteMouseClicked
        // TODO add your handling code here:
        
        setar_campos();
    }//GEN-LAST:event_jtbclienteMouseClicked

    private void jtecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtecActionPerformed
        // TODO add your handling code here:
        
        if(jtbcliente.getSelectedRow() != -1){
            Cliente c = new Cliente();
            ClienteDAO dao = new ClienteDAO();
            
             c.setIdcliente((int)jtbcliente.getValueAt(jtbcliente.getSelectedRow(), 0));
            
             dao.delete(c);
            
            readJtableCliente();
            jtcliente.setText("");
            
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma linha para a exclusão");
        }
        
        
        
        
    }//GEN-LAST:event_jtecActionPerformed

    private void jtprecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtprecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtprecoActionPerformed

    private void jttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jttotalActionPerformed
        // TODO add your handling code here:
        
        double aux=0;
        
        aux = aux + Double.parseDouble(jtpreco.getText());
         
        jtpreco.setText(Double.toString(aux));
        
    }//GEN-LAST:event_jttotalActionPerformed

    private void jtfimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfimActionPerformed
        // TODO add your handling code here:
        
        
      
        double soma=0;
        try{
        for(int i = 0; i<jtproduto.getRowCount();i++){
            Double valor = (Double)jtproduto.getValueAt(i,4);
            soma = soma + valor.doubleValue();
            }
        
        jttotal.setText(String.valueOf(soma));
        }catch(Exception e){JOptionPane.showMessageDialog(null, "Erro: " +e);}
    }//GEN-LAST:event_jtfimActionPerformed

    private void jtpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtpMouseClicked
        // TODO add your handling code here:
         
        
    }//GEN-LAST:event_jtpMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        readJtableForId(jtid.getText());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jbcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcActionPerformed
        // TODO add your handling code here:
        
        readJtableForDescricao(jtcliente.getText());
    }//GEN-LAST:event_jbcActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JButton jbatualizar;
    private javax.swing.JButton jbbuscar;
    private javax.swing.JButton jbc;
    private javax.swing.JButton jbcadastrar;
    private javax.swing.JButton jbexcluir;
    private javax.swing.JTable jtbcliente;
    private javax.swing.JTextField jtbuscar;
    private javax.swing.JTextField jtcliente;
    private javax.swing.JTextField jtdescricao;
    private javax.swing.JButton jtec;
    private javax.swing.JButton jtfim;
    private javax.swing.JTextField jtid;
    private javax.swing.JPanel jtp;
    private javax.swing.JTextField jtpreco;
    private javax.swing.JTable jtproduto;
    private javax.swing.JTextField jtquantidade;
    private javax.swing.JTextField jttotal;
    // End of variables declaration//GEN-END:variables
}
