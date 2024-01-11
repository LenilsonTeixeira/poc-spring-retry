package com.lteixeira.pocspringretry

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.retry.annotation.EnableRetry

@EnableRetry
@EnableFeignClients
@SpringBootApplication
class PocSpringRetryApplication

fun main(args: Array<String>) {
	runApplication<PocSpringRetryApplication>(*args)
}
