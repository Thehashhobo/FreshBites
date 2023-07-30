package com.example.freshbites

import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import androidx.annotation.RequiresApi
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.viewpager2.widget.ViewPager2
import com.example.freshbites.ui.main.RecipesAdapter
import com.example.freshbites.databinding.ActivityRecipeBinding
import com.example.freshbites.recyclerHome.subRecyclers.RecipeCardData
import com.google.android.material.tabs.TabLayoutMediator

class RecipeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecipeBinding
    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter: RecipesAdapter


    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        fun checkerOnclick(view: CardView){
//            val cardViewColor = (view.background as ColorDrawable).color
//            if (cardViewColor == getColor(R.color.green_Have_Ingredient)){
//                view.setCardBackgroundColor(getColor(R.color.red_No_Ingredient))
//            } else {
//                view.setCardBackgroundColor(getColor(R.color.green_Have_Ingredient))
//            }
//        }

        binding = ActivityRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val tabTitles = arrayOf("Overview", "Ingredients", "Instructions")
        val recipeData = intent.getParcelableExtra<RecipeCardData>("passed_data")
        // val tabIds = arrayOf<Int>(1300014, 1300012, 1300007)
        // watch for id collisions
        val tabLayout: TabLayout = findViewById(R.id.tabs)
        adapter = RecipesAdapter(this, supportFragmentManager, lifecycle, recipeData!!) //wrong?
        viewPager2 = binding.viewPager2
        viewPager2.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
        binding.title.text = recipeData.title

        val fab: FloatingActionButton = binding.fab
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Saved to favorites", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}