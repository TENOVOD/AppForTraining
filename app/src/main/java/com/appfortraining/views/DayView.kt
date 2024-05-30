package com.appfortraining.views

import android.app.Application
import android.view.View
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
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
fun DaysScreen(vm: DayViewModel = viewModel(),navController: NavController) {
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
    Column(
        Modifier
            .fillMaxWidth()
            .padding(14.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = day.dayName,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = day.dayDate,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = "0",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
        }

    }
    Spacer(
        Modifier
            .background(color = Color.DarkGray)
            .fillMaxWidth()
            .height(1.dp)
    )
}
