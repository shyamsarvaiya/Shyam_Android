import java.io.FileInputStream

fun main()
{

    var fis: FileInputStream =FileInputStream("E://sahil.txt")
    var barr: ByteArray = ByteArray(fis.available())
    fis.read(barr)
    var str: String = String(barr)
    println(str)


}