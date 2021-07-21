package scalqa; package gen; package request; import language.implicitConversions

class DEFAULT private() extends Request

object DEFAULT extends DEFAULT:
  implicit inline def implicitToExecutionContext (inline v: DEFAULT) : concurrent.ExecutionContext = ZZ.Context
  implicit inline def implicitToStringFunction[A](inline v: DEFAULT) : A => String                 = zToString.cast[A => String]

  // *********************************************************************************************************
  object zToString extends (Any => String):
    def apply(v: Any) = if(v == null) "null" else v.toString

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class  DEFAULT -> ### DEFAULT Request Type

       See [[Request]] for usage

@object DEFAULT -> ### DEFAULT Object

       Singleton implementation of [[DEFAULT]] request type

*/

