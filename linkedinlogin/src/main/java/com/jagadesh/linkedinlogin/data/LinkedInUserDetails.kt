package com.jagadesh.linkedinlogin.data

import android.os.Parcel
import android.os.Parcelable

class LinkedInUserDetails() : Parcelable {
    var firstName: String? = null
    var lastName: String? = null
    var image: String? = null
    var email: String? = null

    constructor(parcel: Parcel) : this() {
        firstName = parcel.readString()
        lastName = parcel.readString()
        image = parcel.readString()
        email = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeString(image)
        parcel.writeString(email)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LinkedInUserDetails> {
        override fun createFromParcel(parcel: Parcel): LinkedInUserDetails {
            return LinkedInUserDetails(parcel)
        }

        override fun newArray(size: Int): Array<LinkedInUserDetails?> {
            return arrayOfNulls(size)
        }
    }
}