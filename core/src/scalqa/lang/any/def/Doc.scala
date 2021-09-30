package scalqa; package lang; package any; package `def`; import language.implicitConversions

trait Doc[-A] extends Tag[A]:
  def value_doc(v: A): Gen.Doc

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def value_tag -> Instance tag

      Returns String tag describing provided value

@def value_doc -> Instance Doc

      Returns Doc describing provided value

*/