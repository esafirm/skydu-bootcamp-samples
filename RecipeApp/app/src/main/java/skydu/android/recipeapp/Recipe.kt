package skydu.android.recipeapp

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(
    val name: String,
    @DrawableRes val image: Int,
    val isFavorite: Boolean,
    val isBookmark: Boolean,
    val recipeBahan: String = """
        1 Sendok Tepung Terigu
        2 Sendok Gula
        5 Gayung Air
        Seluruh cintaku padamu
    """.trimIndent(),
    val recipeCara: String = """
        1. Campur BOS, margarin dan gula halus dengan menggunakan mixer hingga tercampur.
        2. Tambahkan kuning telur lalu mixer kembali hingga tercampur.
        3. Masukkan tepung terigu, susu bubuk dan tepung pati jagung, aduk menggunakan spatula hingga semua tercampur rata dan dapat dibentuk.Ambil adonan lalu bentuk seperti bola-bola kecil (bisa dibentuk sesuai selera) hingga adonan habis. Sishikan.
        4. Tambahkan gula, kayu manis dan cengkeh. Aduk dan masak hingga menjadi selai. Sisihkan.Ambil bulatan adonan tadi, pipihkan lalu isi dengan selai nanas. Lalu bentuk kembali menjadi bola-bola kecil.
        5. Oleskan atasnya dengan kuning telur dan tancapkan 1 buah cengkeh setiap nastar. Panggang selama 40 menit pada suhu 175℃.
        6. Setelah matang, biarkan hingga dingin lalu masukkan dalam toples kesukaanmu.
    """.trimIndent()
) : BundleParam

interface BundleParam : Parcelable {

    companion object {
        const val BUNDLE_PARAM_PREFIX = "bp:"

        inline fun <reified T : BundleParam> fromBundle(bundle: Bundle?): T {
            val key = BUNDLE_PARAM_PREFIX + T::class.java.simpleName
            return bundle?.getParcelable<T>(key) ?: error("No value")
        }
    }

    private val bundleKey get() = BUNDLE_PARAM_PREFIX + this::class.java.simpleName

    fun toBundle(intent: Intent? = null): Bundle {
        return if (intent != null) {
            intent.putExtra(bundleKey, this)
            intent.extras ?: Bundle()
        } else {
            Bundle().apply {
                putParcelable(bundleKey, this)
            }
        }
    }
}