package com.mungaicodes.mybusinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mungaicodes.mybusinesscard.ui.theme.MyBusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}


@Composable
fun BusinessCardApp() {
    BusinessCardUserInfo(
        name = stringResource(R.string.username),
        rank = stringResource(R.string.rank),
        image = painterResource(R.drawable.ic_launcher_background)
    )
    BusinessCardContactInfo(
        phoneNumber = stringResource(R.string.phone_number),
        twitter = stringResource(R.string.twitter_username),
        email = stringResource(R.string.email_address)
    )
}

@Composable
fun BusinessCardUserInfo(
    name: String,
    rank: String,
    image: Painter,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = image,
            contentDescription = "profile_pic",
            modifier = Modifier
                .width(160.dp)
                .height(160.dp)
        )
        Text(
            text = name,
            fontSize = 36.sp,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier
                .padding(top = 10.dp, bottom = 12.dp)
        )
        Text(
            text = rank,
            color = Color.Green,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold
        )
    }

}

@Composable
fun BusinessCardContactInfo(
    phoneNumber: String,
    twitter: String,
    email: String,
    modifier: Modifier = Modifier
) {

    val  phoneNumberIcon =

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier
            .fillMaxSize()
            .padding(start = 70.dp, bottom = 45.dp, end = 70.dp)
    ) {
        Row(Modifier.padding(bottom = 3.dp)) {
            Icon(
                Icons.Filled.Phone,
                contentDescription = "phone",
                tint = Color.Green
            )
            Spacer(Modifier.width(35.dp))
            Text(
                text = phoneNumber,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }
        Row(Modifier.padding(bottom = 3.dp)) {
            Icon(
                Icons.Filled.Share,
                contentDescription = "share",
                tint = Color.Green
            )
            Spacer(Modifier.width(35.dp))
            Text(
                text = twitter,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }
        Row(Modifier.padding(bottom = 3.dp)) {
            Icon(
                Icons.Filled.Email,
                contentDescription = "email",
                tint = Color.Green
            )
            Spacer(Modifier.width(35.dp))
            Text(
                text = email,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun BusinessCardAppPreview() {
    MyBusinessCardTheme {
        androidx.compose.material.Surface(color = Color.DarkGray) {
            BusinessCardApp()
        }
    }
}
