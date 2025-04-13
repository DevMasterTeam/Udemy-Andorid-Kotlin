package com.devmasterteam.tasks.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.devmasterteam.tasks.service.constants.TaskConstants
import com.devmasterteam.tasks.service.model.TaskModel
import com.devmasterteam.tasks.service.model.ValidationModel
import com.devmasterteam.tasks.service.repository.PriorityRepository
import com.devmasterteam.tasks.service.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskListViewModel(private val application: Application) : BaseAndroidViewModel(application) {

    // Repositórios responsáveis por tarefas e prioridades
    private val taskRepository = TaskRepository(application.applicationContext)
    private val priorityRepository = PriorityRepository(application.applicationContext)

    // Armazena o filtro atual aplicado na listagem de tarefas (TODAS, PRÓXIMAS, ATRASADAS)
    private var taskFilter = 0

    private val _tasks = MutableLiveData<List<TaskModel>>()
    val tasks: LiveData<List<TaskModel>> = _tasks

    private val _delete = MutableLiveData<ValidationModel>()
    val delete: LiveData<ValidationModel> = _delete

    private val _status = MutableLiveData<ValidationModel>()
    val status: LiveData<ValidationModel> = _status

    private val _error = MutableLiveData<ValidationModel>()
    val error: LiveData<ValidationModel> = _error

    /**
     * Carrega a lista de tarefas com base no filtro informado.
     * O filtro pode ser: todas, próximas ou atrasadas.
     */
    fun list(filter: Int) {
        taskFilter = filter

        viewModelScope.launch {
            try {
                val response = when (filter) {
                    TaskConstants.FILTER.ALL -> taskRepository.list()
                    TaskConstants.FILTER.NEXT -> taskRepository.listNext()
                    else -> taskRepository.listOverdue()
                }

                if (response.isSuccessful) {
                    val result = response.body().orEmpty().map { task ->
                        task.apply {
                            priorityDescription = priorityRepository.getDescription(priorityId)
                        }
                    }

                    _tasks.value = result
                }
            } catch (e: Exception) {
                _error.value = handleException(e)
            }
        }
    }

    /**
     * Deleta uma tarefa com o ID informado.
     * Em caso de sucesso, a lista é recarregada.
     * Em caso de erro, o erro é propagado.
     */
    fun delete(id: Int) {
        viewModelScope.launch {
            try {
                val response = taskRepository.delete(id)
                if (response.isSuccessful && response.body() == true) {
                    list(taskFilter)
                } else {
                    _delete.value = eErrorMessageFromResponse(response)
                }
            } catch (e: Exception) {
                _delete.value = handleException(e)
            }
        }
    }

    /**
     * Atualiza o status da tarefa (completa ou pendente).
     * Após a atualização, recarrega a lista.
     */
    fun status(id: Int, complete: Boolean) {
        viewModelScope.launch {
            try {
                val response = if (complete) {
                    taskRepository.complete(id)
                } else {
                    taskRepository.undo(id)
                }

                if (response.isSuccessful && response.body() == true) {
                    list(taskFilter)
                } else {
                    val error = response.errorBody()?.string().orEmpty()
                    _status.value = ValidationModel(error)
                }

            } catch (e: Exception) {
                _status.value = handleException(e)
            }
        }
    }

}