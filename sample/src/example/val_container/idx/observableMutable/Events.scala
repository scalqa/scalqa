package example.val_container.idx.observableMutable;  import scalqa.{*, given};  import language.implicitConversions

object Events:

  def main(sa:  Array[String]): Unit =

    val buf = Idx.OM[Int]()

    buf.onChange(_.~.toText.indent("ChangeEvent ").tp.tp)

    buf ++= (0 <>> 10)

    "After Change" +- buf.~ tp()

    buf.remove_<>(3 <> 5)

    "After Change" +- buf.~ tp()

