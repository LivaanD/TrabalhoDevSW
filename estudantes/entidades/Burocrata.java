package estudantes.entidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import professor.entidades.*;

/**
 * Classe que traz a lógica do algoritmo de organização e despacho de processos.
 * <br><br>
 * Você pode incluir novos atributos e métodos nessa classe para criar
 * lógicas mais complexas para o gerenciamento da organização e despacho de 
 * processos, mas eles não serão invocados diretamente pelo simulador e devem
 * respeitar propriedades de encapsulamento e coesão.
 * 
 * @author João Marcelo Peres
 * @author Rafael Droves Silveira
 */
public class Burocrata {
    private int estresse = 0;
    private Mesa mesa;
    private Universidade universidade;
    
    /**
     * Construtor de Burocrata.
     * 
     * @param m mesa com os processos
     * @param u universidade com os montes dos cursos e a secretaria
     */
    public Burocrata(Mesa m, Universidade u){
        this.mesa = m;
        this.universidade = u;
    }
    
    /**
     * Executa a lógica de criação e despacho dos processos.
     * <br><br>
     * Esse método é o único método de controle invocado durante a simulação 
     * da universidade.
     * <br><br>
     * Aqui podem ser feitas todas as verificações sobre os documentos nos 
     * montes dos cursos e dos processos abertos na mesa do Burocrata. A partir 
     * dessas informações, você pode colocar documentos nos processos abertos
     * e despachar os processos para a secretaria acadêmica.
     * <br><br>
     * Cuidado com a complexidade do seu algoritmo, porque se ele demorar muito
     * serão criados menos documentos na sua execução e sua produtividade geral
     * vai cair.
     * <br><br>
     * Esse método será chamado a cada 50 milissegundos pelo simulador da
     * universidade.
     * <br><br>
     * <strong>O burocrata não pode manter documentos com ele</strong> depois
     * que o método trabalhar terminar de executar, ou seja, você deve devolver
     * para os montes dos cursos todos os documentos que você removeu dos montes
     * dos cursos.
     * 
     * @see professor.entidades.Universidade#despachar(Processo)
     * @see professor.entidades.Universidade#removerDocumentoDoMonteDoCurso(estudantes.entidades.Documento, professor.entidades.CodigoCurso)
     * @see professor.entidades.Universidade#devolverDocumentoParaMonteDoCurso(estudantes.entidades.Documento, professor.entidades.CodigoCurso) 
     */
    public void trabalhar(){

        //cria um vetor para guardar todos os documentos dos montes
        //utilizada IA como auxilio para entender a criação de listas em java, porém não foi utilizada no desenvolvimento da lógica
        List<Documento> gaveta = new ArrayList<>(), gradAcad = new ArrayList<>(), posGradAcad = new ArrayList<>(), gradAdm = new ArrayList<>(), posGradAdm = new ArrayList<>(), atasGrad = new ArrayList<>(), atasPosGrad = new ArrayList<>();
        //fim do código da IA

        //percorre todos os cursos

        for(CodigoCurso codigo : CodigoCurso.values()){

            //pega todos os montes dos cursos
            Documento []monte = universidade.pegarCopiaDoMonteDoCurso(codigo);

            //verifica se o monte não estava vazio
            if(monte != null){

                //pega os documentos individualmente
                for(Documento doc : monte){

                    //verifica se o documento é válido
                    if(doc != null){

                        //adiciona o documento na gaveta do burocrata
                        gaveta.add(doc);          
                    }

                }

            }
        }
        for(Documento doc : gaveta){
            // lógica para tratar cada documento na gaveta
            //não precisa verificar se é valido pois já foi verificado antes de adicionar na gaveta

            //verifica se o documento é um edital ou portaria e se é substancial
            if((doc instanceof Edital || doc instanceof Portaria) && ((Norma) doc).getPaginas() >= 100 && ((Norma) doc).isValido()){
                //verifica se o processo está vazio
                for(int i = 0; i < 5; i++){
                    Processo process = mesa.getProcesso(i);
                    if(process != null && process.contarDocumentos() == 0){
                        //adiciona o documento no processo
                        process.adicionarDocumento(doc);
                        //remove o documento do monte do curso
                        universidade.removerDocumentoDoMonteDoCurso(doc, doc.getCodigoCurso());
                        universidade.despachar(process);
                        break;
                    }      
                }
            //verifica se o documento é de pós-graduação
            }else if(doc.getCodigoCurso().equals(CodigoCurso.POS_GRADUACAO_COMPUTACAO) || doc.getCodigoCurso().equals(CodigoCurso.POS_GRADUACAO_ENGENHARIA_ELETRICA) || doc.getCodigoCurso().equals(CodigoCurso.POS_GRADUACAO_MICROELETRONICA)){
                //se for documento de pos acadêmico separa gaveta em outra partiçãa
                if(doc instanceof DocumentoAcademico){
                    posGradAcad.add(doc);
                //se for documento de pos administrativo separa gaveta em outra partição
                }else if(doc instanceof DocumentoAdministrativo){
                    posGradAdm.add(doc);
                //se não for documento de pos acadêmico ou administrativo é uma ata de pos graduação e separa gaveta em outra partição
                }else atasPosGrad.add(doc);

            //se o documento não é pos é de graduação, não precisa verificar novamente
            }else{
                //se for documento de graduação acadêmico separa gaveta em outra partição
                if(doc instanceof DocumentoAcademico){
                    gradAcad.add(doc);
                //se for documento de graduação administrativo separa gaveta em outra partição
                }else if(doc instanceof DocumentoAdministrativo){
                    gradAdm.add(doc);
                //se não for documento de graduação acadêmico ou administrativo é uma ata de graduação e separa gaveta em outra partição
                }else atasGrad.add(doc);
            }
        }

    }

