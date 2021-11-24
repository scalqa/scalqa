package scalqa; package j

object Vm:

  inline def host                                         : String   = java.net.InetAddress.getLocalHost.getHostName()
  inline def address                                      : String   = java.net.InetAddress.getLocalHost.getHostAddress()

  inline def availableProcessors                          : Int      = Runtime.getRuntime().availableProcessors()
  inline def exit                                         : Unit     = { println("J.Vm.exit requested"); System.exit(0) }

  /**/   def reload(className:String,paths:Stream[J.Path]): Class[_] = vm.z.ClassLoader.reload(className, paths)

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def Priority     = vm.Priority;     type Priority = vm.Priority.TYPE.DEF
  transparent inline def Setup        = vm.Setup
  transparent inline def Memory       = vm.Memory

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Vm -> ### JVM Utilities

@def host -> Local host name

    Inlines following:
    ```
    java.net.InetAddress.getLocalHost.getHostName()
    ```

@def address -> Local host address

    Inlines following:
    ```
    java.net.InetAddress.getLocalHost.getHostAddress()
    ```

@def availableProcessors -> Core count

    Inlines following:
    ```
    java.lang.Runtime.getRuntime().availableProcessors()
    ```

@def exit -> JVM shutdown

    Inlines following:
    ```
    println("J.Vm.exit requested")
    System.exit(0)
    ```

@def reload -> Load Class

    Retreives latest class definition with custom ClassLoader.

*/
