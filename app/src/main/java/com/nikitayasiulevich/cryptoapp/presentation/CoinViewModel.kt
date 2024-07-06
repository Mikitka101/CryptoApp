package com.nikitayasiulevich.cryptoapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.nikitayasiulevich.cryptoapp.data.repository.CoinRepositoryImpl
import com.nikitayasiulevich.cryptoapp.domain.usecase.GetCoinInfoListUseCase
import com.nikitayasiulevich.cryptoapp.domain.usecase.GetCoinInfoUseCase
import com.nikitayasiulevich.cryptoapp.domain.usecase.LoadDataUseCase

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CoinRepositoryImpl(application)

    private val getCoinInfoUseCase = GetCoinInfoUseCase(repository)
    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)

    init {
        loadDataUseCase()
    }
}