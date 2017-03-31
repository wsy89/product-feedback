package leanne.feedback.controllers;

import leanne.feedback.models.Feedback;
import leanne.feedback.models.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by leanne on 31/03/17.
 */
@Controller
public class AdminController {

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        Login login = new Login();
        model.addAttribute("login", login);
        return "admin";
    }
}
