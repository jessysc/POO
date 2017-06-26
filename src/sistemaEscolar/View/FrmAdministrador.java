package sistemaEscolar.View;

import sistemaEscolar.Control.Login;
import sistemaEscolar.Model.Administrador;


public class FrmAdministrador extends javax.swing.JFrame
{
    Administrador currentAdmin;
    Login logged;
    
    /**
     * Construtor para inicializar o login do adminstrador
     * Exibe o nome do adminstrador atual na tela
     * @param logged
     */
    public FrmAdministrador(Login logged)
    {
        initComponents();
        this.logged = logged;
        this.currentAdmin = (Administrador)logged.getLoggedUser();
        txtAdminName.setText(currentAdmin.getNome());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtAdminName = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnProf = new javax.swing.JMenuItem();
        btnProf1 = new javax.swing.JMenuItem();
        btnAlunos = new javax.swing.JMenuItem();
        btnYourAccount = new javax.swing.JMenuItem();
        btnDeslog = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Seja bem vindo!");

        txtAdminName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAdminName.setText("Nome do Administrador");

        jMenu1.setText("Operações");

        btnProf.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK));
        btnProf.setText("Cadastrar Professores");
        btnProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfActionPerformed(evt);
            }
        });
        jMenu1.add(btnProf);

        btnProf1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK));
        btnProf1.setText("VisualizarProfessores");
        btnProf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProf1ActionPerformed(evt);
            }
        });
        jMenu1.add(btnProf1);

        btnAlunos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.SHIFT_MASK));
        btnAlunos.setText("Visualizar Alunos");
        btnAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlunosActionPerformed(evt);
            }
        });
        jMenu1.add(btnAlunos);

        btnYourAccount.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK));
        btnYourAccount.setText("Sua Conta");
        btnYourAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYourAccountActionPerformed(evt);
            }
        });
        jMenu1.add(btnYourAccount);

        btnDeslog.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK));
        btnDeslog.setText("Sair");
        btnDeslog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeslogActionPerformed(evt);
            }
        });
        jMenu1.add(btnDeslog);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAdminName)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel1)))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(218, 218, 218)
                .addComponent(txtAdminName)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProfActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnProfActionPerformed
    {//GEN-HEADEREND:event_btnProfActionPerformed
        FrmCadUser janela = new FrmCadUser(1);
        janela.setVisible(true);
    }//GEN-LAST:event_btnProfActionPerformed

    private void btnYourAccountActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnYourAccountActionPerformed
    {//GEN-HEADEREND:event_btnYourAccountActionPerformed
        FrmUserAccount<Administrador> fac = new FrmUserAccount(currentAdmin,this,2);
        fac.setVisible(true);
    }//GEN-LAST:event_btnYourAccountActionPerformed

    private void btnAlunosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAlunosActionPerformed
    {//GEN-HEADEREND:event_btnAlunosActionPerformed
        FrmCrudUserAl fcu = new FrmCrudUserAl(currentAdmin);
        fcu.setVisible(true);
    }//GEN-LAST:event_btnAlunosActionPerformed

    private void btnDeslogActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnDeslogActionPerformed
    {//GEN-HEADEREND:event_btnDeslogActionPerformed
        logged.logoff();
        this.dispose();
        FrmLogin login = new FrmLogin(logged, 2);
        login.setVisible(true);
    }//GEN-LAST:event_btnDeslogActionPerformed

    private void btnProf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProf1ActionPerformed
        FrmCrudUser fcu = new FrmCrudUser(currentAdmin);
        fcu.setVisible(true);
    }//GEN-LAST:event_btnProf1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnAlunos;
    private javax.swing.JMenuItem btnDeslog;
    private javax.swing.JMenuItem btnProf;
    private javax.swing.JMenuItem btnProf1;
    private javax.swing.JMenuItem btnYourAccount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel txtAdminName;
    // End of variables declaration//GEN-END:variables
}
