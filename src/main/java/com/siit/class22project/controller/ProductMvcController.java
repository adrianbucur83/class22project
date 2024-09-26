package com.siit.class22project.controller;

import com.siit.class22project.model.Product;
import com.siit.class22project.model.ProductCreateDto;
import com.siit.class22project.model.ProductReturnDto;
import com.siit.class22project.model.ProductUpdateDto;
import com.siit.class22project.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mvc")
@RequiredArgsConstructor
public class ProductMvcController {

    private final ProductService productService;

    @GetMapping
    public String getProducts(Model model) {
        List<ProductReturnDto> productList = productService.getProducts();
        model.addAttribute("productList", productList);
        return "products";
    }

    @GetMapping("/delete")
    public String deleteProductById(@RequestParam Long id) {
        productService.deleteProductById(id);
        return "redirect:/mvc";
    }

    @GetMapping("/update")
    public String updateView(@RequestParam Long id, Model model) {
        model.addAttribute("productUpdateDto", new ProductUpdateDto());
        return "update";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute ProductUpdateDto productUpdateDto, Model model) {
        model.addAttribute("productUpdateDto", productUpdateDto);
        productService.updateProduct(productUpdateDto);
        return "redirect:/mvc";
    }

}
