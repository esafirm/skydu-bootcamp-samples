package skydu.android.recipeapp

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import skydu.android.recipeapp.databinding.ItemRecipeBinding

class RecipeViewHolder(
    val binding: ItemRecipeBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun setData(
        recipe: Recipe,
        onFavorite: () -> Unit,
        onBookmark: () -> Unit
    ) {
        val context = binding.root.context

        binding.txtName.text = recipe.name
        binding.imgRecipe.setImageResource(recipe.image)
        binding.btnBookmark.setOnClickListener { onBookmark() }
        binding.btnFavorite.setOnClickListener { onFavorite() }
        binding.btnShare.setOnClickListener { context.sendData(recipe) }

        if (recipe.isBookmark) {
            binding.btnBookmark.setColorFilter(ContextCompat.getColor(context, R.color.purple_700))
        } else {
            binding.btnBookmark.clearColorFilter()
        }

        if (recipe.isFavorite) {
            binding.btnFavorite.setColorFilter(ContextCompat.getColor(context, R.color.red))
        } else {
            binding.btnFavorite.clearColorFilter()
        }
    }

    private fun Context.sendData(recipe: Recipe) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, recipe.name)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}