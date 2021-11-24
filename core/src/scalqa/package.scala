import language.implicitConversions

package object scalqa:
  export scalqa.Lang.*
  export scalqa.Val.*
  export scalqa.Gen.*
  export scalqa.gen.Request.*
  export scalqa.j.vm.Predef.{ given }

  private[scalqa] type ClassTag[A]    = scala.reflect.ClassTag[A];      private[scalqa] transparent inline def ClassTag   = scala.reflect.ClassTag
  private[scalqa] type Specialized[A] = lang.any.Specialized[A];        private[scalqa] transparent inline def Specialized= lang.any.Specialized;
  private[scalqa] type tn             = scala.annotation.targetName
  private[scalqa] type fast           = scala.annotation.threadUnsafe

  extension[A](inline x: A)
    private[scalqa] inline def cast[B]: B = x.asInstanceOf[B]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object scalqa -> ### \n\n Root package [[scalqa]] defines 5 members:

  -- [[scalqa.Lang$ Lang]] holds language level extentions to Java and Scala functionality
  -- [[scalqa.Gen$ Gen]]   holds core language utilities
  -- [[scalqa.Fx$ Fx]]     holds GUI API
  -- [[scalqa.J$ J]]       holds second tier language utilities
  -- [[scalqa.Val$ Val]]   holds generic containers framework

  [[scalqa]] also contains many aliases,
  so the types and objects defined deeper in the hierarchy can be accessed without prefixes

*/
