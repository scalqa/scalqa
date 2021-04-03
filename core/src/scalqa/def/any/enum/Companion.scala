package scalqa; package `def`; package any; package `enum`; import language.implicitConversions

abstract class Companion[A <: scala.reflect.Enum] extends Able.~[A]:
  protected def values: Array[A]

  @tn("pack") @fast lazy val >< : ><[A] = values.~.sortBy(_.ordinal).><
  @tn("stream")   inline def ~  : ~[A]  = this.><.~

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Companion -> ###

   [[Companion]] is a type to be extended by all `enum` companion objects to integrate them with Scalqa containers.

   This is a recommended step, which might not be nessesasy in simple cases

  ```
    enum Direction:
      case Up,Down,Left,Right

    object Direction extends Any.Enum.Companion[Direction]

    Direction.~.TP

    // Output
    ~(Up, Down, Left, Right)
  ```

@val >< -> Packed

        Packed values

@def ~ -> Stream

        Enum values as a stream, ordered by `ordinal` property
*/