package com.projects.enzoftware.myapplication.view.view.presenter

import com.projects.enzoftware.myapplication.view.view.UserDetails
import com.projects.enzoftware.myapplication.view.view.model.User

/**
 * Created by enzoftware on 12/29/17.
 */
class UserDetailsImpl(override var view : UserDetails? ) : UserDetailsPresenter<UserDetails> {
    override var user : User ?= null
    set(value) {
        field = value
        if ( field != null){
            view?.showUserDetails(field!!)
        }else{
            view?.showNoUserError()
        }
    }
}