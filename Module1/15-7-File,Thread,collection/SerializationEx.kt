import java.io.FileOutputStream
import java.io.ObjectOutputStream

fun main()
{

    var s1 = Student12(101,"a")
    var fout = FileOutputStream("E://shyam.txt")
    var out = ObjectOutputStream(fout)
    out.writeObject(s1)
    println("success")

}