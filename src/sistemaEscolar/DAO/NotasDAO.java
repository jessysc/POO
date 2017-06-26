package sistemaEscolar.DAO;

import sistemaEscolar.Model.Aluno;

/**
 * Interface com responsável por atualizar as notas do aluno.
 */
public interface NotasDAO
{   
    /**
     * Método responsável por atualizar as notas do aluno no banco de dados.
     * @param aluno instancia de um Aluno
     * @return valor booleano indicando se o update foi realizado com sucesso.
     */
    boolean updateNota(Aluno aluno);
}
