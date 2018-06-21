package br.com.segprevseguros.server.oauth2.controller;

import br.com.segprevseguros.server.oauth2.model.OauthUser;
import br.com.segprevseguros.server.oauth2.repository.OauthUserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private OauthUserRepository oauthUserRepository;

    @GetMapping(value = "/user")
    public List listUser() {
        return oauthUserRepository.findAll();
    }

    @PostMapping(value = "/user")
    public OauthUser create(@RequestBody OauthUser user) {
        return oauthUserRepository.save(user);
    }

//    @DeleteMapping(value = "/user/{id}")
//    public String delete(@PathVariable(value = "id") String id) {
//        oauthUserRepository.delete(id);
//        return "success";
//    }

}
