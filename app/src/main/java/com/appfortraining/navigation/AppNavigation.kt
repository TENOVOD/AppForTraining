package com.appfortraining.navigation

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.appfortraining.views.DayViewModelFactory
import com.appfortraining.views.DaysScreen
import com.appfortraining.views.ExerciseViewModelFactory
import com.appfortraining.views.ExercisesScreen
import com.appfortraining.vm.DayViewModel
import com.appfortraining.vm.ExerciseViewModel


@Composable
fun AppNavigation() {
    val owner = LocalViewModelStoreOwner.current

    owner?.let {
        val viewModelExercise: ExerciseViewModel = viewModel(
            it,
            "UserViewModel",
            ExerciseViewModelFactory(LocalContext.current.applicationContext as Application)
        )

        val viewModel: DayViewModel = viewModel(
            it,
            "UserViewModel",
            DayViewModelFactory(LocalContext.current.applicationContext as Application)
        )
        //DaysScreen(viewModel)
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "dayScreen") {
            composable("dayScreen") { DaysScreen(vm = viewModel, navController = navController) }
            composable("exercisesScreen") { ExercisesScreen(vm=viewModelExercise,navController = navController) }
        }

    }

}