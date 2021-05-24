package example.val_container.idx.observable;  import scalqa.{*, given};  import language.implicitConversions

/*
   Purpose: Prove that x.statefulMap_^ instances are garbage collected, when not in use

*/
object StatefullMap:
  val buf  = Idx.OM[Int]()
  var map  = buf.statefulMap_^(_ * 100)
  val weak = J.WeakRef(map)

  def main(sa:  Array[String]): Unit =

    J.scheduleEvery(1.Second, {
      buf += 1
      J.Vm.Memory.gc
      "weakRef =" +- weak tp()
    })
      .limitRunsTo(5)
      .onCancelRun{J.Vm.exit}

    J.sleep(3.Seconds)

    "Clearing hard ref...".tp
    map = null
