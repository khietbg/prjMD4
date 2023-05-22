package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ra.model.entity.Cart;
import ra.model.entity.Catalog;
import ra.model.entity.User;
import ra.model.service.cartService.CartServiceImp;
import ra.model.service.cartService.ICartService;
import ra.model.service.catalog.ICatalogService;
import ra.model.service.catalog.catalogServiceIpm;
import ra.model.service.userService.UserServiceIpm;

import java.util.List;

@Controller

public class AdminController {
    UserServiceIpm userServiceIpm = new UserServiceIpm();
    ICartService cartService = new CartServiceImp();

    @GetMapping("dashboard")
    public String dashboard(){
        return "admin/dashboard";
    }
    @GetMapping("userManager")
    public String userManager(Model model){
        List<User> userList = userServiceIpm.findAll();
        model.addAttribute("list",userList);
        return "admin/userManager";

    }
    @GetMapping("invoiceManager")
    public String showInvoice(Model model){
        List<Cart> cartList = cartService.getAllCart();
        float total = 0;
        for (Cart c:cartList) {
            total += c.getTotal();
        }
        model.addAttribute("total",total);
        model.addAttribute("list",cartList);
        return "admin/invoiceManager";
    }

}
