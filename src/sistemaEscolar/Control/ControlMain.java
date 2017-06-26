package sistemaEscolar.Control;

/**
 * Classe responsável por retornar as instâncias dos controladores seguindo
 * o padrão Singleton, o que garante que nunca precisaremos instanciar um novo 
 * controlador e também que o mesmo nunca será nulo.
 * Vale lembrar que todos os métodos são estáticos, logo, não se faz necessário
 * a istância de um objeto dessa classe, uma vez que os métodos podem ser acessados
 * diretamente da classe. 
 */
public class ControlMain
{
    private static  ControlAdministrador controlAdministrador; 
    private static  ControlAluno controlAluno;
    private static  ControlProfessor controlProfessor;
    
    /**
     * Método responsável por retornar instância do Controlador de Adminsitradores.
     * @return instância de ControlAdministrador
     */
    public static ControlAdministrador getControlAdministrador()
    {
        if(controlAdministrador == null)
            controlAdministrador = new ControlAdministrador();
        return controlAdministrador;
    }

    /**
     * Método responsável por retornar instância do Controlador de Alunos.
     * @return instância de ControlAluno
     */
    public static ControlAluno getControlAluno()
    {
        if(controlAluno == null)
            controlAluno = new ControlAluno();
        return controlAluno;
    }
    
    
    /**
     * Método responsável por retornar instância do Controlador de Professores.
     * @return instância de ControlProfessor
     */
     public static ControlProfessor getControlProfessor()
    {
        if(controlProfessor == null)
            controlProfessor = new ControlProfessor();
        return controlProfessor;
    }

  
   
}