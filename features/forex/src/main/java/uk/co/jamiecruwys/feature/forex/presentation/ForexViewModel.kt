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

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uk.co.jamiecruwys.base.data.User
import uk.co.jamiecruwys.base.data.UserRepository
import uk.co.jamiecruwys.feature.forex.data.domain.ForexDomainModel
import uk.co.jamiecruwys.feature.forex.data.repository.ForexRepository
import javax.inject.Inject

@HiltViewModel
class ForexViewModel @Inject constructor(
    private val forexRepository: ForexRepository,
    private val userRepository: UserRepository
) : ViewModel() {
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    private val _items = MutableLiveData<List<ForexDomainModel>>()
    val items: LiveData<List<ForexDomainModel>>
        get() = _items

    private val _user = MutableLiveData<User>()
    val user: LiveData<User>
        get() = _user

    fun load() {
        _loading.postValue(true)

        viewModelScope.launch {
            val items = forexRepository.getData()
            val user = userRepository.getUser()

            _items.postValue(items)
            _loading.postValue(false)
            _user.postValue(user)
        }
    }
}
