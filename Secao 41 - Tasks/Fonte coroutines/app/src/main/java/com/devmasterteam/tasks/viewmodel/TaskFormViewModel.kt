package com.devmasterteam.tasks.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.devmasterteam.tasks.service.model.TaskModel
import com.devmasterteam.tasks.service.model.ValidationModel
import com.devmasterteam.tasks.service.repository.PriorityRepository
import com.devmasterteam.tasks.service.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskFormViewModel(private val application: Application) : BaseAndroidViewModel(application) {

    private val priorityRepository = PriorityRepository(application.applicationContext)
    private val taskRepository = TaskRepository(application.applicationContext)

    val priorityList = priorityRepository.list().asLiveData()

    private val _taskSave = MutableLiveData<ValidationModel>()
    val taskSave: LiveData<ValidationModel> = _taskSave

    private val _task = MutableLiveData<TaskModel>()
    val task: LiveData<TaskModel> = _task

    private val _taskLoad = MutableLiveData<ValidationModel>()
    val taskLoad: LiveData<ValidationModel> = _taskLoad

    /**
     * Salva uma nova tarefa ou atualiza uma existente.
     * Se o ID for 0, uma nova tarefa é criada. Caso contrário, é feita a atualização.
     */
    fun save(task: TaskModel) {
        viewModelScope.launch {
            try {
                val response = if (task.id == 0) {
                    taskRepository.create(task)
                } else {
                    taskRepository.update(task)
                }

                if (response.isSuccessful && response.body() == true) {
                    _taskSave.value = ValidationModel()
                } else {
                    _taskSave.value = eErrorMessageFromResponse(response)
                }

            } catch (e: Exception) {
                _taskLoad.value = handleException(e)
            }
        }
    }

    /**
     * Carrega uma tarefa a partir do ID informado, normalmente para edição.
     */
    fun load(id: Int) {
        viewModelScope.launch {
            try {
                val response = taskRepository.load(id)
                if (response.isSuccessful) {
                    _task.value = response.body()!!
                }
            } catch (e: Exception) {
                _taskLoad.value = handleException(e)
            }
        }
    }

}