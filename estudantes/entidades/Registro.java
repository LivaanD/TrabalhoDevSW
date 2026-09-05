package estudantes.entidades;

import professor.entidades.CodigoCurso;

public abstract class Registro extends DocumentoAcademico
{
    private String estudante;
    private long matricula;
    
    // Construtor
    public Registro(String criador, CodigoCurso CodigoCurso, int paginas, long autenticacao, String estudante, long matricula)
    {
        super(criador, CodigoCurso, paginas, autenticacao);
        this.estudante = estudante;
        this.matricula = matricula;
    }
}
