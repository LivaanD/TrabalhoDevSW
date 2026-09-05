package estudantes.entidades;

import professor.entidades.CodigoCurso;

public class Diploma extends Certificado
{
    private String habilitacao;

    // Construtor
    public Diploma(String criador, CodigoCurso CodigoCurso, int paginas, long autenticacao, String estudante, long matricula, String descricao, String hablitacao)
    {
        super(criador, CodigoCurso, paginas, autenticacao, estudante, matricula, descricao);
        this.habilitacao = hablitacao;
    }
}