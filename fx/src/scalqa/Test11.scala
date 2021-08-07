package scalqa; import language.implicitConversions

object Test11:

  def main(sa: Array[String]): Unit =


    var t: Time = CURRENT

    var i = 0

    "1-------------------------".tp
    val l = 3.Seconds

    "2-------------------------".tp
    t += 4.Seconds
    "3-----------------------d--".tp
    t += 7L.Seconds
    "4-------------------------".tp
    t = t + l
    "5-------------------------".tp


//    while( t > CURRENT){
//      J.sleep(1.Second)
//      i += 1
//    }

    i.tp


    t.tp