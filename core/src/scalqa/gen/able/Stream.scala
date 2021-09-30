package scalqa; package gen; package able; import language.implicitConversions

trait Stream[+A]:

  @tn("stream") def ~ : ~[A]

object Stream:

  extension [A](inline x: able.Stream[A])
    @tn("pack") inline def ><(using inline A:Specialized[A]): A.><  = `val`.pack.z.StreamAble(x)


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Stream -> Able of providing stream of elements

@def ~ -> Stream elements

   Returns stream of all alements

*/
