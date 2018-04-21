package br.edu.ifsul.dao;

import br.edu.ifsul.servicos.Cliente;
import br.edu.ifsul.servicos.ServicoClienteService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import org.tempuri.CalcPrecoPrazo;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@Stateless
public class ClienteDAO implements Serializable {
    
    private ServicoClienteService cliente;
    CalcPrecoPrazo calcularPrecoPrazo;
    
    
    public ClienteDAO(){
        cliente = new ServicoClienteService();
    }
    
    public List<Cliente> getListaPessoas(){
        return cliente.getServicoClientePort().listaPessoas();
    }
    
    public void inserir(Cliente obj){
        cliente.getServicoClientePort().inserir(obj);
    }
    
    public void alterar(Cliente obj){
        cliente.getServicoClientePort().alterar(obj);
    }    
    
    public void remover(Integer id){
        cliente.getServicoClientePort().remover(id);
    }

    public ServicoClienteService getCliente() {
        return cliente;
    }

    public void setCliente(ServicoClienteService cliente) {
        this.cliente = cliente;
    }
}
