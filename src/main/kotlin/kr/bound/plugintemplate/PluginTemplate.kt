package kr.bound.plugintemplate

import org.mineacademy.fo.plugin.SimplePlugin

class PluginTemplate : SimplePlugin() {
    override fun onPluginStart() {
        val bootstrapper = GuiceBootstrapper(this)
        val injector = bootstrapper.createInjector()
        injector.injectMembers(this)
    }
}