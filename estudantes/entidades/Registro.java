package estudantes.entidades;

import java.util.Objects;

import professor.entidades.CodigoCurso;

public abstract class Registro extends DocumentoAcademico
{
    private String estudante;
    private long matricula;
    
    // Construtor
    public Registro(String criador, CodigoCurso codigoCurso, int paginas, long autenticacao, String estudante, long matricula)
    {
        super(criador, codigoCurso, paginas, autenticacao);
        this.estudante = estudante;
        this.matricula = matricula;
    }
    
    @Override
    public boolean equals(Object obj) 
    {
        if (!super.equals(obj)) return false;
        
        Registro reg = (Registro) obj;
        return matricula == reg.matricula && Objects.equals(estudante, reg.estudante);
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(super.hashCode(), estudante, matricula);
    }

}
