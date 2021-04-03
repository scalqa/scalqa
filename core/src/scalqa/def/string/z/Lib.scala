package scalqa; package `def`; package string; package z; import language.implicitConversions

import string.{ _Extension as X }

transparent trait Lib[A<: String | Opaque.String] extends X._evaluate[A] with X._modify[A] with X._copy[A] with X._transform[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
