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
package uk.co.jamiecruwys.feature.crypto.data.api

import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import uk.co.jamiecruwys.base.CoroutineTestRule
import uk.co.jamiecruwys.base.loadJson
import uk.co.jamiecruwys.feature.crypto.data.domain.CryptoDomainModel
import uk.co.jamiecruwys.feature.crypto.data.repository.CryptoRepositoryImpl
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class CryptoServiceTest {
    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutineTestRule()

    private val mockCryptoService = MockCryptoService()

    private lateinit var repository: CryptoRepositoryImpl

    @Before
    @Throws(Exception::class)
    fun setUp() {
        repository = CryptoRepositoryImpl(mockCryptoService)
    }

    @Test
    fun testGetPricesWithItems() = runBlocking {
        // Given
        val type = object : TypeToken<List<CryptoApiItem>>() {}.type
        mockCryptoService.getPricesResponse = "crypto_items.json".loadJson(type)

        // When
        val actual = repository.getPrices()

        // Then
        val expected = listOf(
            CryptoDomainModel("Bitcoin", "https://assets.coingecko.com/coins/images/1/large/bitcoin.png?1547033579", 51038.0),
            CryptoDomainModel("Ethereum", "https://assets.coingecko.com/coins/images/279/large/ethereum.png?1595348880", 1635.63),
        )

        assertEquals(expected, actual)
    }
}
