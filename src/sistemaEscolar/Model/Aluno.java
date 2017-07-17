package sistemaEscolar.Model;

import java.time.LocalDate;
import sistemaEscolar.Control.ControlAluno;

/**
 * Classe aluno que extende de Usuário 
 * e implementa a interface Comparable.
 */
public class Aluno extends Usuario 
{
    private double nota1, nota2, nota3, notaFinal;
    

    public Aluno(String nome, LocalDate dataNascimento, String email, String usuario, String senha,double nota1, double nota2, double nota3, double notaFinal)
    {
        super(nome,dataNascimento,email,usuario,senha);
        this.nota1 = 0;
        this.nota2 = 0;
        this.nota3 = 0;        
        this.notaFinal = 0;  
        
    }
 
    public double getNotaFinal()
    {
        return notaFinal;
    }
    
    public double getN1()
    {
        return nota1;
    }
    
    public double getN2()
    {
        return nota2;
    }
    
    public double getPrj()
    {
        return nota3;
    }
    
    public void setN1(double nota){
        this.nota1 = nota;
    }
    
     public void setN2(double nota){
        this.nota2 = nota;
    }
     
      public void setN3(double nota){
        this.nota3 = nota;
    }
      
     public void setNotaFinal(double nota){
        this.notaFinal = nota;
    }  
    
        
    @Override
    public String toString()
    {
        return super.toString()+" |Nota: "+notaFinal;
        
    }

    /**
     * Sobrescrita do método compareTo da interface Comparable,
     * definindo que os alunos serão comparados pela pontuação.
     * @param controlAluno
     * @param aluno
     * @return 
     */
    
    public boolean notas(ControlAluno controlAluno, Aluno aluno)
    {
       return controlAluno.update(aluno);
    }
    
    public double compareTo(Aluno aluno)
    {
        return aluno.getNotaFinal() - this.notaFinal;
    }
}
