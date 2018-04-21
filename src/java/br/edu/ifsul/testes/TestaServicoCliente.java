package br.edu.ifsul.testes;

import br.edu.ifsul.servicos.Cliente;
import br.edu.ifsul.servicos.ServicoClienteService;
import javax.xml.datatype.DatatypeConfigurationException;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class TestaServicoCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DatatypeConfigurationException {
        ServicoClienteService cliente = new ServicoClienteService();
        Cliente p = new Cliente();
        p.setId(0);
        p.setNome("Alex");
        p.setEndereco("Rua Portugal");
        p.setValorCompra(850.0);
        p.setCepOrigem("99450-000");
        p.setCepDestino("9175-190");
        p.setValorFrete(37.50);
        p.setPrazoEntrega("18 dias");
        cliente.getServicoClientePort().inserir(p);
    }

}
