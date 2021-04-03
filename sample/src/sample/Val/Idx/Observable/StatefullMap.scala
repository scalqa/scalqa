package sample.Val.Idx.Observable;  import scalqa.{*, given};  import language.implicitConversions

/*
   Purpose: Prove that x.statefulMap_^ instances are garbage collected, when not in use

*/
object StatefullMap:

  def main(sa:  Array[String]): Unit =
    val list = Idx.OM[Int]()
    var m = list.statefulMap_^(_ * 100)
    val weak = J.WeakRef(m)

    weak.tp
    m.tp

    weak.get_?.get.onChange(_.~.tp)
      .limitRunsTo(3)
      .onCancelRun("Event Cancelled".tp)

    val p = (1 <> 6).~.enablePreview

    J.scheduleEvery(1.Second, {
      list += p.read
      J.Vm.Memory.gc
      "ref =" +- weak tp()
    })
      .cancelIf(() => p.preview_?.isVoid)
      .onCancelRun(J.Vm.exit)

    J.sleep(3.Seconds)
