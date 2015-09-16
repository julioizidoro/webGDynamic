/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaodoalemao.managerBean;

import br.com.lojaodoalemao.facade.ForPedidoFacade;
import br.com.lojaodoalemao.facade.FornecedorFacade;
import br.com.lojaodoalemao.model.Fornecedor;
import br.com.lojaodoalemao.model.Forpedido;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Wolverine
 */
@Named
@ViewScoped
public class ConsForPedidoMB  implements Serializable{
    
    @Inject 
    private UsuarioLogadoMB usuarioLogadoMB;
    private List<Fornecedor> listaFornecedor;
    private Date dataInical;
    private Date dataFinal;
    private boolean pedidoFinalizado;
    private Fornecedor fornecedor;
    private List<Forpedido> listaPedidos;
    private Forpedido forPedido;

    @PostConstruct
    public void init() {
        FornecedorFacade fornecedorFacade = new FornecedorFacade();
        listaFornecedor = fornecedorFacade.consultarFornecedor();
        if (listaFornecedor==null){
            this.listaFornecedor = new ArrayList<Fornecedor>();
        }
        forPedido = new Forpedido();
        fornecedor = new Fornecedor();
        getUsuarioLogadoMB();
        carregarListaForPedido(null);
    }
    
    public List<Fornecedor> getListaFornecedor() {
        return listaFornecedor;
    }

    public void setListaFornecedor(List<Fornecedor> listaFornecedor) {
        this.listaFornecedor = listaFornecedor;
    }

    public Date getDataInical() {
        return dataInical;
    }

    public void setDataInical(Date dataInical) {
        this.dataInical = dataInical;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

   

   

    public boolean isPedidoFinalizado() {
        return pedidoFinalizado;
    }

    public void setPedidoFinalizado(boolean pedidoFinalizado) {
        this.pedidoFinalizado = pedidoFinalizado;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<Forpedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<Forpedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public Forpedido getForPedido() {
        return forPedido;
    }

    public void setForPedido(Forpedido forPedido) {
        this.forPedido = forPedido;
    }

    public UsuarioLogadoMB getUsuarioLogadoMB() {
        return usuarioLogadoMB;
    }

    public void setUsuarioLogadoMB(UsuarioLogadoMB usuarioLogadoMB) {
        this.usuarioLogadoMB = usuarioLogadoMB;
    }
    
    public void carregarListaForPedido(String sql){
        if (sql==null){
            sql = "SELECT f FROM Forpedido f where f.registrado<>'SIM' and f.empresa.idempresa=" + usuarioLogadoMB.getUsuario().getEmpresa().getIdempresa()  + " order by f.idForPedido";
        }
        ForPedidoFacade forPedidoFacade = new ForPedidoFacade();
        listaPedidos = forPedidoFacade.consultarForPedido(sql);
        if (listaPedidos==null){
            listaPedidos = new ArrayList<Forpedido>();
        }
    }
    
    
}
