package com.experiments.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.experiments.compose.components.ui.theme.AccountInfoBackground
import com.experiments.compose.components.ui.theme.AccountNumberTextColor
import com.experiments.compose.components.ui.theme.Grey
import com.experiments.compose.data.SampleData
import com.experiments.compose.data.model.Account
import com.experiments.compose.util.formatAsAmount

/**
 * Created by Prasada Rao on 26/11/21 4:44 PM
 **/
@Composable
fun AccountHeader(
  modifier: Modifier = Modifier,
  account: Account
) {
  Box(
    modifier = modifier
      .background(color = AccountInfoBackground)
      .padding(horizontal = 8.dp, vertical = 16.dp)
  ) {
    Card {
      Column {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(8.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Icon(
            modifier = Modifier.padding(8.dp),
            painter = painterResource(id = R.drawable.icon_transactional),
            contentDescription = null,
            tint = Color.Unspecified
          )
          Column {
            Text(
              text = "Complete Access",
              style = MaterialTheme.typography.h4.copy(color = Color.Black, fontSize = 22.sp)
            )
            Text(
              text = account.accountNumber,
              style = MaterialTheme.typography.h5.copy(color = AccountNumberTextColor, fontSize = 18.sp)
            )
          }
        }
        AmountsBodyContent(account)
      }
    }
  }
}

@Composable
private fun AmountsBodyContent(account: Account) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .background(color = Grey)
      .padding(8.dp)
  ) {
    AmountsContentRow("Available funds", account.availableAmount.formatAsAmount())
    AmountsContentRow("Account balance", account.balanceAmount.formatAsAmount())
  }
}

@Composable
private fun AmountsContentRow(key: String, value: String) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(4.dp),
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    Text(
      text = key,
      style = MaterialTheme.typography.body1.copy(color = AccountNumberTextColor)
    )
    Text(
      text = value,
      style = MaterialTheme.typography.body1.copy(color = AccountNumberTextColor, fontWeight = FontWeight.Bold)
    )
  }
}

@Preview(showBackground = true)
@Composable
fun AccountHeaderPreview() {
  AccountHeader(account = SampleData.accountInformation)
}
