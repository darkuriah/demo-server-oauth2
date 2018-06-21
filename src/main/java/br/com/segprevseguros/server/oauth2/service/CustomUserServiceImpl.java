package br.com.segprevseguros.server.oauth2.service;

import br.com.segprevseguros.server.oauth2.model.OauthUser;
import br.com.segprevseguros.server.oauth2.repository.OauthUserRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "customUserService")
public class CustomUserServiceImpl implements UserDetailsService, CustomUserService {

    @Autowired
    private OauthUserRepository oauthUserRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        OauthUser user = oauthUserRepository.findByUsername(userId);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    private Set<GrantedAuthority> getAuthority(OauthUser user) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        user.getAuthoritySet().forEach((authority) -> {
            authorities.add(new SimpleGrantedAuthority(authority.getName()));
        });
        return authorities;
    }

    @Override
    public List findAll() {
        List list = new ArrayList();
        oauthUserRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public OauthUser save(OauthUser user) {
        return oauthUserRepository.save(user);
    }
}
