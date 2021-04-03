package sample.Val.Idx.ObservableMutable;  import scalqa.{*, given};  import language.implicitConversions

object Events:

  def main(sa:  Array[String]): Unit =

    val l = Idx.OM[Int]()

    l.onChange(_.~.toText.indent("ChangeEvent ").tp.tp)

    l ++= (0 <>> 10)

    l.~.toText.indent("After Change ").tp.tp

    l refresh_<> 3 <> 5

    l.~.toText.indent("After Change ").tp.tp

