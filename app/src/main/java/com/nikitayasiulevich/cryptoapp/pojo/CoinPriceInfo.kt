package com.nikitayasiulevich.cryptoapp.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.nikitayasiulevich.cryptoapp.api.ApiFactory.BASE_IMAGE_URL
import com.nikitayasiulevich.cryptoapp.utils.convertTimestampToTime

@Entity(tableName = "full_price_list")
data class CoinPriceInfo(
    @PrimaryKey
    @SerializedName("FROMSYMBOL")
    @Expose
    val fromSymbol: String = "",

    @SerializedName("TOSYMBOL")
    @Expose
    val toSymbol: String? = null,

    @SerializedName("LASTMARKET")
    @Expose
    val lastMarket: String? = null,

    @SerializedName("PRICE")
    @Expose
    val price: Double? = null,

    @SerializedName("LASTUPDATE")
    @Expose
    val lastUpdate: Long? = null,

    @SerializedName("VOLUMEHOUR")
    @Expose
    val volumeHour: Double? = null,

    @SerializedName("HIGHHOUR")
    @Expose
    val highHour: Double? = null,

    @SerializedName("LOWHOUR")
    @Expose
    val lowHour: Double? = null,

    @SerializedName("VOLUMEDAY")
    @Expose
    val volumeDay: Double? = null,

    @SerializedName("HIGHDAY")
    @Expose
    val highDay: Double? = null,

    @SerializedName("LOWDAY")
    @Expose
    val lowDay: Double? = null,

    @SerializedName("VOLUME24HOUR")
    @Expose
    val volume24hour: Double? = null,

    @SerializedName("HIGH24HOUR")
    @Expose
    val high24hour: Double? = null,

    @SerializedName("LOW24HOUR")
    @Expose
    val low24hour: Double? = null,

    @SerializedName("CHANGE24HOUR")
    @Expose
    val change24hour: Double? = null,

    @SerializedName("CHANGEHOUR")
    @Expose
    val changeHour: Double? = null,

    @SerializedName("IMAGEURL")
    @Expose
    val imageUrl: String? = null,
) {
    fun getFormattedTime(): String {
        return convertTimestampToTime(lastUpdate)
    }

    fun getFullImageUrl(): String {
        return BASE_IMAGE_URL + imageUrl
    }
}
