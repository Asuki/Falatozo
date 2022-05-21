package hu.anyrt.falatozo.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hu.anyrt.falatozo.R
import hu.anyrt.falatozo.data.Day

/**
 * Összekapcsolja a napok listájához az adatokat és az egyedi nézetet
 * Lekezeli a kattintás efektet
 * @param context: A hívó activity -> this@HívóActivity
 * @param dataSet: Day típusú adathalmaz a napokról
 * */
class DayRecyclerAdapter(private val context: Context, private val dataSet: ArrayList<Day>) :
    RecyclerView.Adapter<DayRecyclerAdapter.DayViewHolder>() {
    // Ez fogja tartalmazni a layouthoz kapcsolódó nézeteket
    class DayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Létrehozzuk a változókat és hozzá kapcsoljuk akódhoz
        var textViewDay: TextView? = itemView.findViewById(R.id.textViewDay)
        var textViewDate: TextView? = itemView.findViewById(R.id.textViewDate)
    }

    /**
     * Összekapcsolja az előre elkészített nézetet és az adaptert
     * */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        return DayViewHolder(
            LayoutInflater
                .from(context)
                .inflate(
                    R.layout.day_list_item,
                    parent,
                    false
                )
        )
    }

    /**
     * Összekapcsolja a nézetet az adatokkal
     * @param holder: Az a viewholder, ami a programkódot tartalmazza a nézetek összekapcsolásához
     * @param position: A kiválasztott elem. Kattintáskor automatikusan érzékeli, hogy mire kattintottak
     * */
    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        val data = dataSet[position]
        holder.textViewDay?.text = data.day
        holder.textViewDate?.text = data.date
    }

    /**
     * Vissza adja a hívónak az elemszámot
     * */
    override fun getItemCount(): Int {
        return dataSet.size
    }


}