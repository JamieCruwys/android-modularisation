/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.co.jamiecruwys.feature.forex.data.api

import com.google.gson.annotations.SerializedName

data class ForexRates(
    @SerializedName("CAD") val canadianDollar: Float,
    @SerializedName("HKD") val hongKongDollar: Float,
    @SerializedName("ISK") val icelandKrona: Float,
    @SerializedName("PHP") val philippinePeso: Float,
    @SerializedName("DKK") val denmarkKroner: Float,
    @SerializedName("HUF") val hungaryForint: Float,
    @SerializedName("CZK") val czechKoruna: Float,
    @SerializedName("GBP") val britishPound: Float,
    @SerializedName("RON") val romanianLeu: Float,
    @SerializedName("SEK") val swedishKrona: Float,
    @SerializedName("IDR") val indonesianRupiah: Float,
    @SerializedName("INR") val indianRupee: Float,
    @SerializedName("BRL") val brazilReais: Float,
    @SerializedName("RUB") val russianRuble: Float,
    @SerializedName("HRK") val croatiaKuna: Float,
    @SerializedName("THB") val thaiBaht: Float,
    @SerializedName("CHF") val swissFranc: Float,
    @SerializedName("EUR") val euro: Float,
    @SerializedName("MYR") val malaysianRinggit: Float,
    @SerializedName("BGN") val bulgarianLev: Float,
    @SerializedName("TRY") val turkishLira: Float,
    @SerializedName("CNY") val chineseRenminbi: Float,
    @SerializedName("NOK") val norwayKroner: Float,
    @SerializedName("NZD") val newZealandDollar: Float,
    @SerializedName("ZAR") val southAfricanRand: Float,
    @SerializedName("USD") val usDollar: Float,
    @SerializedName("MXN") val mexicanPeso: Float,
    @SerializedName("AUD") val australianDollar: Float,
    @SerializedName("ILS") val israeliNewShekel: Float,
    @SerializedName("KRW") val southKoreanWon: Float,
    @SerializedName("PLN") val polishZloty: Float
)
