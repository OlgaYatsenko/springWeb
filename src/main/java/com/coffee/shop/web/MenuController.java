package com.coffee.shop.web;


import com.coffee.shop.Order;
import com.coffee.shop.Product;
import com.coffee.shop.data.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/menu")

public class MenuController {

//    private final ProductRepository productRepository;
//
//    @Autowired
//    public MenuController(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

//    @GetMapping
//    public String showMenuForm(Model model) {
//        List<Product> products = (List<Product>) productRepository.findAll();
//        model.addAttribute("products", products);
//        return "menu";
//    }

    @GetMapping
    public String showMenuForm(Model model) {
        List<Product> products = Arrays.asList(
                new Product("ESSP", "Esspresso", Product.Type.DRINK),
                new Product("WHCO", "White Coffee", Product.Type.DRINK),
                new Product("TIRA", "Tiramisu", Product.Type.DESSERT),
                new Product("CHMO", "Chocolate mousse", Product.Type.DESSERT));
        model.addAttribute("products", products);
        return "menu";
    }


    @PostMapping
    public String processDesign( @ModelAttribute Order order) {

        //save order to db
        return "redirect:/orders/current";
    }





}
