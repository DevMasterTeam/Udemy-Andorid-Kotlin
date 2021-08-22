package com.devmasterteam.tasks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devmasterteam.tasks.service.listener.APIListener
import com.devmasterteam.tasks.service.listener.ValidationListener
import com.devmasterteam.tasks.service.model.PriorityModel
import com.devmasterteam.tasks.service.model.TaskModel
import com.devmasterteam.tasks.service.repository.PriorityRepository
import com.devmasterteam.tasks.service.repository.TaskRepository

class TaskFormViewModel(application: Application) : AndroidViewModel(application) {

    private val mTaskRepository = TaskRepository(application)
    private val mPriorityRepository = PriorityRepository(application)

    private val mTask = MutableLiveData<TaskModel>()
    val task: LiveData<TaskModel> = mTask

    private val mPriorityList = MutableLiveData<List<PriorityModel>>()
    val priorityList: LiveData<List<PriorityModel>> = mPriorityList

    private val mValidation = MutableLiveData<ValidationListener>()
    val validation: LiveData<ValidationListener> = mValidation

    /**
     * Carregamente de uma tarefas
     */
    fun load(taskId: Int) {
        mTaskRepository.load(taskId, object : APIListener<TaskModel> {
            override fun onSuccess(result: TaskModel, statusCode: Int) {
                mTask.value = result
            }
            override fun onFailure(message: String) {
                mTask.value = null
                mValidation.value = ValidationListener(message)
            }

        })
    }

    fun loadPriorities() {
        mPriorityList.value = mPriorityRepository.list()
    }

    fun save(task: TaskModel) {
        if (task.id == 0) {
            mTaskRepository.create(task, object : APIListener<Boolean> {
                override fun onSuccess(result: Boolean, statusCode: Int) {
                    mValidation.value = ValidationListener()
                }
                override fun onFailure(message: String) {
                    mValidation.value = ValidationListener(message)
                }

            })
        } else {
            mTaskRepository.update(task, object : APIListener<Boolean> {
                override fun onSuccess(result: Boolean, statusCode: Int) {
                    mValidation.value = ValidationListener()
                }
                override fun onFailure(message: String) {
                    mValidation.value = ValidationListener(message)
                }
            })
        }
    }

}