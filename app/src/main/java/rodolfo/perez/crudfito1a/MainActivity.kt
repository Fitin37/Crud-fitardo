package rodolfo.perez.crudfito1a

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import modelo.ClaseConexion

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtPrecio= findViewById<EditText>(R.id.txtPrecio)
        val txtNombre= findViewById<EditText>(R.id.txtNombreProducto)
        val txtCantidad = findViewById<EditText>(R.id.txtCantidad)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)

        btnAgregar.setOnClickListener {
             GlobalScope.launch(Dispatchers.IO){
                 //Guardar datos
                 //1- Crear un objeto de la clase conexion
                 val objConexion = ClaseConexion().cadenaConexion()

                 //2- Crear una variable que sea igual a un PreparaStateman
                 val addProducto = objConexion?.prepareStatement("insert into tbProductos1A values(?, ?, ?)")!!
                 addProducto.setString(1, txtNombre.text.toString())
                 addProducto.setInt(2,txtPrecio.text.toString().toInt())
                 addProducto.setInt(3,txtCantidad.text.toString().toInt())
                 addProducto.executeUpdate()
             }
        }
    }
}