package id.four.fourdice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.four.fourdice.data.DataSource
import id.four.fourdice.ui.theme.FourDiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FourDiceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FourDiceApp(
                        list = DataSource().loadListIdImage(),
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(Alignment.Center)
                        )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FourDiceApp(list : List<Int> = listOf(),  modifier: Modifier = Modifier){
    var result by remember {
        mutableStateOf(R.drawable.dice_1)
    }
    var count by remember {
        mutableStateOf(0)
    }
    var index by remember {
        mutableStateOf(0)
    }
    var isEnabled by remember {
        mutableStateOf(true)
    }

    if(count != 0 ){
        if(count == index){
            count = 0
            index = 0
            isEnabled = true
        } else{
            index++
            result = list.random()
        }
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .padding(50.dp),
            painter = painterResource(id = result),
            contentDescription = stringResource(id = R.string.description_dice)
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 50.dp,
                    end = 50.dp
                ),
            onClick = {
                count = (25 .. 100).random()
                isEnabled = false
            },
            enabled = isEnabled) {
            Text(
                text = stringResource(id = R.string.acak)
            )
        }
    }
}