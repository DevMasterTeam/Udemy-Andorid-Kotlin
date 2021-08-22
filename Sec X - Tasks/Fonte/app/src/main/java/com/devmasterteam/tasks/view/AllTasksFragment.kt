package com.devmasterteam.tasks.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.devmasterteam.tasks.R
import com.devmasterteam.tasks.databinding.FragmentAllTasksBinding
import com.devmasterteam.tasks.service.constants.TaskConstants
import com.devmasterteam.tasks.service.listener.TaskListener
import com.devmasterteam.tasks.view.adapter.TaskAdapter
import com.devmasterteam.tasks.viewmodel.TaskListViewModel

class AllTasksFragment : Fragment() {

    private lateinit var mViewModel: TaskListViewModel
    private var _binding: FragmentAllTasksBinding? = null
    private val binding get() = _binding!!

    private lateinit var mListener: TaskListener
    private val mAdapter = TaskAdapter()
    private var mTaskFilter = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        mViewModel = ViewModelProvider(this).get(TaskListViewModel::class.java)
        _binding = FragmentAllTasksBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Filtro de tarefas
        mTaskFilter = requireArguments().getInt(TaskConstants.BUNDLE.TASKFILTER, 0)

        val recycler = binding.recyclerAllTasks
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = mAdapter

        mListener = object : TaskListener {
            override fun onListClick(id: Int) {
                val intent = Intent(context, TaskFormActivity::class.java)
                val bundle = Bundle()
                bundle.putInt(TaskConstants.BUNDLE.TASKID, id)
                intent.putExtras(bundle)
                startActivity(intent)
            }

            override fun onDeleteClick(id: Int) {
                mViewModel.deleteTask(id)
            }

            override fun onCompleteClick(id: Int) {
                mViewModel.completeTask(id)
            }

            override fun onUndoClick(id: Int) {
                mViewModel.undoTask(id)
            }
        }

        // Cria os observadores
        observe()

        return root
    }

    override fun onResume() {
        super.onResume()
        mAdapter.attachListener(mListener)
        mViewModel.list(mTaskFilter)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observe() {
        mViewModel.taskList.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                mAdapter.updateList(it)
            }
        })

        mViewModel.validation.observe(viewLifecycleOwner, Observer {
            if (it.success()) {
                Toast.makeText(context, R.string.task_removed, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, it.failure(), Toast.LENGTH_SHORT).show()
            }
        })
    }
}