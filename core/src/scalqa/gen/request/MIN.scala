package scalqa; package gen; package request; import language.implicitConversions

object MIN extends Request:
  implicit inline def xx_Char  (v: MIN.type): Char   = Char.min
  implicit inline def xx_Byte  (v: MIN.type): Byte   = Byte.min
  implicit inline def xx_Short (v: MIN.type): Short  = Short.min
  implicit inline def xx_Int   (v: MIN.type): Int    = Int.min
  implicit inline def xx_Long  (v: MIN.type): Long   = Long.min
  implicit inline def xx_Float (v: MIN.type): Float  = Float.min
  implicit inline def xx_Double(v: MIN.type): Double = Double.min

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
    @object MIN -> ### Any Type Request  MIN

     See [[Request]] for usage


*/
