package com.idn.recipecatalougeapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.idn.recipecatalougeapp.DetailActivity
import com.idn.recipecatalougeapp.data.Recipes
import com.idn.recipecatalougeapp.databinding.RowItemRecipeBinding

class RecipesAdapter(val listRecipes: ArrayList<Recipes>): RecyclerView.Adapter<RecipesAdapter.MyViewHolder>() {
    class MyViewHolder(val binding: RowItemRecipeBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder (
        RowItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            with(listRecipes[position]) {
                tvNameRecipe.text = name
                tvCategory.text = category
                tvPrice.text = price
                Glide.with(imgRecipe.context).load(photo).into(imgRecipe)
            }
        }
        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.RECIPES_DATA, listRecipes[position])
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount() = listRecipes.size

    }


