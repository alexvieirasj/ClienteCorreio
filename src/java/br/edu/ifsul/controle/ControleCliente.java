package br.edu.ifsul.controle;

import br.edu.ifsul.servicos.Cliente;
import br.edu.ifsul.dao.ClienteDAO;
import br.edu.ifsul.testes.TestaServicoCliente;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.tempuri.CResultado;
import org.tempuri.CServico;
import org.tempuri.CalcPrecoPrazo;
import org.tempuri.CalcPrecoPrazoWS;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@Named(value = "controleCliente")
@SessionScoped
public class ControleCliente implements Serializable{

    private Cliente objeto;
    @EJB
    private ClienteDAO dao;
    String valorFrete = "";
    String prazo = "";
    String destino = "";
    String origem = "";
    private CalcPrecoPrazoWS servicoCorreio;
    private CalcPrecoPrazo salvaDados;
    
    public ControleCliente(){
         servicoCorreio = new CalcPrecoPrazoWS();
         salvaDados = new CalcPrecoPrazo();
    }
    
    public String novo(){
        objeto = new Cliente();
        salvaDados = new CalcPrecoPrazo(); 
        objeto.setId(0);
        return "form?faces-redirect=true";
    }
    
    public String alterar(Cliente obj){
        objeto = obj;
        return "form?faces-redirect=true";
    }
    
    public String salvar(){
        if (objeto.getId() == 0){
            dao.inserir(objeto);
        } else {
            dao.alterar(objeto);
        }
        return "index?faces-redirect=true";
    }    
    
    public String cancelar(){
        return "index?faces-redirect=true";
    }
    
    public void enviaFrete(){
        CResultado retorno = getServicoCorreio().getCalcPrecoPrazoWSSoap().calcPrecoPrazo(
                   "", "",salvaDados.getNCdServico(), salvaDados.getSCepOrigem(), salvaDados.getSCepDestino(), salvaDados.getNVlPeso(), 
                   salvaDados.getNCdFormato(),salvaDados.getNVlComprimento(), salvaDados.getNVlAltura(), salvaDados.getNVlLargura(), 
                   salvaDados.getNVlDiametro(), salvaDados.getSCdMaoPropria(), salvaDados.getNVlValorDeclarado(), salvaDados.getSCdAvisoRecebimento());
                      //Empresa, Senha - Não obrigatorio
                        // Serviço - 41106 - Via PAC, 40010 - Via SEDEX
        List<CServico> lista = retorno.getServicos().getCServico();
        for (CServico cs : lista) {
           valorFrete = cs.getValor();
           valorFrete = valorFrete.replaceAll(",", ".");
           Double valorDouble = Double.parseDouble(valorFrete);
           objeto.setValorFrete(valorDouble);
           
           prazo = cs.getPrazoEntrega();
           objeto.setPrazoEntrega(prazo+" dia(s)");
           
           origem = salvaDados.getSCepOrigem();
           objeto.setCepOrigem(origem);
           
           destino = salvaDados.getSCepDestino();
           objeto.setCepDestino(destino);
           
           System.out.println("Valor: R$ "+valorDouble+"\nPrazo para Entrega: "+prazo+" dia(s)");
        } 
       
    } 
    
    public void remover(Integer id){
        dao.remover(id);
    }

    public Cliente getObjeto() {
        return objeto;
    }

    public void setObjeto(Cliente objeto) {
        this.objeto = objeto;
    }

    public ClienteDAO getDao() {
        return dao;
    }

    public void setDao(ClienteDAO dao) {
        this.dao = dao;
    }

    public CalcPrecoPrazoWS getServicoCorreio() {
        return servicoCorreio;
    }

    public void setServicoCorreio(CalcPrecoPrazoWS servicoCorreio) {
        this.servicoCorreio = servicoCorreio;
    }

    public CalcPrecoPrazo getSalvaDados() {
        return salvaDados;
    }

    public void setSalvaDados(CalcPrecoPrazo salvaDados) {
        this.salvaDados = salvaDados;
    }
}
