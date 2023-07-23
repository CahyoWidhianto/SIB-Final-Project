package id.co.mii.LMS.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import id.co.mii.LMS.Model.dto.request.LoginRequest;
import id.co.mii.LMS.Service.LoginService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class LoginController {
    private LoginService loginService;

     @GetMapping("/login")
    public String loginPage(LoginRequest loginRequest){
    // model.addAttribute("loginRequest", new LoginRequest());
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(LoginRequest loginRequest){
        if (!loginService.login(loginRequest)){
            return "redirect:/login?error=true";
        }
        return "redirect:/index";
    }
}
