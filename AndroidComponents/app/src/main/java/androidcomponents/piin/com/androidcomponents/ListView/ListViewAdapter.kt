package androidcomponents.piin.com.androidcomponents.ListView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidcomponents.piin.com.androidcomponents.R

/**
 * Created by jairpinedo on 23/08/17.
 */

class ListViewAdapter : BaseAdapter {

    private var inflater: LayoutInflater
    private var modelsToBeFilled: ArrayList<Model>
    private var listener: OnListViewDeleteButtonClicked

    constructor(modelsToBeFilled: ArrayList<Model>, context: Context, listener: OnListViewDeleteButtonClicked) {
        this.modelsToBeFilled = modelsToBeFilled
        this.listener = listener
        inflater = LayoutInflater.from(context)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        val myView: View = inflater.inflate(R.layout.row_item,null)

        //init view Components
        val image: ImageView = myView.findViewById(R.id.ivItemRow)
        val deleteButton: ImageView = myView.findViewById(R.id.ivButtonDelete)
        val name: TextView = myView.findViewById(R.id.tvNameRow)
        val description: TextView = myView.findViewById(R.id.tvDescriptionRow)

        image.setImageResource(modelsToBeFilled[position].getImage())
        name.text = modelsToBeFilled[position].getName()
        description.text = modelsToBeFilled[position].getDescription()

        deleteButton.setOnClickListener {

            if (listener != null) {
                listener.onDeleteButtonClicked(position)
            }

        }

        return myView

    }

    override fun getItem(position: Int): Any {
        return modelsToBeFilled[position]

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return modelsToBeFilled.size
    }

    /**
     * Callback to tell Activity when DeleteButton was clicked
     */
    interface OnListViewDeleteButtonClicked {
        fun onDeleteButtonClicked(position: Int)
    }


}