package com.nikitayasiulevich.cryptoapp.domain

data class CoinInfo(
    val fromSymbol: String = "",
    val toSymbol: String? = null,
    val lastMarket: String? = null,
    val price: Double? = null,
    val lastUpdate: String,
    val highDay: Double? = null,
    val lowDay: Double? = null,
    val imageUrl: String
)