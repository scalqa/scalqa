package scalqaTry.Fx.test;  import scalqa.{*, given};  import language.implicitConversions

object zTest:

  def main(sa:  Array[String]): Unit =
    val l = Idx.OM[Int]()

    val ol = Fx.JavaFx.list(l)
    val lo = Fx.JavaFx.As.idx_O(ol)

    ol.^.tp
    lo.^.tp

    //  l ++= (1 <> 5 !).reverse

    l.onChange( v => { "\n ****** Strt".tp; v.~.toText.tp })
    lo.onChange(v => { "\n ****** End".tp;  v.~.toText.tp })

    l.modify(l => {
      l += 0
      l ++= (1 <> 5).~.reverse
      l(1) = 11
      l(2) = 12
      l(3) = 13
      l.sort
      l.removeAt(1)
      //    l.refresh(1)
      l.removeAt(1)
    })

    //l += 0
    //
    //l ++= (1 <> 5).~.reverse
    //
    //  l.delete(3)
    //
    //  l.sort
    //
    //  l.refresh(3 to 5)

    //  l.refresh(3 to 3)

    l.~.tp
    lo.~.tp
