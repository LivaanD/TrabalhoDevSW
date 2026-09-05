package estudantes.entidades;

import professor.entidades.CodigoCurso;

public class Historico extends Registro 
{
    private double coeficiente;
    private String[] componentes;

    // Construtor
    public Historico (String criador, CodigoCurso CodigoCurso, int paginas, long autenticacao, String estudante, long matricula, double coeficiente, String[] componentes)
    {
        super(criador, CodigoCurso, paginas, autenticacao, estudante, matricula);
        this.coeficiente = coeficiente;
        this.componentes = componentes;
    }
}
