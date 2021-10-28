package com.example.rubricatelefonica.data

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.rubricatelefonica.R
import kotlinx.android.synthetic.main.riga.view.*

class RecuperaLista: RecyclerView.Adapter<RecuperaLista.ViewLista>(){
    private var nContatti= emptyList<Contatto>()

    class ViewLista(itemView:View): RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewLista {
        return ViewLista(LayoutInflater.from(parent.context).inflate(R.layout.riga,parent, false))
    }

    override fun getItemCount(): Int {
        return nContatti.size
    }

    override fun onBindViewHolder(holder:ViewLista, position: Int) {
        val c=nContatti[position]
        holder.itemView.nomec.text=c.nome
        holder.itemView.cognomec.text=c.cognome
        holder.itemView.numeroc.text=c.numero
        holder.itemView.emailc.text=c.email
        holder.itemView.riga_contatto.setOnClickListener{
            val context: Context = holder.itemView.context
            val dialogBuilder = AlertDialog.Builder(context)
            dialogBuilder.setMessage("Eliminare contatto?").setCancelable(false).setPositiveButton("Conferma", DialogInterface.OnClickListener{
                dialog,id -> Toast.makeText(context,"Eliminato",Toast.LENGTH_LONG).show()

            })
                .setNegativeButton("Annulla", DialogInterface.OnClickListener { dialog, id ->
                    Toast.makeText(context,"Operazione annullata",Toast.LENGTH_LONG).show()
                })
            val alert = dialogBuilder.create()
            alert.setTitle("Elimina")
            alert.show()
        }

    }
    fun setDati(contatti:List<Contatto>){
        this.nContatti=contatti
        notifyDataSetChanged()
    }
}

