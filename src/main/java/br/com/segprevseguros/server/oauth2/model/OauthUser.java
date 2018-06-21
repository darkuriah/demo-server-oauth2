package br.com.segprevseguros.server.oauth2.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "oauth_user")
@SuppressWarnings("PersistenceUnitPresent")
public class OauthUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 63)
    @Column(name = "username")
    private String username;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 63)
    @Column(name = "email")
    private String email;
    @Size(max = 511)
    @Column(name = "password")
    private String password;
    @Column(name = "activated")
    private Boolean activated;
    @Size(max = 63)
    @Column(name = "activation_key")
    private String activationKey;
    @Size(max = 63)
    @Column(name = "reset_password_key")
    private String resetPasswordKey;
    @JoinTable(name = "oauth_user_authority", joinColumns = {
        @JoinColumn(name = "username", referencedColumnName = "username")}, inverseJoinColumns = {
        @JoinColumn(name = "authority", referencedColumnName = "name")})
    @ManyToMany(fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<OauthAuthority> authoritySet;

    public OauthUser() {
    }

    public OauthUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }

    public String getResetPasswordKey() {
        return resetPasswordKey;
    }

    public void setResetPasswordKey(String resetPasswordKey) {
        this.resetPasswordKey = resetPasswordKey;
    }

    public Set<OauthAuthority> getAuthoritySet() {
        return authoritySet;
    }

    public void setAuthoritySet(Set<OauthAuthority> authoritySet) {
        this.authoritySet = authoritySet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OauthUser)) {
            return false;
        }
        OauthUser other = (OauthUser) object;
        return !((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username)));
    }

    @Override
    public String toString() {
        return "br.com.segprevseguros.server.oauth2.model.OauthUser[ username=" + username + " ]";
    }
    
}
