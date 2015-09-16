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
@Table(name = "municipios")
@NamedQueries({
    @NamedQuery(name = "Municipios.findAll", query = "SELECT m FROM Municipios m")})
public class Municipios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmunicipios")
    private Integer idmunicipios;
    @Size(max = 2)
    @Column(name = "estado")
    private String estado;
    @Size(max = 19)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 150)
    @Column(name = "nomeMunicipio")
    private String nomeMunicipio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipios")
    private List<Fornecedor> fornecedorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipios")
    private List<Empresa> empresaList;

    public Municipios() {
    }

    public Municipios(Integer idmunicipios) {
        this.idmunicipios = idmunicipios;
    }

    public Integer getIdmunicipios() {
        return idmunicipios;
    }

    public void setIdmunicipios(Integer idmunicipios) {
        this.idmunicipios = idmunicipios;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    public List<Fornecedor> getFornecedorList() {
        return fornecedorList;
    }

    public void setFornecedorList(List<Fornecedor> fornecedorList) {
        this.fornecedorList = fornecedorList;
    }

    public List<Empresa> getEmpresaList() {
        return empresaList;
    }

    public void setEmpresaList(List<Empresa> empresaList) {
        this.empresaList = empresaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmunicipios != null ? idmunicipios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipios)) {
            return false;
        }
        Municipios other = (Municipios) object;
        if ((this.idmunicipios == null && other.idmunicipios != null) || (this.idmunicipios != null && !this.idmunicipios.equals(other.idmunicipios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.lojaodoalemao.model.Municipios[ idmunicipios=" + idmunicipios + " ]";
    }
    
}
