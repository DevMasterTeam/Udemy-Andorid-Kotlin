package com.devmasterteam.tasks.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.devmasterteam.tasks.databinding.FragmentAllTasksBinding
import com.devmasterteam.tasks.service.constants.TaskConstants
import com.devmasterteam.tasks.view.adapter.TaskAdapter
import com.devmasterteam.tasks.viewmodel.TaskListViewModel

class AllTasksFragment : Fragment() {

    private val viewModel: TaskListViewModel by viewModels()
    private var _binding: FragmentAllTasksBinding? = null
    private val binding get() = _binding!!

    private val adapter = TaskAdapter()
    private var taskFilter = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View {
        _binding = FragmentAllTasksBinding.inflate(inflater, container, false)

        binding.recyclerAllTasks.layoutManager = LinearLayoutManager(context)
        binding.recyclerAllTasks.adapter = adapter

        taskFilter = requireArguments().getInt(TaskConstants.BUNDLE.TASKFILTER, 0)

        // Cria os observadores
        observe()

        return binding.root
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observe() {
    }
}