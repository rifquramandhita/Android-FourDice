package id.four.fourdice.data

import id.four.fourdice.R

class DataSource{
    fun loadListIdImage() : List<Int>{
        return listOf(
            R.drawable.dice_1,
            R.drawable.dice_2,
            R.drawable.dice_3,
            R.drawable.dice_4,
            R.drawable.dice_5,
            R.drawable.dice_6
        )
    }
}