open class Bank
{
    fun bank()
    {
        println("banking")
    }
}
class Current : Bank()
{
    fun current()
    {
        println("current")
    }
}
class Save : Bank()
{
    fun save()
    {
        println("saving")
    }
}
fun main()
{
    var c1 = Current()
    var c2 = Save()

    c1.current()
    c2.save()
    c1.bank()


}