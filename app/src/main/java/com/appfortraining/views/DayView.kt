package com.appfortraining.views

import android.app.Application
import android.view.View
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.appfortraining.models.Day
import com.appfortraining.vm.DayViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DayViewModelFactory(
    val application: Application
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DayViewModel(application) as T
    }
}

@Composable
fun DaysScreen(vm: DayViewModel = viewModel()) {
    val dayList by vm.dayList.observeAsState(listOf())
    DayList(dayList)

}

@Composable
fun DayList(days: List<Day>) {
    LazyColumn(Modifier.fillMaxWidth()) {
        item {

        }
        items(days) { e ->
            DayRow(day = e)
        }
    }
}

@Composable
fun DayRow(day: Day) {
    Column(Modifier.fillMaxWidth()) {
        Row {
            Text(text = day.dayName)
            Text(text = day.dayDate)
        }

    }
}

fun convertUnixTimestampToDate(timestamp:Long):String{
    val date = Date(timestamp*1000)
    val dateFormat = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
    return dateFormat.format(date)
}