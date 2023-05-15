package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.model.entity.User;
import ra.model.service.userService.UserServiceIpm;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    UserServiceIpm userServiceIpm= new UserServiceIpm();
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("formLogin")
    public String formLogin(){
        return "login";
    }
    @GetMapping("formRegister")
    public String formRegister(Model model){
        User user = new User();
        model.addAttribute("newUser",user);
        return "register";
    }
    @PostMapping("register")
    public String register( User user){
        boolean check = userServiceIpm.save(user);
        if (check){
            return "redirect:formLogin";
        }else {
            return "error";
        }
    }
    @PostMapping("login")
    public String login(String userName, String password, Model model, HttpServletRequest request){
            if (userName.equals("")||password.equals("")){
                model.addAttribute("login","Not Required");
                return "login";
            }
            User userLogin = userServiceIpm.checkLogin(userName,password);
            if (userLogin==null){
                model.addAttribute("login","Username or password incorrect");
                return "login";
            }else {
                request.getSession().setAttribute("userLogin",userLogin);
                if (userLogin.isRole()){
                    return "admin/dashboard";
                }else {
                    return "home";
                }
            }
    }
    @GetMapping("logOut")
    public String logOut(HttpServletRequest request){
        request.getSession().removeAttribute("userLogin");
        return "home";
    }
    @GetMapping("/blockUser/{id}")
    public String deleteCatalog(@PathVariable("id") int id){
        boolean check = userServiceIpm.blockUser(id);
        if (check){
            return "redirect:/userManager";
        }else {
            return "error";
        }
    }

}
