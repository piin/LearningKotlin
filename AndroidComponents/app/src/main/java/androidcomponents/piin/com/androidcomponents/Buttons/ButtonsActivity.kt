package androidcomponents.piin.com.androidcomponents.Buttons

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
import androidcomponents.piin.com.androidcomponents.R

class ButtonsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buttons)
    }

    open fun onButtonClicked(view: View){
        when (view.id) {
            (R.id.button) -> showToast("Button clicked")
            (R.id.toggleButton) -> {
                val toggleButton = findViewById<ToggleButton>(R.id.toggleButton)
                showToast("ToggleButton value : " + toggleButton.isChecked)
            }

        }
    }

    private fun showToast(msg: String){
        val toast = Toast.makeText(this,msg,Toast.LENGTH_SHORT)
        toast.show()
    }

}
