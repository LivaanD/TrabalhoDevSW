package estudantes.entidades;

import java.util.Arrays;
import java.util.Objects;

import professor.entidades.CodigoCurso;

public class Plano extends DocumentoAcademico
{
    private String responsavel;
    private String[] planejamento;
    
    // Construtor
    public Plano(String criador, CodigoCurso codigoCurso, int paginas, long autenticacao, String responsavel, String[] planejamento)
    {
        super(criador, codigoCurso, paginas, autenticacao);
        this.responsavel = responsavel;
        this.planejamento = planejamento;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (!super.equals(obj)) return false;
        
        Plano plano = (Plano) obj;
        return Objects.equals(responsavel, plano.responsavel) && Arrays.equals(planejamento, plano.planejamento);
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(super.hashCode(), responsavel, Arrays.hashCode(planejamento));
    }
}