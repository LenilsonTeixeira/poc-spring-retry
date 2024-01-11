package com.lteixeira.pocspringretry.controller

import com.lteixeira.pocspringretry.model.Product
import com.lteixeira.pocspringretry.service.GbProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(private val gbProductService: GbProductService) {

    @GetMapping("/products/{sku}")
    fun getProduct(@PathVariable("sku") sku: String): Product {
        return gbProductService.getProduct(sku)
    }
}