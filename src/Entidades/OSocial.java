/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Agustin
 */
@Entity
@Table(name = "o_social")
@NamedQueries({
    @NamedQuery(name = "OSocial.findAll", query = "SELECT o FROM OSocial o")})
public class OSocial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO_OOSS")
    private Integer codigoOoss;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "DOMICILIO")
    private String domicilio;
    @Column(name = "LOCALIDAD")
    private String localidad;
    @Column(name = "DEPARTAMENTO")
    private String departamento;
    @Column(name = "PAIS")
    private String pais;
    @Column(name = "TIPO")
    private String tipo;

    public OSocial() {
    }

    public OSocial(Integer codigoOoss) {
        this.codigoOoss = codigoOoss;
    }

    public Integer getCodigoOoss() {
        return codigoOoss;
    }

    public void setCodigoOoss(Integer codigoOoss) {
        this.codigoOoss = codigoOoss;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoOoss != null ? codigoOoss.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OSocial)) {
            return false;
        }
        OSocial other = (OSocial) object;
        if ((this.codigoOoss == null && other.codigoOoss != null) || (this.codigoOoss != null && !this.codigoOoss.equals(other.codigoOoss))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.OSocial[ codigoOoss=" + codigoOoss + " ]";
    }
    
}
