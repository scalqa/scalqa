package scalqaTry.Gen.Event;  import scalqa.{*, given};  import language.implicitConversions

/*
   Purpose: Illustrate simple event creation


*/
object Create:

  class TimeSource:
    private   val eventStore                   : Event.Store   = new Event.Store()
    /**/      def onEverySecond(f: Time => Any): Event.Control = eventStore.onEvent1(TimeSource.ChangeEvent, f)
    protected def fireEverySecond(t: Time)     : Unit          = eventStore.fireEvent1(TimeSource.ChangeEvent, t)
    J.scheduleEvery(1.Second, fireEverySecond(Time()))

  object TimeSource:
    object ChangeEvent

  def main(sa:  Array[String]): Unit =

    val ts = new TimeSource

    ts.onEverySecond(_.tp).limitRunsTo(3)

    J.sleep(5.Seconds)

    J.Vm.exit