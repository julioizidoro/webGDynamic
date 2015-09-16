/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaodoalemao.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "vinculo")
@NamedQueries({
    @NamedQuery(name = "Vinculo.findAll", query = "SELECT v FROM Vinculo v")})
public class Vinculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvinculo")
    private Integer idvinculo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorCompra")
    private Float valorCompra;
    @Column(name = "dataCompra")
    @Temporal(TemporalType.DATE)
    private Date dataCompra;
    @Size(max = 20)
    @Column(name = "codigoFabricante")
    private String codigoFabricante;
    @Column(name = "embalagem")
    private Long embalagem;
    @Size(max = 3)
    @Column(name = "pedido")
    private String pedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vinculo")
    private List<Forpedproduto> forpedprodutoList;
    @JoinColumn(name = "empresa_idempresa", referencedColumnName = "idempresa")
    @ManyToOne(optional = false)
    private Empresa empresa;
    @JoinColumn(name = "fornecedor_idfornecedor", referencedColumnName = "idfornecedor")
    @ManyToOne(optional = false)
    private Fornecedor fornecedor;
    @JoinColumn(name = "produto_idProduto", referencedColumnName = "idProduto")
    @ManyToOne(optional = false)
    private Produto produto;

    public Vinculo() {
    }

    public Vinculo(Integer idvinculo) {
        this.idvinculo = idvinculo;
    }

    public Integer getIdvinculo() {
        return idvinculo;
    }

    public void setIdvinculo(Integer idvinculo) {
        this.idvinculo = idvinculo;
    }

    public Float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Float valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getCodigoFabricante() {
        return codigoFabricante;
    }

    public void setCodigoFabricante(String codigoFabricante) {
        this.codigoFabricante = codigoFabricante;
    }

    public Long getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(Long embalagem) {
        this.embalagem = embalagem;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public List<Forpedproduto> getForpedprodutoList() {
        return forpedprodutoList;
    }

    public void setForpedprodutoList(List<Forpedproduto> forpedprodutoList) {
        this.forpedprodutoList = forpedprodutoList;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvinculo != null ? idvinculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vinculo)) {
            return false;
        }
        Vinculo other = (Vinculo) object;
        if ((this.idvinculo == null && other.idvinculo != null) || (this.idvinculo != null && !this.idvinculo.equals(other.idvinculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.lojaodoalemao.model.Vinculo[ idvinculo=" + idvinculo + " ]";
    }
    
}
