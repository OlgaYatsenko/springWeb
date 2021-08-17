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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(i -> products.add(i));
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

//    @RequestMapping(value = "/menu", method = RequestMethod.GET)
//    public ModelAndView functionList(Model model, @RequestParam("checkboxname")String[] checkboxvalues) throws Exception {
//        ModelAndView mv = new ModelAndView("menu");
//        mv.addObject("functionList", getFunctionsFromDB());
//        return mv;
//    }



    @PostMapping
    public String processDesign( @RequestParam("productSelected") List<String> listProducts,@ModelAttribute Customer customer) {
      //  if(errors.hasErrors()) return "menu";
        List<Product> productsSelected=new ArrayList<>();
        for (String listProduct : listProducts) {productsSelected.add(productRepository.findByName(listProduct));
        }

        Order order=new Order();
        order.setProducts(productsSelected);

        Order order_saved=orderRepository.save(order);
        log.info("----------------------------------order saved--"+order_saved.getId());
        log.info("----------------------------------order saved--"+order_saved.getProducts());


        customer.setOrder(order_saved);
        log.info("-------------------------------------------------------order added to the customer");

        //save order to db
        return "redirect:/orders/current";
    }





}
