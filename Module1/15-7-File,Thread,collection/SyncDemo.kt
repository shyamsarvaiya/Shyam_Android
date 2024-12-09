class Sender
{
    fun send(msg:String)
    {
        println("Sending $msg")
        Thread.sleep(1000)
        println("$msg sent")
    }
}

class ThreadSend(var sender: Sender,var msg:String) : Thread()
{

    override fun run()
    {
        super.run()
        synchronized(sender)
        {
            sender.send(msg)
        }


    }


}

fun main()
{
    var s1 = Sender()

    var t1 = ThreadSend(s1,"Hii")
    var t2 = ThreadSend(s1,"Byee")

    t1.start()
    t2.start()
}

