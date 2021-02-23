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

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import io.mockk.verifySequence
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import uk.co.jamiecruwys.base.CoroutineTestRule
import uk.co.jamiecruwys.base.data.User
import uk.co.jamiecruwys.base.data.UserRepository
import uk.co.jamiecruwys.feature.forex.data.domain.ForexDomainModel
import uk.co.jamiecruwys.feature.forex.data.repository.ForexRepository

@RunWith(JUnit4::class)
class ForexViewModelTest {
    @get:Rule
    var rule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutineTestRule()

    @RelaxedMockK
    internal lateinit var forexRepository: ForexRepository

    @RelaxedMockK
    internal lateinit var userRepository: UserRepository

    @RelaxedMockK
    internal lateinit var loadObserver: androidx.lifecycle.Observer<Boolean>

    @RelaxedMockK
    internal lateinit var itemsObserver: androidx.lifecycle.Observer<List<ForexDomainModel>>

    @RelaxedMockK
    internal lateinit var userObserver: androidx.lifecycle.Observer<User>

    private lateinit var viewModel: ForexViewModel

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = ForexViewModel(forexRepository, userRepository)
    }

    @Test
    fun `when load() called then loading should be true`() {
        // Given
        val fakeItems = listOf<ForexDomainModel>()
        val fakeUser = User("")
        coEvery { forexRepository.getData() } returns fakeItems
        every { userRepository.getUser() } returns fakeUser
        viewModel.loading.observeForever(loadObserver)

        // When
        viewModel.load()

        // Then
        verify {
            loadObserver.onChanged(true)
        }
    }

    @Test
    fun `when forex has items when load() called then items should be returned`() {
        // Given
        val fakeItems = listOf(
            ForexDomainModel("CAD", 1.22f)
        )
        val fakeUser = User("")
        coEvery { forexRepository.getData() } returns fakeItems
        every { userRepository.getUser() } returns fakeUser

        // When
        viewModel.load()

        // Then
        viewModel.items.value shouldBeEqualTo fakeItems
    }

    @Test
    fun `when forex has no items when load() called then no items should be returned`() {
        // Given
        val fakeItems = listOf<ForexDomainModel>()
        val fakeUser = User("")
        coEvery { forexRepository.getData() } returns fakeItems
        every { userRepository.getUser() } returns fakeUser

        // When
        viewModel.load()

        // Then
        viewModel.items.value shouldBeEqualTo fakeItems
    }

    @Test
    fun `when forex has a user when load() called then user should be returned`() {
        // Given
        val fakeItems = listOf<ForexDomainModel>()
        val fakeUser = User("Joshua")
        coEvery { forexRepository.getData() } returns fakeItems
        every { userRepository.getUser() } returns fakeUser

        // When
        viewModel.load()

        // Then
        viewModel.user.value shouldBeEqualTo fakeUser
    }

    @Test
    fun `when forex has no user when load() called then no user should be returned`() {
        // Given
        val fakeItems = listOf<ForexDomainModel>()
        val fakeUser = User("")
        coEvery { forexRepository.getData() } returns fakeItems
        every { userRepository.getUser() } returns fakeUser

        // When
        viewModel.load()

        // Then
        viewModel.user.value shouldBeEqualTo fakeUser
    }

    @Test
    fun `when load() called then data should be emitted and loading should be false`() {
        // Given
        val fakeItems = listOf(
            ForexDomainModel("CAD", 1.433f),
            ForexDomainModel("USD", 1.01f)
        )
        val fakeUser = User("Sarah")
        coEvery { forexRepository.getData() } returns fakeItems
        every { userRepository.getUser() } returns fakeUser

        viewModel.loading.observeForever(loadObserver)
        viewModel.items.observeForever(itemsObserver)
        viewModel.user.observeForever(userObserver)

        // When
        viewModel.load()

        // Then
        verifySequence {
            loadObserver.onChanged(true)
            itemsObserver.onChanged(fakeItems)
            loadObserver.onChanged(false)
            userObserver.onChanged(fakeUser)
        }
    }
}
