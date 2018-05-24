package scalqa; package Index; package Val; package Z

private[Val] object Void extends Val[Any] with Index.Z.The.Void[Any] {

  def _minusRange(vl: Val[Any], r: Int.Range) = this

  def _plusAt(i: Int, v: Any, t: Tag[Any]): Val[Any] = this.+(v)(t)

  def _plusAllAt(i: Int, all: ~[Any], sz: Int, t: Tag[Any]): Val[Any] = _plusAll(all, sz, t)

  override def +(v: Any)(implicit tag: Tag[Any] = Tag.Void): Val[Any] = {
    val t = tag ? v.Class.tag
    if (t.isValue) {
      val companion = Any.Value.companion(v)
      new ArrayBased.ValWrap[Any, Any]({ val a = companion.tag[Any].newArrayRaw[Any](1); a(0) = companion.undo(v); a }, companion)
    } else if (t.isPrimitive) {
      new ArrayBased({ val a = t.newArrayRaw[Any](1); a(0) = v; a })
    } else {
      new Tupled._1(v)
    }
  }

  override def _plusAll(a: ~[Any], sz: Int, t: Tag[Any]): Val[Any] = {
    if (t.isValue) {
      val it = a.iterator
      val companion = Any.Value.companion(it.preview)
      new ArrayBased.ValWrap[Any, Any](companion, it.all.map(companion.undo).to(Pipe.To.Array, t.valueTag.cast))
    } else if (t.isPrimitive) {
      new ArrayBased(a.to(Pipe.To.Array, t).raw)
    } else {
      var i = -1
      @inline def v = { i += 1; a.pumpOpt(EVERY) or Fail("All sized:" + sz + " failed at element:" + i + '\n' + a.metadata.I.infoText.indent("Description: ")) }
      sz match {
        case 1  => new Tupled._1(v)
        case 2  => new Tupled._2(v, v)
        case 3  => new Tupled._3(v, v, v)
        case 4  => new Tupled._4(v, v, v, v)
        case 5  => new Tupled._5(v, v, v, v, v)
        case 6  => new Tupled._6(v, v, v, v, v, v)
        case 7  => new Tupled._7(v, v, v, v, v, v, v)
        case 8  => new Tupled._8(v, v, v, v, v, v, v, v)
        case 9  => new Tupled._9(v, v, v, v, v, v, v, v, v)
        case 10 => new Tupled._10(v, v, v, v, v, v, v, v, v, v)
        case 11 => new Tupled._11(v, v, v, v, v, v, v, v, v, v, v)
        case 12 => new Tupled._12(v, v, v, v, v, v, v, v, v, v, v, v)
        case _  => new ArrayBased(a.to(Pipe.To.Array, t).raw)
      }
    }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/