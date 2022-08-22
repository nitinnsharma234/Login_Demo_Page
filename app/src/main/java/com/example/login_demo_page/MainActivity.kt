package com.example.login_demo_page

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.login_demo_page.ui.theme.Login_Demo_PageTheme
import com.example.login_demo_page.ui.theme.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Login_Demo_PageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val mainViewModel: MainViewModel by  viewModels()
                    Greeting(mv=mainViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(mv: MainViewModel = viewModel()) {
    val context= LocalContext.current

    var email=mv.email.collectAsState()
    var password=mv.password.collectAsState()
    var error:String

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )

    {
            TextField(value = email.value, onValueChange ={mv.setValue(it)} )
            TextField(value = password.value, onValueChange ={mv.setPassword(it)} )

            Button(onClick = { error= mv.submit()
                Toast.makeText(context,error,Toast.LENGTH_SHORT).show()
            }) {
                Text("Submit")

            }


    }

}

