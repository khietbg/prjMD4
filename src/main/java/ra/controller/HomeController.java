package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.model.entity.*;
import ra.model.service.cartService.CartServiceImp;
import ra.model.service.cartService.ICartService;
import ra.model.service.productService.IProductService;
import ra.model.service.productService.ProductServiceIpm;
import ra.model.service.userService.UserServiceIpm;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController {
    UserServiceIpm userServiceIpm= new UserServiceIpm();
    IProductService productService = new ProductServiceIpm();
    ICartService cartService = new CartServiceImp();
    @GetMapping("/")
    public String home(Model model, HttpServletRequest request){
        List<Product> productList = productService.findAll();
        model.addAttribute("listProduct",productList);
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
            UserLogin userLogin = userServiceIpm.checkLogin(userName,password);
            if (userLogin==null){
                model.addAttribute("login","Username or password incorrect");
                return "login";
            }else {
                request.getSession().setAttribute("userLogin",userLogin);
                if (userLogin.isRole()){
                    return "admin/dashboard";
                }else {
                    List<CartItem> list =  cartService.findAllByUserLogin(userLogin.getUserId());
                    model.addAttribute("list",list);
                    List<Product> productList = productService.findAll();
                    model.addAttribute("listProduct",productList);
                    return "home";
                }
            }
    }
    @GetMapping("logOut")
    public String logOut(HttpServletRequest request,Model model){
        request.getSession().removeAttribute("userLogin");
        List<Product> productList = productService.findAll();
        model.addAttribute("listProduct",productList);
        return "home";
    }
    @GetMapping("/blockUser/{id}")
    public String blookUser(@PathVariable("id") int id){
        boolean check = userServiceIpm.blockUser(id);
        if (check){
            return "redirect:/userManager";
        }else {
            return "error";
        }
    }
@GetMapping("profile")
    public String profile(HttpServletRequest request,Model model){
      UserLogin userLogin = (UserLogin) request.getSession().getAttribute("userLogin");
      User user = userServiceIpm.findById(userLogin.getUserId());
      List<Cart> cartList = cartService.getCartByUserLogin(user.getUserId());
    model.addAttribute("userLogin",user);
    model.addAttribute("list",cartList);
        return "profile";
}
@GetMapping("formChangePassword")
    public String changePass(HttpServletRequest request,Model model){
    UserLogin userLogin = (UserLogin) request.getSession().getAttribute("userLogin");
    model.addAttribute("userLogin",userLogin);
    return "changePassword";
}
@PostMapping("changePass")
    public String changPassword(@RequestParam("idC")int id,@RequestParam("pass")String newPass,@RequestParam("rePass")String rePass,Model model){
        if (newPass.equals(rePass)){
            userServiceIpm.changePass(id,newPass);
            return "redirect:profile";
        }else {
           model.addAttribute("notMatch","re pass not match, please try again") ;
           return "changePassword";
        }
}
@PostMapping("updateUser")
    public String updateUser(int idUp,String fullNameUp,String emailUp,String phoneUp, String addressUp,HttpServletRequest request){
        userServiceIpm.updateUser(idUp,fullNameUp,emailUp,phoneUp,addressUp);
        return "redirect:profile";
}

}
