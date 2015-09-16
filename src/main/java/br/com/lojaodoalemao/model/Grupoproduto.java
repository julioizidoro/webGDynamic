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
@Table(name = "grupoproduto")
@NamedQueries({
    @NamedQuery(name = "Grupoproduto.findAll", query = "SELECT g FROM Grupoproduto g")})
public class Grupoproduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgrupoProduto")
    private Integer idgrupoProduto;
    @Size(max = 50)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoproduto")
    private List<Subgrupoproduto> subgrupoprodutoList;

    public Grupoproduto() {
    }

    public Grupoproduto(Integer idgrupoProduto) {
        this.idgrupoProduto = idgrupoProduto;
    }

    public Integer getIdgrupoProduto() {
        return idgrupoProduto;
    }

    public void setIdgrupoProduto(Integer idgrupoProduto) {
        this.idgrupoProduto = idgrupoProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Subgrupoproduto> getSubgrupoprodutoList() {
        return subgrupoprodutoList;
    }

    public void setSubgrupoprodutoList(List<Subgrupoproduto> subgrupoprodutoList) {
        this.subgrupoprodutoList = subgrupoprodutoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgrupoProduto != null ? idgrupoProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupoproduto)) {
            return false;
        }
        Grupoproduto other = (Grupoproduto) object;
        if ((this.idgrupoProduto == null && other.idgrupoProduto != null) || (this.idgrupoProduto != null && !this.idgrupoProduto.equals(other.idgrupoProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.lojaodoalemao.model.Grupoproduto[ idgrupoProduto=" + idgrupoProduto + " ]";
    }
    
}
