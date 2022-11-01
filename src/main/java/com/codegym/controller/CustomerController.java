package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Binding;
import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    public ICustomerService customerService;
    @Autowired
    public IProvinceService provinceService;

    @ModelAttribute("provinces")
    public Page<Province> provinces(Pageable pageable) {
        return provinceService.findAll(pageable);
    }
    @GetMapping("/customers")
    public ModelAndView showAllList(@PageableDefault(value = 5) Pageable pageable, @RequestParam("s")Optional<String> s){
        Page<Customer> list;
        if (s.isPresent()) {
            list = customerService.findAllByFirstNameContaining(s.get(), pageable);
        } else {
            list = customerService.findAll(pageable);
        }
        return new ModelAndView("/customer/list", "list", list);
    }
    @GetMapping("customers/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer", customer.get());
        return modelAndView;
    }
    @PostMapping("customers/edit/{id}")
    public String edit(@ModelAttribute Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }
    @GetMapping("customers/delete/{id}")
    public String delete(@PathVariable Long id){
        customerService.delete(id);
        return "redirect:/customers";
    }
    @GetMapping("customers/create")
    public ModelAndView showCreateForm() {
        return  new ModelAndView("/customer/create","customer",new Customer());
    }
    @PostMapping("customers/create")
    public String create(@ModelAttribute Customer customer, BindingResult rs) {
        customerService.save(customer);
        return "redirect:/customers";
    }

}
