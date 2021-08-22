package com.devmasterteam.tasks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devmasterteam.tasks.service.constants.TaskConstants
import com.devmasterteam.tasks.service.listener.APIListener
import com.devmasterteam.tasks.service.listener.ValidationListener
import com.devmasterteam.tasks.service.model.TaskModel
import com.devmasterteam.tasks.service.repository.TaskRepository

class TaskListViewModel(application: Application) : AndroidViewModel(application) {

    private val mValidation = MutableLiveData<ValidationListener>()
    val validation: LiveData<ValidationListener> = mValidation

    private val mTaskList = MutableLiveData<List<TaskModel>>()
    val taskList: LiveData<List<TaskModel>> = mTaskList

    // Acesso a dados
    private val mTaskRepository: TaskRepository = TaskRepository(application)
    private var mTaskFilter = 0

    fun list(taskFilter: Int) {
        mTaskFilter = taskFilter
        val listener = object : APIListener<List<TaskModel>> {
            override fun onSuccess(result: List<TaskModel>, statusCode: Int) {
                mTaskList.value = result
            }

            override fun onFailure(message: String) {
                mTaskList.value = listOf()
                mValidation.value = ValidationListener(message)
            }
        }

        if (taskFilter == TaskConstants.FILTER.ALL) {
            mTaskRepository.all(listener)
        } else if (taskFilter == TaskConstants.FILTER.NEXT) {
            mTaskRepository.next(listener)
        } else {
            mTaskRepository.expired(listener)
        }
    }

    fun deleteTask(id: Int) {
        mTaskRepository.delete(id, object : APIListener<Boolean> {
            override fun onSuccess(result: Boolean, statusCode: Int) {
                mValidation.value = ValidationListener()
                list(mTaskFilter)
            }

            override fun onFailure(message: String) {
                mValidation.value = ValidationListener(message)
            }

        })
    }

    fun completeTask(id: Int) {
        updateStatus(id, true)
    }

    fun undoTask(id: Int) {
        updateStatus(id, false)
    }

    private fun updateStatus(id: Int, complete: Boolean) {
        mTaskRepository.updateStatus(id, complete, object : APIListener<Boolean> {
            override fun onSuccess(result: Boolean, statusCode: Int) {
                list(mTaskFilter)
            }

            override fun onFailure(message: String) {
                mValidation.value = ValidationListener(message)
            }
        })
    }

}