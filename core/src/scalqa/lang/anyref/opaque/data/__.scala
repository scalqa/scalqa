package scalqa; package lang; package anyref; package opaque; import language.implicitConversions

abstract class Data[A<:Opaque,REAL<:AnyRef:ClassTag](typeName: String) extends Base[A,REAL](typeName) with g.customized.Containers[A] with Data._methods[A,REAL]

object Data:
  type Ordered[A<:Opaque, REAL<:AnyRef] = data.Ordered[A,REAL];    transparent inline def Ordered       = data.Ordered

  // *************************************************************************************************
  transparent trait _methods[A<:Opaque,REAL<:AnyRef] extends Base._methods[A,REAL]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Data -> ### AnyRef Opaque Data Companion Object Base

  Opaque Data allows to create Scalqa basic opaque type with attached customized containers.

  For AnyRef types there is no performance advantage in having attached containers, just some available syntax choice, compare:

  ```
  val sb1: Buffer[String] = NEW

  //  vs.

  val sb2: String.Buffer = NEW
  ```

*/