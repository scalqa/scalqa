package example.gen.event.store;  import scalqa.{*, given};  import language.implicitConversions
/*
   Purpose: Illustrate how Event.Store can be printed out
*/

object ToText:

  def main(sa:  Array[String]): Unit =

    val eventStore = new Event.Store()
    eventStore.onEvent1[Any]("Scope1", v => ())
    eventStore.onEvent2[Any, Any]("Scope2", (v1, v2) => ())
    eventStore.onEvent1[Any]("Scope3", v => ())
    eventStore.onEvent2[Any, Any]("Scope4", (v1, v2) => ())
    eventStore.toText().tp


