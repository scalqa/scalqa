package scalqa; package gen; package request; import language.implicitConversions

class NEW private() extends Request

object NEW extends NEW:
  implicit inline def implicitScalaBuffer[A](inline v: NEW): scala.collection.mutable.Buffer[A] = scala.collection.mutable.Buffer.empty

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