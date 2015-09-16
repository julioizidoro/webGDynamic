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
@Table(name = "produto")
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p")})
public class Produto implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private List<Estoque> estoqueList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProduto")
    private Integer idProduto;
    @Size(max = 100)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 5)
    @Column(name = "unidade")
    private String unidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ipi")
    private Double ipi;
    @Column(name = "mva")
    private Double mva;
    @Size(max = 10)
    @Column(name = "ncm")
    private String ncm;
    @Size(max = 30)
    @Column(name = "situacao")
    private String situacao;
    @Column(name = "referencia")
    private Integer referencia;
    @Size(max = 17)
    @Column(name = "codigoBarras")
    private String codigoBarras;
    @Column(name = "dataPedido")
    @Temporal(TemporalType.DATE)
    private Date dataPedido;
    @Column(name = "codigoNovo")
    private Integer codigoNovo;
    @Column(name = "precoFixo")
    private Integer precoFixo;
    @Column(name = "sincronizado")
    private Integer sincronizado;
    @Column(name = "percentualComissao")
    private Double percentualComissao;
    @Column(name = "codgioJurere")
    private Integer codgioJurere;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private List<Forpedproduto> forpedprodutoList;
    @JoinColumn(name = "aliquota_idaliquota", referencedColumnName = "idaliquota")
    @ManyToOne(optional = false)
    private Aliquota aliquota;
    @JoinColumn(name = "subgrupoproduto_idsubGrupoProduto", referencedColumnName = "idsubGrupoProduto")
    @ManyToOne(optional = false)
    private Subgrupoproduto subgrupoproduto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private List<Vinculo> vinculoList;

    public Produto() {
    }

    public Produto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Double getIpi() {
        return ipi;
    }

    public void setIpi(Double ipi) {
        this.ipi = ipi;
    }

    public Double getMva() {
        return mva;
    }

    public void setMva(Double mva) {
        this.mva = mva;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Integer getReferencia() {
        return referencia;
    }

    public void setReferencia(Integer referencia) {
        this.referencia = referencia;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Integer getCodigoNovo() {
        return codigoNovo;
    }

    public void setCodigoNovo(Integer codigoNovo) {
        this.codigoNovo = codigoNovo;
    }

    public Integer getPrecoFixo() {
        return precoFixo;
    }

    public void setPrecoFixo(Integer precoFixo) {
        this.precoFixo = precoFixo;
    }

    public Integer getSincronizado() {
        return sincronizado;
    }

    public void setSincronizado(Integer sincronizado) {
        this.sincronizado = sincronizado;
    }

    public Double getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(Double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    public Integer getCodgioJurere() {
        return codgioJurere;
    }

    public void setCodgioJurere(Integer codgioJurere) {
        this.codgioJurere = codgioJurere;
    }

    public List<Forpedproduto> getForpedprodutoList() {
        return forpedprodutoList;
    }

    public void setForpedprodutoList(List<Forpedproduto> forpedprodutoList) {
        this.forpedprodutoList = forpedprodutoList;
    }

    public Aliquota getAliquota() {
        return aliquota;
    }

    public void setAliquota(Aliquota aliquota) {
        this.aliquota = aliquota;
    }

    public Subgrupoproduto getSubgrupoproduto() {
        return subgrupoproduto;
    }

    public void setSubgrupoproduto(Subgrupoproduto subgrupoproduto) {
        this.subgrupoproduto = subgrupoproduto;
    }

    public List<Vinculo> getVinculoList() {
        return vinculoList;
    }

    public void setVinculoList(List<Vinculo> vinculoList) {
        this.vinculoList = vinculoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.lojaodoalemao.model.Produto[ idProduto=" + idProduto + " ]";
    }

    public List<Estoque> getEstoqueList() {
        return estoqueList;
    }

    public void setEstoqueList(List<Estoque> estoqueList) {
        this.estoqueList = estoqueList;
    }
    
}
