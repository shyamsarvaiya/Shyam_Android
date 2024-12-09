package tops.tech.roomdbex.Dao

import androidx.room.Dao
import androidx.room.Insert
import tops.tech.roomdbex.Entity.User
@Dao
interface Daoclass
{
    @Insert
     fun insertdata(user:User?)
}