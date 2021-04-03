package scalqa; package j

object Vm:
  def availableProcessors : Int   = Runtime.getRuntime().availableProcessors()
  def exit                : Unit  = { println("J.Vm.exit requested"); System.exit(0) }

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type       Priority     = vm.Priority.opaque.`type`
  inline def Setup        = vm.Setup
  inline def Memory       = vm.Memory
  inline def Host         = vm.Host
  inline def ClassLoader  = vm.ClassLoader

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Vm -> ### JVM Utilities

@def exit -> Kills process

       Calls System.exit(0)


*/
