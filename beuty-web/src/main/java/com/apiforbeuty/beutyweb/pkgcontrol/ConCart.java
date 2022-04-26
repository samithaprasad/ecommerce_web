package com.apiforbeuty.beutyweb.pkgcontrol;

import com.apiforbeuty.beutyweb.pkgallaccess.AllAccessCart;
import com.apiforbeuty.beutyweb.pkgobj.ObjProduct;
import com.apiforbeuty.beutyweb.pkgservice.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller

public class ConCart {

    @Autowired
    ServiceProduct serviceProduct;

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable Long id){
        AllAccessCart.cart.add(serviceProduct.getProdutById(id).get());
        return "redirect:/shop";
    }

    @GetMapping("/cart/removeItem/{index}")
    public String cartItemRemove(@PathVariable int index){
        AllAccessCart.cart.remove(index);
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String cartGet(Model model){
        model.addAttribute("cartCount",AllAccessCart.cart.size());
        model.addAttribute("total",AllAccessCart.cart.stream().mapToDouble(ObjProduct::getPrice).sum());
        model.addAttribute("cart",AllAccessCart.cart);
        return "cart";
    }

    @GetMapping("/checkout")
    public String checkout(Model model){
        model.addAttribute("total",AllAccessCart.cart.stream().mapToDouble(ObjProduct::getPrice).sum());
        AllAccessCart.cart.clear();
        return "checkout";
    }


}
