package scalqaTry.Val.Promise;  import scalqa.{*, given};  import language.implicitConversions

object Transitions:

  def main(sa:  Array[String]): Unit =

    val p = Promise{ J.sleep(1.Second); 12 }

    p.onResult(_.tp)

    p.map(_ / 4).onResult(_.tp)

    p.map(_ / 0).onResult(_.tp)

    p.take(_ > 15, _ => "Must be over 15").onResult(_.tp)

    J.sleep(2.Seconds)

