package scalqa; package Any; package Tuple

import scala.language.implicitConversions

private[scalqa] trait _include {

  implicit def zzTuple2_library[A, B](v: (A, B)) = new _library2(v)

  implicit def zzTuple3_library[A, B, C](v: (A, B, C)) = new _library3(v)

  implicit def zzTuple4_library[A, B, C, D](v: (A, B, C, D)) = new _library4(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def zzTuple2_library-> Attaches Tuple2 custom library
 *
 *    All library methods are implicitly attached and available on any instance of ''Tuple2'' type
 *
 * @def zzTuple3_library-> Attaches Tuple3 custom library
 *
 *    All library methods are implicitly attached and available on any instance of ''Tuple3'' type
 *
 * @def zzTuple4_library-> Attaches Tuple4 custom library
 *
 *    All library methods are implicitly attached and available on any instance of ''Tuple4'' type
 *
 */
