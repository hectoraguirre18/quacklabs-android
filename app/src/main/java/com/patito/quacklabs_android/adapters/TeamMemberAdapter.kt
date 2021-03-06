package com.patito.quacklabs_android.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.patito.quacklabs_android.MemberDetailsActivity
import com.patito.quacklabs_android.R
import com.patito.quacklabs_android.models.TeamMember
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class TeamMemberAdapter(val teamMembers: List<TeamMember>, val parent: AppCompatActivity) : RecyclerView.Adapter<TeamMemberAdapter.ViewHolder>(){
    inner class ViewHolder(listItem: View) : RecyclerView.ViewHolder(listItem) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        val layout: View = itemView.findViewById(R.id.item_layout)
        val photo: ImageView = itemView.findViewById(R.id.memberPhoto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val teamMemberView = inflater.inflate(R.layout.item_teammember, parent, false)
        return ViewHolder(teamMemberView)
    }

    override fun getItemCount(): Int {
        return teamMembers.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val teamMember: TeamMember = teamMembers.get(position)
        holder.tvName.text = teamMember.name
        holder.tvDescription.text = teamMember.description
        holder.layout.setOnClickListener(View.OnClickListener {
            val intent = Intent(this.parent, MemberDetailsActivity::class.java)
            intent.putExtra("member", teamMember)
            this.parent.startActivity(intent)
        })

        Picasso.get()
            .load("https://quacklabs.herokuapp.com${teamMember.imageRoute}")
            .into(holder.photo, object: Callback {
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