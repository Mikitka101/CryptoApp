package com.nikitayasiulevich.cryptoapp.domain.usecase

import com.nikitayasiulevich.cryptoapp.domain.repository.CoinRepository

class GetCoinInfoUseCase(
    private val repository: CoinRepository
) {
    operator fun invoke(fromSymbol: String) = repository.getCoinInfo(fromSymbol)
}