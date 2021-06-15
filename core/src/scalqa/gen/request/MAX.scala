package scalqa; package gen; package request; import language.implicitConversions

class MAX private() extends Request

object MAX extends MAX:
  implicit inline def implicitToChar  (v: MAX.type): Char   = Char.max
  implicit inline def implicitToByte  (v: MAX.type): Byte   = Byte.max
  implicit inline def implicitToShort (v: MAX.type): Short  = Short.max
  implicit inline def implicitToInt   (v: MAX.type): Int    = Int.max
  implicit inline def implicitToLong  (v: MAX.type): Long   = Long.max
  implicit inline def implicitToFloat (v: MAX.type): Float  = Float.max
  implicit inline def implicitToDouble(v: MAX.type): Double = Double.max

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class  MAX -> ### MAX Request Type

       See [[Request]] for usage

@object MAX -> ### MAX Object

       Singleton implementation of [[MAX]] request type

*/
