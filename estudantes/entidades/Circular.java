package estudantes.entidades;

import java.util.Arrays;
import java.util.Objects;

import professor.entidades.CodigoCurso;

public class Circular extends Deliberacao
{
    private String[] destinatarios;

    // Construtor
    public Circular(String criador, CodigoCurso codigoCurso, int paginas, String texto, String[] destinatarios)
    {
        super(criador, codigoCurso, paginas, texto);
        this.destinatarios = destinatarios;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (!super.equals(obj)) return false;
        
        Circular circ = (Circular) obj;
        return Arrays.equals(destinatarios, circ.destinatarios);
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(super.hashCode(), Arrays.hashCode(destinatarios));
    }
}
