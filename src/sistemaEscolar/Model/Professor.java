package sistemaEscolar.Model;

import java.time.LocalDate;
import sistemaEscolar.Control.ControlAluno;

public class Professor extends Usuario{   
    
  
    public Professor(String nome, LocalDate dataNascimento, String email, String usuario, String senha)
    {
        super(nome,dataNascimento,email,usuario,senha);
        
    }
    /**
     * Método responsável por remover o aluno passado por parâmetro através do ControlAluno
     * É chamado o método remove() de controlAluno passando o aluno por parâmetro.
     * @param controlAluno
     * @param aluno
     * @return valor booleano indicando se a remorção do aluno foi feita com sucesso.
     */ 
     public boolean removeUser(ControlAluno controlAluno, Aluno aluno)
    {
       return controlAluno.remove(aluno);
    }
      
}
