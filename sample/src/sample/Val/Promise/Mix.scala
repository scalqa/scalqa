package sample.Val.Promise;  import scalqa.{*, given};  import language.implicitConversions

object Mix:

  def main(sa:  Array[String]): Unit =

    val p1: Promise[String] = Promise{ J.sleep(1.Second);  "Promise1" }
    val p2: Promise[String] = Promise{ J.sleep(2.Seconds); "Promise2" }
    val p3: Promise[String] = Promise{ J.sleep(3.Seconds); "Promise3" }

    p1.onResult(_ => "Promise 1 ready".tp)
    p2.onResult(_ => "Promise 2 ready".tp)
    p3.onResult(_ => "Promise 3 ready".tp)

    val p: Promise[String] = for(x <- p1; y <- p2; z <- p3) yield x + " " + y + " " + z

    p.onResult(_.tp)

    J.sleep(4.Seconds)

    J.Vm.exit

