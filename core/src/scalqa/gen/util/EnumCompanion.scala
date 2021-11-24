package scalqa; package gen; package util; import language.implicitConversions

abstract class EnumCompanion[A <: scala.reflect.Enum] extends Idx[A]:
  protected  def values      : Array[A]
  @fast lazy val pack        : Pack[A]   = values.stream.sortBy(_.ordinal).pack
  override   def stream      : Stream[A] = pack.stream
  /**/       def apply(i:Int): A         = pack(i)
  /**/       def size        : Int       = pack.size

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class EnumCompanion -> ###

   [[EnumCompanion]] is a type to be extended by all `enum` companion objects to integrate them with Scalqa containers.

   This is a recommended step, which might not be nessesasy in simple cases

  ```
    enum Direction:
      case Up,Down,Left,Right

    object Direction extends EnumCompanion[Direction]

    Direction.stream.TP

    // Output
    Stream(Up, Down, Left, Right)
  ```

@val pack -> All values

        Packed values

@def stream -> Stream

        Enum values as a stream, ordered by `ordinal` property
*/