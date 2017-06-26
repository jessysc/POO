package sistemaEscolar.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sistemaEscolar.Model.Professor;

/**
 * Classe responsável pelas operações CRUD de professores no banco de dados.

 */
public class ProfessorDAO implements DAO<Professor>
{ 
    /**
     * Método responsável por persistir um professor no banco de dados.
     * @param obj
     * @return valor booleano indicando se a persistência foi realizada com sucesso!
     */
    
    @Override
    
    //Método responsável por adicionar professor ao banco de dados
    public boolean add(Professor obj)
    {
        String usuario = obj.getUsuario();
        String senha = obj.getSenha();
        String nome = obj.getNome();
        System.out.println(nome);
        String email = obj.getEmail();
        Date datanascimento = Date.from(obj.getDataNascimento().atStartOfDay(ZoneId.systemDefault()).toInstant());
        String sql = "INSERT INTO professor VALUES('"+nome+"','"+datanascimento+"','"+email+"','"+usuario+"','"+senha+"')";
        return Conexao.update(sql);
    }

    /**
     * Método responsável por remover um professor do banco de dados.
     * @param obj
     * @return valor booleano indicando se a remorção por realizada com sucesso.
     */
    
    @Override
    public boolean remove(Professor obj)
    {
        //Deleta professor usando email como identificador.
        String sql = "DELETE FROM professor WHERE email='"+obj.getEmail()+"'";
        return Conexao.update(sql);
    }

    /**
     * Método responsável por atualizar os dados do professor no banco de dados usando o Email como chave primária.
     * @param obj
     * @return valor booleano indicando se a atualização foi realizada com sucesso.
     */  
    @Override
    public boolean update(Professor obj)
    {
        String nome = obj.getNome();
        String usuario = obj.getUsuario();
        String senha = obj.getSenha();
       
        String sql = "UPDATE professor SET nome='"+nome+"', usuario='"+usuario+"', senha='"+senha+"' WHERE email='"+obj.getEmail()+"'";
        return Conexao.update(sql);
    }
    
    

    /**
     * Método responsável por listar todos os professores persistidos no banco de dados.
     * @return ArrayList contendo todos os administradores cadastrados.
     */
    
    @Override
    public java.util.List<Professor> List()
    {
        List<Professor> professores = new ArrayList<>();
        String sql = "SELECT * FROM professor";
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
                Professor j = new Professor(nome,dataNascimento,email,usuario,senha);
                professores.add(j);
            }
            return professores;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
}
