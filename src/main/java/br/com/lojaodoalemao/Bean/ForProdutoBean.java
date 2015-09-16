/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaodoalemao.Bean;

import br.com.lojaodoalemao.model.Estoque;
import br.com.lojaodoalemao.model.Vinculo;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Wolverine
 */
public class ForProdutoBean implements Serializable {
    
    private Estoque estouqe;
    private Vinculo Vinculo;
    private Date dataChegada;
    private String pedido;
    private Double quantidadepedido;

    public ForProdutoBean() {
    }

    public Estoque getEstouqe() {
        return estouqe;
    }

    public void setEstouqe(Estoque estouqe) {
        this.estouqe = estouqe;
    }

    public Vinculo getVinculo() {
        return Vinculo;
    }

    public void setVinculo(Vinculo Vinculo) {
        this.Vinculo = Vinculo;
    }

    public Date getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public Double getQuantidadepedido() {
        return quantidadepedido;
    }

    public void setQuantidadepedido(Double quantidadepedido) {
        this.quantidadepedido = quantidadepedido;
    }

    
    
}
