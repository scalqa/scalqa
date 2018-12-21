package scalqa; package Stream; package Z; package consume; package convert

private[Stream] object ToScala {

  object List extends Interface.To.Converter[List] {

    def make[A] = f => { var l: List[A] = Nil; f.foreachSynchronized(v => l = v :: l); l }
  }

  // ****************************************************************************************************************
  object Iterator extends Interface.To.Converter[scala.Iterator] {

    def make[A] = f => Z.A.Scala.Iterator.make(f.sequential)
  }

  // ****************************************************************************************************************
  object Vector extends Interface.To.Converter[Vector] {

    def make[A] = f => Iterator.make(f).toVector
  }

  // ****************************************************************************************************************
  object Buffer extends Interface.To.Converter[collection.mutable.Buffer] {

    def make[A] = f => { val w = new collection.mutable.ArrayBuffer[A](f.sizeOpt or App.initSize); f.foreachSynchronized(w.+=); w }
  }

  // ****************************************************************************************************************
  object IndexedSeq extends Interface.To.Converter[IndexedSeq] {

    def make[A] = f => ToArray.Buffer.make(f).asSeqView
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
