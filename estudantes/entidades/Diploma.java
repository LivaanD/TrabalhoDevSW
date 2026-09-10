package estudantes.entidades;

import java.util.Objects;

import professor.entidades.CodigoCurso;

public class Diploma extends Certificado
{
    private String habilitacao;

    // Construtor
    public Diploma(String criador, CodigoCurso codigoCurso, int paginas, long autenticacao, String estudante, long matricula, String descricao, String habilitacao)
    {
        super(criador, codigoCurso, paginas, autenticacao, estudante, matricula, descricao);
        this.habilitacao = habilitacao;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (!super.equals(obj)) return false;
        
        Diploma diploma = (Diploma) obj;
        return Objects.equals(habilitacao, diploma.habilitacao);
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(super.hashCode(), habilitacao);
    }

}

