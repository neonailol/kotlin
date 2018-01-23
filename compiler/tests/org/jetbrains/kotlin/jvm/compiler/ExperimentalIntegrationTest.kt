/*
 * Copyright 2000-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.jvm.compiler

import org.jetbrains.kotlin.cli.js.K2JSCompiler
import java.io.File

class ExperimentalIntegrationTest : AbstractKotlinCompilerIntegrationTest() {
    override val testDataPath: String
        get() = "compiler/testData/experimental/"

    fun testJvmExperimentalModule() {
        val lib = compileLibrary("lib", additionalOptions = listOf("-Xexperimental=lib.ExperimentalAPI"))
        compileKotlin("usage.kt", tmpdir, listOf(lib))
    }

    fun testJsExperimentalModule() {
        val lib = compileJsLibrary("lib", additionalOptions = listOf("-Xexperimental=lib.ExperimentalAPI"))
        compileKotlin("usage.kt", File(tmpdir, "usage.js"), listOf(lib), K2JSCompiler())
    }
}
