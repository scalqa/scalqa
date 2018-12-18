package scalqa.Util.Z.Include

import scalqa.Custom.{ Numeric, Ordering }

private[scalqa] trait Custom {

  implicit def zzNumeric_Byte = Numeric.Byte

  implicit def zzNumeric_Short = Numeric.Short

  implicit def zzNumeric_Int = Numeric.Int

  implicit def zzNumeric_Long = Numeric.Long

  implicit def zzNumeric_Float = Numeric.Float

  implicit def zzNumeric_Double = Numeric.Double

  //  implicit def zzOrdering_Comparable[A]( = Numeric.Double

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def zzNumeric_Byte -> Default Numeric
 *
 *     Default Byte Custom.Numeric interface
 *
 * @def zzNumeric_Short -> Default Numeric
 *
 *     Default Short Custom.Numeric interface
 *
 * @def zzNumeric_Int -> Default Numeric
 *
 *     Default Int Custom.Numeric interface
 *
 * @def zzNumeric_Long -> Default Numeric
 *
 *     Default Long Custom.Numeric interface
 *
 * @def zzNumeric_Float -> Default Numeric
 *
 *     Default Float Custom.Numeric interface
 *
 * @def zzNumeric_Double -> Default Numeric
 *
 *     Default Double Custom.Numeric interface
 */
