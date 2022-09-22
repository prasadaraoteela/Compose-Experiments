package com.experiments.compose.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Created by Prasada Rao on 27/03/22 7:18 PM
 **/
data class City(val name: String, val country: String)

val CitySaver = run {
  val nameKey = "Name"
  val countryKey = "Country"
  mapSaver(
    save = {
      mapOf(nameKey to it.name, countryKey to it.country)
    },
    restore = { map ->
      City(name = map[nameKey] as String, country = map[countryKey] as String)
    }
  )
}

val CityListSaver = listSaver<City, String>(
  save = { listOf(it.name, it.country) },
  restore = { City(name = it[0], country = it[1]) }
)

@Composable
fun CityScreen(modifier: Modifier = Modifier) {
  val selectedCity by rememberSaveable(stateSaver = CitySaver) {
    mutableStateOf(City(name = "Madrid", country = "Spain"))
  }
  Card(
    elevation = 4.dp,
    modifier = Modifier.padding(12.dp)
  ) {
    Row {
      Text(text = selectedCity.name)
      Text(text = selectedCity.country)
    }
  }
}

@Preview(showBackground = true)
@Composable
fun CityScreenPreview() {
  CityScreen()
}
