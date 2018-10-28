package io.revze.footballmatchschedule.view.matchlist.nextmatch

import com.google.gson.Gson
import io.revze.footballmatchschedule.api.ApiRepository
import io.revze.footballmatchschedule.api.Endpoint
import io.revze.footballmatchschedule.api.response.NextMatchResponse
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class NextMatchPresenter(private val view: NextMatchView,
                         private val apiRepository: ApiRepository,
                         private val gson: Gson) {
    fun getNextMatchList() {
        view.showLoading()

        async(UI) {
            val data = bg {
                gson.fromJson(apiRepository.doRequest(Endpoint().NEXT_EVENT_URL), NextMatchResponse::class.java)
            }

            view.showNextMatchList(data.await().nextMatch)
            view.hideLoading()
        }
     }
}