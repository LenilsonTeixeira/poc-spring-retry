package com.lteixeira.backendproduct.controller

import com.lteixeira.backendproduct.model.Product
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class ProductController {

    @GetMapping("/products/{sku}")
    fun getProduct(@PathVariable("sku") sku: String): Product {
        val random = Random(System.currentTimeMillis())

        val numeroAleatorio = random.nextInt(1, 11)

        if (numeroAleatorio < 5) {
           return Product(sku, status = "08")
        } else {
            return Product(sku, status = "07")
        }
    }
}