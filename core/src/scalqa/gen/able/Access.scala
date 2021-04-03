package scalqa; package gen; package able; import language.implicitConversions

trait Access[A]:
  def access: A

object Access:

  trait Update[A] extends Access[A]:
    def access_=(v: A): Unit


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Access -> Able of providing public access method to some property

@trait Update -> Able of providing public "write" method to some property

@def access -> Get value

   Returns accessible property value

@def access_= -> Set value

   Sets the value of accessible property

*/
