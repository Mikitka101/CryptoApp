package com.nikitayasiulevich.cryptoapp.data.mapper

import com.google.gson.Gson
import com.nikitayasiulevich.cryptoapp.data.database.CoinInfoDbModel
import com.nikitayasiulevich.cryptoapp.data.network.model.CoinInfoDto
import com.nikitayasiulevich.cryptoapp.data.network.model.CoinInfoJsonContainerDto
import com.nikitayasiulevich.cryptoapp.data.network.model.CoinNamesListDto
import com.nikitayasiulevich.cryptoapp.domain.CoinInfo
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class CoinMapper {

    fun mapDtoToDbModel(dto: CoinInfoDto) = CoinInfoDbModel(
        fromSymbol = dto.fromSymbol,
        toSymbol = dto.toSymbol,
        lastMarket = dto.lastMarket,
        price = dto.price,
        lastUpdate = dto.lastUpdate,
        highDay = dto.highDay,
        lowDay = dto.lowDay,
        imageUrl = BASE_IMAGE_URL + dto.imageUrl
    )

    fun mapJsonContainerToListCoinInfo(jsonContainer: CoinInfoJsonContainerDto): List<CoinInfoDto> {
        val result = mutableListOf<CoinInfoDto>()
        val jsonObject = jsonContainer.json ?: return result
        val coinKeySet = jsonObject.keySet()
        for (coinKey in coinKeySet) {
            val currencyJson = jsonObject.getAsJsonObject(coinKey)
            val currencyKeySet = currencyJson.keySet()
            for (currencyKey in currencyKeySet) {
                val priceInfo = Gson().fromJson(
                    currencyJson.getAsJsonObject(currencyKey),
                    CoinInfoDto::class.java
                )
                result.add(priceInfo)
            }
        }
        return result
    }

    fun mapNamesListToString(namesListDto: CoinNamesListDto): String {
        return namesListDto.names?.map {
            it.coinName?.name
        }?.joinToString(",") ?: ""
    }

    fun mapDbModelToEntity(dbModel: CoinInfoDbModel) = CoinInfo(
        fromSymbol = dbModel.fromSymbol,
        toSymbol = dbModel.toSymbol,
        lastMarket = dbModel.lastMarket,
        price = dbModel.price,
        lastUpdate = convertTimestampToTime(dbModel.lastUpdate),
        highDay = dbModel.highDay,
        lowDay = dbModel.lowDay,
        imageUrl = dbModel.imageUrl
    )

    private fun convertTimestampToTime(timestamp: Long?): String {
        if(timestamp == null){
            return ""
        }
        val stamp = Timestamp(timestamp * 1000)
        val date = Date(stamp.time)
        val pattern = "HH:mm:ss"
        val simpleDateFormat = SimpleDateFormat(pattern, Locale.getDefault())
        simpleDateFormat.timeZone = TimeZone.getDefault()
        return simpleDateFormat.format(date)
    }

    companion object {
        const val BASE_IMAGE_URL = "https://cryptocompare.com"
    }
}