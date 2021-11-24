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
@trait Doc -> A given Any.Def.Doc instance for a specific type determines how instance documentation is created.

  Usually there is no need to create Any.Def.Doc, because it is implicitly created for standard opaque types.
  Reference types can mix [[scalqa.gen.able.Doc Able.Doc]] instead.

  Defining Any.Def.Doc is usefull for third-party existing types, one has no control over.

@def value_doc -> Instance Doc

      Returns Doc describing provided value

*/