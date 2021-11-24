package scalqa; package `val`; package stream; package _use; package _transform; import language.implicitConversions

import z._use._transform.{ toTuple as Z }

transparent trait _toTuple:

  extension[A](inline x: Stream[A])
    inline def tuple2 : (A,A)                                         = Z.tuple2(x)
    inline def tuple3 : (A,A,A)                                       = Z.tuple3(x)
    inline def tuple4 : (A,A,A,A)                                     = Z.tuple4(x)
    inline def tuple5 : (A,A,A,A,A)                                   = Z.tuple5(x)
    inline def tuple6 : (A,A,A,A,A,A)                                 = Z.tuple6(x)
    inline def tuple7 : (A,A,A,A,A,A,A)                               = Z.tuple7(x)
    inline def tuple8 : (A,A,A,A,A,A,A,A)                             = Z.tuple8(x)
    inline def tuple9 : (A,A,A,A,A,A,A,A,A)                           = Z.tuple9(x)
    inline def tuple10: (A,A,A,A,A,A,A,A,A,A)                         = Z.tuple10(x)
    inline def tuple11: (A,A,A,A,A,A,A,A,A,A,A)                       = Z.tuple11(x)
    inline def tuple12: (A,A,A,A,A,A,A,A,A,A,A,A)                     = Z.tuple12(x)
    inline def tuple13: (A,A,A,A,A,A,A,A,A,A,A,A,A)                   = Z.tuple13(x)
    inline def tuple14: (A,A,A,A,A,A,A,A,A,A,A,A,A,A)                 = Z.tuple14(x)
    inline def tuple15: (A,A,A,A,A,A,A,A,A,A,A,A,A,A,A)               = Z.tuple15(x)
    inline def tuple16: (A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A)             = Z.tuple16(x)
    inline def tuple17: (A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A)           = Z.tuple17(x)
    inline def tuple18: (A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A)         = Z.tuple18(x)
    inline def tuple19: (A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A)       = Z.tuple19(x)
    inline def tuple20: (A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A)     = Z.tuple20(x)
    inline def tuple21: (A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A)   = Z.tuple21(x)
    inline def tuple22: (A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A) = Z.tuple22(x)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def tuple2  -> Convert to Tuple2   \n\n If Stream has less then 2  elements, the operation will fail.
@def tuple3  -> Convert to Tuple3   \n\n If Stream has less then 3  elements, the operation will fail.
@def tuple4  -> Convert to Tuple4   \n\n If Stream has less then 4  elements, the operation will fail.
@def tuple5  -> Convert to Tuple5   \n\n If Stream has less then 5  elements, the operation will fail.
@def tuple6  -> Convert to Tuple6   \n\n If Stream has less then 6  elements, the operation will fail.
@def tuple7  -> Convert to Tuple7   \n\n If Stream has less then 7  elements, the operation will fail.
@def tuple8  -> Convert to Tuple8   \n\n If Stream has less then 8  elements, the operation will fail.
@def tuple9  -> Convert to Tuple9   \n\n If Stream has less then 9  elements, the operation will fail.
@def tuple10 -> Convert to Tuple10  \n\n If Stream has less then 10 elements, the operation will fail.
@def tuple11 -> Convert to Tuple11  \n\n If Stream has less then 11 elements, the operation will fail.
@def tuple12 -> Convert to Tuple12  \n\n If Stream has less then 12 elements, the operation will fail.
@def tuple13 -> Convert to Tuple13  \n\n If Stream has less then 13 elements, the operation will fail.
@def tuple14 -> Convert to Tuple14  \n\n If Stream has less then 14 elements, the operation will fail.
@def tuple15 -> Convert to Tuple15  \n\n If Stream has less then 15 elements, the operation will fail.
@def tuple16 -> Convert to Tuple16  \n\n If Stream has less then 16 elements, the operation will fail.
@def tuple17 -> Convert to Tuple17  \n\n If Stream has less then 17 elements, the operation will fail.
@def tuple18 -> Convert to Tuple18  \n\n If Stream has less then 18 elements, the operation will fail.
@def tuple19 -> Convert to Tuple19  \n\n If Stream has less then 19 elements, the operation will fail.
@def tuple20 -> Convert to Tuple20  \n\n If Stream has less then 20 elements, the operation will fail.
@def tuple21 -> Convert to Tuple21  \n\n If Stream has less then 21 elements, the operation will fail.
@def tuple22 -> Convert to Tuple22  \n\n If Stream has less then 22 elements, the operation will fail.

*/
