package id.co.mii.LMS.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
     @GetMapping
    public String home(Model model) {
        model.addAttribute("name", "SIBKM");
        return "index";
  }
}
