package scalqa; package lang; package long; package z; import language.implicitConversions

transparent trait toPrimitives[A<:RAW]:

  extension(inline x:A)
    inline def Byte  : Byte               = x.cast[Byte]
    inline def Char  : Char               = x.cast[Char]
    inline def Short : Short              = x.cast[Short]
    inline def Int   : Int                = x.cast[Int]
    inline def Long  : Long               = x.cast[Long]
    inline def Float : Float              = x.cast[Float]
    inline def Double: Double             = x.cast[Double]
    inline def Number: java.lang.Long     = java.lang.Long.valueOf(x)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def Byte    -> Make Byte

                Attached Byte constructor

@def Char    -> Make Char

                Attached Char constructor

@def Short   -> Make Short

                Attached Short constructor

@def Int     -> Make Int

                Attached Int constructor

@def Long    -> Make Long

                Returnes underlying value

@def Float   -> Make Float

                Attached Float constructor

@def Double  -> Make Double

                Attached Double constructor

@def Number  -> Make Number

                Attached Number constructor
*/