package com.projects.enzoftware.myapplication.view.view

import com.projects.enzoftware.myapplication.view.view.model.User


interface View

interface CreateUserView : View {
    fun showEmptyError() /* show error when name is empty */
    fun showEmptySurnameError() /* show error when surname is empty */
    fun showUserSaved() /* Show user saved info */
    fun showUserDetails(user:User) /* Show user details */
}

interface UserDetails : View {
    fun showUserDetails(user: User)
    fun showNoUserError()
}