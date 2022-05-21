package hu.anyrt.falatozo.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hu.anyrt.falatozo.Entity.DayEntity
import hu.anyrt.falatozo.R
import hu.anyrt.falatozo.data.Dao
import hu.anyrt.falatozo.data.Day
import hu.anyrt.falatozo.presentation.adapter.DayRecyclerAdapter


class HomeFragment : Fragment() {

    // Lista nézetek
    private lateinit var recyclerViewDays: RecyclerView
    private lateinit var recyclerViewMenu: RecyclerView

    // Képek a gombokhoz
    private lateinit var imageViewAddToBasket: ImageView
    private lateinit var imageViewClearBasket: ImageView
    private var menuDayList: ArrayList<Day> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Layout becsatolása
        val rootView: View? = inflater.inflate(R.layout.fragment_home, container, false)
        (activity as? MainActivity)?.supportActionBar?.title = getString(R.string.menuOrder)
        init(rootView)
        return rootView
    }

    /**
     * Beállítja az alapértékeket
     * @param rootView: A Fragmenthez tartozó nézet
     * */
    private fun init(rootView: View?) {
        initViews(rootView)
        initEvents()
        populateList()
    }

    private fun populateList() {
        // Minta lista elemek hozzáadása
        menuDayList.addAll(Dao().getDays())

        // lista feltöltése
        recyclerViewDays.adapter = DayRecyclerAdapter(
            requireContext(), menuDayList
        )
    }

    private fun initEvents() {
        imageViewAddToBasket.setOnClickListener {
            // a let lehetővé teszi, hogy hivatkozzunk az aktivitire.
            // ez lamda kifejezéskét működik
            activity?.let {
                // activity indítás
                it.startActivity(Intent(it, SettingsActivity::class.java))
            }
        }
    }

    /**
     * Beállítja a nézeteket a Fragmenthez
     * @param rootView: A Fragmenthez tartozó nézet
     * */
    private fun initViews(rootView: View?) {
        if (rootView != null) {
            // A fragmentekben kell a fő nézet az összekapcsoláshoz
            // ezért használjuk itt a rootView változót
            recyclerViewDays = rootView.findViewById(R.id.listViewDays)
            recyclerViewDays.layoutManager =
                LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
            recyclerViewMenu = rootView.findViewById(R.id.listViewMenu)
            imageViewAddToBasket = rootView.findViewById(R.id.imageViewAddToBascetMain)
            imageViewClearBasket = rootView.findViewById(R.id.imageViewClearBasketMain)
        }
    }
}