package estudantes.entidades;

import java.util.Objects;

import professor.entidades.CodigoCurso;

public abstract class DocumentoAcademico extends Documento 
{
    private long autenticacao;
    
    // Construtor
    public DocumentoAcademico(String criador, CodigoCurso codigoCurso, int paginas, long autenticacao)
    {
        super(criador, codigoCurso, paginas);
        this.autenticacao = autenticacao;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (!super.equals(obj)) return false;
        
        DocumentoAcademico docAcad = (DocumentoAcademico) obj;
        return autenticacao == docAcad.autenticacao;
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(super.hashCode(), autenticacao);
    }
}
