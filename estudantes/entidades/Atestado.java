package estudantes.entidades;

import professor.entidades.CodigoCurso;

public class Atestado extends Registro 
{
    private String descricao;
    private String categoria;

    // Construtor
    public Atestado (String criador, CodigoCurso CodigoCurso, int paginas, long autenticacao, String estudante, long matricula, String descricao, String categoria)
    {
        super(criador, CodigoCurso, paginas, autenticacao, estudante, matricula);
        this.descricao = descricao;
        this.categoria = categoria;
    }
}
