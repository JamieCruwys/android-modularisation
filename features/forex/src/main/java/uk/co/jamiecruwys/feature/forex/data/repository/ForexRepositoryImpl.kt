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
package uk.co.jamiecruwys.feature.forex.data.repository

import uk.co.jamiecruwys.feature.forex.data.api.ForexService
import uk.co.jamiecruwys.feature.forex.data.domain.ForexDomainModel
import javax.inject.Inject

class ForexRepositoryImpl @Inject constructor(
    private val forexService: ForexService
) : ForexRepository {
    override suspend fun getData(): List<ForexDomainModel> {
        val response = forexService.getRates()
        val rates = response.rates

        return listOf(
            createItem("CAD", rates.canadianDollar),
            createItem("HKD", rates.hongKongDollar),
            createItem("ISK", rates.icelandKrona),
            createItem("PHP", rates.philippinePeso),
            createItem("DKK", rates.denmarkKroner),
            createItem("HUF", rates.hungaryForint),
            createItem("CZK", rates.czechKoruna),
            createItem("GBP", rates.britishPound),
            createItem("RON", rates.romanianLeu),
            createItem("SEK", rates.swedishKrona),
            createItem("IDR", rates.indonesianRupiah),
            createItem("INR", rates.indianRupee),
            createItem("BRL", rates.brazilReais),
            createItem("RUB", rates.russianRuble),
            createItem("HRK", rates.croatiaKuna),
            createItem("THB", rates.thaiBaht),
            createItem("CHF", rates.swissFranc),
            createItem("EUR", rates.euro),
            createItem("MYR", rates.malaysianRinggit),
            createItem("BGN", rates.bulgarianLev),
            createItem("TRY", rates.turkishLira),
            createItem("CNY", rates.chineseRenminbi),
            createItem("NOK", rates.norwayKroner),
            createItem("NZD", rates.newZealandDollar),
            createItem("ZAR", rates.southAfricanRand),
            createItem("USD", rates.usDollar),
            createItem("MXN", rates.mexicanPeso),
            createItem("AUD", rates.australianDollar),
            createItem("ILS", rates.israeliNewShekel),
            createItem("KRW", rates.southKoreanWon),
            createItem("PLN", rates.polishZloty)
        )
    }

    private fun createItem(name: String, value: Float): ForexDomainModel {
        return ForexDomainModel(
            name = name,
            value = value.toDouble()
        )
    }
}
