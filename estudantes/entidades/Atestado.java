package estudantes.entidades;

import java.util.Objects;

import professor.entidades.CodigoCurso;

public class Atestado extends Registro 
{
    private String descricao;
    private String categoria;

    // Construtor
    public Atestado (String criador, CodigoCurso codigoCurso, int paginas, long autenticacao, String estudante, long matricula, String descricao, String categoria)
    {
        super(criador, codigoCurso, paginas, autenticacao, estudante, matricula);
        this.descricao = descricao;
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (!super.equals(obj)) return false;
        
        Atestado outro = (Atestado) obj;
        return Objects.equals(descricao, outro.descricao) && Objects.equals(categoria, outro.categoria);
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(super.hashCode(), descricao, categoria);
    }
}
