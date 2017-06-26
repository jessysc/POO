package sistemaEscolar.Exceptions;

public class EmailJaCadastrado extends Exception
{
    public EmailJaCadastrado()
    {
        super("Já existe um usuário com esse E-mail.");
    }
}
