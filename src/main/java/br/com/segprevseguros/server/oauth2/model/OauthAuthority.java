package br.com.segprevseguros.server.oauth2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "oauth_authority")
@SuppressWarnings("PersistenceUnitPresent")
public class OauthAuthority implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 63)
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "authoritySet")
    @JsonBackReference
    private Set<OauthUser> oauthUserSet;

    public OauthAuthority() {
    }

    public OauthAuthority(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<OauthUser> getOauthUserSet() {
        return oauthUserSet;
    }

    public void setOauthUserSet(Set<OauthUser> oauthUserSet) {
        this.oauthUserSet = oauthUserSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OauthAuthority)) {
            return false;
        }
        OauthAuthority other = (OauthAuthority) object;
        return !((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name)));
    }

    @Override
    public String toString() {
        return "br.com.segprevseguros.server.oauth2.model.Authority[ name=" + name + " ]";
    }
    
}
