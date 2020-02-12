package  com.cvcheck.db.entity

import androidx.databinding.BaseObservable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "experience_table")
data class Experience(
        var name: String? = "Test",
        var image: String? = "New",
        var occupation: String? = "",
        var aboutMe: String? = ""
): BaseObservable()
{

        @PrimaryKey(autoGenerate = true)
        var expId: Int = 0

}
