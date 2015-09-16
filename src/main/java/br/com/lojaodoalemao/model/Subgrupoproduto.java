/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaodoalemao.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "subgrupoproduto")
@NamedQueries({
    @NamedQuery(name = "Subgrupoproduto.findAll", query = "SELECT s FROM Subgrupoproduto s")})
public class Subgrupoproduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsubGrupoProduto")
    private Integer idsubGrupoProduto;
    @Size(max = 50)
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "percentualComissao")
    private Double percentualComissao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subgrupoproduto")
    private List<Produto> produtoList;
    @JoinColumn(name = "grupoproduto_idgrupoProduto", referencedColumnName = "idgrupoProduto")
    @ManyToOne(optional = false)
    private Grupoproduto grupoproduto;

    public Subgrupoproduto() {
    }

    public Subgrupoproduto(Integer idsubGrupoProduto) {
        this.idsubGrupoProduto = idsubGrupoProduto;
    }

    public Integer getIdsubGrupoProduto() {
        return idsubGrupoProduto;
    }

    public void setIdsubGrupoProduto(Integer idsubGrupoProduto) {
        this.idsubGrupoProduto = idsubGrupoProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(Double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    public Grupoproduto getGrupoproduto() {
        return grupoproduto;
    }

    public void setGrupoproduto(Grupoproduto grupoproduto) {
        this.grupoproduto = grupoproduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsubGrupoProduto != null ? idsubGrupoProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subgrupoproduto)) {
            return false;
        }
        Subgrupoproduto other = (Subgrupoproduto) object;
        if ((this.idsubGrupoProduto == null && other.idsubGrupoProduto != null) || (this.idsubGrupoProduto != null && !this.idsubGrupoProduto.equals(other.idsubGrupoProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.lojaodoalemao.model.Subgrupoproduto[ idsubGrupoProduto=" + idsubGrupoProduto + " ]";
    }
    
}
