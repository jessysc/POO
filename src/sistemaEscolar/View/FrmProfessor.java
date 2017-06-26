package sistemaEscolar.View;

import sistemaEscolar.Control.Login;
import sistemaEscolar.Model.Professor;


public class FrmProfessor extends javax.swing.JFrame {

    Professor currentProf;
    Login logged;
    
    /**
     * Construtor para inicializar o login do professor
     * Exibe nome do professor atual logado na tela
     * @param logged 
     */
    public FrmProfessor(Login logged) {
        initComponents();
        this.logged = logged;
        this.currentProf = (Professor)logged.getLoggedUser();
        txtProfName.setText(currentProf.getNome());
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        txtProfName = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        btnProf = new javax.swing.JMenuItem();
        btnProf1 = new javax.swing.JMenuItem();
        btnYourAccount = new javax.swing.JMenuItem();
        btnDeslog = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        jMenuItem1.setText("jMenuItem1");

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Seja bem vindo!");

        txtProfName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtProfName.setText("Nome");

        jMenu5.setText("Operações");

        btnProf.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK));
        btnProf.setText("Cadastrar Alunos");
        btnProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfActionPerformed(evt);
            }
        });
        jMenu5.add(btnProf);

        btnProf1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK));
        btnProf1.setText("Visualizar Alunos");
        btnProf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProf1ActionPerformed(evt);
            }
        });
        jMenu5.add(btnProf1);

        btnYourAccount.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK));
        btnYourAccount.setText("Sua Conta");
        btnYourAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYourAccountActionPerformed(evt);
            }
        });
        jMenu5.add(btnYourAccount);

        btnDeslog.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK));
        btnDeslog.setText("Sair");
        btnDeslog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeslogActionPerformed(evt);
            }
        });
        jMenu5.add(btnDeslog);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProfName)
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
                .addComponent(txtProfName)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeslogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeslogActionPerformed
        logged.logoff();
        this.dispose();
        FrmLogin login = new FrmLogin(logged, 2);
        login.setVisible(true);
    }//GEN-LAST:event_btnDeslogActionPerformed

    private void btnYourAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYourAccountActionPerformed
        FrmUserAccount<Professor> fac = new FrmUserAccount(currentProf,this,1);
        fac.setVisible(true);
    }//GEN-LAST:event_btnYourAccountActionPerformed

    private void btnProf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProf1ActionPerformed
        FrmCrudUserAl fcu = new FrmCrudUserAl(currentProf);
        fcu.setVisible(true);
    }//GEN-LAST:event_btnProf1ActionPerformed

    private void btnProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfActionPerformed
        FrmCadUser janela = new FrmCadUser(2);
        janela.setVisible(true);
    }//GEN-LAST:event_btnProfActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnDeslog;
    private javax.swing.JMenuItem btnProf;
    private javax.swing.JMenuItem btnProf1;
    private javax.swing.JMenuItem btnYourAccount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel txtProfName;
    // End of variables declaration//GEN-END:variables
}
