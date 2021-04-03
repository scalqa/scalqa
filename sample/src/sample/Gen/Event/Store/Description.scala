package sample.Gen.Event.Store;  import scalqa.{*, given};  import language.implicitConversions
/*
   Purpose: Illustrate how Any.Ref.Extra list can be peeked at


*/
object Description:

  def main(sa:  Array[String]): Unit =
    "Description".tp
    new Test

  class Test:
    private val eventStore = new Event.Store()
    eventStore.onEvent1[Any]("Scope1", v => ())
    eventStore.onEvent2[Any, Any]("Scope2", (v1, v2) => ())
    eventStore.onEvent1[Any]("Scope3", v => ())
    eventStore.onEvent2[Any, Any]("Scope4", (v1, v2) => ())
    eventStore.describe().tp


