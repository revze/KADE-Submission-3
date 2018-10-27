package io.revze.footballmatchschedule.view.matchlist.nextmatch

import io.revze.footballmatchschedule.model.NextMatch

interface NextMatchView {
    fun showLoading()
    fun hideLoading()
    fun showNextMatchList(data: List<NextMatch>)
}