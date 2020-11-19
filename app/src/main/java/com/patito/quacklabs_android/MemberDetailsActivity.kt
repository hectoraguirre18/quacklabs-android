package com.patito.quacklabs_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.patito.quacklabs_android.models.TeamMember
import kotlinx.android.synthetic.main.activity_member_details.*

class MemberDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member_details)
        val teamMember: TeamMember = intent.getSerializableExtra("member") as TeamMember

        val txtName = findViewById<TextView>(R.id.txtName)
        val txtLanguages = findViewById<TextView>(R.id.txtLanguages)
        val txtDescription = findViewById<TextView>(R.id.txtDescription)
        val imageView = findViewById<ImageView>(R.id.imageView)
        this.txtName.text = teamMember.name
        this.txtLanguages.text = teamMember.languages.toString()
        this.txtDescription.text = teamMember.description


    }
}