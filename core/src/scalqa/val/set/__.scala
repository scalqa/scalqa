package scalqa; package `val`; import language.implicitConversions

abstract class Set[A] private[scalqa]() extends Collection[A] with gen.able.Contain[A]:
  type THIS_TYPE <: Set[A]
  /**/                   def join(v: A)         : THIS_TYPE
  /**/                   def joinAll(v: ~[A])   : THIS_TYPE
  @tn("join")     inline def + (inline v: A)    : THIS_TYPE = join(v)
  @tn("joinAll")  inline def ++(inline v: ~[A]) : THIS_TYPE = joinAll(v)
  /**/                   def contains(v: A)     : Boolean

object Set:
  /**/            def apply[A](v: A*)           : Set[A] = Z.AnyRef(v.iterator)
  /**/            def fromStream[A](v: ~[A])    : Set[A] = Z.AnyRef(v.iterator)
  @tn("getVoid")  def void[A]                   : Set[A] = Z.Void.cast[Set[A]]

  implicit inline def implicitRequest[A](v: \/) : Set[A] = void[A]

  // *****************************************************************************************************
  private object Z:
    import scala.collection.immutable.{ HashSet => REAL }

    final class AnyRef[A] private (real: REAL[A]) extends Set[A]:
        def this(v : Iterator[A]) = this(REAL.from(v))
        type THIS_TYPE = Set[A]
        /**/          def contains(v: A)   : Boolean      = real.contains(v)
        /**/          def size             : Int          = real.size
        @tn("stream") def ~                : ~[A]         = real.~
        /**/          def join(v: A)       : Set[A] = new AnyRef(real + v)
        /**/          def joinAll(v: ~[A]) : Set[A] = new AnyRef(real ++ v.iterator)

    object Void extends Set[Any] with Gen.Void:
      type THIS_TYPE = Set[Any]
      /**/            def contains(v: Any)  : Boolean        = false
      /**/            def size              : Int            = 0
      @tn("stream")   def ~                 : ~[Any]         = \/
      /**/            def join(v: Any)      : Set[Any] = Set(v)
      /**/            def joinAll(v: ~[Any]): Set[Any] = Set(v)


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Set ->
       [[Set]] is an immutable collection with no duplicate values

       When an element is [[join]]ed to [[Set]], it is evaluated for uniqueness and the operation is ignored in case of duplicates.

       Note: [[scalqa.val.collection.Set Set]] is a concrete single implementation of unique collection.
       There is no general "Set" interface, because its use is rare. If there is a need for more efficient "Set" functionality,
       create one with [[scalqa.val.collection.Mutable$.noDuplicates Collection.Mutable.noDuplicates]]. The result is faster, but is not thread safe.

@def join -> Join element

    If given value does not exist in current collection, a new [[Set]] is created with this value

    ```
      var set: Set[Int] = \/

      set = set.join(1).join(1).join(2).join(2).join(3).join(3)

      set.~.TP  // Prints ~(1, 2, 3)
    ```

@def + -> Alias for [[join]]

    If given value does not exist in current collection, a new [[Set]] is created with this value

    ```
      var set: Set[Int] = \/

      set = set + 1 + 2 + 3 + 1 + 2 + 3

      set.~.TP  // Prints ~(1, 2, 3)
    ```

@def joinAll -> Join stream of elements

    Creates a [[Set]] with a stream of only unique elements joined in

    ```
      var set: Set[Int] = \/

      set = set.joinAll(1 <> 5).joinAll(3 <> 8).joinAll(5 <> 10)

      set.~.sort.TP  // Prints ~(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    ```

@def ++ -> Alias for [[joinAll]]

    Creates a [[Set]] with a stream of only unique elements joined in

    ```
      var set: Set[Int] = \/

      set = set ++ (1 <> 5) ++ (3 <> 8) ++ (5 <> 10)

      set.~.sort.TP  // Prints ~(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    ```
*/
