package scalqa; package gen; package request; import language.implicitConversions

object DEFAULT extends Request:

  implicit inline def implicitToExecutionContext (inline v: DEFAULT) : concurrent.ExecutionContext = ZZ.Context
  implicit inline def implicitToStringFunction[A](inline v: DEFAULT) : A => String                 = ToString.cast[A => String]


  // *********************************************************************************************************
  private object ToString extends (Any => String) { def apply(v: Any) = if(v == null) "null" else v.toString }


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
