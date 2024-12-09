import java.io.FileInputStream
import java.io.ObjectInput
import java.io.ObjectInputStream

fun main()
{

    var out = ObjectInputStream(FileInputStream("E://shyam.txt"))
    var s:Student12 = out.readObject() as Student12
    println("${s.id} and ${s.name}")

}