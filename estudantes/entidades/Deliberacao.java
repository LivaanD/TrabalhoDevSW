package estudantes.entidades;

import java.util.Objects;

import professor.entidades.CodigoCurso;

public abstract class Deliberacao extends DocumentoAdministrativo 
{
    private String texto;
    
    // Construtor
    public Deliberacao(String criador, CodigoCurso codigoCurso, int paginas, String texto)
    {
        super(criador, codigoCurso, paginas);
        this.texto = texto;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (!super.equals(obj)) 
        {
            return false;
        }

        Deliberacao delib = (Deliberacao) obj;
        return Objects.equals(texto, delib.texto);
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(super.hashCode(), texto);
    }
}
