package estudantes.entidades;

import professor.entidades.CodigoCurso;
import java.util.Objects;
import java.util.Arrays;

public class Ata extends Documento
{
    private int numero;
    private String texto;
    private String[] presentes;

    // Construtor
    public Ata (String criador, CodigoCurso codigoCurso, int paginas, int numero, String texto, String[] presentes)
    { 
        super(criador, codigoCurso, paginas);
        this.numero = numero;
        this.texto = texto;
        this.presentes = presentes;
    }

    // equals
    @Override
    public boolean equals(Object obj) 
    {
        if(!super.equals(obj))
        {
            return false;
        }
        
        Ata ata = (Ata) obj;
        return numero == ata.numero && Objects.equals(texto, ata.texto) && Arrays.equals(presentes, ata.presentes);
    }

    // hashCode
    @Override
    public int hashCode() 
    {
        return Objects.hash(super.hashCode(), numero, texto, Arrays.hashCode(presentes));
    }

}