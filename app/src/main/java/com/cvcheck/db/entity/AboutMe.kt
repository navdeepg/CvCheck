package  com.cvcheck.db.entity

import androidx.databinding.BaseObservable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "about_table")
data class AboutMe(
        var name: String? = "",
        var image: String? = "",
        var occupation: String? = "",
        var aboutMe: String? = ""
): BaseObservable()
{

        @PrimaryKey(autoGenerate = true)
        var id: Int = 0

}
