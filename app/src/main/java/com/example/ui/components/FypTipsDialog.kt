package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.ui.theme.VipAmberPrimary
import com.example.ui.theme.VipCoral

@Composable
fun FypTipsDialog(
  isDark: Boolean,
  onDismiss: () -> Unit
) {
  Dialog(onDismissRequest = onDismiss) {
    Surface(
      shape = RoundedCornerShape(24.dp),
      color = if (isDark) Color(0xFF131522) else Color(0xFFFFFFFF),
      modifier = Modifier
        .fillMaxWidth()
        .border(1.dp, VipAmberPrimary, RoundedCornerShape(24.dp))
    ) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(20.dp)
      ) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
              modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(VipAmberPrimary.copy(alpha = 0.2f)),
              contentAlignment = Alignment.Center
            ) {
              Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "FYP Shield",
                tint = VipAmberPrimary,
                modifier = Modifier.size(20.dp)
              )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(
              text = "TikTok FYP & কপিরাইট গাইড",
              fontSize = 16.sp,
              fontWeight = FontWeight.Bold,
              color = MaterialTheme.colorScheme.onBackground
            )
          }

          IconButton(onClick = onDismiss) {
            Icon(Icons.Default.Close, contentDescription = "Close")
          }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
          text = "কেন 'Not eligible for For You feed' আসে?",
          fontSize = 13.sp,
          fontWeight = FontWeight.Bold,
          color = VipCoral
        )
        Text(
          text = "টিকটক একই ভিডিওর হুবহু মেটাডাটা ও অরিজিনাল অডিও ফাইল হুবহু চিনে ফেলে এবং একে 'Unoriginal Content' ধরে রিকমেন্ডেশন বন্ধ করে দেয়।",
          fontSize = 12.sp,
          color = if (isDark) Color(0xFFA5ABB8) else Color(0xFF555555),
          lineHeight = 16.sp
        )

        Spacer(modifier = Modifier.height(14.dp))

        Text(
          text = "কীভাবে ১০০% কপিরাইটমুক্ত করবেন:",
          fontSize = 13.sp,
          fontWeight = FontWeight.Bold,
          color = VipAmberPrimary
        )
        Spacer(modifier = Modifier.height(8.dp))

        TipBulletItem("১. অ্যাপের Anti-Copyright Shield সক্রিয় রাখুন (এটি স্বয়ংক্রিয়ভাবে মেটাডাটা মুছে নতুন বাইনারি সিগনেচার দেয়)।", isDark)
        TipBulletItem("২. টিকটকে আপলোড করার সময় নিজস্ব এডিটর দিয়ে ভিডিওর শুরুতে ১-২ সেকেন্ড হুক টেক্সট দিন।", isDark)
        TipBulletItem("৩. টিকটকের ব্যাকগ্রাউন্ডে একটি ট্রেন্ডিং মিউজিক বা সাউন্ড যোগ করে সেটির ভলিউম ১% থেকে ৫% রাখুন।", isDark)
        TipBulletItem("৪. ভিডিওর শেষ ১ সেকেন্ড ট্রিম/কাট করে ফেলুন।", isDark)

        Spacer(modifier = Modifier.height(18.dp))

        Button(
          onClick = onDismiss,
          shape = RoundedCornerShape(12.dp),
          colors = ButtonDefaults.buttonColors(containerColor = VipAmberPrimary),
          modifier = Modifier.fillMaxWidth()
        ) {
          Text("বুঝেছি (Got It)", color = Color.Black, fontWeight = FontWeight.Bold)
        }
      }
    }
  }
}

@Composable
private fun TipBulletItem(text: String, isDark: Boolean) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 4.dp),
    verticalAlignment = Alignment.Top
  ) {
    Icon(
      imageVector = Icons.Default.CheckCircle,
      contentDescription = "Tip",
      tint = VipAmberPrimary,
      modifier = Modifier
        .size(16.dp)
        .padding(top = 2.dp)
    )
    Spacer(modifier = Modifier.width(8.dp))
    Text(
      text = text,
      fontSize = 12.sp,
      color = if (isDark) Color(0xFFDCDFEA) else Color(0xFF333333),
      lineHeight = 16.sp
    )
  }
}
