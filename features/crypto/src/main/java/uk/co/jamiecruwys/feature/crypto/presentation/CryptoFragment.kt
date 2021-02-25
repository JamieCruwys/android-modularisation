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
package uk.co.jamiecruwys.feature.crypto.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import uk.co.jamiecruwys.base.data.User
import uk.co.jamiecruwys.feature.crypto.data.domain.CryptoDomainModel
import uk.co.jamiecruwys.feature.crypto.databinding.FragmentCryptoBinding

@AndroidEntryPoint
class CryptoFragment : Fragment() {
    lateinit var binding: FragmentCryptoBinding
    private val viewModel: CryptoViewModel by viewModels()
    private val cryptoAdapter = CryptoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loading.observe(this, { handleLoadingState(it) })
        viewModel.items.observe(this, { handleItemsState(it) })
        viewModel.user.observe(this, { handleUserState(it) })
        viewModel.load()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCryptoBinding.inflate(layoutInflater)
        binding.cryptoList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = cryptoAdapter
        }
        return binding.root
    }

    private fun handleLoadingState(loading: Boolean) {
        binding.cryptoLoading.isVisible = loading
        binding.cryptoList.isVisible = !loading
    }

    private fun handleItemsState(items: List<CryptoDomainModel>) {
        cryptoAdapter.items = items
    }

    private fun handleUserState(user: User) {
        val name = user.name
        Toast.makeText(context, "Name: $name", Toast.LENGTH_SHORT).show()
    }
}
