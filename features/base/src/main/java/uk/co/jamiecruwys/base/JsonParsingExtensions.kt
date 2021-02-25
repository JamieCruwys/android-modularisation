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
package uk.co.jamiecruwys.base

import androidx.test.platform.app.InstrumentationRegistry
import com.google.gson.Gson
import timber.log.Timber
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.reflect.Type

inline fun <reified T> String.loadJson(type: Type = T::class.java): T = Gson().fromJson(loadString(), type)

fun String.loadString(): String {
    val returnString = StringBuilder()
    var reader: BufferedReader? = null
    try {
        reader = BufferedReader(
            InputStreamReader(InstrumentationRegistry.getInstrumentation().context.assets.open(this), "UTF-8")
        )
        var line: String?
        line = reader.readLine()
        while (line != null) {
            returnString.append(line)
            line = reader.readLine()
        }
    } catch (e: IOException) {
        Timber.e(e)
    } finally {
        if (reader != null) {
            try {
                reader.close()
            } catch (e: IOException) {
                Timber.e(e)
            }
        }
    }
    return returnString.toString()
}
