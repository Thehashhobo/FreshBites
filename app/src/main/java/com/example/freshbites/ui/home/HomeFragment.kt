package com.example.freshbites.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.freshbites.databinding.FragmentHomeBinding
import com.example.freshbites.recyclerHome.ItemAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome

        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        val itemAdapter = ItemAdapter(listOf())
        binding.innerRV.adapter = itemAdapter // assign the adapter to your RecyclerView
        binding.innerRV.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false) // assuming you want a vertical list of items

        // Observe the recipes LiveData in your ViewModel. When the recipe data changes, update the adapter.
        homeViewModel.items.observe(viewLifecycleOwner) { items ->
            itemAdapter.setItems(items)
            itemAdapter.notifyDataSetChanged()

        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}