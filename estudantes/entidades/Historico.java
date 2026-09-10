package estudantes.entidades;

import java.util.Arrays;
import java.util.Objects;

import professor.entidades.CodigoCurso;

public class Historico extends Registro 
{
    private double coeficiente;
    private String[] componentes;

    // Construtor
    public Historico (String criador, CodigoCurso codigoCurso, int paginas, long autenticacao, String estudante, long matricula, double coeficiente, String[] componentes)
    {
        super(criador, codigoCurso, paginas, autenticacao, estudante, matricula);
        this.coeficiente = coeficiente;
        this.componentes = componentes;
    }
    
    @Override
    public boolean equals(Object obj) 
    {
        if (!super.equals(obj)) return false;
        
        Historico historico = (Historico) obj;
        return Double.compare(historico.coeficiente, coeficiente) == 0 && Arrays.equals(componentes, historico.componentes);
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(super.hashCode(), coeficiente, Arrays.hashCode(componentes));
    }

}
