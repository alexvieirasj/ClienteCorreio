package br.edu.ifsul.converter;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@FacesConverter(value = "converterNascimento")
public class ConverterNascimento implements Converter {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            GregorianCalendar gdata = new GregorianCalendar();
            gdata.setTime(sdf.parse(value));
            XMLGregorianCalendar nascimento = 
                    DatatypeFactory.newInstance().newXMLGregorianCalendar(gdata);
            return nascimento;
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        XMLGregorianCalendar nascimento = (XMLGregorianCalendar) value;
        GregorianCalendar gdata = new GregorianCalendar(nascimento.getYear(),
                nascimento.getMonth(), nascimento.getDay());
        return sdf.format(gdata.getTime());
    }

}
