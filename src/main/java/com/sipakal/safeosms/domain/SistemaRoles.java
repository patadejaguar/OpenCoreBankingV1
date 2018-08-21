package com.sipakal.safeosms.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.util.Objects;

/**
 * Reglas generales.
 * Maximo en nombres de catalogos 80
 * Maximo en tipos desconocidos 80
 * Maximo en mails 80
 * Boleanos como enteros 0/1
 * Maximo en alias de catalogo 30
 */
@ApiModel(description = "Reglas generales. Maximo en nombres de catalogos 80 Maximo en tipos desconocidos 80 Maximo en mails 80 Boleanos como enteros 0/1 Maximo en alias de catalogo 30")
@Entity
@Table(name = "sistema_roles")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "sistemaroles")
public class SistemaRoles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "rolesid")
    private Integer rolesid;

    @Column(name = "tipo_en_sistemaid")
    private Integer tipoEnSistemaid;

    /**
     * Estado Activo/Inactivo 1/0
     */
    @Max(value = 9)
    @ApiModelProperty(value = "Estado Activo/Inactivo 1/0")
    @Column(name = "estatus")
    private Integer estatus;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRolesid() {
        return rolesid;
    }

    public SistemaRoles rolesid(Integer rolesid) {
        this.rolesid = rolesid;
        return this;
    }

    public void setRolesid(Integer rolesid) {
        this.rolesid = rolesid;
    }

    public Integer getTipoEnSistemaid() {
        return tipoEnSistemaid;
    }

    public SistemaRoles tipoEnSistemaid(Integer tipoEnSistemaid) {
        this.tipoEnSistemaid = tipoEnSistemaid;
        return this;
    }

    public void setTipoEnSistemaid(Integer tipoEnSistemaid) {
        this.tipoEnSistemaid = tipoEnSistemaid;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public SistemaRoles estatus(Integer estatus) {
        this.estatus = estatus;
        return this;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
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
        SistemaRoles sistemaRoles = (SistemaRoles) o;
        if (sistemaRoles.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sistemaRoles.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SistemaRoles{" +
            "id=" + getId() +
            ", rolesid=" + getRolesid() +
            ", tipoEnSistemaid=" + getTipoEnSistemaid() +
            ", estatus=" + getEstatus() +
            "}";
    }
}
