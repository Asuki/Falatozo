package hu.anyrt.falatozo.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import hu.anyrt.falatozo.R

class HomeFragment : Fragment() {

    private lateinit var listViewDays: ListView
    private lateinit var listViewMenu: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        (activity as? MainActivity)?.supportActionBar?.title = getString(R.string.menuOrder)
        initViews(rootView)
        return rootView
    }

    private fun initViews(rootView: View?) {
        if(rootView != null) {
            listViewDays = rootView.findViewById(R.id.listViewDays)
            listViewMenu = rootView.findViewById(R.id.listViewMenu)
        }
    }
}