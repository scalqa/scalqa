package scalqa; package gen; package able; import language.implicitConversions

trait Stream[+A]:
  def stream : Val.Stream[A]

object Stream:

  extension [A](inline x: able.Stream[A])
     inline def pack(using inline s:Specialized[A]): s.Pack  = `val`.pack.z.StreamAble(x)


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Stream -> Able of providing stream of elements

@def stream -> Stream elements

   Returns stream of all alements

*/
