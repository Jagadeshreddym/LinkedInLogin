package com.jagadesh.linkedinlogin.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class UserListResponse : Serializable{

    @SerializedName("given_name")
    var given_name: String? = null

    @SerializedName("family_name")
    var family_name: String? = null

    @SerializedName("picture")
    var picture: String? = null


}