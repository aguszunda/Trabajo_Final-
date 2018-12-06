/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;


import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Agustin
 */
@Entity
@Table(name = "cobertura")
public class Cobertura implements Serializable
{
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NRO_COBERTURA")
    private Integer nro_cobertura;
    @Column(name = "N_AFILIADO")
    private String n_afiliado;
    @Column(name = "CODIGO_OOSS")
    private String codigo_ooss;
    @Column(name = "PACIENTE_ID")
    private int paciente_id;

    public int getPaciente_id() {
        return paciente_id;
    }

    public void setPaciente_id(int paciente_id) {
        this.paciente_id = paciente_id;
    }
    @Column(name = "NOMBRE")
    private String nombre;

    @Temporal(TemporalType.DATE) 
    @Column(name = "FECHA_DESDE")
    private Calendar fecha_desde;
 
    @Temporal(TemporalType.DATE) 
    @Column(name = "FECHA_HASTA")
    private Calendar fecha_hasta;

    public Integer getNro_cobertura() {
        return nro_cobertura;
    }

    public void setNro_cobertura(Integer nro_cobertura) {
        this.nro_cobertura = nro_cobertura;
    }

    public String getN_afiliado() {
        return n_afiliado;
    }

    public void setN_afiliado(String n_afiliado) {
        this.n_afiliado = n_afiliado;
    }

    public String getCodigo_ooss() {
        return codigo_ooss;
    }

    public void setCodigo_ooss(String codigo_ooss) {
        this.codigo_ooss = codigo_ooss;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Calendar getFecha_desde() {
        return fecha_desde;
    }

    public void setFecha_desde(Calendar fecha_desde) {
        this.fecha_desde = fecha_desde;
    }

    public Calendar getFecha_hasta() {
        return fecha_hasta;
    }

    public void setFecha_hasta(Calendar fecha_hasta) {
        this.fecha_hasta = fecha_hasta;
    }

      @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cobertura)) {
            return false;
        }
        Cobertura other = (Cobertura) object;
        if ((this.nro_cobertura == null && other.nro_cobertura != null) || (this.nro_cobertura != null && !this.nro_cobertura.equals(other.nro_cobertura))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Cobertura{" + "nro_cobertura=" + nro_cobertura + ", n_afiliado=" + n_afiliado + ", codigo_ooss=" + codigo_ooss + ", nombre=" + nombre + ", fecha_desde=" + fecha_desde + ", fecha_hasta=" + fecha_hasta + '}';
    }
    
    
}
