package com.devmasterteam.tasks.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.app.DatePickerDialog
import android.view.View
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import androidx.activity.viewModels
import com.devmasterteam.tasks.R
import com.devmasterteam.tasks.databinding.ActivityTaskFormBinding
import com.devmasterteam.tasks.service.constants.TaskConstants
import com.devmasterteam.tasks.service.model.PriorityModel
import com.devmasterteam.tasks.service.model.TaskModel
import com.devmasterteam.tasks.viewmodel.TaskFormViewModel
import java.text.SimpleDateFormat
import java.util.*

class TaskFormActivity : AppCompatActivity(), View.OnClickListener,
    DatePickerDialog.OnDateSetListener {

    private val viewModel: TaskFormViewModel by viewModels()
    private val binding: ActivityTaskFormBinding by lazy {
        ActivityTaskFormBinding.inflate(layoutInflater)
    }
    private val dateFormat = SimpleDateFormat("dd/MM/yyyy")
    private var listPriority: List<PriorityModel> = mutableListOf()
    private var taskId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        supportActionBar?.hide()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left + binding.root.paddingStart,
                systemBars.top,
                systemBars.right + binding.root.paddingEnd,
                systemBars.bottom
            )
            insets
        }

        // Eventos
        binding.buttonSave.setOnClickListener(this)
        binding.buttonDate.setOnClickListener(this)

        // Carrega dados da Actvity - Se existirem
        loadDataFromActivity()

        // Observadores
        observe()
    }

    /**
     * Responde aos eventos de click
     * */
    override fun onClick(v: View) {
        if (v.id == R.id.button_date) {
            handleDate()
        } else if (v.id == R.id.button_save) {
            handleSave()
        }
    }

    /**
     * Responde ao evento de data selecionada
     * */
    override fun onDateSet(v: DatePicker, year: Int, month: Int, dayOfMonth: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)

        val dueDate = dateFormat.format(calendar.time)
        binding.buttonDate.text = dueDate
    }

    /**
     * Carrega dados da Actvity - Se existirem
     * Caso existe, trata-se de edição
     * */
    private fun loadDataFromActivity() {
        val bundle = intent.extras
        if (bundle != null) {
            taskId = bundle.getInt(TaskConstants.BUNDLE.TASKID)
            viewModel.load(taskId)
        }
    }

    /**
     * Retorna o índice correspondente ao ID de prioridade fornecido.
     * Utilizado para selecionar o item correto no Spinner.
     */
    private fun getIndex(priorityId: Int): Int {
        var index = 0
        for (l in listPriority) {
            if (l.id == priorityId) {
                break
            }
            index++
        }
        return index
    }

    /**
     * Observadores - Diz como a aplicação vai responder em caso de mudanças
     */
    private fun observe() {
        viewModel.priorityList.observe(this) {
            listPriority = it
            val list = mutableListOf<String>()
            for (p in it) {
                list.add(p.description)
            }
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, list)
            binding.spinnerPriority.adapter = adapter
        }

        viewModel.taskSave.observe(this) {
            if (it.status()) {
                if (taskId == 0) {
                    toast(getString(R.string.msg_task_created))
                } else {
                    toast(getString(R.string.msg_task_updated))
                }
                finish()
            } else {
                toast(it.message())
            }
        }

        viewModel.task.observe(this) {
            binding.editDescription.setText(it.description)
            binding.checkComplete.isChecked = it.complete
            binding.spinnerPriority.setSelection(getIndex(it.priorityId))

            val date = SimpleDateFormat("yyyy-MM-dd").parse(it.dueDate)
            binding.buttonDate.text = SimpleDateFormat("dd/MM/yyyy").format(date)
            binding.buttonSave.text = getString(R.string.button_update_task)
        }

        viewModel.taskLoad.observe(this) {
            if (!it.status()) {
                toast(it.message())
                finish()
            }
        }
    }

    /**
     * Exibe um Toast com a mensagem fornecida.
     */
    private fun toast(str: String) {
        Toast.makeText(applicationContext, str, Toast.LENGTH_SHORT).show()
    }

    /**
     * Coleta os dados preenchidos no formulário, cria um modelo da tarefa e chama a ViewModel
     * para salvar os dados.
     */
    private fun handleSave() {
        val task = TaskModel().apply {
            this.id = taskId
            this.description = binding.editDescription.text.toString()
            this.complete = binding.checkComplete.isChecked
            this.dueDate = binding.buttonDate.text.toString()

            val index = binding.spinnerPriority.selectedItemPosition
            this.priorityId = listPriority[index].id
        }

        viewModel.save(task)
    }

    /**
     * Exibe um DatePickerDialog para o usuário selecionar uma data com o padrão seleciondo para hoje.
     */
    private fun handleDate() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this, this, year, month, day).show()
    }
}