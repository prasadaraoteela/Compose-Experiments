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
import com.experiments.compose.components.ui.theme.Yellow
import com.experiments.compose.data.SampleData.transactionGroup
import com.experiments.compose.data.model.Transaction
import com.experiments.compose.data.model.TransactionGroup
import com.experiments.compose.util.dateToDisplayFormat
import com.experiments.compose.util.formatAsAmount
import com.experiments.compose.util.numberOfDaysAgo

/**
 * Created by Prasada Rao on 26/11/21 1:28 PM
 **/
@Composable
fun TransactionHeader(
  modifier: Modifier = Modifier,
  transactionGroup: TransactionGroup
) {
  Row(
    modifier = modifier
      .background(color = Yellow)
      .padding(horizontal = 4.dp, vertical = 8.dp),
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    Text(
      text = transactionGroup.date,
      modifier = Modifier.weight(1f),
      style = MaterialTheme.typography.h6
    )
    Text(
      text = transactionGroup.timeAgo,
      style = MaterialTheme.typography.h6
    )
  }
}

@Preview(showBackground = true)
@Composable
fun TransactionHeaderPreview() {
  TransactionHeader(transactionGroup = transactionGroup)
}
