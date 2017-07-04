/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Optional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author camila.batista
 */
@RestController
@RequestMapping(LoggedUserController.PATH)
public class LoggedUserController {

    public static final String PATH = "/logged-user";

    @GetMapping
    public User getUserDetails(Authentication authentication) {
        return Optional.ofNullable(authentication)
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .orElse(null);
    }
}
