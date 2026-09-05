package estudantes.entidades;

import professor.entidades.CodigoCurso;

public class Portaria extends Norma
{
    private int anoInicio;

    // Construtor
    public Portaria(String criador, CodigoCurso CodigoCurso, int paginas, int numero, boolean valido, String texto, int anoInicio)
    {
        super(criador, CodigoCurso, paginas, numero, valido, texto);
        this.anoInicio = anoInicio;
    }

}
