package com.example.danhsachsv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.core.view.WindowInsetsControllerCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowInsetsControllerCompat(
            window,
            window.decorView
        ).isAppearanceLightStatusBars = false
        setContent {
            DanhSachSV()
        }
    }
}

data class Student(
    val name: String,
    val email: String?,
    val phone: String?
)

@Composable
fun DanhSachSV() {
    val students = listOf(
        Student(
            name = "Nguyễn Hoài Linh",
            email = "vunh123@gmail.com",
            phone = "0302302302"
        ),
        Student(
            name = "Nguyễn Hoài Lâm",
            email = null,
            phone = "0301301301"
        ),
        Student(
            name = "Nguyễn Hoài Vũ",
            email = "vunh789@gmail.com",
            phone = null
        ),
        Student(
            name = "Nguyễn Hoài Khang",
            email = "vunh301@gmail.com",
            phone = "0456456456"
        ),
        Student(
            name = "Nguyễn Hoài Nam",
            email = null,
            phone = null
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE8ECF2))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF304878))
                .padding(
                    start = 20.dp,
                    top = 58.dp,
                    bottom = 18.dp
                )
        ) {
            Text(
                text = "Danh sách sinh viên",
                color = Color.White,
                fontSize = 24.sp
            )
        }

        for (info in students)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 12.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = info.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        buildAnnotatedString {
                            append("Email: ")
                            if (info.email == null) {
                                withStyle(SpanStyle(color = Color.Red)) {
                                    append("Chưa cập nhật")
                                }
                            } else {
                                append(info.email)
                            }
                        },
                        color = Color.Gray
                    )
                    Text(
                        buildAnnotatedString {
                            append("SĐT: ")
                            if (info.phone == null) {
                                withStyle(SpanStyle(color = Color.Red)) {
                                    append("Chưa cập nhật")
                                }
                            } else {
                                append(info.phone)
                            }
                        },
                        color = Color.Gray
                    )
                }
            }

        val missingEmail = students.count { it.email == null}

        Card (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 12.dp),
            shape = RoundedCornerShape(6.dp),
            colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFD1E5FA)
            )
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    buildAnnotatedString {
                        append("Tổng: ")
                        withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("${students.size} sinh viên")
                        }
                    },
                    color = Color(0xFF1565C0)
                )
                Text(
                    buildAnnotatedString {
                        append("Thiếu email: ")
                        withStyle(SpanStyle(color = Color.Red)) {
                            append("$missingEmail")
                        }
                    },
                    color = Color(0xFF1565C0)
                )
            }
        }
    }
}