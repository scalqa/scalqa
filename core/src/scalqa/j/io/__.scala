package scalqa; package j; import language.implicitConversions

object Io:
  inline def Input  = io.Input;   type Input  = io.Input.OPAQUE.TYPE
  inline def Output = io.Output;  type Output = io.Output.OPAQUE.TYPE

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Io -> ### Input / Output

   Note [[scalqa.j.io.Input J.Input]] and [[scalqa.j.io.Output J.Output]] can be called without [[.Io.]] prefix

*/