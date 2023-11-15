package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import java.text.NumberFormat
import androidx.compose.material3.TextField
import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TipTimeLayout()
                }
            }
        }
    }
}

@Composable
fun GreetingText(message : String,  from: String = "Anonynous", modifier: Modifier = Modifier){
    Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
        Text(text = message, fontSize = 100.sp, lineHeight = 116.sp, textAlign = TextAlign.Center)
        Text(text = from, fontSize = 36.sp,modifier = modifier
            .padding(16.dp)
            .align(alignment = Alignment.CenterHorizontally))
    }

}

@Composable
fun Article(modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.bg_compose_background)
    Column(modifier = modifier) {
        Image(painter = image, contentDescription = null, contentScale = ContentScale.FillWidth)
        Text(text = stringResource(R.string.article_title), fontSize = 24.sp, modifier = Modifier.padding(16.dp))
        Text(text = stringResource(R.string.article_subtitle), modifier = Modifier.padding(16.dp), textAlign = TextAlign.Justify)
        Text(text = stringResource(R.string.article_text), modifier = Modifier.padding(16.dp), textAlign = TextAlign.Justify)
    }

}

@Composable
fun TaskProgress(modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.ic_task_completed)
    Column(modifier = modifier
        .fillMaxWidth()
        .fillMaxHeight(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = image, contentDescription = null, contentScale = ContentScale.Crop)
        Text(text = stringResource(R.string.all_tasks_completed), modifier = Modifier.padding(top = 24.dp, bottom = 8.dp), fontWeight = FontWeight.Bold)
        Text(text = stringResource(R.string.nice_work), fontSize = 16.sp, textAlign = TextAlign.Justify)
    }

}

@Composable
fun Quadrant(modifier: Modifier = Modifier){
    Column(modifier = modifier.fillMaxWidth()) {
        Row(modifier.weight(1f)){
            Column(modifier = modifier
                .weight(1f)
                .background(color = Color(0xFFEADDFF))
                .fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                Text(text = stringResource(R.string.text_composable), modifier = Modifier.padding(bottom = 16.dp),fontWeight = FontWeight.Bold)
                Text(modifier = modifier.padding(16.dp), text = stringResource(R.string.material_design), textAlign = TextAlign.Justify)
            }

            Column(modifier = modifier
                .weight(1f)
                .background(color = Color(0xFFD0BCFF))
                .fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                Text(text = "Image composable", modifier = Modifier.padding(bottom = 16.dp),fontWeight = FontWeight.Bold)
                Text(modifier = modifier.padding(16.dp), text = stringResource(R.string.given_painter), textAlign = TextAlign.Justify)
            }

        }

        Row(modifier.weight(1f)){
            Column(modifier = modifier
                .weight(1f)
                .background(color = Color(0xFFB69DF8))
                .fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                Text(text = "Row composable", modifier = Modifier.padding(bottom = 16.dp), fontWeight = FontWeight.Bold)
                Text(modifier = modifier.padding(16.dp), text = stringResource(R.string.h_seq), textAlign = TextAlign.Justify)
            }

            Column(modifier = modifier
                .weight(1f)
                .background(color = Color(0xFFF6EDFF))
                .fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                Text(text = "Column composable", modifier = Modifier.padding(bottom = 16.dp), fontWeight = FontWeight.Bold)
                Text(modifier = modifier.padding(16.dp), text = "A layout composable that places its children in a vertical sequence.", textAlign = TextAlign.Justify)
            }

        }



    }

}


@Composable
fun GreetingImage(message: String, from: String = "Anonymous", modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box{
        Image(painter = image, contentDescription = null, contentScale = ContentScale.Crop, alpha = 0.5F)
        GreetingText(message = message, from = from, modifier = modifier.padding(8.dp))

    }
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    Column (modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        var result by remember { mutableStateOf(1) }
        val imageResource = when (result) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { result = (1..6).random() }) {
            Text(stringResource(R.string.roll))
        }
    }
}

@Composable
fun TipTimeLayout() {
    var amountInput by remember { mutableStateOf("") }
    var tipInput by remember { mutableStateOf("") }
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tipPercent = tipInput.toDoubleOrNull() ?: 0.0
    var roundUp by remember { mutableStateOf(false) }
    val tip = calculateTip(amount, tipPercent, roundUp)

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp).verticalScroll(rememberScrollState())
            .safeDrawingPadding().fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )

        EditNumberField(R.string.bill_amount,  leadingIcon = R.drawable.money, keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ), value = amountInput, onValueChange = { amountInput = it },modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth())
        EditNumberField(label = R.string.how_was_the_service, leadingIcon = R.drawable.percent, keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ), value = tipInput, onValueChange = { tipInput = it }, modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth())
        RoundTheTipRow(
            roundUp = roundUp,
            onRoundUpChanged = { roundUp = it },
            modifier = Modifier.padding(bottom = 32.dp)
        )
        Text(
            text = stringResource(R.string.tip_amount, tip),
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(150.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNumberField(@StringRes label: Int, @DrawableRes leadingIcon: Int, keyboardOptions: KeyboardOptions, value: String, onValueChange: (String) -> Unit, modifier: Modifier = Modifier) {

    TextField(
        label = { Text(stringResource(label)) },
        singleLine = true,
        keyboardOptions = keyboardOptions,
        value = value,
        leadingIcon = { Icon(painter = painterResource(id = leadingIcon), null) },
        onValueChange = onValueChange,
        modifier = modifier
    )
}

/**
 * Calculates the tip based on the user input and format the tip amount
 * according to the local currency.
 * Example would be "$10.00".
 */
@VisibleForTesting
internal fun calculateTip(amount: Double, tipPercent: Double = 15.0,  roundUp: Boolean): String {
    var tip = tipPercent / 100 * amount
    if (roundUp) {
        tip = kotlin.math.ceil(tip)
    }
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Composable
fun RoundTheTipRow(roundUp: Boolean,
                   onRoundUpChanged: (Boolean) -> Unit,
                   modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .size(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(R.string.round_up_tip))
        Switch(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
            checked = roundUp,
            onCheckedChange = onRoundUpChanged,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerApp() {
    MyApplicationTheme {
        TipTimeLayout()
    }
}