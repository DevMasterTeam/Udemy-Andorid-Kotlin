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

    private lateinit var viewModel: GuestsViewModel
    private val adapter: GuestAdapter = GuestAdapter()
    private lateinit var listener: GuestListener
    private var _binding: FragmentAbsentBinding? = null

    // Propriedade somente válida entre onCreateView e onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View {

        viewModel = ViewModelProvider(this).get(GuestsViewModel::class.java)
        _binding = FragmentAbsentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Elemento de interface - RecyclerView
        // Não é possível deixar o Kotlin fazer o mapeamento, pois a fragment ainda não está totalmente criada
        // Assim, precisamos buscar o elemento através de findViewById
        val recycler = binding.recyclerAbsents

        // Atribui um layout que diz como a RecyclerView se comporta
        recycler.layoutManager = LinearLayoutManager(context)

        // Defini um adapater - Faz a ligação da RecyclerView com a listagem de itens
        recycler.adapter = adapter

        // Cria comportamento quando item for clicado
        listener = object : GuestListener {
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
                viewModel.load(GuestConstants.FILTER.ABSENT)
            }
        }

        // Cria os observadores
        observe()

        adapter.attachListener(listener)
        return root
    }

    /**
     * Ciclo de vida - onResume
     */
    override fun onResume() {
        super.onResume()
        viewModel.load(GuestConstants.FILTER.ABSENT)
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