package estudantes.entidades;

import professor.entidades.CodigoCurso;

public class Oficio extends Deliberacao
{
    private String destinatario;

    // Construtor
    public Oficio(String criador, CodigoCurso CodigoCurso, int paginas, String texto, String destinatario)
    {
        super(criador, CodigoCurso, paginas, texto);
        this.destinatario = destinatario;
    }
}