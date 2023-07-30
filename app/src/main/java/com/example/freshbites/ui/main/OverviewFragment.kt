package com.example.freshbites.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.freshbites.R
import com.example.freshbites.databinding.TabOverviewFragmentBinding

class OverviewFragment: Fragment() {
    val binding get() = _binding!!
    private var _binding: TabOverviewFragmentBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val recipeOverviewData = arguments?.getStringArrayList("recipeOverviewData")
        _binding = TabOverviewFragmentBinding.inflate(inflater, container, false)
        binding.overviewText.text = recipeOverviewData?.get(4)
        binding.ratingBar.rating = recipeOverviewData?.get(2)!!.toFloat()
        binding.timeText.text = recipeOverviewData?.get(1)!!
        return binding.root

    }
}