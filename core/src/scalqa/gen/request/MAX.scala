package scalqa; package gen; package request; import language.implicitConversions

object MAX extends Request:
  implicit inline def xx_Char  (v: MAX.type): Char   = Char.max
  implicit inline def xx_Byte  (v: MAX.type): Byte   = Byte.max
  implicit inline def xx_Short (v: MAX.type): Short  = Short.max
  implicit inline def xx_Int   (v: MAX.type): Int    = Int.max
  implicit inline def xx_Long  (v: MAX.type): Long   = Long.max
  implicit inline def xx_Float (v: MAX.type): Float  = Float.max
  implicit inline def xx_Double(v: MAX.type): Double = Double.max

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
    @object MAX -> ### Any Type Request  MAX

     See [[Request]] for usage


*/
