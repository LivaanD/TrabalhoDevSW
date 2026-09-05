package estudantes.entidades;

import professor.entidades.CodigoCurso;

public class Norma extends DocumentoAdministrativo
{
    private int numero;
    private boolean valido;
    private String texto;
    
    // Construtor
    public Norma (String criador, CodigoCurso CodigoCurso, int paginas, int numero, boolean valido, String texto)
    {
        super(criador, CodigoCurso, paginas);
        this.numero = numero;
        this.valido = valido;
        this.texto = texto;
    }
}
