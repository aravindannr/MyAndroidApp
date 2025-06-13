import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.R

class HomeFragment : Fragment(R.layout.fragment_home) {
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val container = view.findViewById<LinearLayout>(R.id.cardContainer)
        repeat(9) {
            val card = LayoutInflater.from(context).inflate(R.layout.item_card, container, false)
            val textView = card.findViewById<TextView>(R.id.cardText)
            textView.text = "Card Item ${it + 1}"
            container.addView(card)
        }
    }
}
