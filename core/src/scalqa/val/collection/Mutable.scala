package scalqa; package `val`; package collection

trait Mutable[A] extends Collection[A] with Able.Add[A]:
  /**/              def remove(v: A)       : Int
  /**/              def removeAll(v: ~[A]) : Int       = v.map(remove).sum
  /**/              def clear              : Unit
  /**/              def replaceAll(v: ~[A]): Unit      = { clear; addAll(v) }
  @tn("_remove")    def -= (v: A)          : this.type = { this.remove(v);    this }
  @tn("_removeAll") def --=(v: ~[A])       : this.type = { this.removeAll(v); this }

object Mutable:
  def apply[A](initSize: Int = J.initSize)           : Collection[A] = Buffer[A](initSize)
  def uniqueElementSet[A](initSize: Int = J.initSize): Collection[A] = Z.UniqueElementSet(initSize)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Mutable -> ### Mutable Collection

@def remove -> Remove element

    Removes all collection elements, which are equal to the given value

    Returns count of removed elements, which can be 0, 1, or many

@def -= -> Alias for [[remove]]

    Removes all collection elements, which are equal to the given value

    Returns the collection itself

@def removeAll -> Remove all streamed

    Removes all collection elements, which are equal to those in given stream

    Returns count of removed elements, which can be 0, 1, or many

@def --= -> Alias for [[removeAll]]

    Removes all collection elements, which are equal to those in given stream

    Returns the collection itself

@def clear -> Remove everything

    Discards all elements, so the colection size will become 0

@def replaceAll -> Replace everything

    Discards all old elements and adds all provided elements

*/