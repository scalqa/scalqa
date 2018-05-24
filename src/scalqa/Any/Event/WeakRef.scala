package scalqa; package Any; package Event

class WeakRef[A] private (private val real: java.lang.ref.WeakReference[A]) extends AnyVal

object WeakRef {

  def get[A](t: A) = new WeakRef[A](new java.lang.ref.WeakReference[A](t))

  import scala.language.implicitConversions

  implicit def zzGet[A](a: A) = get(a)

  implicit def zzTargetType[A](r: WeakRef[A]): A = r.real.get.Opt or (throw CancelException)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class WeakRef ->
 *
 *   If we use an object within some event code, this will create a hard reference
 *
 *   The referenced object will not be garbage collected, even if it is not used anywhere else
 *
 *   [[WeakRef]] allows to create a week referenced objects, which will be garbage
 *   collected and the event will be cancelled as a side effect
 *
 *   {{{
 *      // Generic application class
 *      class MyCounter {
 *         private var cnt = 0
 *
 *         def next = cnt.I.run(cnt += 1)
 *
 *         override def finalize = "MyCounter is garbage collected".lp
 *      }
 *
 *      var hardRef = new MyCounter
 *
 *      Time.currentPro(1.Second) // Pro.O[Time] with observable change every second
 *        .onValueChange(t => {
 *          val mc : MyCounter = Any.Event.WeakRef.get(hardRef)
 *          Print.ls("Time:", t.dayTime, "Counter value:",  mc.next)
 *        })
 *        .onCancelRun(() => {
 *          "Job cancelled".lp
 *          App.exit
 *        })
 *
 *      Schedule.onceIn(3.Seconds, {
 *        hardRef = null
 *        "MyCounter reference removed".lp
 *        App.Memory.gc
 *      })
 *
 *      // Output
 *      Time: 10:40:01.186 Counter value: 0
 *      Time: 10:40:02.037 Counter value: 1
 *      Time: 10:40:03.036 Counter value: 2
 *      MyCounter reference removed
 *      MyCounter is garbage collected
 *      Job cancelled
 *      App.exit requested
 *   }}}
 */
