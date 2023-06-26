package rs.ac.metropolitan.pzcs330.presentation.list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import rs.ac.metropolitan.pzcs330.domain.model.Bike

@Composable
fun BikeListItem(
    bike: Bike,
    onItemClick: (Bike) -> Unit
) {
    Row (
        modifier = Modifier
            .fillMaxSize()
            .clickable { onItemClick(bike) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text (
            text = "${bike.name} ${bike.brand} ${bike.battery}" ,
            style = MaterialTheme.typography.bodyLarge,
            overflow = TextOverflow.Ellipsis
        )
        Text (
            text = "${bike.name} ${bike.brand} ${bike.battery}" ,
            style = MaterialTheme.typography.bodyLarge,
            overflow = TextOverflow.Ellipsis,
            color = Color.Green,
            textAlign = TextAlign.End,
            modifier = Modifier.align(CenterVertically)
            )
}
}
