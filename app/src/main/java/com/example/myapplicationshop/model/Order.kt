package com.example.myapplicationshop.model

import Produkt

data class Order(
    val product: Produkt,
    val dateTime: String,
    val quantity: Int,
    val totalPrice: Double
)
