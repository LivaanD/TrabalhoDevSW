package estudantes.entidades;

import professor.entidades.CodigoCurso;
import java.util.Objects;

/**
 * Classe que representa um documento genérico.
 * <br><br>
 * <strong>Seu trabalho começa aqui...</strong>
 * 
 * @author coloque os nomes dos autores aqui
 */

public abstract class Documento 
{
    private String criador;
    private CodigoCurso CodigoCurso;
    private int paginas;

    // Construtor
    public Documento(String criador, CodigoCurso CodigoCurso, int paginas)
    {
        this.criador = criador;
        this.CodigoCurso = CodigoCurso;
        this.paginas = paginas;
    }
    
    // equals
    @Override
    public boolean equals(Object obj) 
    {
        if(this == obj) 
        {
            return true;
        }
        if(obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        
        Documento Documento = (Documento) obj;
        return paginas == Documento.paginas && Objects.equals(criador, Documento.criador) && Objects.equals(CodigoCurso, Documento.CodigoCurso);
    }

    // hashCode
    @Override
    public int hashCode() 
    {
        return Objects.hash(criador, CodigoCurso, paginas);
    }
}
