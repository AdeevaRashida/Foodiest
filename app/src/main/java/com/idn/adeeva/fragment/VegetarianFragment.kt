package com.idn.adeeva.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.idn.adeeva.adapter.RecipesAdaptor
import com.idn.adeeva.databinding.FragmentVegetarianBinding
import com.idn.adeeva.model.DataRecipes
import com.idn.adeeva.model.Recipes

class VegetarianFragment : Fragment() {
    private lateinit var vegetarianBinding: FragmentVegetarianBinding
    private var list : ArrayList<Recipes> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vegetarianBinding = FragmentVegetarianBinding.inflate(inflater, container, false)
        return vegetarianBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        list.addAll(DataRecipes.dataVegetarian)
        vegetarianBinding.rvVegetarian.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2)
            val recipesAdaptor = RecipesAdaptor(list)
            adapter = recipesAdaptor
        }
    }
}