package sistemaEscolar.Control;

import java.util.List;

/**
 * Interface que terá métodos apenas para listar objetos e ordená-los.
 * @param <T>
 */
public interface Pesquisavel<T>
{
    /**
     * Método que retorna uma lista de objetos.
     * @return lista de objetos.
     */
    List<T> list();
    /**
     * Método que retorna uma lista ordenada de objetos.
     * @return lista ordenada de objetos.
     */
    List<T> sort();
}
