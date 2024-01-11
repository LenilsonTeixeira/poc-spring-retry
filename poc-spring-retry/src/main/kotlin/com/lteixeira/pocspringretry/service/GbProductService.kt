package com.lteixeira.pocspringretry.service

import com.lteixeira.pocspringretry.exception.ProductStatusInvalidException
import com.lteixeira.pocspringretry.http.GbProductHttpClient
import com.lteixeira.pocspringretry.model.Product
import com.lteixeira.pocspringretry.validator.GbProductValidation
import org.slf4j.LoggerFactory
import org.springframework.retry.annotation.Backoff
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Service

@Service
class GbProductService(private val gbProductHttpClient: GbProductHttpClient) {

    companion object {
        private val log = LoggerFactory.getLogger(GbProductService::class.java)
    }

    @Retryable(retryFor = [ProductStatusInvalidException::class], maxAttemptsExpression = "3", backoff = Backoff(delayExpression = "1000"))
    fun getProduct(sku: String): Product {
        log.info("Realizando chamada para a gbproducts para o sku ${sku}")
        val product = gbProductHttpClient.getProduct(sku)
        log.info("Retorno da gbproducts: SKU: ${product.sku} Status: ${product.status}")
        GbProductValidation.validate(product)
        return product
    }

}