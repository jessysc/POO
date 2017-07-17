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
public class AlunoDAO implements DAO<Aluno>
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
        double nota1 = obj.getN1();
        double nota2 = obj.getN2();
        double nota3 = obj.getPrj();
        double notaFinal = obj.getNotaFinal();
        
        Date dataNascimento = Date.from(obj.getDataNascimento().atStartOfDay(ZoneId.systemDefault()).toInstant());
        String sql = "INSERT INTO aluno VALUES('"+nome+"','"+dataNascimento+"','"+email+"','"+usuario+"','"+senha+"', '"+nota1+"', '"+nota2+"', '"+nota3+"',"+notaFinal+")";
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
        double nota1 = obj.getN1();
        double nota2 = obj.getN2();
        double nota3 = obj.getPrj();
        double notaFinal = obj.getNotaFinal();
       
        String sql = "UPDATE aluno SET nome='"+nome+"', usuario='"+usuario+"', senha='"+senha+"', nota1='"+nota1+"', nota2='"+nota2+"', nota3='"+nota3+"',notaFinal='"+notaFinal+"' WHERE email='"+obj.getEmail()+"'";
        return Conexao.update(sql);
    }
    
   

    /**
     * Método responsável por listar todos os alunos persistidos no banco de dados.
     * @return ArrayList contendo todos os alunos cadastrados.
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
                double nota1 = rs.getDouble("nota1");
                double nota2 = rs.getDouble("nota2");
                double nota3 = rs.getDouble("nota3");
                double notaFinal = rs.getDouble("notaFinal");
                Aluno j = new Aluno(nome,dataNascimento,email,usuario,senha, nota1, nota2, nota3, notaFinal);
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
