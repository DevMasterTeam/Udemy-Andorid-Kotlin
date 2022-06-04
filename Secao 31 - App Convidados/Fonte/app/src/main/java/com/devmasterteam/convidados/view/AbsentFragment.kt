package com.devmasterteam.convidados.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.devmasterteam.convidados.databinding.FragmentAbsentBinding
import com.devmasterteam.convidados.service.constants.GuestConstants
import com.devmasterteam.convidados.view.adapter.GuestAdapter
import com.devmasterteam.convidados.view.listener.GuestListener
import com.devmasterteam.convidados.viewmodel.GuestsViewModel

class AbsentFragment : Fragment() {

    private var _binding: FragmentAbsentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: GuestsViewModel
    private val adapter = GuestAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View {

        viewModel = ViewModelProvider(this).get(GuestsViewModel::class.java)
        _binding = FragmentAbsentBinding.inflate(inflater, container, false)

        // Atribui um layout que diz como a RecyclerView se comporta
        binding.recyclerAbsents.layoutManager = LinearLayoutManager(context)

        // Define um adapater - Faz a ligação da RecyclerView com a listagem de itens
        binding.recyclerAbsents.adapter = adapter

        // Cria comportamento quando item for clicado
        val listener = object : GuestListener {
            override fun onClick(id: Int) {
                // Intenção
                val intent = Intent(context, GuestFormActivity::class.java)

                // "Pacote" de valores que serão passados na navegação
                val bundle = Bundle()
                bundle.putInt(GuestConstants.GUEST.ID, id)

                // Atribui o pacote a Intent
                intent.putExtras(bundle)

                // Inicializa Activity com dados
                startActivity(intent)
            }

            override fun onDelete(id: Int) {
                viewModel.delete(id)
                viewModel.getAbsent()
            }
        }

        // Cria os observadores
        observe()

        adapter.attachListener(listener)
        return binding.root
    }

    /**
     * Ciclo de vida - onResume
     */
    override fun onResume() {
        super.onResume()
        viewModel.getAbsent()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     * Cria os observadores
     */
    private fun observe() {
        viewModel.guestList.observe(viewLifecycleOwner) {
            adapter.updateGuests(it)
        }
    }
}