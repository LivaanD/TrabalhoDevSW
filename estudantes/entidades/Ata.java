package estudantes.entidades;

import professor.entidades.CodigoCurso;

public class Ata extends Documento
{
    private int numero;
    private String texto;
    private String[] presentes;

    // Construtor
    public Ata (String criador, CodigoCurso CodigoCurso, int paginas, int numero, String texto, String[] presentes)
    { 
        super(criador, CodigoCurso, paginas);
        this.numero = numero;
        this.texto = texto;
        this.presentes = presentes;
    }
}