    //Métodos auxiliares utilizados pra implementação do burocrata

    private int quantasPaginasRestam(Processo process) {

        int pag = 0;

        for (Documento docs : process.pegarCopiaDoProcesso()) {

            pag += docs.getPaginas();
            
        }
        return 250 - pag;
    }

    //Verifica se o processo está dentro da regra de graduação e pós-graduação
    private boolean regraGraduacaoPosGraduacao(Processo process) {

        boolean graduacao = false, posgraduacao = false;

        for (Documento docs : process.pegarCopiaDoProcesso()) {

            if (docs.getCodigoCurso().equals(CodigoCurso.POS_GRADUACAO_COMPUTACAO) || docs.getCodigoCurso().equals(CodigoCurso.POS_GRADUACAO_ENGENHARIA_ELETRICA) || docs.getCodigoCurso().equals(CodigoCurso.POS_GRADUACAO_MICROELETRONICA)) {
                posgraduacao = true;
            } else {
                graduacao = true;
            }

        }

        return !(graduacao && posgraduacao);

    }

    //Verifica se o processo está dentro da regra de documentos administrativos e acadêmicos

    private boolean regraAdministrativoAcademico(Processo process) {

        boolean administrativos = false, academicos = false;

        for (Documento docs : process.pegarCopiaDoProcesso()) {

            if (docs instanceof DocumentoAdministrativo) {
                administrativos = true;
            }
            if (docs instanceof DocumentoAcademico) {
                academicos = true;
            }

        }

        return !(administrativos && academicos);

    }

    //Verifica se o processo está dentro da regra de somente atas

    private boolean regraSomenteAtas(Processo process) {

        boolean apenasAtas = true;

        for (Documento docs : process.pegarCopiaDoProcesso()) {
            if(process.pegarCopiaDoProcesso() != null){
                if (docs instanceof DocumentoAdministrativo) {
                    apenasAtas = false;
                }
                if (docs instanceof DocumentoAcademico) {
                    apenasAtas = false;
                }
            }

        }

        return !(apenasAtas);

    }

    //Verifica se o processo está dentro da regra de documento substancial
    private boolean regraDocumentoSubstancial(Processo process) {

        boolean documentoSubstancialValido = false;
        for(Documento docs : process.pegarCopiaDoProcesso()){
            if(docs instanceof Edital || docs instanceof Portaria){
                Norma norma = (Norma) docs;
                if(norma.getPaginas() >= 100 && norma.isValido()){
                    documentoSubstancialValido = true;
                }
            }
        }
        return !(documentoSubstancialValido && process.pegarCopiaDoProcesso().length > 1);
    }

