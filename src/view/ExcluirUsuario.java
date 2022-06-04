/*
 * Nome da Classe: ExcluirUsuario
 * 
 * Versão: 1.0
 *
 * Data: 08/07/2020
 * 
 * Código liberado pelo desenvolvedor.
 *
 * @author Erinaldo Henrique
 *
 */

package view;

import conect.Conexao;
import dao.ClienteDao;
import dao.UsuarioDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Usuario;

/**
 *
 * @author henco
 */
public class ExcluirUsuario extends javax.swing.JInternalFrame {
    
    /**
     * Creates new form ConsultarCliente
     */
    public ExcluirUsuario() {
        initComponents();
        exibeConsulta();
        DefaultTableModel ordenar = (DefaultTableModel) tbUsuario.getModel();
        tbUsuario.setRowSorter(new TableRowSorter(ordenar)); // Criar a ordenação da tabel.
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuario = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(57, 150, 196));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Excluir Usuário");

        tbUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idUsuario", "Login", "Senha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbUsuario.setRowHeight(20);
        jScrollPane1.setViewportView(tbUsuario);

        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(348, 348, 348))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(101, 101, 101)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if(tbUsuario.getSelectedRow() != -1){
            int id = (int) tbUsuario.getValueAt(tbUsuario.getSelectedRow(), 0);
            
            Usuario usuario = new Usuario();
            usuario.setId(id);
            
            UsuarioDao.excluir(usuario);
            exibeConsulta();
        } else {
            JOptionPane.showMessageDialog(null, "Você não selecionou a linha da tabela que deseja remover!");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    public void exibeConsulta(){
        try {
            Statement st = Conexao.conectaBD().createStatement();
            String sql = "select * from usuario";
            ResultSet rs = st.executeQuery(sql);
            
            int col = rs.getMetaData().getColumnCount(); // Quantidade de colunas da tabela
            while(rs.next()){
                Object[] linha = new Object[col]; // Criação do array para armazenar os dados de cada linha do banco de dados
                for(int i = 1; i <= col; i++){
                    linha[i - 1] = rs.getObject(i);
                }
                ((DefaultTableModel)tbUsuario.getModel()).insertRow(rs.getRow() - 1, linha);
            }
            rs.close();
            st.close();
        } catch (SQLException e){
            System.out.println("Erro de conexão!");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erro ao tentar acessar a linha!");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbUsuario;
    // End of variables declaration//GEN-END:variables
}