package scalqa; package `val`; package collection; import language.implicitConversions

object Z:

  def contains[A](x: Collection[A], v: A): Boolean =
    x  match
        case c: Able.Contain[_] => c.cast[Able.Contain[A]].contains(v);
        case c: Idx[_]          => {val x=c.cast[Idx[A]];{var i=0; val sz=x.size; while(i<sz){if(x(i)==v) return true; i+=1}}; false}
        case c                  => c.~.contains(v)

  def onObservableChange[A,U](x: Observable[A], l: () => U): Event.Control =
    x  match
        case v: Idx.O[_] => v.onChange(_ => l())
        case v           => Event.Control.join(x.onAdd(Event.Id.map1(l,_ => l())), x.onRemove(Event.Id.map1(l,_ => l())))

  class ReadOnly_View[A](real: Collection[A]) extends Collection[A]:
    @tn("stream") def ~    = real.~
    /**/          def size = real.size

  class ValueMap_View[A,B](real: Collection[A], m: A => B) extends Collection[B]:
    @tn("stream") def ~    = real.~.map(m(_))
    /**/          def size = real.size

  class UniqueElementSet[A](initSize: Int) extends Mutable[A]:
    import scala.collection.mutable.HashMap
    private val real = new HashMap[A,Unit](initSize,HashMap.defaultLoadFactor)
    @tn("stream") def ~             = real.keySet
    /**/          def size          = real.size
    /**/          def add(v: A)     = real.put(v,())
    /**/          def remove(v: A)  = real.remove(v).nonEmpty.toInt
    /**/          def clear         = real.clear

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
