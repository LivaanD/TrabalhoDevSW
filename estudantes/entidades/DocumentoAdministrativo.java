package estudantes.entidades;

import professor.entidades.CodigoCurso;

public abstract class DocumentoAdministrativo extends Documento 
{
    // Construtor
    public DocumentoAdministrativo(String criador, CodigoCurso CodigoCurso, int paginas)
    {
        super(criador, CodigoCurso, paginas);
    }
}
