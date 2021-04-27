package com.changui.android_mvvm_cleanarch_kotlin_flow.domain

import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.scope.CoroutineDispatchers
import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.scope.CoroutineDispatchersImpl
import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.scope.CoroutineScopeImpl
import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.scope.CoroutineScopes
import org.koin.core.module.Module
import org.koin.dsl.module


val domainModule : Module = module {
    single<CoroutineScopes> { CoroutineScopeImpl() }
    single<CoroutineDispatchers> { CoroutineDispatchersImpl() }
    factory<GetQuestionListUseCase> { GetQuestionListUseCaseImpl(get()) }
}
