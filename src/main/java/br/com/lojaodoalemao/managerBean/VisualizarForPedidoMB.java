/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaodoalemao.managerBean;

import br.com.lojaodoalemao.model.Forpedido;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Wolverine
 */
@Named
@ViewScoped
public class VisualizarForPedidoMB implements Serializable{
    
    @Inject
    private UsuarioLogadoMB usuarioLogadoMB;
    private Forpedido forpedido;
    
    
    @PostConstruct
    public void init(){
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        forpedido = (Forpedido) session.getAttribute("forPedido");
        session.removeAttribute("forPedido");
        if (forpedido!=null){
            forpedido.setDataEmissao(new  Date());
            forpedido.setEmpresa(usuarioLogadoMB.getUsuario().getEmpresa());
            forpedido.setEntregue(false);
            forpedido.setRegistrado("Não");
        }
    }

    public UsuarioLogadoMB getUsuarioLogadoMB() {
        return usuarioLogadoMB;
    }

    public void setUsuarioLogadoMB(UsuarioLogadoMB usuarioLogadoMB) {
        this.usuarioLogadoMB = usuarioLogadoMB;
    }

    public Forpedido getForpedido() {
        return forpedido;
    }

    public void setForpedido(Forpedido forpedido) {
        this.forpedido = forpedido;
    }
    
    
    
}
