package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ra.model.entity.Catalog;
import ra.model.entity.User;
import ra.model.service.catalog.ICatalogService;
import ra.model.service.catalog.catalogServiceIpm;
import ra.model.service.userService.UserServiceIpm;

import java.util.List;

@Controller

public class AdminController {
    UserServiceIpm userServiceIpm = new UserServiceIpm();

    @GetMapping("dashboard")
    public String dashboard(){
        return "admin/dashboard";
    }
    @GetMapping("userManager")
    public String userManager(Model model){
        List<User> userList = userServiceIpm.findAll();
        model.addAttribute("list",userList);
        return "admin/userManager";

//    }@GetMapping("productManager")
//    public String productManager(Model model){
//        List<User> userList = userServiceIpm.findAll();
//        model.addAttribute("list",userList);
//        return "admin/productManager";
//    }@GetMapping("orderManager")
//    public String orderManager(Model model){
//        List<User> userList = userServiceIpm.findAll();
//        model.addAttribute("list",userList);
//        return "admin/orderManager";
    }

}
