/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaodoalemao.converter;

import br.com.lojaodoalemao.model.Fornecedor;
import java.util.Iterator;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Wolverine
 */
@FacesConverter(value="fornecedorConverter")
public class FornecedorConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        List<Fornecedor> fornecedor = (List<Fornecedor>) component.getAttributes().get("listaFornecedor");
        for (Iterator<Fornecedor> iterator = fornecedor.iterator(); iterator.hasNext();) {
            Fornecedor f = (Fornecedor) iterator.next();
            if (f.getNomeFantasia().equals(value)) {
                return f;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Fornecedor){
            Fornecedor fornecedor = (Fornecedor) value;
            return fornecedor.getNomeFantasia();
        }else return "";
    }
    
}
