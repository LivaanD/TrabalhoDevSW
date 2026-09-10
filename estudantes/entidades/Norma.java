package estudantes.entidades;

import java.util.Objects;

import professor.entidades.CodigoCurso;

public class Norma extends DocumentoAdministrativo
{
    private int numero;
    private boolean valido;
    private String texto;
    
    // Construtor
    public Norma (String criador, CodigoCurso codigoCurso, int paginas, int numero, boolean valido, String texto)
    {
        super(criador, codigoCurso, paginas);
        this.numero = numero;
        this.valido = valido;
        this.texto = texto;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (!super.equals(obj)) 
        {
            return false;
        }

        Norma norma = (Norma) obj;
        return numero == norma.numero && valido == norma.valido && Objects.equals(texto, norma.texto);
    }
    
    @Override
    public int hashCode() 
    {
        return Objects.hash(super.hashCode(), numero, valido, texto);
    }
}
