package com.patito.quacklabs_android.models

import java.io.Serializable

class TeamMember(
    val name: String,
    val lastName: String,
    val languages: List<String>,
    val description: String,
    val imageRoute: String
) : Serializable {
}