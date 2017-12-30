package com.projects.enzoftware.myapplication.view.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.projects.enzoftware.myapplication.R
import com.projects.enzoftware.myapplication.view.view.CreateUserView
import com.projects.enzoftware.myapplication.view.view.model.User
import com.projects.enzoftware.myapplication.view.view.presenter.CreateUserImpl
import com.projects.enzoftware.myapplication.view.view.presenter.CreateUserPresenter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() , CreateUserView{

    private val presenter : CreateUserPresenter<CreateUserView> by lazy {
        CreateUserImpl(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonEnter.setOnClickListener {
            presenter.saveUser(editTextName.text.toString() , editTextSurname.text.toString())

        }
    }

    override fun showEmptyError() {
        editTextName.error = getString(R.string.name_empty_error)
    }

    override fun showEmptySurnameError() {
        editTextSurname.error = getString(R.string.surname_empty_error)
    }

    override fun showUserSaved() {
        Toast.makeText(this,R.string.user_saved , Toast.LENGTH_SHORT ).show()
    }

    override fun showUserDetails(user: User) {
        startActivity<UserDetailActivity>("user" to user)

    }



    override fun onDestroy() {
        presenter.onDestroy()
    }
}
