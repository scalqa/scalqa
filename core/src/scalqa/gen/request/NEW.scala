package scalqa; package gen; package request; import language.implicitConversions

class NEW private() extends Request

object NEW extends NEW:
  implicit inline def implicitScalaBuffer     [A](inline v: NEW): scala.collection.mutable.Buffer[A]      = scala.collection.mutable.Buffer.empty
  implicit inline def implicitScalaArrayBuffer[A](inline v: NEW): scala.collection.mutable.ArrayBuffer[A] = new scala.collection.mutable.ArrayBuffer()
  implicit inline def implicitJavaArrayList   [A](inline v: NEW): java.util.ArrayList[A]                  = new java.util.ArrayList()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class  NEW -> ### NEW Request Type

       See [[Request]] for usage

@object NEW -> ### NEW Object

       Singleton implementation of [[NEW]] request type

*/