package br.com.segprevseguros.server.oauth2.repository;

import br.com.segprevseguros.server.oauth2.model.OauthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OauthUserRepository extends JpaRepository<OauthUser, String> {
    OauthUser findByUsername(String username);    
}
