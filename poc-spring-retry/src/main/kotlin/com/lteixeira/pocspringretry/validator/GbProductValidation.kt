package com.lteixeira.pocspringretry.validator

import com.lteixeira.pocspringretry.exception.ProductStatusInvalidException
import com.lteixeira.pocspringretry.model.Product

class GbProductValidation {
    companion object {
        fun validate(product: Product) {
            if (product.status.equals("08")){
                throw ProductStatusInvalidException("Produto com status inválido")
            }
        }
    }
}