package skydu.android.recipeapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import skydu.android.recipeapp.databinding.ActivtyRecipeBinding

class RecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivtyRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val padding = resources.getDimensionPixelSize(R.dimen.padding) / 4

        val onItemClick = { recipe: Recipe ->
            val intent = Intent(this, RecipeDetailActivty::class.java)
            recipe.toBundle(intent)

            startActivity(intent)
        }

        binding.recyclerView.run {
            clipToPadding = false
            setPadding(padding, padding, padding, padding)
            addItemDecoration(ItemOffsetDecoration(padding))

            layoutManager = GridLayoutManager(this@RecipeActivity, 2)
            adapter = RecipeAdapter(onItemClick).apply {
                submitData(getData())
            }
        }
    }

    private fun getData() = listOf(
        Recipe(
            name = "Kue Nastar",
            image = R.drawable.img_recipe1,
            isFavorite = false,
            isBookmark = false
        ),
        Recipe(
            name = "Putri Salju",
            image = R.drawable.img_recipe2,
            isFavorite = false,
            isBookmark = false
        ),
        Recipe(
            name = "Kastengel",
            image = R.drawable.img_recipe3,
            isFavorite = false,
            isBookmark = false
        ),
        Recipe(
            name = "Sagu Keju",
            image = R.drawable.img_recipe4,
            isFavorite = false,
            isBookmark = false
        ),
        Recipe(
            name = "Ayam Woku",
            image = R.drawable.img_recipe1,
            isFavorite = false,
            isBookmark = false
        ),
        Recipe(
            name = "Rendang Iga",
            image = R.drawable.img_recipe2,
            isFavorite = false,
            isBookmark = false
        ),
        Recipe(
            name = "Sup Labu Keju",
            image = R.drawable.img_recipe3,
            isFavorite = false,
            isBookmark = false
        ),
        Recipe(
            name = "Pasta a la Mamah",
            image = R.drawable.img_recipe4,
            isFavorite = false,
            isBookmark = false
        )
    )
}