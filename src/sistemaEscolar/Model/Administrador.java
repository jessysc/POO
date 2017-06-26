package sistemaEscolar.Model;

import java.time.LocalDate;
import sistemaEscolar.Control.ControlProfessor;

/**
 * Classe Administrador que extende de Usuario e também
 * implementa Comparable.
 
 */
public class Administrador extends Usuario implements Comparable<Administrador>
{
 
    public Administrador(String nome, LocalDate dataNascimento, String email, String usuario, String senha)
    {
        super(nome,dataNascimento,email,usuario,senha);
    }   

    
    /**
     * Método responsável por remover o professor passado por parâmetro através do ControlProfessor
     * É chamado o método remove() de controlProfessor passando o professor por parâmetro.
     * @param controlProfessor
     * @param professor
     * @return valor booleano indicando se a remorção do professor foi feita com sucesso.
     */
    public boolean removeUser(ControlProfessor controlProfessor, Professor professor)
    {
       return controlProfessor.remove(professor);
    }
    
    /**
     * Método da interface Comparable sendo sobrescrito, assim definindo que
     * os administradores serão comparados pela idade.
     * @param administrador
     * @return 
     */
    @Override
    public int compareTo(Administrador administrador)
    {
        return super.getIdade() - administrador.getIdade();
    }
}
