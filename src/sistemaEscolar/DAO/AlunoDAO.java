package sistemaEscolar.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sistemaEscolar.Model.Aluno;

/**
 * Classe responsável pelas operações CRUD de alunos no banco de dados.
*/
public class AlunoDAO implements DAO<Aluno>, NotasDAO
{ 
    /**
     * Método responsável por persistir um aluno no banco de dados.
     * @param obj
     * @return valor booleano indicando se a persistência foi realizada com sucesso!
     */
    
    @Override
    public boolean add(Aluno obj)
    {
        String usuario = obj.getUsuario();
        String senha = obj.getSenha();
        String nome = obj.getNome();
        System.out.println(nome);
        String email = obj.getEmail();
        Date dataNascimento = Date.from(obj.getDataNascimento().atStartOfDay(ZoneId.systemDefault()).toInstant());
        String sql = "INSERT INTO aluno VALUES('"+nome+"','"+dataNascimento+"','"+email+"','"+usuario+"','"+senha+"',"+obj.getNota()+")";
        return Conexao.update(sql);
    }

    /**
     * Método responsável por remover um aluno do banco de dados.
     * @param obj
     * @return valor booleano indicando se a remorção por realizada com sucesso.
     */
    
    @Override
    public boolean remove(Aluno obj)
    {
        //Deleta aluno usando email como identificador.
        String sql = "DELETE FROM aluno WHERE email='"+obj.getEmail()+"'";
        return Conexao.update(sql);
    }

    /**
     * Método responsável por atualizar os dados do aluno no banco de dados usando o Email como chave primária.
     * @param obj
     * @return valor booleano indicando se a atualização foi realizada com sucesso.
     */  
    @Override
    public boolean update(Aluno obj)
    {
        String nome = obj.getNome();
        String usuario = obj.getUsuario();
        String senha = obj.getSenha();
       
        String sql = "UPDATE aluno SET nome='"+nome+"', usuario='"+usuario+"', senha='"+senha+"' WHERE email='"+obj.getEmail()+"'";
        return Conexao.update(sql);
    }
    
    /**
     * Método responsável por atualizar a pontuação do aluno passado por parâmetro no banco de dados.
     * @param obj
     * @return valor booleano indicando se a atualização foi feita com sucesso.
     */
    @Override
    public boolean updateNota(Aluno obj)
    {
        String sql = "UPDATE aluno SET nota="+obj.getNota()+" WHERE EMAIL='"+obj.getEmail()+"'";
        return Conexao.update(sql);
    }

    /**
     * Método responsável por listar todos os alunos persistidos no banco de dados.
     * @return ArrayList contendo todos os administradores cadastrados.
     */
    
    @Override
    public java.util.List<Aluno> List()
    {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM aluno";
        ResultSet rs = Conexao.query(sql);
        try
        {
            while(rs.next())            
            {
                String nome = rs.getString("nome");
                Date data = rs.getDate("datanascimento");
                LocalDate dataNascimento = LocalDate.parse(data.toString());
                String email = rs.getString("email");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");
                int nota = rs.getInt("nota");
                Aluno j = new Aluno(nome,dataNascimento,email,usuario,senha,nota);
                alunos.add(j);
            }
            return alunos;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
}
