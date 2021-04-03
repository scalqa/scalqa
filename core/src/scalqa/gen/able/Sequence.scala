package scalqa; package gen; package able; import language.implicitConversions

trait Sequence[A]:
  def step(v: A, step: Int): A

object Sequence:
  given byte  : Sequence[Byte]  = new Sequence[Byte] { inline def step(v: Byte,  s: Int) = (v + s).Byte  }
  given char  : Sequence[Char]  = new Sequence[Char] { inline def step(v: Char,  s: Int) = (v + s).Char  }
  given short : Sequence[Short] = new Sequence[Short]{ inline def step(v: Short, s: Int) = (v + s).Short }
  given int   : Sequence[Int]   = new Sequence[Int]  { inline def step(v: Int,   s: Int) =  v + s        }
  given long  : Sequence[Long]  = new Sequence[Long] { inline def step(v: Long,  s: Int) =  v + s        }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Sequence -> Generic sequential interface

@def step -> Traverse sequence

      Given instance and step value, returns other appropriate instance within sequance

*/

