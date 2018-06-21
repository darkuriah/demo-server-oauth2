package br.com.segprevseguros.server.oauth2.repository;

import br.com.segprevseguros.server.oauth2.model.OauthClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OauthClientDetailsRepository extends JpaRepository<OauthClientDetails, String> {

}
