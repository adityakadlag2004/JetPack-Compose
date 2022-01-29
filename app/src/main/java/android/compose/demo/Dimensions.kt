package android.compose.demo

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

sealed class Dimensions {
    object Width : Dimensions()
    object Height : Dimensions()


    sealed class DimensionOperator {
        object LessThan : DimensionOperator()
        object GreaterThan : DimensionOperator()
    }

    class DimensionComparator(
        val Operator: DimensionOperator,
        private val dimension: Dimensions,
        val Value: Dp
    ) {
        fun compare(screenWidth: Dp, screenHeight: Dp): Boolean {
            return if (dimension is Width) {
                when (Operator) {
                    is DimensionOperator.LessThan -> screenWidth < Value
                    is DimensionOperator.GreaterThan -> screenWidth > Value
                }
            } else {
                when (Operator) {
                    is DimensionOperator.LessThan -> screenHeight < Value
                    is DimensionOperator.GreaterThan -> screenHeight > Value
                }
            }
        }
    }
}


@Composable
fun MediaQuery(comparator: Dimensions.DimensionComparator, content: @Composable () -> Unit) {
    val screenWidth =
        LocalContext.current.resources.displayMetrics.widthPixels.dp / LocalDensity.current.density
    val screenHeight =
        LocalContext.current.resources.displayMetrics.heightPixels.dp / LocalDensity.current.density
    if (comparator.compare(screenWidth, screenHeight)) {
        content()
    }
}

infix fun Dimensions.lessThan(value:Dp):Dimensions.DimensionComparator{
    return Dimensions.DimensionComparator(Operator = Dimensions.DimensionOperator.LessThan, dimension = this,value)
}

infix fun Dimensions.greaterThan(value:Dp):Dimensions.DimensionComparator{
    return Dimensions.DimensionComparator(Operator = Dimensions.DimensionOperator.GreaterThan, dimension = this,value)
}