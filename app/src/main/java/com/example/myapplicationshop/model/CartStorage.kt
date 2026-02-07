package com.example.myapplicationshop.model

import Produkt

object CartStorage {
    // вся корзина
    private val items = mutableListOf<Produkt>()

    fun addCart(new_item: Produkt){
        val CheckInCart = items.any { it.id == new_item.id }

        if (CheckInCart == false){
            items.add(new_item)
        }
    }

    fun remove(old_item: Produkt){
        items.removeAll{it.id == old_item.id}
    }

    fun all() : List<Produkt>{
        return items.toList()
    }

    fun clear(){
        items.clear()
    }

}