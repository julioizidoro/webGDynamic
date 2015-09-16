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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "empresa")
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")})
public class Empresa implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    private List<Estoque> estoqueList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private Integer idempresa;
    @Size(max = 100)
    @Column(name = "razaoSocial")
    private String razaoSocial;
    @Size(max = 100)
    @Column(name = "nomeFantasia")
    private String nomeFantasia;
    @Size(max = 10)
    @Column(name = "tipoLogradouro")
    private String tipoLogradouro;
    @Size(max = 100)
    @Column(name = "logradouro")
    private String logradouro;
    @Size(max = 10)
    @Column(name = "numero")
    private String numero;
    @Size(max = 50)
    @Column(name = "complemento")
    private String complemento;
    @Size(max = 50)
    @Column(name = "bairro")
    private String bairro;
    @Size(max = 50)
    @Column(name = "cidade")
    private String cidade;
    @Size(max = 9)
    @Column(name = "cep")
    private String cep;
    @Size(max = 2)
    @Column(name = "uf")
    private String uf;
    @Size(max = 13)
    @Column(name = "foneComercial")
    private String foneComercial;
    @Size(max = 13)
    @Column(name = "foneFax")
    private String foneFax;
    @Size(max = 100)
    @Column(name = "emailnfe")
    private String emailnfe;
    @Size(max = 100)
    @Column(name = "emailcompras")
    private String emailcompras;
    @Size(max = 18)
    @Column(name = "cnpj")
    private String cnpj;
    @Size(max = 30)
    @Column(name = "inscricaoEstadual")
    private String inscricaoEstadual;
    @Column(name = "idparametros")
    private Integer idparametros;
    @Column(name = "importacao")
    private Integer importacao;
    @Size(max = 45)
    @Column(name = "inscricaoMunicipal")
    private String inscricaoMunicipal;
    @Size(max = 7)
    @Column(name = "cnae")
    private String cnae;
    @Size(max = 1)
    @Column(name = "crt")
    private String crt;
    @Column(name = "numeroNFe")
    private Integer numeroNFe;
    @Column(name = "serieNFe")
    private Integer serieNFe;
    @Size(max = 100)
    @Column(name = "logocaminho")
    private String logocaminho;
    @Size(max = 6)
    @Column(name = "timeZona")
    private String timeZona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    private List<Forpedido> forpedidoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    private List<Vinculo> vinculoList;
    @JoinColumn(name = "municipios_idmunicipios", referencedColumnName = "idmunicipios")
    @ManyToOne(optional = false)
    private Municipios municipios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    private List<Usuarios> usuariosList;

    public Empresa() {
    }

    public Empresa(Integer idempresa) {
        this.idempresa = idempresa;
    }

    public Integer getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Integer idempresa) {
        this.idempresa = idempresa;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getFoneComercial() {
        return foneComercial;
    }

    public void setFoneComercial(String foneComercial) {
        this.foneComercial = foneComercial;
    }

    public String getFoneFax() {
        return foneFax;
    }

    public void setFoneFax(String foneFax) {
        this.foneFax = foneFax;
    }

    public String getEmailnfe() {
        return emailnfe;
    }

    public void setEmailnfe(String emailnfe) {
        this.emailnfe = emailnfe;
    }

    public String getEmailcompras() {
        return emailcompras;
    }

    public void setEmailcompras(String emailcompras) {
        this.emailcompras = emailcompras;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public Integer getIdparametros() {
        return idparametros;
    }

    public void setIdparametros(Integer idparametros) {
        this.idparametros = idparametros;
    }

    public Integer getImportacao() {
        return importacao;
    }

    public void setImportacao(Integer importacao) {
        this.importacao = importacao;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getCnae() {
        return cnae;
    }

    public void setCnae(String cnae) {
        this.cnae = cnae;
    }

    public String getCrt() {
        return crt;
    }

    public void setCrt(String crt) {
        this.crt = crt;
    }

    public Integer getNumeroNFe() {
        return numeroNFe;
    }

    public void setNumeroNFe(Integer numeroNFe) {
        this.numeroNFe = numeroNFe;
    }

    public Integer getSerieNFe() {
        return serieNFe;
    }

    public void setSerieNFe(Integer serieNFe) {
        this.serieNFe = serieNFe;
    }

    public String getLogocaminho() {
        return logocaminho;
    }

    public void setLogocaminho(String logocaminho) {
        this.logocaminho = logocaminho;
    }

    public String getTimeZona() {
        return timeZona;
    }

    public void setTimeZona(String timeZona) {
        this.timeZona = timeZona;
    }

    public List<Forpedido> getForpedidoList() {
        return forpedidoList;
    }

    public void setForpedidoList(List<Forpedido> forpedidoList) {
        this.forpedidoList = forpedidoList;
    }

    public List<Vinculo> getVinculoList() {
        return vinculoList;
    }

    public void setVinculoList(List<Vinculo> vinculoList) {
        this.vinculoList = vinculoList;
    }

    public Municipios getMunicipios() {
        return municipios;
    }

    public void setMunicipios(Municipios municipios) {
        this.municipios = municipios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idempresa != null ? idempresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idempresa == null && other.idempresa != null) || (this.idempresa != null && !this.idempresa.equals(other.idempresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.lojaodoalemao.model.Empresa[ idempresa=" + idempresa + " ]";
    }

    public List<Estoque> getEstoqueList() {
        return estoqueList;
    }

    public void setEstoqueList(List<Estoque> estoqueList) {
        this.estoqueList = estoqueList;
    }

    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }
    
}
