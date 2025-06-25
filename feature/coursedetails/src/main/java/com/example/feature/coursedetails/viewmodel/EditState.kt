package com.example.feature.coursedetails.viewmodel

sealed interface EditState {
    data class Edited(val progress: Int) : EditState
    object NotEdited : EditState
}