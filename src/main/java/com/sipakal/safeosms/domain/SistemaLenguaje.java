package com.sipakal.safeosms.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.util.Objects;

/**
 * A SistemaLenguaje.
 */
@Entity
@Table(name = "sistema_lenguaje")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "sistemalenguaje")
public class SistemaLenguaje implements Serializable {

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

    public SistemaLenguaje lenguajeID(String lenguajeID) {
        this.lenguajeID = lenguajeID;
        return this;
    }

    public void setLenguajeID(String lenguajeID) {
        this.lenguajeID = lenguajeID;
    }

    public String getLenguajeVal() {
        return lenguajeVal;
    }

    public SistemaLenguaje lenguajeVal(String lenguajeVal) {
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
        SistemaLenguaje sistemaLenguaje = (SistemaLenguaje) o;
        if (sistemaLenguaje.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sistemaLenguaje.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SistemaLenguaje{" +
            "id=" + getId() +
            ", lenguajeID='" + getLenguajeID() + "'" +
            ", lenguajeVal='" + getLenguajeVal() + "'" +
            "}";
    }
}
