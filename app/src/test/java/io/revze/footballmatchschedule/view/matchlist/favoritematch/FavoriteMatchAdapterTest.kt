package io.revze.footballmatchschedule.view.matchlist.favoritematch

import org.junit.Assert.*
import org.junit.Test
import java.text.ParseException
import java.text.SimpleDateFormat

class FavoriteMatchAdapterTest {
    fun dateConverter(date: String): String {
        try {
            val sourceDF = SimpleDateFormat("yyyy-MM-dd")
            val parseSrcDate = sourceDF.parse(date)
            val finalDF = SimpleDateFormat("EEE, dd MM yyyy")
            return finalDF.format(parseSrcDate)
        }
        catch (e: ParseException) {
            return date
        }
    }

    @Test
    fun testDateConverter() {
        assertEquals("19 May 1999", dateConverter("1999-05-19"))
    }

    @Test
    fun testDateConverter2() {
        assertEquals("19 May 2000", dateConverter("2000-05-19"))
    }
}