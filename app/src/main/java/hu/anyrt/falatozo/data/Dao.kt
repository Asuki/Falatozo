package hu.anyrt.falatozo.data

import android.util.Log


class Dao {
    val dayBox = ObjectBox.get().boxFor(Day::class.java)

    fun addDay(day: Day){
        val id = dayBox.put(day)
    }

    fun getDays() : ArrayList<Day>{
        return ArrayList(dayBox.all)
    }

    fun clearDays() {
        dayBox.removeAll()
    }
}