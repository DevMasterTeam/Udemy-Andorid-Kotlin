package com.devmasterteam.convidados.view.viewholder

import android.app.AlertDialog
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devmasterteam.convidados.R
import com.devmasterteam.convidados.databinding.RowGuestBinding
import com.devmasterteam.convidados.service.model.GuestModel
import com.devmasterteam.convidados.view.listener.GuestListener

class GuestViewHolder(
    private val itemBinding: RowGuestBinding, private val listener: GuestListener
) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(guest: GuestModel) {

        // Atribui valores
        itemBinding.textName.text = guest.name

        // Atribui eventos
        itemBinding.textName.setOnClickListener {
            listener.onClick(guest.id)
        }

        // Atribui eventos
        itemBinding.textName.setOnLongClickListener {
            AlertDialog.Builder(itemView.context)
                .setTitle(R.string.remocao_convidado)
                .setMessage(R.string.deseja_remover)
                .setPositiveButton(R.string.remover) { dialog, which ->
                    listener.onDelete(guest.id)
                }
                .setNeutralButton(R.string.cancelar, null)
                .show()

            true
        }
    }
}