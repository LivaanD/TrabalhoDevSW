package estudantes.entidades;

import professor.entidades.CodigoCurso;

public class Certificado extends Registro 
{
    private String descricao;

    // Construtor
    public Certificado (String criador, CodigoCurso CodigoCurso, int paginas, long autenticacao, String estudante, long matricula, String descricao)
    {
        super(criador, CodigoCurso, paginas, autenticacao, estudante, matricula);
        this.descricao = descricao;
    }
}
