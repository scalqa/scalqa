package scalqa; package lang; package anyref; import language.implicitConversions

object G:
  @tn("Range")  transparent inline def <>        = g.Range;        @tn("Range")   type <>[A] = g.Range[A]
  /**/          transparent inline def Companion = g.Companion
  /**/          transparent inline def Fun       = g.Fun

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object AnyRef -> ###
   scala.AnyRef type is an alias for java.lang.Object, they can be used interchangebly.

   AnyRef object is a companion for scala.AnyRef type

*/
