package com.nikitayasiulevich.cryptoapp.domain.repository

import androidx.lifecycle.LiveData
import com.nikitayasiulevich.cryptoapp.domain.CoinInfo

interface CoinRepository {

    fun getCoinInfoList(): LiveData<List<CoinInfo>>

    fun getCoinInfo(fromSymbol: String): LiveData<CoinInfo>

    fun loadData()
}