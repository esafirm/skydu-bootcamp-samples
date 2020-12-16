package skydu.android.recipeapp

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import skydu.android.recipeapp.databinding.ActivityRecipeDetailBinding

class RecipeDetailActivty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityRecipeDetailBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        val recipe = BundleParam.fromBundle<Recipe>(intent.extras)

        binding.imgRecipe.setImageResource(recipe.image)
        binding.txtTitle.text = recipe.name

        binding.txtBahan.text = recipe.recipeBahan
        binding.txtCara.text = recipe.recipeCara

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}