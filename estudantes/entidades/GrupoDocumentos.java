package estudantes.entidades;
import java.util.List;

public class GrupoDocumentos {
    List<Documento> lista;
    int totalPaginas;

    public GrupoDocumentos(List<Documento> lista, int totalPaginas) {
        this.lista = lista;
        this.totalPaginas = totalPaginas;
    }
}