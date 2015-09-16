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
@Table(name = "forpedido")
@NamedQueries({
    @NamedQuery(name = "Forpedido.findAll", query = "SELECT f FROM Forpedido f")})
public class Forpedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idForPedido")
    private Integer idForPedido;
    @Column(name = "dataEmissao")
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;
    @Column(name = "dataEntrega")
    @Temporal(TemporalType.DATE)
    private Date dataEntrega;
    @Size(max = 50)
    @Column(name = "condicaoPagamento")
    private String condicaoPagamento;
    @Column(name = "entregue")
    private Boolean entregue;
    @Size(max = 3)
    @Column(name = "registrado")
    private String registrado;
    @Column(name = "dataRegistro")
    @Temporal(TemporalType.DATE)
    private Date dataRegistro;
    @JoinColumn(name = "empresa_idempresa", referencedColumnName = "idempresa")
    @ManyToOne(optional = false)
    private Empresa empresa;
    @JoinColumn(name = "fornecedor_idfornecedor1", referencedColumnName = "idfornecedor")
    @ManyToOne(optional = false)
    private Fornecedor fornecedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "forpedido")
    private List<Forpedproduto> forpedprodutoList;

    public Forpedido() {
    }

    public Forpedido(Integer idForPedido) {
        this.idForPedido = idForPedido;
    }

    public Integer getIdForPedido() {
        return idForPedido;
    }

    public void setIdForPedido(Integer idForPedido) {
        this.idForPedido = idForPedido;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getCondicaoPagamento() {
        return condicaoPagamento;
    }

    public void setCondicaoPagamento(String condicaoPagamento) {
        this.condicaoPagamento = condicaoPagamento;
    }

    public Boolean getEntregue() {
        return entregue;
    }

    public void setEntregue(Boolean entregue) {
        this.entregue = entregue;
    }

    public String getRegistrado() {
        return registrado;
    }

    public void setRegistrado(String registrado) {
        this.registrado = registrado;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
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

    public List<Forpedproduto> getForpedprodutoList() {
        return forpedprodutoList;
    }

    public void setForpedprodutoList(List<Forpedproduto> forpedprodutoList) {
        this.forpedprodutoList = forpedprodutoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idForPedido != null ? idForPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Forpedido)) {
            return false;
        }
        Forpedido other = (Forpedido) object;
        if ((this.idForPedido == null && other.idForPedido != null) || (this.idForPedido != null && !this.idForPedido.equals(other.idForPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.lojaodoalemao.model.Forpedido[ idForPedido=" + idForPedido + " ]";
    }
    
}
