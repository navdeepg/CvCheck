package  com.cvcheck.db.entity

import androidx.databinding.BaseObservable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
import kotlin.collections.ArrayList


@Entity(tableName = "exp_type_table")
data class ExperienceType(
        var title: String? = "",
        var description: String? = "",
        var companyName: String? = "",
        var duration: String? = ""
): BaseObservable()
{

        @PrimaryKey(autoGenerate = true)
        var expTypeId: Int = 0

}
