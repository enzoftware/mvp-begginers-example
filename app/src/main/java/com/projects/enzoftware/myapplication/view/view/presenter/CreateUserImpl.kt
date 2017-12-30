package com.projects.enzoftware.myapplication.view.view.presenter


import com.projects.enzoftware.myapplication.view.view.CreateUserView
import com.projects.enzoftware.myapplication.view.view.model.User
import com.projects.enzoftware.myapplication.view.view.model.UserError
import com.projects.enzoftware.myapplication.view.view.model.UserStore
import com.projects.enzoftware.myapplication.view.view.model.UserValidator

/**
 * Created by enzoftware on 12/29/17.
 */
class CreateUserImpl(override var view : CreateUserView? ): CreateUserPresenter<CreateUserView> {
    override fun saveUser(name: String, surname: String) {
        val user = User(name,surname)
        when(UserValidator.validateUser(user)){
            UserError.EMPTY_NAME -> view?.showEmptyError()
            UserError.EMPTY_SURNAME -> view?.showEmptySurnameError()
            UserError.NO_ERROR -> {
                UserStore.saveUser(user)
                view?.showUserSaved()
                view?.showUserDetails(user)
            }
        }

    }
}