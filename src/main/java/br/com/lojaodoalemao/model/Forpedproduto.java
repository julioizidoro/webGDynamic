/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaodoalemao.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "forpedproduto")
@NamedQueries({
    @NamedQuery(name = "Forpedproduto.findAll", query = "SELECT f FROM Forpedproduto f")})
public class Forpedproduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idForPedProduto")
    private Integer idForPedProduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade")
    private Double quantidade;
    @Column(name = "entrada")
    private Integer entrada;
    @JoinColumn(name = "forpedido_idForPedido", referencedColumnName = "idForPedido")
    @ManyToOne(optional = false)
    private Forpedido forpedido;
    @JoinColumn(name = "produto_idProduto", referencedColumnName = "idProduto")
    @ManyToOne(optional = false)
    private Produto produto;
    @JoinColumn(name = "vinculo_idvinculo", referencedColumnName = "idvinculo")
    @ManyToOne(optional = false)
    private Vinculo vinculo;

    public Forpedproduto() {
    }

    public Forpedproduto(Integer idForPedProduto) {
        this.idForPedProduto = idForPedProduto;
    }

    public Integer getIdForPedProduto() {
        return idForPedProduto;
    }

    public void setIdForPedProduto(Integer idForPedProduto) {
        this.idForPedProduto = idForPedProduto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getEntrada() {
        return entrada;
    }

    public void setEntrada(Integer entrada) {
        this.entrada = entrada;
    }

    public Forpedido getForpedido() {
        return forpedido;
    }

    public void setForpedido(Forpedido forpedido) {
        this.forpedido = forpedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Vinculo getVinculo() {
        return vinculo;
    }

    public void setVinculo(Vinculo vinculo) {
        this.vinculo = vinculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idForPedProduto != null ? idForPedProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Forpedproduto)) {
            return false;
        }
        Forpedproduto other = (Forpedproduto) object;
        if ((this.idForPedProduto == null && other.idForPedProduto != null) || (this.idForPedProduto != null && !this.idForPedProduto.equals(other.idForPedProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.lojaodoalemao.model.Forpedproduto[ idForPedProduto=" + idForPedProduto + " ]";
    }
    
}
