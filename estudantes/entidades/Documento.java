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
    private CodigoCurso codigoCurso;
    private int paginas;

    // Construtor
    public Documento(String criador, CodigoCurso codigoCurso, int paginas)
    {
        this.criador = criador;
        this.codigoCurso = codigoCurso;
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
        
        Documento documento = (Documento) obj;
        return paginas == documento.paginas && Objects.equals(criador, documento.criador) && Objects.equals(codigoCurso, documento.codigoCurso);
    }

    // hashCode
    @Override
    public int hashCode() 
    {
        return Objects.hash(criador, codigoCurso, paginas);
    }
}
