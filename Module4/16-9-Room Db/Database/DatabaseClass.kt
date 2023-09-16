package tops.tech.roomdbex.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import tops.tech.roomdbex.Dao.Daoclass
import tops.tech.roomdbex.Entity.User

@Database(entities = [User::class], version = 1)
abstract class DatabaseClass : RoomDatabase()
{
    abstract fun daoClass(): Daoclass
}