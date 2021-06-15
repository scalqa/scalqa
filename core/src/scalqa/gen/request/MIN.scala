package scalqa; package gen; package request; import language.implicitConversions

class MIN private() extends Request

object MIN extends MIN:
  implicit inline def implicitToChar  (v: MIN.type): Char   = Char.min
  implicit inline def implicitToByte  (v: MIN.type): Byte   = Byte.min
  implicit inline def implicitToShort (v: MIN.type): Short  = Short.min
  implicit inline def implicitToInt   (v: MIN.type): Int    = Int.min
  implicit inline def implicitToLong  (v: MIN.type): Long   = Long.min
  implicit inline def implicitToFloat (v: MIN.type): Float  = Float.min
  implicit inline def implicitToDouble(v: MIN.type): Double = Double.min

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class  MIN -> ### MIN Request Type

       See [[Request]] for usage

@object MIN -> ### MIN Object

       Singleton implementation of [[MIN]] request type

*/
