package com.nikitayasiulevich.cryptoapp.domain.usecase

import com.nikitayasiulevich.cryptoapp.domain.repository.CoinRepository

class GetCoinInfoListUseCase(
    private val repository: CoinRepository
) {
    operator fun invoke() = repository.getCoinInfoList()
}