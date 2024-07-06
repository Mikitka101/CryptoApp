package com.nikitayasiulevich.cryptoapp.domain.usecase

import com.nikitayasiulevich.cryptoapp.domain.repository.CoinRepository

class LoadDataUseCase(
    private val repository: CoinRepository
) {

    suspend operator fun invoke() {
        repository.loadData()
    }
}