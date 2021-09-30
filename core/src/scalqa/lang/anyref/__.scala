package scalqa; package lang; import language.implicitConversions

object AnyRef:

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Buffer[A]     = anyref.Buffer[A];       transparent inline def Buffer     = anyref.Buffer
  /**/                                         transparent inline def G          = anyref.G
  type Opaque        = anyref.Opaque.TYPE.DEF; transparent inline def Opaque     = anyref.Opaque;

package object anyref:
  type Opaque = lang.anyref.Opaque.TYPE.DEF

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
