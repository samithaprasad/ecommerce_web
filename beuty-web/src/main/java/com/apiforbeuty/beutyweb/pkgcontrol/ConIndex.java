package com.apiforbeuty.beutyweb.pkgcontrol;

import com.apiforbeuty.beutyweb.pkgallaccess.AllAccessCart;
import com.apiforbeuty.beutyweb.pkgservice.ServiceCategory;
import com.apiforbeuty.beutyweb.pkgservice.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller

public class ConIndex {

    @Autowired
    ServiceCategory serviceCategory;

    @Autowired
    ServiceProduct serviceProduct;

    @GetMapping({"/","/home"})
    public String home(){
        return "index";
    }

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("categories",serviceCategory.getAllCategories());
        model.addAttribute("products",serviceProduct.getAllProducts());
        model.addAttribute("cartCount", AllAccessCart.cart.size());
        return "shop";
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model model,@PathVariable Long id){
        model.addAttribute("product" ,serviceProduct.getProdutById(id).get());
        model.addAttribute("cartCount",AllAccessCart.cart.size());
        return "viewProduct";
    }

    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model model, @PathVariable Integer id){
        model.addAttribute("categories",serviceCategory.getAllCategories());
        model.addAttribute("products",serviceProduct.findAllByCategoryId(id));
        model.addAttribute("cartCount",AllAccessCart.cart.size());
        return "shop";
    }

}