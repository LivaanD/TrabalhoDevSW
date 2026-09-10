package estudantes.entidades;

import java.util.Arrays;
import java.util.Objects;

import professor.entidades.CodigoCurso;

public class Edital extends Norma
{
    private String[] responsaveis;

    // Construtor
    public Edital(String criador, CodigoCurso codigoCurso, int paginas, int numero, boolean valido, String texto, String[] responsaveis)
    {
        super(criador, codigoCurso, paginas, numero, valido, texto);
        this.responsaveis = responsaveis;
    }
    
    @Override
    public boolean equals(Object obj) 
    {
        if (!super.equals(obj)) return false;
        
        Edital edit = (Edital) obj;
        return Arrays.equals(responsaveis, edit.responsaveis);
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(super.hashCode(), Arrays.hashCode(responsaveis));
    }
}
