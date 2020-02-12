package  com.cvcheck.db.entity

import androidx.databinding.BaseObservable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
import kotlin.collections.ArrayList


@Entity(tableName = "skill_table")
data class Skill(
        var skills: List<SkillType>? = null
): BaseObservable()
{

        @PrimaryKey(autoGenerate = true)
        var skillId: Int = 0

}
