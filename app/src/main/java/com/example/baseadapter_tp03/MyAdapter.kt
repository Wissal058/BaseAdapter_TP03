import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.baseadapter_tp03.R

class MyAdapter(private val context: Context, private val personnes: List<HashMap<String, String>>) : BaseAdapter() {

    override fun getCount(): Int = personnes.size

    override fun getItem(position: Int): Any = personnes[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.listview_items, parent, false)
        val personne = personnes[position]

        val nom = personne["nom"] ?: ""
        val prenom = personne["prenom"] ?: ""
        val age = personne["age"]?.toIntOrNull() ?: 0

        val textViewNom = view.findViewById<TextView>(R.id.textViewNom)
        textViewNom.text = "$prenom $nom"

        // Définir la couleur du texte en fonction de l'âge
        textViewNom.setTextColor(
            when {
                age < 18 -> Color.GREEN
                age > 60 -> Color.BLUE
                else -> Color.BLACK
            }
        )

        return view
    }
}
