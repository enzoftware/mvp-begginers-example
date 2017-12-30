package com.projects.enzoftware.myapplication.view.view.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by enzoftware on 12/29/17.
 */
data class User (val name : String ,val surname : String ): Parcelable{
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(surname)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }

}

enum class UserError{
    EMPTY_NAME,
    EMPTY_SURNAME,
    NO_ERROR
}

object UserStore{
    fun saveUser(user: User){

    }
}

object UserValidator{
    fun validateUser(user: User) : UserError{
        with(user){
            if(name.isNullOrEmpty()) return UserError.EMPTY_NAME
            if (surname.isNullOrEmpty()) return UserError.EMPTY_SURNAME
        }
        return UserError.NO_ERROR
    }
}
