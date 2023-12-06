package com.jagadesh.linkedinsample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.request.RequestOptions
import com.jagadesh.linkedinlogin.builder.LinkedInBuilder
import com.jagadesh.linkedinlogin.data.UserListResponse
import com.jagadesh.linkedinlogin.utils.KeyUtils
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonLogin.setOnClickListener(this)
    }

    /**
     * Here pass client_id,client_secret,redirecturi and state_value*/
    override fun onClick(v: View?) {
        val intent = LinkedInBuilder.Builder(this)
            .setClientId(getString(R.string.client_id))//CLIENT_ID
            .setClientSecret(getString(R.string.client_secret))//CLIENT_SECRET
            .setRedirectUri(getString(R.string.redirect_uri))//REDIRECT_URI
            .setStateValue(getString(R.string.state_value))//STATE_VALUE
            .setScopeValue(KeyUtils.BOTH_EMAIL_USERDETAILS_SCOPE_VALUE)//PASS_SCOPE_VALUE_HERE
            .build()
        startActivityForResult(intent, KeyUtils.REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && data != null) {
            when (requestCode) {
                KeyUtils.REQUEST_CODE -> {
                    Log.i("Test","on activity result");
                    val linkedInUser = data.getSerializableExtra(KeyUtils.KEY_LINKEDIN_CONTENT) as? UserListResponse

                    if (linkedInUser != null) {
                        buttonLogin.visibility = View.GONE
                        tvUserDetails.text =
                            "${linkedInUser.given_name}${linkedInUser.family_name}"
                        ivUserImage.loadImage(linkedInUser.picture, RequestOptions.circleCropTransform())
                    } else {
                        //handle the error
                    }
                }
            }
        }
        else{
            //Login failed handle error
        }
    }
}

