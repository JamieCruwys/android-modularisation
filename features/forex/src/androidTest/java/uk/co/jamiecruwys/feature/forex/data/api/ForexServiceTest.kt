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

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import uk.co.jamiecruwys.base.CoroutineTestRule
import uk.co.jamiecruwys.feature.forex.data.domain.ForexDomainModel
import uk.co.jamiecruwys.feature.forex.data.repository.ForexRepositoryImpl
import uk.co.jamiecruwys.loadJson
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class ForexServiceTest {
    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutineTestRule()

    private val mockForexService = MockForexService()

    private lateinit var repository: ForexRepositoryImpl

    @Before
    @Throws(Exception::class)
    fun setUp() {
        repository = ForexRepositoryImpl(mockForexService)
    }

    @Test
    fun testGetRatesWithItems() = runBlocking {
        // Given
        mockForexService.getRatesResponse = "forex_items.json".loadJson()

        // When
        val actual = repository.getData()

        // Then
        val expected = listOf(
            ForexDomainModel("CAD", 1.5328f),
            ForexDomainModel("HKD", 9.407f),
            ForexDomainModel("ISK", 155.6f),
            ForexDomainModel("PHP", 59.112f),
            ForexDomainModel("DKK", 7.4365f),
            ForexDomainModel("HUF", 359.09f),
            ForexDomainModel("CZK", 25.954f),
            ForexDomainModel("GBP", 0.8653f),
            ForexDomainModel("RON", 4.8758f),
            ForexDomainModel("SEK", 10.0315f),
            ForexDomainModel("IDR", 17197.5f),
            ForexDomainModel("INR", 87.972f),
            ForexDomainModel("BRL", 6.6843f),
            ForexDomainModel("RUB", 90.98f),
            ForexDomainModel("HRK", 7.5714f),
            ForexDomainModel("THB", 36.448f),
            ForexDomainModel("CHF", 1.0888f),
            ForexDomainModel("EUR", 0.0f),
            ForexDomainModel("MYR", 4.9048f),
            ForexDomainModel("BGN", 1.9558f),
            ForexDomainModel("TRY", 8.5684f),
            ForexDomainModel("CNY", 7.8447f),
            ForexDomainModel("NOK", 10.3185f),
            ForexDomainModel("NZD", 1.6583f),
            ForexDomainModel("ZAR", 18.0732f),
            ForexDomainModel("USD", 1.2133f),
            ForexDomainModel("MXN", 25.2189f),
            ForexDomainModel("AUD", 1.5392f),
            ForexDomainModel("ILS", 3.9683f),
            ForexDomainModel("KRW", 1350.83f),
            ForexDomainModel("PLN", 4.4982f),
        )

        assertEquals(expected, actual)
    }
}
