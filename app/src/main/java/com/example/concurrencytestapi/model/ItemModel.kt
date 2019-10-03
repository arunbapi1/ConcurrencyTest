package com.example.concurrencytestapi.model


data class ItemModel(
    val data: List<ProfessionalData>
)

data class ProfessionalData(
    val companyName: String? = "",
    val companyLogo: String,
    val designation: String? = "",
    val duration: String,
    val role: String? = "",
    val achievements: String
)
