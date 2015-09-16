/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaodoalemao.managerBean;

import br.com.lojaodoalemao.facade.UsuariosFacade;
import br.com.lojaodoalemao.model.Usuarios;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Wolverine
 */
@Named
@SessionScoped
public class UsuarioLogadoMB implements Serializable{
    
    private Usuarios usuario;

    public UsuarioLogadoMB() {
        usuario = new Usuarios();
    }
    
    

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
    
    public String validarLogin(){
        if (usuario!=null){
            usuario = new Usuarios();
            UsuariosFacade usuariosFacade = new UsuariosFacade();
            usuario = usuariosFacade.consultarUsuario(1);
            return "paginainicial";
        }
        return "";
    }
    
    
    public String pedidosFornecedor(){
        return "pedidosfornecedor";
    }
    
}
