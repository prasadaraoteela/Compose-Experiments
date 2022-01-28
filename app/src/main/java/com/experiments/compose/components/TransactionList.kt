package com.experiments.compose.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.experiments.compose.AccountHeader
import com.experiments.compose.data.SampleData.accountInformation
import com.experiments.compose.data.SampleData.transactionGroups
import com.experiments.compose.data.model.Account
import com.experiments.compose.data.model.TransactionGroup

/**
 * Created by Prasada Rao on 26/11/21 1:40 PM
 **/
@ExperimentalFoundationApi
@Composable
fun TransactionList(
  modifier: Modifier = Modifier,
  account: Account,
  transactionGroups: List<TransactionGroup>
) {
  LazyColumn(
    modifier = modifier
  ) {
    item {
      AccountHeader(account = account)
    }
    transactionGroups.forEach { transactionGroup ->
      stickyHeader {
        TransactionHeader(transactionGroup = transactionGroup)
      }
      itemsIndexed(transactionGroup.transactions) { index, transaction ->
        Transaction(transaction = transaction)
        if (index < transactionGroup.transactions.lastIndex) {
          Divider(color = Color.White, thickness = 1.dp)
        }
      }
    }
  }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun TransactionListPreview() {
  TransactionList(account = accountInformation, transactionGroups = transactionGroups)
}
