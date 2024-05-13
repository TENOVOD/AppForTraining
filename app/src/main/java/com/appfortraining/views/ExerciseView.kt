package com.appfortraining.views

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.appfortraining.models.Exercise

import com.appfortraining.vm.ExerciseViewModel

class ExerciseViewModelFactory(val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ExerciseViewModel(application) as T
    }
}

@Composable
fun Main(vm: ExerciseViewModel = viewModel()) {
    val exerciseList by vm.exerciseList.observeAsState(listOf())
    Column {
        OutlinedTextField(
            value = vm.exerciseName,
            modifier = Modifier.padding(8.dp),
            label = { Text("Name") },
            onValueChange = { vm.changeName(it) })
        OutlinedTextField(
            value = vm.exerciseRepetitions.toString(),
            modifier = Modifier.padding(8.dp),
            label = { Text("Repetitions") },
            keyboardOptions = KeyboardOptions(keyboardType= KeyboardType.Number),
            onValueChange = { vm.changeRepetition(it) }
        )
        Button({ vm.addExercise() }, Modifier.padding(8.dp)) {Text("Add", fontSize = 22.sp)}
        ExerciseList(exercises = exerciseList, delete = {vm.deleteExercise(it)})
    }
}

@Composable
fun ExerciseList(exercises:List<Exercise>,delete:(Int)->Unit){

    LazyColumn(Modifier.fillMaxWidth()){
        item{ ExerciseTitleRow() }
        items(exercises) { e ->
            ExerciseRow(exercise = e, { delete(e.id) })
        }
    }
}

@Composable
fun ExerciseRow(exercise: Exercise, delete:(Int)->Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(5.dp)) {
        Text(exercise.id.toString(), Modifier.weight(0.1f), fontSize = 12.sp)
        Text(exercise.exerciseName, Modifier.weight(0.2f), fontSize = 12.sp)
        Text(exercise.repetitions.toString(), Modifier.weight(0.2f), fontSize = 12.sp)
        Text(exercise.time.toString(), Modifier.weight(0.2f), fontSize = 12.sp)

        Text("Delete",
            Modifier
                .weight(0.2f)
                .clickable { delete(exercise.id) }, color= Color(0xFF6650a4), fontSize = 12.sp)
    }
}
@Composable
fun ExerciseTitleRow() {
    Row(
        Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(5.dp)) {
        Text("Id", color = Color.White,modifier = Modifier.weight(0.1f), fontSize = 20.sp)
        Text("Name", color = Color.White,modifier = Modifier.weight(0.2f), fontSize = 20.sp)
        Text("Repetition", color = Color.White, modifier = Modifier.weight(0.2f), fontSize = 20.sp)
        Text("Time", color = Color.White, modifier = Modifier.weight(0.2f), fontSize = 20.sp)
        Spacer(Modifier.weight(0.2f))
    }
}