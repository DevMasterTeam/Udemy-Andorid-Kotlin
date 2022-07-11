package com.devmasterteam.convidados.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.devmasterteam.convidados.databinding.FragmentPresentBinding
import com.devmasterteam.convidados.service.constants.GuestConstants
import com.devmasterteam.convidados.view.adapter.GuestAdapter
import com.devmasterteam.convidados.view.listener.GuestListener
import com.devmasterteam.convidados.viewmodel.GuestsViewModel

class PresentFragment : Fragment() {

    private lateinit var viewModel: GuestsViewModel
    private var _binding: FragmentPresentBinding? = null
    private val adapter: GuestAdapter = GuestAdapter()
    private lateinit var listener: GuestListener

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        // Instâncias da classe
        viewModel = ViewModelProvider(this).get(GuestsViewModel::class.java)
        _binding = FragmentPresentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // RecyclerView
        val recycler = binding.recyclerPresents
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = adapter

        // Listener
        listener = object : GuestListener {
            override fun onClick(id: Int) {
                val intent = Intent(context, GuestFormActivity::class.java)

                val bundle = Bundle()
                bundle.putInt(GuestConstants.GUEST.ID, id)

                intent.putExtras(bundle)
                startActivity(intent)
            }

            override fun onDelete(id: Int) {
                viewModel.delete(id)
                viewModel.load(GuestConstants.FILTER.PRESENT)
            }
        }

        // Cria os observadores
        observe()

        adapter.attachListener(listener)
        return root
    }

    override fun onResume() {
        super.onResume()
        viewModel.load(GuestConstants.FILTER.PRESENT)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observe() {
        viewModel.guestList.observe(viewLifecycleOwner) {
            adapter.updateGuests(it)
        }
    }
}