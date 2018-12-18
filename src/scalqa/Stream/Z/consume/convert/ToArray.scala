package scalqa; package Stream; package Z; package consume; package convert

import Stream.A.Specialized.Indexed

private[Stream] object ToArray {

  object Buffer extends Interface.To.Converter[Idx.Array.Buffer] {

    def make[A] = _ match {
      case v: Stream[_] => apply(v.asInstanceOf[Stream[A]])
      case v            => applyFlow(v)
    }
    def apply[@specialized(DATA) A](s: Stream[A]): Idx.Array.Buffer[A] = {
      var src = s
      val ilk = s.ilkOpt or { val b = s.preview; src = b; b.previewIlk }
      val bin = ilk.mkBuffer[A](src.sizeOpt);
      src.copyTo(bin)
      bin
    }
    def applyFlow[@specialized(DATA) A](f: Stream.Flow[A]): Idx.Array.Buffer[A] = {
      class Each extends Consumer[A] {
        var b = false
        var bin: Idx.Array.Buffer[A] = null
        def accept(v: A) = {
          if (b) { b = false; bin = v.Class.ilk.mkBuffer[A](f.sizeOpt) }
          bin.add(v)
        }
      }
      f.ilkOpt.map(_.mkBuffer[A](f.sizeOpt)).apply(b => f.foreachSynchronized(b.add)) or { val r = new Each; f.foreachSynchronized(r); r.bin }
    }
  }

  // ****************************************************************************************
  object View extends Interface.To.Converter[Idx.I] {

    def make[A] = f => f.ilkDefault.mkValue(f)
  }

  // ****************************************************************************************
  object Refs extends Interface.To.Converter[Refs] {

    def make[A] = f => Idx.I.Refs.fromFlow[A](f)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
