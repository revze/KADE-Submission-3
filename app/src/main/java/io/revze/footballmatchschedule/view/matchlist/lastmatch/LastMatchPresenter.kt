package io.revze.footballmatchschedule.view.matchlist.lastmatch

import com.google.gson.Gson
import io.revze.footballmatchschedule.api.ApiRepository
import io.revze.footballmatchschedule.api.Endpoint
import io.revze.footballmatchschedule.api.response.LastMatchResponse
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class LastMatchPresenter(private val view: LastMatchView,
                         private val apiRepository: ApiRepository,
                         private val gson: Gson) {
    fun getLastMatchList() {
        view.showLoading()

        async(UI) {
            val data = bg {
                gson.fromJson(apiRepository.doRequest(Endpoint().LAST_EVENT_URL), LastMatchResponse::class.java)
            }

            view.showLastMatchList(data.await().lastMatch)
            view.hideLoading()
        }
    }
}