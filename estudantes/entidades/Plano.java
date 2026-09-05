package estudantes.entidades;

import professor.entidades.CodigoCurso;

public class Plano extends DocumentoAcademico
{
    private String responsavel;
    private String[] planejamento;
    
    // Construtor
    public Plano(String criador, CodigoCurso CodigoCurso, int paginas, long autenticacao, String responsavel, String[] planejamento)
    {
        super(criador, CodigoCurso, paginas, autenticacao);
        this.responsavel = responsavel;
        this.planejamento = planejamento;
    }
}