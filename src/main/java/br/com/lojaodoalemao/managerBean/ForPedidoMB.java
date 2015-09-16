/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaodoalemao.managerBean;

import br.com.lojaodoalemao.Bean.ForProdutoBean;
import br.com.lojaodoalemao.facade.FornecedorFacade;
import br.com.lojaodoalemao.model.Fornecedor;
import br.com.lojaodoalemao.model.Forpedido;
import br.com.lojaodoalemao.model.Produto;
import br.com.lojaodoalemao.model.Vinculo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
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
public class ForPedidoMB implements Serializable{
    
    @Inject
    private UsuarioLogadoMB usuarioLogadoMB;
    private Forpedido forpedido;
    private List<ForProdutoBean> listaForProdutoBean;
    private ForProdutoBean forProdutoBean;
    private List<Fornecedor> listaFornecedor;
    private Produto produto;
   
    
    
    @PostConstruct
    public void init(){
        forpedido = new Forpedido();
        FornecedorFacade fornecedorFacade = new FornecedorFacade();
        listaFornecedor = fornecedorFacade.consultarFornecedor();
        if (listaFornecedor==null){
            this.listaFornecedor = new ArrayList<Fornecedor>();
        }
    }

    public Forpedido getForpedido() {
        return forpedido;
    }

    public void setForpedido(Forpedido forpedido) {
        this.forpedido = forpedido;
    }

    public List<ForProdutoBean> getListaForProdutoBean() {
        return listaForProdutoBean;
    }

    public void setListaForProdutoBean(List<ForProdutoBean> listaForProdutoBean) {
        this.listaForProdutoBean = listaForProdutoBean;
    }

    public ForProdutoBean getForProdutoBean() {
        return forProdutoBean;
    }

    public void setForProdutoBean(ForProdutoBean forProdutoBean) {
        this.forProdutoBean = forProdutoBean;
    }

    public UsuarioLogadoMB getUsuarioLogadoMB() {
        return usuarioLogadoMB;
    }

    public void setUsuarioLogadoMB(UsuarioLogadoMB usuarioLogadoMB) {
        this.usuarioLogadoMB = usuarioLogadoMB;
    }

    public List<Fornecedor> getListaFornecedor() {
        return listaFornecedor;
    }

    public void setListaFornecedor(List<Fornecedor> listaFornecedor) {
        this.listaFornecedor = listaFornecedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
    
    public void carregarListaProdutos() {
        if (forpedido.getFornecedor() != null) {
            List<Vinculo> listaVinculo = forpedido.getFornecedor().getVinculoList();
            listaForProdutoBean = new ArrayList<ForProdutoBean>();
            for (int i = 0; i < listaVinculo.size(); i++) {
                ForProdutoBean p = new ForProdutoBean();
                p.setVinculo(listaVinculo.get(i));
                p.setEstouqe(listaVinculo.get(i).getProduto().getEstoqueList().get(0));
                p.setPedido("Não");
                p.setQuantidadepedido(0.0);
                if (p.getEstouqe().getDataPrevisao()!=null){
                    p.setDataChegada(p.getEstouqe().getDataPrevisao());
                }
                listaForProdutoBean.add(p);
            }
        }
    }
    
    public String verificarST(Produto produto){
        if (produto!=null){
            if (produto.getAliquota().getDescricao().equalsIgnoreCase("ST")){
                return "SIM";
            }else return "NÃO";
        }
        return "NÃO";
    }
    
    public Float verificarValorCusto(Produto produto){
        Float valor = 0.0f;
        if (produto!=null){    
            valor = produto.getEstoqueList().get(0).getValorCusto().floatValue();
        }
        return valor;
    }
    
    public void onCellEdit(CellEditEvent event) {
        if (event!=null){
            System.out.println("!NULL");
        }else System.out.println("NULL");
    }

}
