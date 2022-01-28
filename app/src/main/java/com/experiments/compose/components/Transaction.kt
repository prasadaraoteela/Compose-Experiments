package com.experiments.compose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.experiments.compose.components.ui.theme.Grey
import com.experiments.compose.components.ui.theme.Yellow
import com.experiments.compose.data.model.Transaction
import com.experiments.compose.util.formatAsAmount

/**
 * Created by Prasada Rao on 26/11/21 1:01 PM
 **/
@Composable
fun Transaction(
  modifier: Modifier = Modifier,
  transaction: Transaction
) {
  Row(
    modifier = modifier
      .background(color = Grey)
      .padding(horizontal = 8.dp, vertical = 16.dp),
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    Text(
      text = transaction.description,
      modifier = Modifier.weight(1f),
      style = MaterialTheme.typography.body2
    )
    Text(
      text = transaction.amount.formatAsAmount(),
      style = MaterialTheme.typography.h6
    )
  }
}

@Preview(showBackground = true)
@Composable
fun TransactionPreview() {
  Transaction(
    transaction = Transaction(
      id = "1506aeeb8c3a699b1e3c87db03156428",
      effectiveDate = "20/07/2017",
      description = "Wdl ATM CBA ATM CIRCULAR QUAY STATION NSW 221092 AUS",
      amount = -200.00
    )
  )
}
