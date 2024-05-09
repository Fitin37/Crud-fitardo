package RecycleviewHelpers


import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import rodolfo.perez.crudfito1a.R

class Recycle (view: View):RecyclerView.ViewHolder(view){

    val textView: TextView = view.findViewById(R.id.txtProductos)
}