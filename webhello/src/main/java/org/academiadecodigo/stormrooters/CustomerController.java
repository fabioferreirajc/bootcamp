package org.academiadecodigo.stormrooters;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    @RequestMapping(method = RequestMethod.GET,value="/")
    public String showCustomerDetails(Model model){

        Customer customer= new Customer();
        customer.setEmail("fabio@emailtest.com");
        customer.setName("Fábio Ferreira");

        model.addAttribute("customer",customer);

        return "customer";
    }
}
