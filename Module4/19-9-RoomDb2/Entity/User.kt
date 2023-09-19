package tops.tech.roomdbex.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tops")
class User
{

        @PrimaryKey(autoGenerate = true)
        var id=0

        @ColumnInfo(name = "user_name")
        var username=""

        @ColumnInfo(name = "user_email")
        var useremail=""



}