package estudantes.entidades;

import java.util.Objects;

import professor.entidades.CodigoCurso;

public class Oficio extends Deliberacao
{
    private String destinatario;

    // Construtor
    public Oficio(String criador, CodigoCurso codigoCurso, int paginas, String texto, String destinatario)
    {
        super(criador, codigoCurso, paginas, texto);
        this.destinatario = destinatario;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (!super.equals(obj)) return false;
        
        Oficio oficio = (Oficio) obj;
        return Objects.equals(destinatario, oficio.destinatario);
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(super.hashCode(), destinatario);
    }

}