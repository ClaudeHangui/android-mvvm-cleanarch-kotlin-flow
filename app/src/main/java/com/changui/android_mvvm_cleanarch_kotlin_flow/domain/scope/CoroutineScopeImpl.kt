package com.changui.android_mvvm_cleanarch_kotlin_flow.domain.scope

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class CoroutineScopeImpl(
    override val main: CoroutineScope = CoroutineScope(Dispatchers.Main + SupervisorJob()),
    override val io: CoroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
    override val default: CoroutineScope = CoroutineScope(Dispatchers.Default + SupervisorJob())
): CoroutineScopes