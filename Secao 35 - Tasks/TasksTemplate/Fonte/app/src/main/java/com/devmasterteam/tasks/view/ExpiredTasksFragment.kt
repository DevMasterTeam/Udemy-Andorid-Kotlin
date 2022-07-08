package com.devmasterteam.tasks.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.devmasterteam.tasks.databinding.FragmentExpiredTasksBinding
import com.devmasterteam.tasks.viewmodel.TaskListViewModel

class ExpiredTasksFragment : Fragment() {

    private lateinit var slideshowViewModel: TaskListViewModel
    private var _binding: FragmentExpiredTasksBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        slideshowViewModel = ViewModelProvider(this).get(TaskListViewModel::class.java)

        _binding = FragmentExpiredTasksBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSlideshow
        slideshowViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}