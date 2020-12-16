package skydu.android.recipeapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import skydu.android.recipeapp.databinding.ItemRecipeBinding

class RecipeAdapter(
    private val onItemClick: (Recipe) -> Unit
) : RecyclerView.Adapter<RecipeViewHolder>() {

    private val recipes: MutableList<Recipe> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return RecipeViewHolder(ItemRecipeBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.setData(
            recipe = recipe,
            onFavorite = { toggleFavorite(position) },
            onBookmark = { toggleBookmark(position)}
        )
        holder.binding.root.setOnClickListener {
            onItemClick(recipe)
        }
    }

    private fun toggleFavorite(pos: Int) {
        val current = recipes[pos]
        recipes[pos] = current.copy(isFavorite = !current.isFavorite)
        notifyItemChanged(pos)
    }

    private fun toggleBookmark(pos: Int) {
        val current = recipes[pos]
        recipes[pos] = current.copy(isBookmark = !current.isBookmark)
        notifyItemChanged(pos)
    }

    override fun getItemCount(): Int = recipes.size

    fun submitData(data: List<Recipe>) {
        recipes.clear()
        recipes.addAll(data)
        notifyDataSetChanged()
    }
}