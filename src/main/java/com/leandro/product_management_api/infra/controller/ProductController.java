package com.leandro.product_management_api.controller;


import com.leandro.product_management_api.dtos.requestdtos.ProductRequestDTO;
import com.leandro.product_management_api.dtos.responsedtos.ProductResponseDTO;
import com.leandro.product_management_api.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> registerProduct(@RequestBody @Valid ProductRequestDTO requestDTO){
        service.registerProduct(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable Long id){
        return ResponseEntity.ok(service.getProduct(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductResponseDTO>> listAllProduct(){
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/page")
    public ResponseEntity<Page<ProductResponseDTO>> lisWithPage(@RequestParam(required = false)String category, Pageable pageable){
        return ResponseEntity.ok(service.listWithPage(category, pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
