package scalqa; package gen; package able

trait Seal:
  def isSealed : Boolean
  def seal     : this.type

object Seal:
  def fail : Nothing = J.illegalState("The object is sealed and cannot be updated anymore")

  inline def check(inline v: Seal): Unit = if (v.isSealed) fail

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Seal -> Generic able to seal

     Classes implementing Able.Seal allow some sort of mutation only until `seal` method is called

     From this point any mutation attempt should fail

@def seal -> Seal object

      Seals `this` instance so it can be no longer modified

@def isSealed -> Sealed check

      Returns `true` if the instance is sealed

*/
