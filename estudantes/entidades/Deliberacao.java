package estudantes.entidades;

import professor.entidades.CodigoCurso;

public abstract class Deliberacao extends DocumentoAdministrativo 
{
    private String texto;
    
    // Construtor
    public Deliberacao(String criador, CodigoCurso CodigoCurso, int paginas, String texto)
    {
        super(criador, CodigoCurso, paginas);
        this.texto = texto;
    }
}
