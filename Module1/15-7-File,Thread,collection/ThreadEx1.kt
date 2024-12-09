class T1 : Thread()
{
    override fun run()
    {
        super.run()
        for(i in 1..10)
        {
            println("Thread T1 : $i")
        }
    }
}
class T2 :Thread()
{
    override fun run()
    {
        super.run()
        for(i in 1..10)
        {
            println("Thread T2 : $i")
        }
    }
}

fun main()
{
    var t1 = T1()
    var t2 = T2()

    t1.start()
    t2.start()
}