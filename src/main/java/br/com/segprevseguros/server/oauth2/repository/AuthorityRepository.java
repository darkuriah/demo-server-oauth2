package br.com.segprevseguros.server.oauth2.repository;

import br.com.segprevseguros.server.oauth2.model.OauthAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<OauthAuthority, String> {

}
