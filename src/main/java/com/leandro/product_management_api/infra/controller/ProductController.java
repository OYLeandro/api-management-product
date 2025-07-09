package com.leandro.product_management_api.infra.controller;

import com.leandro.product_management_api.application.dtos.*;
import com.leandro.product_management_api.application.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> registerProduct(@RequestBody @Valid ProductRequestDTO requestDTO){
        service.register(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable Long id){
        return ResponseEntity.ok(service.getProduct(id));
    }

    @GetMapping("/page")
    public ResponseEntity<PageResponseDTO<ProductResponseDTO>> listWithPage(
            @ModelAttribute PageRequestDTO requestDTO
    ){
        return ResponseEntity.ok().body(service.listWithPage(requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
