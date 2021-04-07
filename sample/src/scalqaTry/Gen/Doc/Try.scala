package scalqaTry.Core.Doc; import scalqa.{*, given};  import language.implicitConversions
/*
   Purpose: Illustrate power of Doc object documentation, where Doc can be printed as line, text, or table

*/
object Try:

  class Object(i: Int) extends Able.Doc:
    def name         = "name" + i
    def index        = i
    def multiple10   = i * 10
    def multiple100  = i * 100
    def multiple1000 = i * 1000
    def doc         = Doc(this) += ("name", name) += ("index", index) += ("multiple10", multiple10) += ("multiple100", multiple100) += ("multiple1000", multiple1000)

  def main(sa:  Array[String]): Unit =
    val v = new Object(5)

    v.tag.tp

    v.doc.text.tp

    (1 <> 5).~.map(Object(_)).print

