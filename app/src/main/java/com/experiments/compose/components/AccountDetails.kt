package com.experiments.compose.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.experiments.compose.R
import com.experiments.compose.data.SampleData
import com.experiments.compose.data.model.Account
import com.experiments.compose.data.model.TransactionGroup

/**
 * Created by Prasada Rao on 27/11/21 1:24 PM
 **/
@ExperimentalFoundationApi
@Composable
fun AccountDetails(
  account: Account,
  transactionGroups: List<TransactionGroup>
) {

  Scaffold(
    topBar = {
      MyTopBar()
    }
  ) { innerPadding ->
    TransactionList(modifier = Modifier.padding(innerPadding), account = account, transactionGroups = transactionGroups)
  }
}

@Composable
private fun MyTopBar(modifier: Modifier = Modifier) {
  TopAppBar(
    modifier = modifier,
    title = { Text(text = "Account details") },
    backgroundColor = Color.White,
    navigationIcon = {
      Icon(
        painter = painterResource(id = R.drawable.icon_welcome_logo),
        contentDescription = "Navigation Icon",
        tint = Color.Unspecified
      )
    }
  )
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun AccountDetailsPreview() {
  AccountDetails(account = SampleData.accountInformation, transactionGroups = SampleData.transactionGroups)
}
