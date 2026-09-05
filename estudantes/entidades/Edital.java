package estudantes.entidades;

import professor.entidades.CodigoCurso;

public class Edital extends Norma
{
    private String[] responsaveis;

    // Construtor
    public Edital(String criador, CodigoCurso CodigoCurso, int paginas, int numero, boolean valido, String texto, String[] responsaveis)
    {
        super(criador, CodigoCurso, paginas, numero, valido, texto);
        this.responsaveis = responsaveis;
    }

}
