package estudantes.entidades;
import java.util.List;

public class GrupoDocumentos {
    List<Documento> lista;
    List<Documento> atas; 
    int totalPaginas;

    public GrupoDocumentos(List<Documento> lista, List<Documento> atas, int totalPaginas) {
        this.lista = lista;
        this.atas = atas; 
        this.totalPaginas = totalPaginas;
    }
}