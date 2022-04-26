package com.apiforbeuty.beutyweb.pkgcontrol;

import com.apiforbeuty.beutyweb.pkgdto.DTOProduct;
import com.apiforbeuty.beutyweb.pkgobj.ObjCategory;
import com.apiforbeuty.beutyweb.pkgobj.ObjProduct;
import com.apiforbeuty.beutyweb.pkgservice.ServiceCategory;
import com.apiforbeuty.beutyweb.pkgservice.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller

public class ConAdmin {

    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages/";

    @Autowired
    ServiceCategory serviceCategory;

    @Autowired
    ServiceProduct serviceProduct;

    @GetMapping("/admin")
    public String adminHome() {
        return "adminHome";
    }

//    -----------------------------
//    product

    @GetMapping("/admin/products")
    public String getProducts(Model model) {
        model.addAttribute("products", serviceProduct.getAllProducts());
        return "products";
    }

    @GetMapping("/admin/products/add")
    public String productsAdd(Model model) {
        model.addAttribute("productDTO", new DTOProduct());
        model.addAttribute("categories", serviceCategory.getAllCategories());
        return "productsAdd";
    }

    @PostMapping("/admin/products/add")
    public String productAddPost(@ModelAttribute("productDTO") DTOProduct productDTO,
                                 @RequestParam("productImage") MultipartFile file,
                                 @RequestParam("imgName") String imgName) throws IOException {

        ObjProduct product = new ObjProduct();

        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCategory(serviceCategory.getCatById(productDTO.getCategoryId()).get());
        product.setPrice(productDTO.getPrice());
        product.setWeight(productDTO.getWeight());
        product.setDescription(productDTO.getDescription());

        String imageUUID;

        if (!file.isEmpty()) {
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNameAndPath, file.getBytes());
        } else
            imageUUID = imgName;

        product.setImageName(imageUUID);
        serviceProduct.addProduct(product);

        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String deleteProducts(@PathVariable Long id){
        serviceProduct.deleteProduct(id);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/update/{id}")
    public String updateProducts(@PathVariable Long id,Model model){

        ObjProduct product=serviceProduct.getProdutById(id).get();

        DTOProduct productDTO=new DTOProduct();

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setCategoryId(product.getCategory().getId());
        productDTO.setPrice(product.getPrice());
        productDTO.setWeight(product.getWeight());
        productDTO.setDescription(product.getDescription());
        productDTO.setImageName(product.getImageName());

        model.addAttribute("categories",serviceCategory.getAllCategories());
        model.addAttribute("productDTO", productDTO);

        return "productsAdd";
    }

//    category

    @GetMapping("/admin/categories")
    public String getCategories(Model model) {
        model.addAttribute("categories", serviceCategory.getAllCategories());
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String getCategoryAdd(Model model) {
        model.addAttribute("category", new ObjCategory());
        return "categoriesAdd";
    }

    @PostMapping("/admin/categories/add")
    public String postCategoryAdd(@ModelAttribute("category") ObjCategory category) {
        serviceCategory.addCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCat(@PathVariable Integer id) {
        serviceCategory.removeCatById(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String updateCat(@PathVariable Integer id, Model model) {
        Optional<ObjCategory> catergory = serviceCategory.getCatById(id);
        if (catergory.isPresent()) {
            model.addAttribute("category", catergory.get());
            return "categoriesAdd";
        } else
            return "404";
    }



}
