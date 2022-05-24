package hu.anyrt.falatozo.data

import hu.anyrt.falatozo.data.entity.Day
import hu.anyrt.falatozo.data.entity.User
import io.objectbox.Box


class Dao {
    val dayBox = ObjectBox.get().boxFor(Day::class.java)
    var userBox: Box<User> = ObjectBox.get().boxFor(User::class.java)

    fun addDay(day: Day){
        val id = dayBox.put(day)
    }

    fun getDays() : ArrayList<Day>{
        return ArrayList(dayBox.all)
    }

    fun clearDays() {
        dayBox.removeAll()
    }

    /**
     * Törli a felhasználókat és hozzá ad egy újat
     * @param user: A  hozzáadni kívánt felhasználó
     * */
    fun addUser(user: User){
        userBox.removeAll()
        userBox.put(user)
    }

    fun getActiveUser(): User{
        return userBox.all[0]
    }
}