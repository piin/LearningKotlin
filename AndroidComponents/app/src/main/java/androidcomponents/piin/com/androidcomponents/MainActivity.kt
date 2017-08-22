package androidcomponents.piin.com.androidcomponents

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidcomponents.piin.com.androidcomponents.Buttons.ButtonsActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onButtonClicked(view: View) {
        when (view.id) {
            (R.id.buttons) -> goToNextActivity(ButtonsActivity::class.java)
            (R.id.textViews) -> Log.d("Button clicked","TextViews")
        }
    }

    private fun goToNextActivity(activity: Class<*>){
        val intent = Intent(this, activity)
        startActivity(intent)
    }

}
