package kr.bound.plugintemplate

import com.google.inject.AbstractModule
import com.google.inject.Guice
import com.google.inject.Injector

class GuiceBootstrapper(
    private val plugin: PluginTemplate
) : AbstractModule() {
    fun createInjector(): Injector {
        return Guice.createInjector(this)
    }

    override fun configure() {
        this.bind(PluginTemplate::class.java).toInstance(plugin)
    }
}