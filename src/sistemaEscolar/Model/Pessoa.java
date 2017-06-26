package sistemaEscolar.Model;

import java.time.LocalDate;
import java.time.Period;

/**
 * Classe abstrata Pessoa
*/
public abstract class Pessoa
{
    private final String nome;
    private final String email;
    private final LocalDate dataNascimento;

    public Pessoa(String nome, LocalDate dataNascimento, String email)
    {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    /**
     * 
     * @return String contendo o nome
     */
    public String getNome() 
    {
        return nome;
    }
    
    /**
     * 
     * @return String contendo o email
     */
    public String getEmail() 
    {
        return email;
    }

    /**
     * Método que cálcula a idade através da data atual e a data de nascimento da pessoa.
     * @return valor inteiro indicando a idade resultante.
     */
    public int getIdade() 
    {
        LocalDate current = LocalDate.now();
        Period p = Period.between(dataNascimento, current);
        return p.getYears();
    }
    
    /**
     * 
     * @return LocalDate com a data de nascimento da pessoa
     */
    public LocalDate getDataNascimento()
    {
        return dataNascimento;
    }
  
    @Override
    public String toString()
    {
        return "|Nome: "+nome+" |Idade: "+getIdade()+" |Email: "+email;
    }
    
    
}
