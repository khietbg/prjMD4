package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ra.model.entity.Catalog;
import ra.model.service.catalog.ICatalogService;
import ra.model.service.catalog.catalogServiceIpm;

import java.util.List;

@Controller
public class CatalogController {
    ICatalogService catalogService = new catalogServiceIpm();

    @GetMapping("catalogManager")
    public String catalogManager(Model model) {
        List<Catalog> catalogList = catalogService.findAll();
        model.addAttribute("list", catalogList);
        return "admin/catalogManager";
    }
    @PostMapping ("createCatalog")
    public String createCatalog(String catalogName){
        Catalog catalog  = new Catalog();
        catalog.setCatalogName(catalogName);
       boolean check =  catalogService.save(catalog);
       if (check){
           return "redirect:/catalogManager";
       }else {
           return "error";
       }
    }
    @GetMapping("/deleteCatalog/{id}")
    public String deleteCatalog(@PathVariable("id") int id){
       boolean check = catalogService.delete(id);
        if (check){
            return "redirect:/catalogManager";
        }else {
            return "error";
        }
    }
    @GetMapping("/editCatalog/{id}")
    public String editCatalog(@PathVariable("id") int id,Model model){
        Catalog catalog = catalogService.findById(id);
        model.addAttribute("editCatalog",catalog);
        return "admin/editCatalog";
    }
    @PostMapping("updateCatalog")
    public String updateCatalog(@ModelAttribute("editCatalog") Catalog editCatalog){
        boolean check = catalogService.update(editCatalog);
        if (check){
            return "redirect:/catalogManager";
        }else {
            return "error";
        }
    }
}