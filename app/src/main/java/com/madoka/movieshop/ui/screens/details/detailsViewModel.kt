package com.madoka.movieshop.ui.screens.details

import androidx.lifecycle.ViewModel
import com.madoka.domain.usecase.MovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class detailsViewModel @Inject constructor(private val movieDetailUseCase: MovieDetailUseCase) :
    ViewModel() {


}