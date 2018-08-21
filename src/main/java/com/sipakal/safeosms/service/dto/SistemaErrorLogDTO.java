package com.sipakal.safeosms.service.dto;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import javax.persistence.Lob;

/**
 * A DTO for the SistemaErrorLog entity.
 */
public class SistemaErrorLogDTO implements Serializable {

    private Long id;

    @Size(max = 30)
    private String uuidorigen;

    @Lob
    private byte[] errorLogText;
    private String errorLogTextContentType;

    private Integer entidadid;

    @Max(value = 999999999L)
    private Long personasid;

    @Max(value = 999999999L)
    private Long contratosid;

    @Max(value = 999999999L)
    private Long recibosid;

    @Size(max = 20)
    private String iplocal;

    @Size(max = 20)
    private String ipproxy;

    @Size(max = 20)
    private String ippublic;

    @Max(value = 9999)
    private Integer usuariosid;

    @Max(value = 999999999L)
    private Long tiempo;

    @Max(value = 9)
    private Integer estatus;

    private Long errorTiposidId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuidorigen() {
        return uuidorigen;
    }

    public void setUuidorigen(String uuidorigen) {
        this.uuidorigen = uuidorigen;
    }

    public byte[] getErrorLogText() {
        return errorLogText;
    }

    public void setErrorLogText(byte[] errorLogText) {
        this.errorLogText = errorLogText;
    }

    public String getErrorLogTextContentType() {
        return errorLogTextContentType;
    }

    public void setErrorLogTextContentType(String errorLogTextContentType) {
        this.errorLogTextContentType = errorLogTextContentType;
    }

    public Integer getEntidadid() {
        return entidadid;
    }

    public void setEntidadid(Integer entidadid) {
        this.entidadid = entidadid;
    }

    public Long getPersonasid() {
        return personasid;
    }

    public void setPersonasid(Long personasid) {
        this.personasid = personasid;
    }

    public Long getContratosid() {
        return contratosid;
    }

    public void setContratosid(Long contratosid) {
        this.contratosid = contratosid;
    }

    public Long getRecibosid() {
        return recibosid;
    }

    public void setRecibosid(Long recibosid) {
        this.recibosid = recibosid;
    }

    public String getIplocal() {
        return iplocal;
    }

    public void setIplocal(String iplocal) {
        this.iplocal = iplocal;
    }

    public String getIpproxy() {
        return ipproxy;
    }

    public void setIpproxy(String ipproxy) {
        this.ipproxy = ipproxy;
    }

    public String getIppublic() {
        return ippublic;
    }

    public void setIppublic(String ippublic) {
        this.ippublic = ippublic;
    }

    public Integer getUsuariosid() {
        return usuariosid;
    }

    public void setUsuariosid(Integer usuariosid) {
        this.usuariosid = usuariosid;
    }

    public Long getTiempo() {
        return tiempo;
    }

    public void setTiempo(Long tiempo) {
        this.tiempo = tiempo;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    public Long getErrorTiposidId() {
        return errorTiposidId;
    }

    public void setErrorTiposidId(Long sistemaErrorTiposId) {
        this.errorTiposidId = sistemaErrorTiposId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SistemaErrorLogDTO sistemaErrorLogDTO = (SistemaErrorLogDTO) o;
        if(sistemaErrorLogDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sistemaErrorLogDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SistemaErrorLogDTO{" +
            "id=" + getId() +
            ", uuidorigen='" + getUuidorigen() + "'" +
            ", errorLogText='" + getErrorLogText() + "'" +
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
