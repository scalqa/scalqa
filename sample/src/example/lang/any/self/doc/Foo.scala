package example.lang.any.self.doc; import scalqa.{*, given};  import language.implicitConversions
/*
   Purpose: Illustrate power of Doc object documentation, where Doc can be printed as line, text, or table
*/

object Foo:

  class Bar(i: Int) extends Able.Doc:
    def name      = "bar" + i
    def index     = i
    def multi10   = i * 10
    def multi100  = i * 100
    def multi1000 = i * 1000
    def doc      = Self.Doc(this) += ("name", name) += ("index", index) += ("multi10", multi10) += ("multi100", multi100) += ("multi1000", multi1000)

  def main(sa:  Array[String]): Unit =
    val v = new Bar(5)

    v.tag.tp.tp

    v.doc.text.tp.tp

    (1 <> 5).~.map(Bar(_)).print

