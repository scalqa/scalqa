package scalqa; package gen; package doc; import doc.*; import language.implicitConversions

transparent trait _core extends Able.Tag:
  self: Doc =>
  /**/   var id                                                                               : String
  /**/   def tag                                                                              : String
  /**/   def text                                                                             : String
  /**/   def nameStream                                                                           : Stream[String]
  /**/   def valueStream                                                                          : Stream[String]
  /**/   def pairStream(sep: String = "=")                                                        : Stream[String]

  /**/   def add[A](name: String, value: A)                          (using t: Any.Def.Tag[A]): Unit
  /**/   def add[A](value: A)                                        (using t: Any.Def.Tag[A]): Unit
  /**/   def addAt[A](pos:Int,name:String,value:A)                   (using t: Any.Def.Tag[A]): Unit

  inline def +=[A] (inline name: String, inline value: A)     (using inline t: Any.Def.Tag[A]): Doc
  inline def +=    (inline value: String)                                                     : Doc
  inline def +@=[A](inline p:Int, inline n:String, inline v:A)(using inline t :Any.Def.Tag[A]): Doc

  /**/   def update[A](name: String, v: A)                           (using t :Any.Def.Tag[A]): Unit
  /**/   def update[A](pos: Int, v: A)                               (using t :Any.Def.Tag[A]): Unit

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _core -> ### Non buffer methods

    This is the full list of Doc methods, with the exception of ones inherited from [[AnyRef.G.Buffer]] and scala.Product

@var id      -> Instance id    \n\n  Id used to identify the instance \n\n It usually includes class name and hash code
@def tag     -> Generates tag  description \n\n  Tag  contains a single line Doc representation
@def text    -> Generates text description \n\n  Text contains multi-line Doc representation

@def +=      ->  Alias to [[add]]   \n\n Adds name and value pair to the buffer
@def +=      ->  Alias to [[add]]   \n\n Adds value with empty name
@def +@=     ->  Alias to [[addAt]] \n\n Adds name and value at given position
@def add     ->  Add name/value     \n\n Adds name and value pair to the buffer
@def add     ->  Add value          \n\n Adds value with empty name
@def addAt   ->  Add name/value at position \n\n Adds name and value at given position

@def nameStream  ->  Stream of names
@def valueStream ->  Stream of values
@def pairStream  ->  Stream of name/value pairs

@def update  ->  Update value by name

                 "update" can be called with simplified notation

                ```
                val d: Doc = Doc("test") += ("foo", "bar1")
                d("foo") = "bar2"
                ```
@def update  ->  Update value by position

                  "update" can be called with simplified notation

                ```
                val d: Doc = Doc("test") += ("foo", "bar1")
                d(0) = "bar2"
                ```
 */

