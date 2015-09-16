package br.com.lojaodoalemao.managerBean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class MenuMB implements Serializable{
    
    
    public String paginaInicial(){
        return "paginainicial";
    }
    
    public String pedidosCompra(){
        return "pedidoscompra";
    }
    
    
    
}
