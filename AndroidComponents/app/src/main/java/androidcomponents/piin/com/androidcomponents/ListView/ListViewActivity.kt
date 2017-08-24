package androidcomponents.piin.com.androidcomponents.ListView

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ListView
import androidcomponents.piin.com.androidcomponents.R

class ListViewActivity : AppCompatActivity(),ListViewAdapter.OnListViewDeleteButtonClicked {

    private lateinit var adapter: ListViewAdapter
    private lateinit var dataToBePopulate: ArrayList<Model>
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        findViews()
        initComponents()
    }

    /**
     * Find listView in the layout.
     */
    private fun findViews(){
        listView = findViewById(R.id.listView)
    }


    private fun initComponents(){
        dataToBePopulate = getDummyData()
        adapter = ListViewAdapter(dataToBePopulate, this, this)
        listView.adapter = adapter

    }

    override fun onDeleteButtonClicked(position: Int) {
        removeItem(position)
    }

    /**
     * Removes item at current position
     * @param position
     */
    private fun removeItem(position: Int){
        dataToBePopulate.removeAt(position)
        adapter.notifyDataSetChanged()
    }

    /**
     * Adds new item in the list
     */
    private fun addNewItem(){
        dataToBePopulate.add(Model(R.mipmap.ic_launcher, "New Name", "New Description"))
        adapter.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.list_view_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.action_add -> {
                addNewItem()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun getDummyData(): ArrayList<Model>{
        val dummyModels = ArrayList<Model>()

        (1..5).mapTo(dummyModels) {
            Model(R.mipmap.ic_launcher_round, "Name: " + it, "Description: " + it)
        }

        return dummyModels
    }

}
