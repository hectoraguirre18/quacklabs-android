package com.patito.quacklabs_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.patito.quacklabs_android.adapters.LanguagesAdapter
import com.patito.quacklabs_android.adapters.TeamMemberAdapter
import com.patito.quacklabs_android.models.TeamMember
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_member_details.*

class MemberDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member_details)
        val teamMember: TeamMember = intent.getSerializableExtra("member") as TeamMember

        val imageView : ImageView = findViewById<ImageView>(R.id.imageView)
        this.txtName.text = teamMember.name
        this.txtLastName.text = teamMember.lastName
        //this.txtLanguages.text = teamMember.languages.toString()
        this.rvLanguages.adapter = LanguagesAdapter(teamMember.languages)
        this.rvLanguages.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)

        this.txtDescription.text = teamMember.description


        Picasso.get()
            .load("https://quacklabs.herokuapp.com${teamMember.imageRoute}")
            .into(imageView, object: Callback {
                override fun onSuccess() {
                    //set animations here
                    Log.d("TeamMemberAdapter", "Success loading ${teamMember.name}'s foto!")
                }

                override fun onError(e: Exception?) {
                    Log.e("TeamMemberAdapter", "Couldnt load images: " + e.toString())
                }
            })
    }
}