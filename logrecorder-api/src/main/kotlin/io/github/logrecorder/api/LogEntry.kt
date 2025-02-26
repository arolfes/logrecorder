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
package io.github.logrecorder.api


/**
 * Contains the data of a single entry of the recorded log.
 *
 * Includes the following data:
 *
 * - the name of the logger ([logger])
 * - the [level][LogLevel] on which the entry was logged ([level])
 * - the (formatted) message ([message])
 * - the optional log marker ([marker])
 *
 * @since 1.0
 * @see LogLevel
 */
data class LogEntry @JvmOverloads constructor(
    val logger: String,
    val level: LogLevel,
    val message: String,
    val marker: String? = null
)
