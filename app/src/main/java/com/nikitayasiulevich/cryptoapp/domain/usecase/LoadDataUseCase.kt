package com.nikitayasiulevich.cryptoapp.domain.usecase

import com.nikitayasiulevich.cryptoapp.domain.repository.CoinRepository

class LoadDataUseCase(
    private val repository: CoinRepository
) {

    operator fun invoke() {
        repository.loadData()
    }
}