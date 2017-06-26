package sistemaEscolar.Control;

import java.util.ArrayList;
import java.util.List;
import sistemaEscolar.DAO.ProfessorDAO;
import sistemaEscolar.Model.Professor;

/**
 *  Classe responsável pelo controle de professores do sistema.
 *  A classe possui uma lista de professores que contém todos os professores cadastrados,
 *  O professor logado que contêm o professor que está logado no momento de execução,
 *  e o ProfessorDAO que é a classe que tem acesso ao banco de dados.
 */
public class ControlProfessor implements Pesquisavel<Professor>, Crud<Professor>, Login<Professor>
{
    private final List<Professor> professores;
    private Professor loggedProfessor;
    private final ProfessorDAO dao;
    
    /**
     * No construtor é instanciado um objeto de ProfessorDAO, que vai servir pra fazer alterações no banco,
     * tais como: Persistir um novo professor, remover um professor e atualizar os dados de um professor e também
     * o atributo 'professores' recebe uma lista contendo todos os professores do banco através do método list() do
     * objeto dao.
     */
    public ControlProfessor()
    {
        dao = new ProfessorDAO();
        professores = dao.List();
    }
    
    /**
     * Método responsável por adicionar um novo professor à lista de professores e persistir esse mesmo professor no banco de dados através 
     * do método add do objeto dao da classe ProfessorDAO.
     * @param professor - instancia da classe Professor
     * @return valor booleano indicando se a inserção e a persistência foram efetuadas com sucesso. 
     */
    @Override
    public boolean add(Professor professor)
    {
        if(!thatEmailExists(professor.getEmail()))
            return professores.add(professor) && dao.add(professor);
        return false;
    }
    
    /**
     * Método responsável por remover um professor da lista de professores e remover também esse mesmo professor do banco de dados.
     * @param professor - instancia da classe Professor
     * @return valor booleano indicando se a remorção tanto da lista quanto do banco foram efetuadas com sucesso. 
     */
    @Override
    public boolean remove(Professor professor)
    {
        return professores.remove(professor) && dao.remove(professor);
    }
    
    /**
     * Método responsável por atualizar os dados do professor. Detalhe que não precisamos atualizar a lista 'professores' 
     * uma vez que os dados do professor é atualizado pelo método set. Então apenas chamamos o método 'update' do dao para atualizar
     * os dados do professor persistido no banco.
     * @param professor - instancia da classe Professor
     * @return booleano indicando se a atualização dos dados no banco foram efetuadas com sucesso. 
     */
    @Override
    public boolean update(Professor professor)
    {
        return dao.update(professor);
    }
    
    /**
     * Método responsável por retornar um Professor que contenha o email passado por parâmetro.
     * @param email - valor em String de um email.
     * @return caso haja um professor com o email passado por parâmetro o método retornará uma instância deste. 
     * Caso contrário, retornará null.
     */
    public Professor get(String email)
    {
        for(Professor p : professores)
            if(p.getEmail().equals(email))
                return p;
        return null;
    }
    
    /**
     * Método responsável por remover um Professor que contenha o email passado por parâmetro.
     * Primeiramente ele pega uma instância do professor com o método get() dessa mesma classe, caso o método retorne um professor
     * ele chama o método remove() dessa mesma classe passando por parâmetro a instância de professor obtida.
     * @param email - valor em String de um email.
     * @return valor booleano. Caso a remorção seja efetuada com sucesso, retorna true. Caso contrário, retorna false.
     */
    public boolean remove(String email)
    {
        Professor j = get(email);
        if(j != null)
            return remove(j);
        return false;
    }

    /**
     * Método responsável por retornar uma lista contendo todos os professores cadastrados.
     * @return list de professores.
     */
    @Override
    public List<Professor> list()
    {
        return professores;
    }
    /**
     * Método que ordena lista de professores através da classe Collections, 
     * vale lembrar que a lista de professores dessa classe não é alterada, 
     * o método cria uma outra lista com as mesmas referências de objetos da outra 
     * e então é ordenada.
     * @return - lista contendo os professores ordenados.
     */
    @Override
    public List<Professor> sort()
    {
        List<Professor> list = new ArrayList<>();
        list.addAll(professores);
        //Collections.sort(list);
        return list;
    }
    
    /**
     * Método responsável por realizar o login de um professor.
     * A verificação é feita através do usuario e a senha passados por parâmetro.
     * Através de um foreach o método verífica se algum professor possui estas credenciais.
     * @param usuario - valor em String do usuario
     * @param senha - valor em String da senha
     * @return - Caso existe um professor com o usuario e a senha passado por parâmetro, o método retornará uma instância do professor,
     * caso contrário, retornará null. 
     */
    @Override
    public Professor login(String usuario, String senha)
    {
        for(Professor professor : professores)
        {
            if(professor.getUsuario().equals(usuario) && professor.getSenha().equals(senha))
            {
                this.loggedProfessor = professor;
                return professor;
            }
        }
        return null;
    }
    
    /**
     * Verifica se existem professores cadastrados no sistema.
     * @return - valor booleano indicando se existem ou não professores cadastrados.
     */
    @Override
    public boolean haveUsers()
    {
        return !professores.isEmpty();
    }
    
    /**
     * Método responsável por deslogar o professor setando o atributo loggedProfessor como nulo.
     */
    @Override
    public void logoff()
    {
        this.loggedProfessor = null;
    }
    
    /**
     * Método responsável por retornar o professor que está logado no sistema.
     * @return instância de um professor.
     */
    @Override
    public Professor getLoggedUser()
    {
        return this.loggedProfessor;
    }
    
     /**
     * Método responsável por verificar se o email a ser cadastrado já existe no sistema. 
     * @param email - String contendo email
     * @return valor booleano indicando se o email passado por parâmetro já existe.
     */
    public boolean thatEmailExists(String email)
    {
        for(Professor j : professores)
            if(j.getEmail().equals(email))
                return true;
        return false;
    }
}
