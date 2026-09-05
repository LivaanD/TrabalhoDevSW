package estudantes.entidades;

import professor.entidades.CodigoCurso;

public class Circular extends Deliberacao
{
    private String[] destinatarios;

    // Construtor
    public Circular(String criador, CodigoCurso CodigoCurso, int paginas, String texto, String[] destinatarios)
    {
        super(criador, CodigoCurso, paginas, texto);
        this.destinatarios = destinatarios;
    }
}
