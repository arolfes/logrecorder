/*
 * Copyright 2017-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package info.novatec.testit.logrecorder.assertion

import info.novatec.testit.logrecorder.api.LogRecord

@DslContext
class LogRecordAssertion(
    private val logRecord: LogRecord
) {

    private val blocks = mutableListOf<AssertionBlock>()

    @Deprecated("replaced with extension function `containsExactly`")
    fun containsInOrder(block: ContainsExactly.() -> Unit) =
        addAssertionBlock(ContainsExactly().apply(block))

    fun addAssertionBlock(block: AssertionBlock) {
        blocks.add(block)
    }

    private fun check() {
        blocks.forEach { it.check(logRecord) }
    }

    companion object {
        fun assertThat(logRecord: LogRecord, block: LogRecordAssertion.() -> Unit) {
            LogRecordAssertion(logRecord).apply(block).check()
        }
    }
}
