package com.projects.enzoftware.myapplication.view.view.presenter

import com.projects.enzoftware.myapplication.view.view.View
import com.projects.enzoftware.myapplication.view.view.model.User

/**
 * Created by enzoftware on 12/29/17.
 */

interface Presenter<T : View>{
    var view : T ?
    fun onDestroy(){
        view = null
    }
}

interface CreateUserPresenter <T: View> : Presenter<T>{
    fun saveUser(name : String , surname : String)
}

interface UserDetailsPresenter<T : View> : Presenter<T>{
    var user : User?
}