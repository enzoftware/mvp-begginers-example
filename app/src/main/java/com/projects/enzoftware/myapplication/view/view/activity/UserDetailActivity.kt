package com.projects.enzoftware.myapplication.view.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.projects.enzoftware.myapplication.R
import com.projects.enzoftware.myapplication.view.view.UserDetails
import com.projects.enzoftware.myapplication.view.view.model.User
import com.projects.enzoftware.myapplication.view.view.presenter.UserDetailsImpl
import com.projects.enzoftware.myapplication.view.view.presenter.UserDetailsPresenter
import kotlinx.android.synthetic.main.activity_user_detail.*

class UserDetailActivity : AppCompatActivity() , UserDetails{
    override fun showUserDetails(user: User) {
        textViewUser.text = "${user.name} ${user.surname}"
    }

    override fun showNoUserError() {
        Toast.makeText(this,R.string.no_user_error,Toast.LENGTH_SHORT).show()
        finish()
    }

    private val presenter : UserDetailsPresenter<UserDetails> by lazy {
        UserDetailsImpl(this)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        val user = intent.getParcelableExtra<User>("user")
        presenter.user = user
    }

    override fun onDestroy() {
        presenter.onDestroy()
    }
}
