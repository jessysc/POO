package sistemaEscolar.View;

import javax.swing.JOptionPane;
import sistemaEscolar.Control.Login;
import sistemaEscolar.Model.Administrador;
import sistemaEscolar.Model.Aluno;
import sistemaEscolar.Model.Professor;


public class FrmLogin extends javax.swing.JFrame
{
    int type;
    Login logged;
    
    /**
     * Construtor para inicializar login de acordo com o tipo de usuario
     * @param logged
     * @param type 
     */
    public FrmLogin(Login logged, int type)
    {
        initComponents();
        this.type = type;
        this.logged = logged;
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setText("Usuário:");

        jLabel2.setText("Senha:");

        btnLogin.setText("Logar");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnBack.setText("Voltar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuario)
                    .addComponent(txtSenha)
                    .addComponent(btnBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(btnBack)
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Método para transformar cadeia de carcteres da senha em uma string
     * @param password
     * @return 
     */ 
    private String passwordToString(char[] password)
    {
        String s_password = "";
        for(char c : password)
            s_password += c;
        return s_password;
    }
    
    /**
     * Método para limpar as informações dos campos 
     */
    private void clean_fields()
    {
        txtUsuario.setText("");
        txtSenha.setText("");
    }
    
    private void close()
    {
        this.dispose();
    }
    
    
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnLoginActionPerformed
    {//GEN-HEADEREND:event_btnLoginActionPerformed
        //Verifica o tipo de usuário e realiza o login de acordo com o usuário atual
        String usuario = txtUsuario.getText();
        String senha = passwordToString(txtSenha.getPassword());
        switch (type) {
            case 1:
                Professor p = (Professor)logged.login(usuario, senha);
                if(p != null)
                {
                    FrmProfessor frmProfessor = new FrmProfessor(logged);
                    frmProfessor.setVisible(true);
                    clean_fields();
                    close();
                }
                else
                    JOptionPane.showMessageDialog(this, "Usuário ou Senha incorreta.");
                break;
            case 2:
            {
                Administrador a = (Administrador)logged.login(usuario, senha);
                if(a != null)
                {
                    FrmAdministrador frmAdministrador = new FrmAdministrador(logged);
                    frmAdministrador.setVisible(true);
                    clean_fields();
                    close();
                }
                else
                    JOptionPane.showMessageDialog(this, "Usuário ou Senha incorreta.");
            }       break;
            case 3:
                Aluno al = (Aluno)logged.login(usuario, senha);
                if(al != null)
                {
                    FrmAluno frmAluno = new FrmAluno(logged);
                    frmAluno.setVisible(true);
                    clean_fields();
                    close();
                }
                else
                    JOptionPane.showMessageDialog(this, "Usuário ou Senha incorreta.");
                break;
            default:
                break;
        }
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBackActionPerformed
    {//GEN-HEADEREND:event_btnBackActionPerformed
        this.dispose();
        FrmHome home_window = new FrmHome();
        home_window.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
