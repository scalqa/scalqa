package scalqa; package lang; package any; package `def`; package z; import language.implicitConversions

class AnyDef[A] extends Doc[A] with Void[A] with Empty[A] :

  override def value_tag(v: A): String =
    v match
       case v: Able.Tag       => v.tag
       case null              => "null"
       case v                 => v.toString

  override def value_doc(v: A): Gen.Doc =
    v match
       case v: Able.Doc       => v.doc
       case null              => Gen.Doc("null")
       case v                 => Gen.Doc(v.^.id)

  override def value_isVoid(v: A): Boolean =
    v match
       case v: Able.Void      => v.isVoid
       case null              => true
       case v                 => false

  override def value_isEmpty(v: A): Boolean =
    v match
       case v: Able.Empty     => v.isEmpty
       case v                 => false


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
