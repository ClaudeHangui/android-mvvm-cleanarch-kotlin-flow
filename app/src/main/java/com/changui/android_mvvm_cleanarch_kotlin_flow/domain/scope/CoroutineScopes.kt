package com.changui.android_mvvm_cleanarch_kotlin_flow.domain.scope

import kotlinx.coroutines.CoroutineScope

interface CoroutineScopes {
    val main: CoroutineScope
    val io: CoroutineScope
    val default: CoroutineScope
}