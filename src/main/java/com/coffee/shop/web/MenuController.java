package com.coffee.shop.web;


import com.coffee.shop.Order;
import com.coffee.shop.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/menu")

public class MenuController {

    @GetMapping
    public String showMenuForm(Model model) {
        List<Product> products = Arrays.asList(
                new Product("ESSP", "Esspresso", Product.Type.DRINK),
                new Product("WHCO", "White Coffee", Product.Type.DRINK),
                new Product("TIRA", "Tiramisu", Product.Type.DESSERT),
                new Product("CHMO", "Chocolate mousse", Product.Type.DESSERT));

        Product.Type[] types = Product.Type.values();
        for (Product.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(products, type));
        }
        model.addAttribute("products", products);
        return "menu";
    }


    @PostMapping
    public String processDesign( @ModelAttribute Order order) {

        //save order to db
        return "redirect:/orders/current";
    }


    private List<Product> filterByType(
            List<Product> products, Product.Type type) {
        return products
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }


}
