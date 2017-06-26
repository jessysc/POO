package sistemaEscolar.Control;

import java.util.ArrayList;
import java.util.List;
import sistemaEscolar.DAO.AlunoDAO;
import sistemaEscolar.Model.Aluno;

/**
 *  Classe responsável pelo controle de alunos do sistema.
 *  A classe possui uma lista de alunos que contém todos os alunos cadastrados,
 *  O aluno logado que contêm o aluno que está logado no momento de execução,
 *  e o AlunoDAO que é a classe que tem acesso ao banco de dados.
 */
public class ControlAluno implements Pesquisavel<Aluno>, Crud<Aluno>, Login<Aluno>
{
    private final List<Aluno> alunos;
    private Aluno loggedAluno;
    private final AlunoDAO dao;
    
    /**
     * No construtor é instanciado um objeto de AlunoDAO, que vai servir pra fazer alterações no banco,
     * tais como: Persistir um novo aluno, remover um aluno e atualizar os dados de um aluno e também
     * o atributo 'alunos' recebe uma lista contendo todos os alunos do banco através do método list() do
     * objeto dao.
     */
    public ControlAluno()
    {
        dao = new AlunoDAO();
        alunos = dao.List();
    }
    
    /**
     * Método responsável por adicionar um novo aluno à lista de alunos e persistir esse mesmo aluno no banco de dados através 
     * do método add do objeto dao da classe AlunoDAO.
     * @param aluno - instancia da classe Aluno
     * @return valor booleano indicando se a inserção e a persistência foram efetuadas com sucesso. 
     */
    @Override
    public boolean add(Aluno aluno)
    {
        if(!thatEmailExists(aluno.getEmail()))
            return alunos.add(aluno) && dao.add(aluno);
        return false;
    }
    
    /**
     * Método responsável por remover um aluno da lista de alunos e remover também esse mesmo aluno do banco de dados.
     * @param aluno - instancia da classe Aluno
     * @return valor booleano indicando se a remorção tanto da lista quanto do banco foram efetuadas com sucesso. 
     */
    @Override
    public boolean remove(Aluno aluno)
    {
        return alunos.remove(aluno) && dao.remove(aluno);
    }
    
    /**
     * Método responsável por atualizar os dados do aluno. Detalhe que não precisamos atualizar a lista 'alunos' 
     * uma vez que os dados do aluno é atualizado pelo método set. Então apenas chamamos o método 'update' do dao para atualizar
     * os dados do aluno persistido no banco.
     * @param aluno - instancia da classe Aluno
     * @return booleano indicando se a atualização dos dados no banco foram efetuadas com sucesso. 
     */
    @Override
    public boolean update(Aluno aluno)
    {
        return dao.update(aluno);
    }
    
    /**
     * Método responsável por retornar um Aluno que contenha o email passado por parâmetro.
     * @param email - valor em String de um email.
     * @return caso haja um aluno com o email passado por parâmetro o método retornará uma instância deste. 
     * Caso contrário, retornará null.
     */
    public Aluno get(String email)
    {
        for(Aluno j : alunos)
            if(j.getEmail().equals(email))
                return j;
        return null;
    }
    
    /**
     * Método responsável por remover um Aluno que contenha o email passado por parâmetro.
     * Primeiramente ele pega uma instância do aluno com o método get() dessa mesma classe, caso o método retorne um aluno
     * ele chama o método remove() dessa mesma classe passando por parâmetro a instância de aluno obtida.
     * @param email - valor em String de um email.
     * @return valor booleano. Caso a remorção seja efetuada com sucesso, retorna true. Caso contrário, retorna false.
     */
    public boolean remove(String email)
    {
        Aluno j = get(email);
        if(j != null)
            return remove(j);
        return false;
    }

    /**
     * Método responsável por retornar uma lista contendo todos os alunos cadastrados.
     * @return list de alunos.
     */
    @Override
    public List<Aluno> list()
    {
        return alunos;
    }
    /**
     * Método que ordena lista de alunos através da classe Collections, 
     * vale lembrar que a lista de alunos dessa classe não é alterada, 
     * o método cria uma outra lista com as mesmas referências de objetos da outra 
     * e então é ordenada.
     * @return - lista contendo os alunos ordenados.
     */
    @Override
    public List<Aluno> sort()
    {
        List<Aluno> list = new ArrayList<>();
        list.addAll(alunos);
       // Collections.sort(list);
        return list;
    }
    
    /**
     * Método responsável por realizar o login de um aluno.
     * A verificação é feita através do usuario e a senha passados por parâmetro.
     * Através de um foreach o método verífica se algum aluno possui estas credenciais.
     * @param usuario - valor em String do usuario
     * @param senha - valor em String da senha
     * @return - Caso existe um aluno com o usuario e a senha passado por parâmetro, o método retornará uma instância do aluno,
     * caso contrário, retornará null. 
     */
    @Override
    public Aluno login(String usuario, String senha)
    {
        for(Aluno aluno : alunos)
        {
            if(aluno.getUsuario().equals(usuario) && aluno.getSenha().equals(senha))
            {
                this.loggedAluno = aluno;
                return aluno;
            }
        }
        return null;
    }
    
    /**
     * Verifica se existem alunos cadastrados no sistema.
     * @return - valor booleano indicando se existem ou não alunos cadastrados.
     */
    @Override
    public boolean haveUsers()
    {
        return !alunos.isEmpty();
    }
    
    /**
     * Método responsável por deslogar o aluno setando o atributo loggedAluno como nulo.
     */
    @Override
    public void logoff()
    {
        this.loggedAluno = null;
    }
    
    /**
     * Método responsável por retornar o aluno que está logado no sistema.
     * @return instância de um aluno.
     */
    @Override
    public Aluno getLoggedUser()
    {
        return this.loggedAluno;
    }
    
     /**
     * Método responsável por verificar se o email a ser cadastrado já existe no sistema. 
     * @param email - String contendo email
     * @return valor booleano indicando se o email passado por parâmetro já existe.
     */
    public boolean thatEmailExists(String email)
    {
        for(Aluno j : alunos)
            if(j.getEmail().equals(email))
                return true;
        return false;
    }
}
