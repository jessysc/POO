package sistemaEscolar.Model;

import java.time.LocalDate;

/**
 * Classe aluno que extende de Usuário 
 * e implementa a interface Comparable.
 */
public class Aluno extends Usuario 
{
    private final int nota;

    public Aluno(String nome, LocalDate dataNascimento, String email, String usuario, String senha,int nota)
    {
        super(nome,dataNascimento,email,usuario,senha);
        this.nota = nota;
    }
 
    public int getNota()
    {
        return nota;
    }
    
    @Override
    public String toString()
    {
        return super.toString()+" |Nota: "+nota;
    }

    /**
     * Sobrescrita do método compareTo da interface Comparable,
     * definindo que os alunos serão comparados pela pontuação.
     * @param aluno
     * @return 
     */
    
    public int compareTo(Aluno aluno)
    {
        return aluno.getNota() - this.nota;
    }
}
