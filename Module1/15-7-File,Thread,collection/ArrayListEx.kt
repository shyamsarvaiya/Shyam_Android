fun main()
{
    var arraylist = ArrayList<String>()

    arraylist.add("a")
    arraylist.add("b")
    arraylist.add("c")

    var arraylist2 = ArrayList<String>()

    arraylist2.add("d")
    arraylist2.add("e")
    arraylist2.add("f")
    arraylist2.add("a")

 /*   println(arraylist)
    println(arraylist2)*/
  /*  arraylist.addAll(arraylist2)
    arraylist.removeAt(2)
    arraylist.removeAll(arraylist2)
*/
    //println(arraylist.get(2))
    arraylist.retainAll(arraylist2)

    var i:Iterator<String> = arraylist.iterator()

    while(i.hasNext())
    {
        println(i.next())
    }



}