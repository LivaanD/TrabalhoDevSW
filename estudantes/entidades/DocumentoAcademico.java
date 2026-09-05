package estudantes.entidades;

import professor.entidades.CodigoCurso;

public abstract class DocumentoAcademico extends Documento 
{
    private long autenticacao;
    
    // Construtor
    public DocumentoAcademico(String criador, CodigoCurso CodigoCurso, int paginas, long autenticacao)
    {
        super(criador, CodigoCurso, paginas);
        this.autenticacao = autenticacao;
    }
}
