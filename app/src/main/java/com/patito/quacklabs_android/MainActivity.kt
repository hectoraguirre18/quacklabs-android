package com.patito.quacklabs_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.patito.quacklabs_android.adapters.TeamMemberAdapter
import com.patito.quacklabs_android.models.Team
import com.patito.quacklabs_android.models.TeamMember
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val queue = Volley.newRequestQueue(this)
        val url = "https://quacklabs.herokuapp.com/team"

        val jsonRequest : StringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener { response ->
                Log.i("CitiesJSON", response.toString())
                val gson = Gson()
                val team: Team = gson.fromJson(response.toString(), Team::class.java)

                val members: List<TeamMember> = team.equipo

                this.rvTeamMembers.adapter = TeamMemberAdapter(members, this)
                this.rvTeamMembers.layoutManager = LinearLayoutManager(this)
            }, Response.ErrorListener { error ->
                Log.e("MainActivity", "Error en la petición ${error.toString()}")
            })

        queue.add(jsonRequest)

    }
}