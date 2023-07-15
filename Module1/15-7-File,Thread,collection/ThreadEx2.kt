class T11 : Runnable
{
    override fun run() {
        for(i in 1..10)
        {
            println("Thread T11 : $i")
        }
    }

}
class T22 : Runnable
{
    override fun run() {
        for(i in 1..10)
        {
            println("Thread T22 : $i")
        }
    }

}

fun main()
{
    var t1 = Thread(T11())
    var t2 = Thread(T22())

    t1.start()
    t2.start()
}