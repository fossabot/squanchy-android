package net.squanchy.analytics

import com.crashlytics.android.Crashlytics

import net.squanchy.BuildConfig

import timber.log.Timber

class CrashlyticsErrorsTree : Timber.Tree() {

    override fun isLoggable(tag: String?, priority: Int) = true

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (t != null && canLog) {
            Crashlytics.logException(t)
        }
    }

    companion object {

        private val canLog = !BuildConfig.DEBUG
    }
}
