package com.example.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Color Palette
val TempleSaffron = Color(0xFFC0392B)
val TempleGold = Color(0xFFD4AF37)
val TempleCream = Color(0xFFFAFAFA)

data class SevaItem(val title: String, val description: String, val price: String)
data class TimingItem(val title: String, val time: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onBookSevaClicked: (SevaItem) -> Unit = {}) {
    val timings = listOf(
        TimingItem("Suprabhatam", "5:30 AM – 6:00 AM"),
        TimingItem("Morning Alankarana", "6:30 AM – 11:30 AM"),
        TimingItem("Maha Archana", "12:00 PM – 1:00 PM"),
        TimingItem("Evening Aarti", "6:30 PM – 8:00 PM")
    )

    val sevas = listOf(
        SevaItem("Special Sahasranama Archana", "Perform personalized archana with your family gothram.", "₹251"),
        SevaItem("Abhishekam Seva", "Participate in the sacred morning bath ritual.", "₹501"),
        SevaItem("Shaswat Pooja Endowment", "Annual pooja conducted automatically on a chosen date.", "₹2,500")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Text(
                        text = "Sri Ankalama Devasthanam", 
                        fontWeight = FontWeight.Bold, 
                        fontSize = 20.sp
                    ) 
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = TempleSaffron,
                    titleContentColor = Color.White
                )
            )
        },
        containerColor = TempleCream
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Hero Section
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = TempleSaffron),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "🛕",
                            fontSize = 40.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Welcome Devotees",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = TempleGold,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Experience divine peace, online seva bookings, and daily rituals.",
                            fontSize = 14.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            // Timings Section Title
            item {
                Text(
                    text = "Daily Temple Timings",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = TempleSaffron
                )
            }

            // Timings Grid
            items(timings) { timing ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = timing.title, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                        Text(text = timing.time, color = Color.Gray, fontSize = 14.sp)
                    }
                }
            }

            // Sevas Section Title
            item {
                Text(
                    text = "Available Online Sevas",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = TempleSaffron
                )
            }

            // Seva Cards
            items(sevas) { seva ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = seva.title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = seva.description, color = Color.Gray, fontSize = 14.sp)
                        Spacer(modifier = Modifier.height(12.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = seva.price, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = TempleSaffron)
                            Button(
                                onClick = { onBookSevaClicked(seva) },
                                colors = ButtonDefaults.buttonColors(containerColor = TempleGold)
                            ) {
                                Text(text = "Book Now", color = Color.Black, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }
        }
    }
}
