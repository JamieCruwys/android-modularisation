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
package uk.co.jamiecruwys.feature.forex.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uk.co.jamiecruwys.feature.forex.data.domain.ForexDomainModel
import uk.co.jamiecruwys.feature.forex.databinding.ItemForexBinding

class ForexAdapter : RecyclerView.Adapter<ForexAdapter.ForexViewHolder>() {
    var items: List<ForexDomainModel> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForexViewHolder {
        val binding = ItemForexBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ForexViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ForexViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    class ForexViewHolder(private val binding: ItemForexBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ForexDomainModel) {
            binding.forexCurrencySymbol.text = item.name
            binding.forexCurrencyValue.text = String.format("%.4f", item.value)
        }
    }
}
