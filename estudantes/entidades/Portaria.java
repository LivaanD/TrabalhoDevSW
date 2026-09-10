package estudantes.entidades;

import java.util.Objects;

import professor.entidades.CodigoCurso;

public class Portaria extends Norma
{
    private int anoInicio;

    // Construtor
    public Portaria(String criador, CodigoCurso codigoCurso, int paginas, int numero, boolean valido, String texto, int anoInicio)
    {
        super(criador, codigoCurso, paginas, numero, valido, texto);
        this.anoInicio = anoInicio;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (!super.equals(obj)) return false;
        
        Portaria port = (Portaria) obj;
        return anoInicio == port.anoInicio;
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(super.hashCode(), anoInicio);
    }
}
