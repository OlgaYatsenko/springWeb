package com.coffee.shop.web;


import com.coffee.shop.Customer;
import com.coffee.shop.Order;
import com.coffee.shop.Product;
import com.coffee.shop.data.OrderRepository;
import com.coffee.shop.data.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/menu")
@SessionAttributes("customer")
public class MenuController {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public MenuController(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }


    @ModelAttribute(name = "customer")
    public Customer customer() {
        return new Customer();
    }

    @ModelAttribute(name = "menu")
    public Order menu() {
        return new Order();
    }


    @GetMapping
    public String showMenuForm(Model model) {
        List<Product> products = (List<Product>) productRepository.findAll();
        model.addAttribute("products", products);
        return "menu";}

//    @GetMapping
//    public String showMenuForm(Model model) {
//        List<Product> products = Arrays.asList(
//                new Product("ESSP", "Esspresso", Product.Type.DRINK),
//                new Product("WHCO", "White Coffee", Product.Type.DRINK),
//                new Product("TIRA", "Tiramisu", Product.Type.DESSERT),
//                new Product("CHMO", "Chocolate mousse", Product.Type.DESSERT));
//        model.addAttribute("products", products);
//        return "menu";
//    }


    @PostMapping
    public String processDesign(@ModelAttribute("menu") Order order, Customer customer, Model model) {
      //  if(errors.hasErrors()) return "menu";

        Order order_saved=orderRepository.save(order);
        log.info("----------------------------------order saved--"+order_saved.getId()+order_saved.getProducts().toString());
        order_saved.getProducts().forEach(System.out::println);

        customer.setOrder(order_saved);
        log.info("-------------------------------------------------------order added to the customer");

        //save order to db
        return "redirect:/orders/current";
    }





}
