package sistemaEscolar.View;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import sistemaEscolar.Control.ControlMain;
import sistemaEscolar.Control.Login;

public class FrmHome extends javax.swing.JFrame
{
    
    Login login_aluno = ControlMain.getControlAluno();
    Login login_admin = ControlMain.getControlAdministrador();
    Login login_prof = ControlMain.getControlProfessor();
    
    public FrmHome()
    {
        lookandfell();
        initComponents();
    }
    
    private void lookandfell()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex)
        {
            Logger.getLogger(FrmHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SwingUtilities.updateComponentTreeUI(this);
    }
    
    private void close()
    {
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        btnAluno = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        btnProf = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));

        btnAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/aluno (1).png"))); // NOI18N
        btnAluno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aluno", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM, new java.awt.Font("Britannic Bold", 0, 12))); // NOI18N
        btnAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlunoActionPerformed(evt);
            }
        });

        btnAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/adm1.png"))); // NOI18N
        btnAdmin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Administrador", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM, new java.awt.Font("Britannic Bold", 0, 12))); // NOI18N
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });

        btnProf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/professor.png"))); // NOI18N
        btnProf.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Professor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM, new java.awt.Font("Britannic Bold", 0, 12))); // NOI18N
        btnProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Britannic Bold", 1, 24)); // NOI18N
        jLabel1.setText("Sistema Escolar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnAdmin)
                .addGap(18, 18, 18)
                .addComponent(btnAluno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProf)
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(121, 121, 121))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProf))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAdminActionPerformed
    {//GEN-HEADEREND:event_btnAdminActionPerformed
        if(login_admin.haveUsers())
        {
            //abre login
            FrmLogin login = new FrmLogin(login_admin,2);
            login.setVisible(true);
            close();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Não há administradores cadastrados ainda.");
            if (JOptionPane.showConfirmDialog(null, "Você deseja cadastrar um novo Administrador?", "WARNING",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
            {
                FrmCadUser cadWindows = new FrmCadUser(2);
                cadWindows.setVisible(true);
            } 
        }
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnAlunoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAlunoActionPerformed
    {//GEN-HEADEREND:event_btnAlunoActionPerformed
    if(login_aluno.haveUsers())
        {
            //abre login
            FrmLogin login = new FrmLogin(login_aluno,3);
            login.setVisible(true);
            close();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Não há jogadores cadastrados ainda.");
            if (JOptionPane.showConfirmDialog(null, "Você deseja cadastrar um novo Jogador?", "WARNING",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
            {
                FrmCadUser cadWindows = new FrmCadUser(2);
                cadWindows.setVisible(true);
            } 
        }
    }//GEN-LAST:event_btnAlunoActionPerformed

    private void btnProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfActionPerformed
        if(login_prof.haveUsers())
        {
            //abre login
            FrmLogin login = new FrmLogin(login_prof,1);
            login.setVisible(true);
            close();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Não há professores cadastrados ainda.");
           
        }
    }//GEN-LAST:event_btnProfActionPerformed

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(() -> {
            new FrmHome().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnAluno;
    private javax.swing.JButton btnProf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