    //Verifica se o processo está dentro da regra de diplomas
    private boolean regraDiplomas(Processo process) {

        boolean diplomas = false, documentosNaoDiplomasCertificadosAtas = false;

        for (Documento docs : process.pegarCopiaDoProcesso()) {

            if (docs instanceof Diploma) {
                diplomas = true;
            }else if (!(docs instanceof Certificado) && !(docs instanceof Ata)) {
                documentosNaoDiplomasCertificadosAtas = true;
            }

        }

        return !(diplomas && documentosNaoDiplomasCertificadosAtas);

    }

    //Verifica se o processo está dentro da regra de atestados com categorias diferentes
    private boolean regraCategoriaAtestado(Processo process) {

        boolean atestadosComCategoriasMisturadas = false;
        String categoriaDoPrimeiroAtestadoEncontrado = null;

        for (Documento docs : process.pegarCopiaDoProcesso()) {
            if(docs instanceof Atestado){
                Atestado atestado = (Atestado) docs;
                if(categoriaDoPrimeiroAtestadoEncontrado == null){
                    categoriaDoPrimeiroAtestadoEncontrado = atestado.getCategoria();
                }else if(!categoriaDoPrimeiroAtestadoEncontrado.equals(atestado.getCategoria())){
                    atestadosComCategoriasMisturadas = true;
                }
            }
        }

        return !(atestadosComCategoriasMisturadas);

    }

    //verifica se o processo está dentro da regra de circulares e ofícios sem destinatário comum
    /* começo de código gerado por IA */
private boolean regraCircularesOficios(Processo process) {
    HashMap<String, Integer> destinatarios = new HashMap<>();
    int contagemDeOficiosECirculares = 0;
    Documento[] copiaDoProcesso = process.pegarCopiaDoProcesso();

    for (Documento doc : copiaDoProcesso) {
        if (doc instanceof Oficio) {
            contagemDeOficiosECirculares++;
            Oficio oficio = (Oficio) doc;
            if (destinatarios.containsKey(oficio.getDestinatario())) {
                destinatarios.put(oficio.getDestinatario(), destinatarios.get(oficio.getDestinatario()) + 1);
            } else {
                destinatarios.put(oficio.getDestinatario(), 1);
            }
        }
        if (doc instanceof Circular) {
            contagemDeOficiosECirculares++;
            Circular circular = (Circular) doc;
            for (String destinatario : circular.getDestinatarios()) {
                if (destinatarios.containsKey(destinatario)) {
                    destinatarios.put(destinatario, destinatarios.get(destinatario) + 1);
                } else {
                    destinatarios.put(destinatario, 1);
                }
            }
        }
    }

    boolean existemCircularesEOficiosSemDestinatarioComum = false;

    if (contagemDeOficiosECirculares > 0) {
        existemCircularesEOficiosSemDestinatarioComum = true;
        for (int ocorrencias : destinatarios.values()) {
            if (ocorrencias >= contagemDeOficiosECirculares) {
                existemCircularesEOficiosSemDestinatarioComum = false;
                break;
            }
        }
    }

    return !existemCircularesEOficiosSemDestinatarioComum;
}
/* fim de código gerado por IA */
    
    
    
    /**
     * Retorna o valor atual de estresse do burocrata.
     * @return estresse atual
     */
    public int getEstresse(){
        return this.estresse;
    }
    
    /**
     * Aumenta o estresse do burocrata em uma unidade.
     * 
     * <strong>VOCÊ NÃO DEVERIA INVOCAR ESSE MÉTODO!!!</strong>
     */
    public void estressar(){
        this.estresse++;
    }
    
    /**
     * Aumenta o estresse do burocrata em 10 unidades.
     * 
     * <strong>VOCÊ NÃO DEVERIA INVOCAR ESSE MÉTODO!!!</strong>
     */
    public void estressarMuito(){
        this.estresse += 10;
    }
}