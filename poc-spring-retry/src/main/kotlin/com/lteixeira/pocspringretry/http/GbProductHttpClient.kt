package com.lteixeira.pocspringretry.http

import com.lteixeira.pocspringretry.model.Product
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "gbproduct-client", url = "\${gbproduct.api.url}")
interface GbProductHttpClient {
    @GetMapping("/products/{sku}")
    fun getProduct(@PathVariable("sku") sku: String) : Product
}
