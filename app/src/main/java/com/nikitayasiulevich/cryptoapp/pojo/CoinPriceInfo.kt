package com.nikitayasiulevich.cryptoapp.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



data class CoinPriceInfo(
@SerializedName("TYPE")
@Expose
private val type: String? = null,

@SerializedName("MARKET")
@Expose
private val market: String? = null,

@SerializedName("FROMSYMBOL")
@Expose
private val fromSymbol: String? = null,

@SerializedName("TOSYMBOL")
@Expose
private val toSymbol: String? = null,

@SerializedName("FLAGS")
@Expose
private val flags: String? = null,

@SerializedName("LASTMARKET")
@Expose
private val lastMarket: String? = null,

@SerializedName("MEDIAN")
@Expose
private val median: Double? = null,

@SerializedName("TOPTIERVOLUME24HOUR")
@Expose
private val topTierVolume24hour: Double? = null,

@SerializedName("TOPTIERVOLUME24HOURTO")
@Expose
private val topTierVolume24hourto: Double? = null,

@SerializedName("LASTTRADEID")
@Expose
private val lastTradeid: String? = null,

@SerializedName("PRICE")
@Expose
private val price: Double? = null,

@SerializedName("LASTUPDATE")
@Expose
private val lastUpdate: Int? = null,

@SerializedName("LASTVOLUME")
@Expose
private val lastVolume: Double? = null,

@SerializedName("LASTVOLUMETO")
@Expose
private val lastVolumeto: Double? = null,

@SerializedName("VOLUMEHOUR")
@Expose
private val volumeHour: Double? = null,

@SerializedName("VOLUMEHOURTO")
@Expose
private val volumeHourTo: Double? = null,

@SerializedName("OPENHOUR")
@Expose
private val openHour: Double? = null,

@SerializedName("HIGHHOUR")
@Expose
private val highHour: Double? = null,

@SerializedName("LOWHOUR")
@Expose
private val lowHour: Double? = null,

@SerializedName("VOLUMEDAY")
@Expose
private val volumeDay: Double? = null,

@SerializedName("VOLUMEDAYTO")
@Expose
private val volumeDayTo: Double? = null,

@SerializedName("OPENDAY")
@Expose
private val openDay: Double? = null,

@SerializedName("HIGHDAY")
@Expose
private val highDay: Double? = null,

@SerializedName("LOWDAY")
@Expose
private val lowDay: Double? = null,

@SerializedName("VOLUME24HOUR")
@Expose
private val volume24hour: Double? = null,

@SerializedName("VOLUME24HOURTO")
@Expose
private val volume24hourTo: Double? = null,

@SerializedName("OPEN24HOUR")
@Expose
private val open24hour: Double? = null,

@SerializedName("HIGH24HOUR")
@Expose
private val high24hour: Double? = null,

@SerializedName("LOW24HOUR")
@Expose
private val low24hour: Double? = null,

@SerializedName("CHANGE24HOUR")
@Expose
private val change24hour: Double? = null,

@SerializedName("CHANGEPCT24HOUR")
@Expose
private val changepct24hour: Double? = null,

@SerializedName("CHANGEDAY")
@Expose
private val changeday: Double? = null,

@SerializedName("CHANGEPCTDAY")
@Expose
private val changepctday: Double? = null,

@SerializedName("CHANGEHOUR")
@Expose
private val changehour: Double? = null,

@SerializedName("CHANGEPCTHOUR")
@Expose
private val changepcthour: Double? = null,

@SerializedName("CONVERSIONTYPE")
@Expose
private val conversiontype: String? = null,

@SerializedName("CONVERSIONSYMBOL")
@Expose
private val conversionsymbol: String? = null,
)
