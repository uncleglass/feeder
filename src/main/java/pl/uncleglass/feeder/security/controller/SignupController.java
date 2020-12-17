package pl.uncleglass.feeder.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.uncleglass.feeder.user.domain.User;
import pl.uncleglass.feeder.user.service.UserService;

@Controller
@RequestMapping("/signup")
public class SignupController {
    private final UserService userService;

    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String signupView() {
        return "security/signup";
    }

    @PostMapping()
    public String signupUser(@ModelAttribute User user, Model model) {
        userService.createUser(user);
        return "security/signup";
    }
}
