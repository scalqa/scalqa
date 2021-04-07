package scalqaTry.Gen.Event.Store;  import scalqa.{*, given};  import language.implicitConversions

/*
   Purpose: Illustrate activation

   Note: The test object is activated with 3 different conditions and remains active until all 3 fail


*/
object Activation:

  object Test:
    private val eventStore = new Event.Store()
    eventStore.onActivateRun("ACTIVATED".tp)
    eventStore.onDeactivateRun("DEACTIVATED".tp)
    var a1, a2, a3 = true
    eventStore.activate(() => a1)
    eventStore.activate(() => a2)
    eventStore.activate(() => a3)
    def isActive = eventStore.isActive

  def main(sa:  Array[String]): Unit =
    J.scheduleIn(1.Second,  { Test.a1 = false })
    J.scheduleIn(2.Seconds, { Test.a2 = false })
    J.scheduleIn(3.Seconds, { Test.a3 = false })

    (0 <> 5).~.peek(_ => J.sleep(900.Millis)).foreach(_ => ("Active = " + Test.isActive).tp)

    J.Vm.exit

