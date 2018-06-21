package br.com.segprevseguros.server.oauth2.service;

import br.com.segprevseguros.server.oauth2.model.OauthUser;
import java.util.List;

public interface CustomUserService {

    OauthUser save(OauthUser user);
    List<OauthUser> findAll();
    //void delete(long id);
}

