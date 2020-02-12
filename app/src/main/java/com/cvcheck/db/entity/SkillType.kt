package  com.cvcheck.db.entity

import androidx.databinding.BaseObservable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
import kotlin.collections.ArrayList


@Entity(tableName = "skill_type_table")
data class SkillType(
        var name: String? = "",
        var description: String? = ""
): BaseObservable()
{

        @PrimaryKey(autoGenerate = true)
        var skillTypeId: Int = 0

}
