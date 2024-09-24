package com.siit.class22project.controller;

import com.siit.class22project.model.ProductReturnDto;
import com.siit.class22project.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mvc")
@RequiredArgsConstructor
public class ProductMvcController {

    private final ProductService productService;

    @GetMapping
    public String getProducts(Model model){
        List<ProductReturnDto> productList = productService.getProducts();
        model.addAttribute("productList", productList);
        return "products";
    }

}
