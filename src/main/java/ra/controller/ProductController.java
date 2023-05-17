package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ra.model.entity.Catalog;
import ra.model.entity.Product;
import ra.model.service.catalog.ICatalogService;
import ra.model.service.catalog.catalogServiceIpm;
import ra.model.service.productService.IProductService;
import ra.model.service.productService.ProductServiceIpm;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {
    private IProductService productService = new ProductServiceIpm();
    private ICatalogService catalogService = new catalogServiceIpm();
    @GetMapping("productManager")
    public String productManager(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("list",productList);
        List<Catalog> catalogList = catalogService.findAll();
        model.addAttribute("listCat",catalogList);
        return "admin/productManager";
    }
    @PostMapping("createProduct")
    public String createProduct(@RequestParam("image") MultipartFile image,String productName,int catalogId, float price,Model model) throws IOException {
        String uploadPath = "/Users/minhkhiet/javaMD3DINHVANKHIET/MD4project/src/main/resources/assets/img/imgProduct/";
        File file = new File(uploadPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileName = image.getOriginalFilename();
        FileCopyUtils.copy(image.getBytes(),new File(uploadPath+File.separator + fileName));
        model.addAttribute("fileName",fileName);
        Product product = new Product(catalogId,productName,fileName,price);
       boolean check =  productService.save(product);
       if (check){
           return "redirect:/productManager";
       }else {
           return "error";
       }

    }
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") int id){
        boolean check = productService.delete(id);
        if (check){
            return "redirect:/productManager";
        }else {
            return "error";
        }

    }
    @GetMapping("/editProduct/{id}")
    public String editProduct(@PathVariable("id") int id,Model model){
        Product product = productService.findById(id);
        List<Catalog> catalogList = catalogService.findAll();
        model.addAttribute("productE",product);
        model.addAttribute("catalogList",catalogList);
        return "admin/editProduct";
    }
    @PostMapping("updateProduct")
    public String updateProduct(@RequestParam("img") MultipartFile image, Product product,Model model) throws IOException {
        if (image.isEmpty()){
            product.setImage(productService.findById(product.getProductId()).getImage());
        }else {
            String uploadPath = "/Users/minhkhiet/javaMD3DINHVANKHIET/MD4project/src/main/resources/assets/img/imgProduct/";
            File file = new File(uploadPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            String fileName = image.getOriginalFilename();
            FileCopyUtils.copy(image.getBytes(),new File(uploadPath+File.separator + fileName));
            model.addAttribute("fileName",fileName);
            product.setImage(fileName);
        }
       boolean check = productService.update(product);
        if (check){
            return "redirect:/productManager";
        }else {
            return "error";
        }
    }


}
