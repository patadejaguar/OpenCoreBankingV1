package com.sipakal.safeosms.domain;

import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.util.Objects;

/**
 * Tipos de Productos en el Sistema :
 * 1 = Propios de la persona
 * 4 = Propios de Credito
 * 8 = Productos de Captacion
 */
@ApiModel(description = "Tipos de Productos en el Sistema : 1 = Propios de la persona 4 = Propios de Credito 8 = Productos de Captacion")
@Entity
@Table(name = "sistema_productos_tipos")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "sistemaproductostipos")
public class SistemaProductosTipos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Size(max = 30)
    @Column(name = "lenguaje_id", length = 30)
    private String lenguajeID;

    @Size(max = 80)
    @Column(name = "lenguaje_val", length = 80)
    private String lenguajeVal;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLenguajeID() {
        return lenguajeID;
    }

    public SistemaProductosTipos lenguajeID(String lenguajeID) {
        this.lenguajeID = lenguajeID;
        return this;
    }

    public void setLenguajeID(String lenguajeID) {
        this.lenguajeID = lenguajeID;
    }

    public String getLenguajeVal() {
        return lenguajeVal;
    }

    public SistemaProductosTipos lenguajeVal(String lenguajeVal) {
        this.lenguajeVal = lenguajeVal;
        return this;
    }

    public void setLenguajeVal(String lenguajeVal) {
        this.lenguajeVal = lenguajeVal;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SistemaProductosTipos sistemaProductosTipos = (SistemaProductosTipos) o;
        if (sistemaProductosTipos.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sistemaProductosTipos.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SistemaProductosTipos{" +
            "id=" + getId() +
            ", lenguajeID='" + getLenguajeID() + "'" +
            ", lenguajeVal='" + getLenguajeVal() + "'" +
            "}";
    }
}
