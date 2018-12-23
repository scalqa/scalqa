package scalqa; package Stream; package Z; package consume; package convert

import java.{ util => J }

private[Stream] object ToJava {

  object List extends Interface.To.Converter[J.List] { def make[A] = f => ToArray.Buffer.make(f).asJavaListView }

  object Iterator extends Interface.To.Converter[J.Iterator] { def make[A] = f => Z.A.Java.Iterator.make(f.sequential) }

  object Stream extends Interface.To.Converter[J.stream.Stream] { def make[A] = f => J.stream.StreamSupport.stream(Spliterator.make(f), false) }

  object Spliterator extends Interface.To.Converter[J.Spliterator] { def make[A] = f => new Z.A.Java.Spliterator(f.sequential, 1) }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
