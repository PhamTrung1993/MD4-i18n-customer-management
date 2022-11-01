package com.codegym.controller;

import com.codegym.model.Province;
import com.codegym.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;

    @GetMapping("/province")
    public ModelAndView listProvinces(Pageable pageable) {
        Iterable<Province> provinces = provinceService.findAll(pageable);
            return  new ModelAndView("/province/list","province", provinces);
    }
}
