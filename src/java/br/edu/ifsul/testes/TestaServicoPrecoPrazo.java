package br.edu.ifsul.testes;

import java.math.BigDecimal;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.tempuri.CResultado;
import org.tempuri.CServico;
import org.tempuri.CalcPrecoPrazo;
import org.tempuri.CalcPrecoPrazoWS;
import org.tempuri.CalcPrecoPrazoWSSoap;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class TestaServicoPrecoPrazo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DatatypeConfigurationException {
        CalcPrecoPrazoWSSoap calcular = new CalcPrecoPrazoWS().getCalcPrecoPrazoWSSoap();
        BigDecimal b = new BigDecimal(22);
        BigDecimal c = new BigDecimal(4);
        BigDecimal d = new BigDecimal(25);
        BigDecimal e = new BigDecimal(30);
        BigDecimal f = new BigDecimal(0);
        CResultado retorno = calcular.calcPrecoPrazo("", "", "40010", "90010340", "99450000", "2.2", 1, b, c, d, e, "N", f, "N");   
        
        List<CServico> lista = retorno.getServicos().getCServico();
        for (CServico cs : lista) {
            System.out.println("Valor: R$ "+cs.getValor()+"\nPrazo para Entrega: "+cs.getPrazoEntrega() + " dia(s)");
        } 
        
        
        //Testando chamada dos metodos
        //CalcPrecoPrazoWS calc = new CalcPrecoPrazoWS();
        //calc.getCalcPrecoPrazoWSSoap().calcPrazo("40010", "90010340", "99450000");
        
        

         // 41106 - Via PAC
        // 40010 - Via SEDEX
        
              /*  <s:element minOccurs="0" maxOccurs="1" name="nCdEmpresa" type="s:string"/>
                <s:element minOccurs="0" maxOccurs="1" name="sDsSenha" type="s:string"/>
                <s:element minOccurs="0" maxOccurs="1" name="nCdServico" type="s:string"/>
                <s:element minOccurs="0" maxOccurs="1" name="sCepOrigem" type="s:string"/>
                <s:element minOccurs="0" maxOccurs="1" name="sCepDestino" type="s:string"/>
                <s:element minOccurs="0" maxOccurs="1" name="nVlPeso" type="s:string"/>
                <s:element minOccurs="1" maxOccurs="1" name="nCdFormato" type="s:int"/>
                <s:element minOccurs="1" maxOccurs="1" name="nVlComprimento" type="s:decimal"/>
                <s:element minOccurs="1" maxOccurs="1" name="nVlAltura" type="s:decimal"/>
                <s:element minOccurs="1" maxOccurs="1" name="nVlLargura" type="s:decimal"/>
                <s:element minOccurs="1" maxOccurs="1" name="nVlDiametro" type="s:decimal"/>
                <s:element minOccurs="0" maxOccurs="1" name="sCdMaoPropria" type="s:string"/>
                <s:element minOccurs="1" maxOccurs="1" name="nVlValorDeclarado" type="s:decimal"/>
                <s:element minOccurs="0" maxOccurs="1" name="sCdAvisoRecebimento" type="s:string"/>
                <s:element minOccurs="0" maxOccurs="1" name="sDtCalculo" type="s:string"/> */
       
    }

}
