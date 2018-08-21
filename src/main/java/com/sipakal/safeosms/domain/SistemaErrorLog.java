package com.sipakal.safeosms.domain;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.util.Objects;

/**
 * A SistemaErrorLog.
 */
@Entity
@Table(name = "sistema_error_log")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "sistemaerrorlog")
public class SistemaErrorLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    /**
     * hash : Usuario de Origen
     */
    @Size(max = 30)
    @ApiModelProperty(value = "hash : Usuario de Origen")
    @Column(name = "uuidorigen", length = 30)
    private String uuidorigen;

    @Lob
    @Column(name = "error_log_text")
    private byte[] errorLogText;

    @Column(name = "error_log_text_content_type")
    private String errorLogTextContentType;

    @Column(name = "entidadid")
    private Integer entidadid;

    @Max(value = 999999999L)
    @Column(name = "personasid")
    private Long personasid;

    @Max(value = 999999999L)
    @Column(name = "contratosid")
    private Long contratosid;

    @Max(value = 999999999L)
    @Column(name = "recibosid")
    private Long recibosid;

    @Size(max = 20)
    @Column(name = "iplocal", length = 20)
    private String iplocal;

    @Size(max = 20)
    @Column(name = "ipproxy", length = 20)
    private String ipproxy;

    @Size(max = 20)
    @Column(name = "ippublic", length = 20)
    private String ippublic;

    /**
     * Usuario identificado de origen
     */
    @Max(value = 9999)
    @ApiModelProperty(value = "Usuario identificado de origen")
    @Column(name = "usuariosid")
    private Integer usuariosid;

    /**
     * Tiempo de Registro
     */
    @Max(value = 999999999L)
    @ApiModelProperty(value = "Tiempo de Registro")
    @Column(name = "tiempo")
    private Long tiempo;

    /**
     * Estado Activo/Inactivo 1/0
     */
    @Max(value = 9)
    @ApiModelProperty(value = "Estado Activo/Inactivo 1/0")
    @Column(name = "estatus")
    private Integer estatus;

    @ManyToOne
    private SistemaErrorTipos errorTiposid;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuidorigen() {
        return uuidorigen;
    }

    public SistemaErrorLog uuidorigen(String uuidorigen) {
        this.uuidorigen = uuidorigen;
        return this;
    }

    public void setUuidorigen(String uuidorigen) {
        this.uuidorigen = uuidorigen;
    }

    public byte[] getErrorLogText() {
        return errorLogText;
    }

    public SistemaErrorLog errorLogText(byte[] errorLogText) {
        this.errorLogText = errorLogText;
        return this;
    }

    public void setErrorLogText(byte[] errorLogText) {
        this.errorLogText = errorLogText;
    }

    public String getErrorLogTextContentType() {
        return errorLogTextContentType;
    }

    public SistemaErrorLog errorLogTextContentType(String errorLogTextContentType) {
        this.errorLogTextContentType = errorLogTextContentType;
        return this;
    }

    public void setErrorLogTextContentType(String errorLogTextContentType) {
        this.errorLogTextContentType = errorLogTextContentType;
    }

    public Integer getEntidadid() {
        return entidadid;
    }

    public SistemaErrorLog entidadid(Integer entidadid) {
        this.entidadid = entidadid;
        return this;
    }

    public void setEntidadid(Integer entidadid) {
        this.entidadid = entidadid;
    }

    public Long getPersonasid() {
        return personasid;
    }

    public SistemaErrorLog personasid(Long personasid) {
        this.personasid = personasid;
        return this;
    }

    public void setPersonasid(Long personasid) {
        this.personasid = personasid;
    }

    public Long getContratosid() {
        return contratosid;
    }

    public SistemaErrorLog contratosid(Long contratosid) {
        this.contratosid = contratosid;
        return this;
    }

    public void setContratosid(Long contratosid) {
        this.contratosid = contratosid;
    }

    public Long getRecibosid() {
        return recibosid;
    }

    public SistemaErrorLog recibosid(Long recibosid) {
        this.recibosid = recibosid;
        return this;
    }

    public void setRecibosid(Long recibosid) {
        this.recibosid = recibosid;
    }

    public String getIplocal() {
        return iplocal;
    }

    public SistemaErrorLog iplocal(String iplocal) {
        this.iplocal = iplocal;
        return this;
    }

    public void setIplocal(String iplocal) {
        this.iplocal = iplocal;
    }

    public String getIpproxy() {
        return ipproxy;
    }

    public SistemaErrorLog ipproxy(String ipproxy) {
        this.ipproxy = ipproxy;
        return this;
    }

    public void setIpproxy(String ipproxy) {
        this.ipproxy = ipproxy;
    }

    public String getIppublic() {
        return ippublic;
    }

    public SistemaErrorLog ippublic(String ippublic) {
        this.ippublic = ippublic;
        return this;
    }

    public void setIppublic(String ippublic) {
        this.ippublic = ippublic;
    }

    public Integer getUsuariosid() {
        return usuariosid;
    }

    public SistemaErrorLog usuariosid(Integer usuariosid) {
        this.usuariosid = usuariosid;
        return this;
    }

    public void setUsuariosid(Integer usuariosid) {
        this.usuariosid = usuariosid;
    }

    public Long getTiempo() {
        return tiempo;
    }

    public SistemaErrorLog tiempo(Long tiempo) {
        this.tiempo = tiempo;
        return this;
    }

    public void setTiempo(Long tiempo) {
        this.tiempo = tiempo;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public SistemaErrorLog estatus(Integer estatus) {
        this.estatus = estatus;
        return this;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    public SistemaErrorTipos getErrorTiposid() {
        return errorTiposid;
    }

    public SistemaErrorLog errorTiposid(SistemaErrorTipos sistemaErrorTipos) {
        this.errorTiposid = sistemaErrorTipos;
        return this;
    }

    public void setErrorTiposid(SistemaErrorTipos sistemaErrorTipos) {
        this.errorTiposid = sistemaErrorTipos;
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
        SistemaErrorLog sistemaErrorLog = (SistemaErrorLog) o;
        if (sistemaErrorLog.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sistemaErrorLog.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SistemaErrorLog{" +
            "id=" + getId() +
            ", uuidorigen='" + getUuidorigen() + "'" +
            ", errorLogText='" + getErrorLogText() + "'" +
            ", errorLogTextContentType='" + getErrorLogTextContentType() + "'" +
            ", entidadid=" + getEntidadid() +
            ", personasid=" + getPersonasid() +
            ", contratosid=" + getContratosid() +
            ", recibosid=" + getRecibosid() +
            ", iplocal='" + getIplocal() + "'" +
            ", ipproxy='" + getIpproxy() + "'" +
            ", ippublic='" + getIppublic() + "'" +
            ", usuariosid=" + getUsuariosid() +
            ", tiempo=" + getTiempo() +
            ", estatus=" + getEstatus() +
            "}";
    }
}
