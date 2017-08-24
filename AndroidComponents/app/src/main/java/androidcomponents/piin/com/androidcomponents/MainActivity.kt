package androidcomponents.piin.com.androidcomponents

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidcomponents.piin.com.androidcomponents.Buttons.ButtonsActivity
import androidcomponents.piin.com.androidcomponents.ListView.ListViewActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onButtonClicked(view: View) {
        when (view.id) {
            R.id.listViews -> goToNextActivity(ListViewActivity::class.java)
            R.id.buttons -> goToNextActivity(ButtonsActivity::class.java)
            R.id.textViews -> Log.d("Button clicked","TextViews")
            else -> {
                Log.d("Error","You should not here")
            }
        }
    }

    private fun goToNextActivity(activity: Class<*>){
        val intent = Intent(this, activity)
        startActivity(intent)
    }

}
