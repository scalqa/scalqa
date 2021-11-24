package scalqa; package lang; package any; import language.implicitConversions

import Any.{ Boolean, Byte, Char, Short, Int, Long, Float, Double }

object Primitive:
  type Type          = Any.Byte    | Any.Char    | Any.Short    | Any.Int    | Any.Long    | Any.Float    | Any.Double    | Any.Boolean
  type Opaque        = Byte.Opaque | Char.Opaque | Short.Opaque | Int.Opaque | Long.Opaque | Float.Opaque | Double.Opaque | Boolean.Opaque

  type Array[A]      = scala.Array      [A&Byte] | scala.Array      [A&Char] | scala.Array       [A&Short] | scala.Array     [A&Int] | scala.Array      [A&Long] | scala.Array       [A&Float] | scala.Array        [A&Double] | scala.Array         [A&Boolean]
  type Stream[A]     = byte.G.Stream    [A&Byte] | char.G.Stream    [A&Char] | short.G.Stream    [A&Short] | int.G.Stream    [A&Int] | long.G.Stream    [A&Long] | float.G.Stream    [A&Float] | double.G.Stream    [A&Double] | boolean.G.Stream    [A&Boolean]
  type Pack[A]       = byte.G.Pack      [A&Byte] | char.G.Pack      [A&Char] | short.G.Pack      [A&Short] | int.G.Pack      [A&Int] | long.G.Pack      [A&Long] | float.G.Pack      [A&Float] | double.G.Pack      [A&Double] | boolean.G.Pack      [A&Boolean]
  type Range[A]      = byte.G.Range     [A&Byte] | char.G.Range     [A&Char] | short.G.Range     [A&Short] | int.G.Range     [A&Int] | long.G.Range     [A&Long] | float.G.Range     [A&Float] | double.G.Range     [A&Double] | Val.Range           [A&Boolean]
  type Buffer[A]     = byte.G.Buffer    [A&Byte] | char.G.Buffer    [A&Char] | short.G.Buffer    [A&Short] | int.G.Buffer    [A&Int] | long.G.Buffer    [A&Long] | float.G.Buffer    [A&Float] | double.G.Buffer    [A&Double] | boolean.G.Buffer    [A&Boolean]
  type Collection[A] = byte.G.Collection[A&Byte] | char.G.Collection[A&Char] | short.G.Collection[A&Short] | int.G.Collection[A&Int] | long.G.Collection[A&Long] | float.G.Collection[A&Float] | double.G.Collection[A&Double] | boolean.G.Collection[A&Boolean]
  type Idx[A]        = byte.G.Idx       [A&Byte] | char.G.Idx       [A&Char] | short.G.Idx       [A&Short] | int.G.Idx       [A&Int] | long.G.Idx       [A&Long] | float.G.Idx       [A&Float] | double.G.Idx       [A&Double] | boolean.G.Idx       [A&Boolean]
  type Lookup[A,B]   = byte.G.Lookup  [A&Byte,B] | char.G.Lookup  [A&Char,B] | short.G.Lookup  [A&Short,B] | int.G.Lookup  [A&Int,B] | long.G.Lookup  [A&Long,B] | Val.Lookup      [A&Float,B] | Val.Lookup       [A&Double,B] | Val.Lookup        [A&Boolean,B]
  type Opt[A]        = byte.G.Opt       [A&Byte] | char.G.Opt       [A&Char] | short.G.Opt       [A&Short] | int.G.Opt       [A&Int] | long.G.Opt       [A&Long] | float.G.Opt       [A&Float] | double.G.Opt       [A&Double] | boolean.G.Opt       [A&Boolean]
  type Pro[A]        = byte.G.Pro       [A&Byte] | char.G.Pro       [A&Char] | short.G.Pro       [A&Short] | int.G.Pro       [A&Int] | long.G.Pro       [A&Long] | float.G.Pro       [A&Float] | double.G.Pro       [A&Double] | boolean.G.Pro       [A&Boolean]
  type Set[A]        = byte.G.Set       [A&Byte] | char.G.Set       [A&Char] | short.G.Set       [A&Short] | int.G.Set       [A&Int] | long.G.Set       [A&Long] | Val.Set           [A&Float] | Val.Set            [A&Double] | Val.Set             [A&Boolean]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Primitive ->

@type Type        ->  All primitive types \n\n All scalqa supported primitive types, which can be handled by specialized containers.

@type Stream      ->  All primitive stream kinds      \n\n All supported primitive stream implementations.
@type Range       ->  All primitive range kinds       \n\n All supported primitive range implementations.
@type Pack        ->  All primitive pack kinds        \n\n All supported primitive pack implementations.
@type Array       ->  All primitive Array kinds       \n\n All possible primitive Array types supported by JVM.
@type Buffer      ->  All primitive Buffer kinds      \n\n All supported primitive Buffer implementations.
@type Collection  ->  All primitive Collection kinds  \n\n All supported primitive Collection implementations.
@type Idx         ->  All primitive Idx kinds         \n\n All supported primitive indexed collection implementations.
@type Lookup      ->  All primitive Lookup kinds      \n\n All supported primitive lookup colelction implementations.
@type Opt         ->  All primitive Opt kinds         \n\n All supported primitive Opt implementations.
@type Pro         ->  All primitive Pro kinds         \n\n All supported primitive Provider/Property implementations.
@type Set         ->  All primitive Set kinds         \n\n All supported primitive Set implementations.
@type Opaque      ->  All primitive Opaque kinds      \n\n All supported primitive Opaque root types.

*/