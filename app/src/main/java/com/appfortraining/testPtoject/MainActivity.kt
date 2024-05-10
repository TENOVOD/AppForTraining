package com.appfortraining.testPtoject

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel


class UserViewModelFactory(val application: Application) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(application) as T
    }
}

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val owner = LocalViewModelStoreOwner.current

            owner?.let {
                val viewModel: UserViewModel = viewModel(
                    it,
                    "UserViewModel",
                    UserViewModelFactory(LocalContext.current.applicationContext as Application)
                )
                Main(viewModel)
            }
        }
    }
}


@Composable
fun Main(vm: UserViewModel = viewModel()) {
    val userList by vm.userList.observeAsState(listOf())
    Column {
        OutlinedTextField(vm.userName, modifier= Modifier.padding(8.dp), label = { Text("Name") }, onValueChange = {vm.changeName(it)})
        OutlinedTextField(vm.userAge.toString(), modifier= Modifier.padding(8.dp), label = { Text("Age") },
            onValueChange = {vm.changeAge(it)},
            keyboardOptions = KeyboardOptions(keyboardType= KeyboardType.Number)
        )
        Button({ vm.addUser() }, Modifier.padding(8.dp)) {Text("Add", fontSize = 22.sp)}
        UserList(users = userList, delete = {vm.deleteUser(it)})
    }
}
@Composable
fun UserList(users:List<User>, delete:(Int)->Unit) {
    LazyColumn(Modifier.fillMaxWidth()) {
        item{ UserTitleRow()}
        items(users) {u -> UserRow(u, {delete(u.id)})  }
    }
}
@Composable
fun UserRow(user:User, delete:(Int)->Unit) {
    Row(Modifier .fillMaxWidth().padding(5.dp)) {
        Text(user.id.toString(), Modifier.weight(0.1f), fontSize = 22.sp)
        Text(user.name, Modifier.weight(0.2f), fontSize = 22.sp)
        Text(user.age.toString(), Modifier.weight(0.2f), fontSize = 22.sp)
        Text("Delete", Modifier.weight(0.2f).clickable { delete(user.id) }, color=Color(0xFF6650a4), fontSize = 22.sp)
    }
}
@Composable
fun UserTitleRow() {
    Row(Modifier.background(Color.LightGray).fillMaxWidth().padding(5.dp)) {
        Text("Id", color = Color.White,modifier = Modifier.weight(0.1f), fontSize = 22.sp)
        Text("Name", color = Color.White,modifier = Modifier.weight(0.2f), fontSize = 22.sp)
        Text("Age", color = Color.White, modifier = Modifier.weight(0.2f), fontSize = 22.sp)
        Spacer(Modifier.weight(0.2f))
    }
}