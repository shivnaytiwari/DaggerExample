package com.missingsemicollon.daggerexample.di

import com.missingsemicollon.daggerexample.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MyModule::class])
public interface ApplicationComponent {
    fun inject(activity: MainActivity)
}