package  com.cvcheck.db.entity

import androidx.databinding.BaseObservable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "experience_table")
data class Experience(
        var experiences: List<ExperienceType>? = null
): BaseObservable()
{

        @PrimaryKey(autoGenerate = true)
        var expId: Int = 0

}
