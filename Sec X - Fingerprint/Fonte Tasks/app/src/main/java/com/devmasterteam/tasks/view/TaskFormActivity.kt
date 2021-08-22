package com.devmasterteam.tasks.view

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.devmasterteam.tasks.R
import com.devmasterteam.tasks.databinding.ActivityTaskFormBinding
import com.devmasterteam.tasks.service.constants.TaskConstants
import com.devmasterteam.tasks.service.model.TaskModel
import com.devmasterteam.tasks.viewmodel.TaskFormViewModel
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class TaskFormActivity : AppCompatActivity(), View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private lateinit var mViewModel: TaskFormViewModel
    private lateinit var binding: ActivityTaskFormBinding
    private val mPriorityListId: MutableList<Int> = arrayListOf()
    private val mDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
    private var mTaskId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Variáveis da classe
        mViewModel = ViewModelProvider(this).get(TaskFormViewModel::class.java)
        binding = ActivityTaskFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Eventos
        binding.buttonSave.setOnClickListener(this)
        binding.buttonDate.setOnClickListener(this)

        // Observadores
        observe()

        // Carrega dados passados para a activity
        loadDataFromActivity()
        mViewModel.loadPriorities()
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)

        val strDate: String = mDateFormat.format(calendar.time)
        binding.buttonDate.text = strDate
    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.button_date) {
            showDateDialog()
        } else if (id == R.id.button_save) {
            handleSave()
        }
    }

    private fun observe() {
        // Carregamento de tarefa
        mViewModel.task.observe(this, Observer {

            // Caso ocorra algum erro no carregamento
            if (it == null) {
                toast(applicationContext.getString(R.string.ERROR_LOAD_TASK))
                finish()
            } else {
                binding.editDescription.setText(it.description)
                binding.checkComplete.isChecked = it.complete
                binding.spinnerPriority.setSelection(getIndex(it.priorityId))

                val date = SimpleDateFormat("yyyy-MM-dd").parse(it.dueDate)
                binding.buttonDate.text = mDateFormat.format(date)
            }
        })

        mViewModel.priorityList.observe(this, Observer {
            val list: MutableList<String> = ArrayList()
            for (p in it) {
                list.add(p.description)
                mPriorityListId.add(p.id)
            }

            // Cria adapter e usa no elemento
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, list)
            binding.spinnerPriority.adapter = adapter
        })

        mViewModel.validation.observe(this, Observer {
            if (it.success()) {
                if (mTaskId == 0) {
                    toast(applicationContext.getString(R.string.task_created))
                } else {
                    toast(applicationContext.getString(R.string.task_updated))
                }
                finish()
            } else {
                toast(it.failure())
            }
        })
    }

    /**
     * Obtém o indexo do valor carregado
     */
    private fun getIndex(priorityId: Int): Int {
        var index = 0
        for (i in 0 until mPriorityListId.count()) {
            if (mPriorityListId[i] == priorityId) {
                index = i
                break
            }
        }
        return index
    }

    private fun loadDataFromActivity() {
        val bundle = intent.extras;
        if (bundle != null) {
            mTaskId = bundle.getInt(TaskConstants.BUNDLE.TASKID, 0)

            // Carrega tarefa
            if (this.mTaskId != 0) {
                binding.buttonSave.setText(R.string.update_task)
                mViewModel.load(mTaskId)
            }
        }
    }

    /**
     * Trata click
     */
    private fun handleSave() {
        val task = TaskModel().apply {
            this.id = mTaskId
            this.description = binding.editDescription.text.toString()
            this.complete = binding.checkComplete.isChecked
            this.dueDate = binding.buttonDate.text.toString()
            this.priorityId = mPriorityListId[binding.spinnerPriority.selectedItemPosition]
        }

        // Envia informação para ViewModel
        mViewModel.save(task)
    }

    /**
     * Mostra datepicker de seleção
     */
    private fun showDateDialog() {
        val c: Calendar = Calendar.getInstance()
        val year: Int = c.get(Calendar.YEAR)
        val month: Int = c.get(Calendar.MONTH)
        val day: Int = c.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this, this, year, month, day).show()
    }

    private fun toast(str: String) {
        Toast.makeText(applicationContext, str, Toast.LENGTH_SHORT).show()
    }
}