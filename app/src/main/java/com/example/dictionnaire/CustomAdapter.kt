package com.example.dictionnaire
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_row.view.*

class CustomAdapter(val seanceslist : ArrayList<data>):RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return seanceslist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data: data = seanceslist[position]
        holder.text_nom.text = data.nom
        holder.text_details.text = data.detail
        holder.mes_seances = data
    }

    class ViewHolder(itmview: View, var mes_seances : data?=null): RecyclerView.ViewHolder(itmview) {

        init {
            itmview.setOnClickListener {
                //Toast.makeText(itmview.context, mes_seances?.nom, Toast.LENGTH_LONG).show()
                var myintent = Intent(itmview.context, detailsActivity::class.java)
                myintent.putExtra("nom", mes_seances?.nom)
                myintent.putExtra("det", mes_seances?.detail)
                itmview.context.startActivity(myintent)


            }
        }

        val text_nom = itmview.tx_name as TextView
        val text_details = itmview.tx_details as TextView
    }

}
