package com.appfortraining

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.appfortraining.navigation.AppNavigation
import com.appfortraining.views.DayViewModelFactory
import com.appfortraining.views.DaysScreen
import com.appfortraining.views.ExerciseViewModelFactory
import com.appfortraining.vm.DayViewModel
import com.appfortraining.vm.ExerciseViewModel


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            val owner = LocalViewModelStoreOwner.current
//
//            owner?.let {
////                val viewModel: ExerciseViewModel = viewModel(
////                    it,
////                    "UserViewModel",
////                    ExerciseViewModelFactory(LocalContext.current.applicationContext as Application)
////                )
////                Main(viewModel)
//                val viewModel: DayViewModel = viewModel(
//                    it,
//                    "UserViewModel",
//                    DayViewModelFactory(LocalContext.current.applicationContext as Application)
//                )
//                //DaysScreen(viewModel)
            AppNavigation()
        }
    }
}



