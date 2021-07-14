package scalqa; package j

object Vm:
  def availableProcessors : Int   = Runtime.getRuntime().availableProcessors()
  def exit                : Unit  = { println("J.Vm.exit requested"); System.exit(0) }

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def Priority     = vm.Priority;  type Priority = vm.Priority.opaque.`type`
  transparent inline def Setup        = vm.Setup
  transparent inline def Memory       = vm.Memory
  transparent inline def Host         = vm.Host
  transparent inline def ClassLoader  = vm.ClassLoader

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Vm -> ### JVM Utilities

@def exit -> JVM shutdown

       Calls System.exit(0)

*/
