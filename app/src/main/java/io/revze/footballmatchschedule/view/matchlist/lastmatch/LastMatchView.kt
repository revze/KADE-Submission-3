package io.revze.footballmatchschedule.view.matchlist.lastmatch

import io.revze.footballmatchschedule.model.LastMatch

interface LastMatchView {
    fun showLoading()
    fun hideLoading()
    fun showLastMatchList(data: List<LastMatch>)
}