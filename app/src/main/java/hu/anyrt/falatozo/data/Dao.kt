package hu.anyrt.falatozo.data

import hu.anyrt.falatozo.Entity.DayEntity

class Dao {
    val dayBox = ObjectBox.get().boxFor(Day::class.java)

    fun addDay(day: Day){
        dayBox.put(day)
    }

    fun getDays() : ArrayList<Day>{
        return ArrayList(dayBox.all)
    }

    fun clearDays() {
        dayBox.removeAll()
    }
}