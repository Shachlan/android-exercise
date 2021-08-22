package com.example.androidexercise1

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import android.widget.Toast




class Contact(val name:String, val phone:String, val imageURL: String, val email: String? = null )

class ContactsAdapter(private val contacts: Array<Contact>, private val contactSelected: (Contact) -> Unit) :
    RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val coreView:View

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.textView)
            coreView = view
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.contacts_item, viewGroup, false)
        val gradientDrawable = GradientDrawable(
            GradientDrawable.Orientation.LEFT_RIGHT,
            intArrayOf(
                Color.parseColor("#008000"),
                Color.parseColor("#ADFF2F"))
        );
        gradientDrawable.cornerRadius = 4f;

        //Set Gradient
        view.setBackground(gradientDrawable)
        view.getLayoutParams().height = 100;
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your contacts at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = contacts[position].name
        viewHolder.coreView.setOnClickListener(View.OnClickListener { view ->
            contactSelected(contacts[position])
        })
    }

    // Return the size of your contacts (invoked by the layout manager)
    override fun getItemCount() = contacts.size

}