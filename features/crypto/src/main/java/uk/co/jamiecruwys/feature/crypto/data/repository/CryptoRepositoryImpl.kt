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
package uk.co.jamiecruwys.feature.crypto.data.repository

import uk.co.jamiecruwys.feature.crypto.data.api.CryptoApiItem
import uk.co.jamiecruwys.feature.crypto.data.api.CryptoService
import uk.co.jamiecruwys.feature.crypto.data.domain.CryptoDomainModel
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(
    private val cryptoService: CryptoService
) : CryptoRepository {
    override suspend fun getPrices(): List<CryptoDomainModel> {
        val response: List<CryptoApiItem>? = cryptoService.getPrices()

        val domainItems = arrayListOf<CryptoDomainModel>()

        response?.forEach {
            val domainItem = CryptoDomainModel(it.name, it.imageUrl, it.price)
            domainItems.add(domainItem)
        }

        return domainItems.toList()
    }
}
