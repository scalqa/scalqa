package scalqa; package gen; import doc.*; import language.implicitConversions

class Doc protected(owner: Any) extends Any.Ref.Buffer[(String, String)] with Able.Tag with Product:
  /**/                var id                                                             : String    = owner match{case null => "null"; case s:String => s; case v => v.^.id}
  /**/                def tag                                                            : String    = id + '{' + pair_~().makeString(",") + '}'
  /**/                def text                                                           : String    = (pair_~().makeString(",\n") + '}').indent(id + "{")
  @tn("name_Stream")  def name_~                                                         : ~[String] = this.~.map(_._1).drop(_.isEmpty)
  @tn("value_Stream") def value_~                                                        : ~[String] = this.~.map(_._2)
  @tn("pair_Stream")  def pair_~(sep: String = "=")                                      : ~[String] = this.~.map((n,v) => if (n == null || n.length == 0) Doc.toString(v) else n + sep + Doc.toString(v))

  /**/                def add[A](name: String, value: A)       (using t: Given.DocTag[A]): Unit      = super.add((name, t.tag(value)))
  /**/                def add[A](value: A)                     (using t: Given.DocTag[A]): Unit      = add("",value)
  /**/                def addAt[A](pos:Int,name:String,value:A)(using t: Given.DocTag[A]): Unit      = addAt(pos,(name, t.tag(value)))

  @tn("_add")         def +=[A] (name: String, value: A)       (using t: Given.DocTag[A]): Doc       = { add(name,value); this }
  @tn("_add")         def +=    (value: String)                                          : Doc       = { add(value);      this }
  @tn("_addAt")       def +=@[A](p:Int, n:String, v:A)         (using t :Given.DocTag[A]): Doc       = { addAt(p,n,v);    this }

  // -------------------------- Product Base  ------------------------------------------------------------------------------
  /**/       override def productPrefix                                                  : String    = id
  /**/                def productArity                                                   : Int       = size
  /**/       override def productElementName(i: Int)                                     : String    = apply(i)._1
  /**/                def productElement(i: Int)                                         : String    = apply(i)._2
  /**/                def canEqual(that: Any)                                            : Boolean   = false

object Doc:
  def apply(owner: Any)   : Doc = new Doc(owner)
  def resolve(owner: Ref) : Doc = owner match{case v: Able.Doc => v.doc; case v => Doc(v.cast[Ref])}
  def product(v: Product) : Doc = new Doc(v.productPrefix).^(_ ++= v.~.map(t => (t._1,t._2.tag)))

  private def toString(v: Any): String  =
    val s = if (v == null) "null" else v.toString
    if (s.contains(",")) "[" + s + "]" else s

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def Tree = doc.Tree;        type Tree = doc.Tree

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@var id      -> Instance id    \n\n  Id used to identify the instance \n\n It usually includes class name and hash code
@def tag     -> Generates tag

@def +=      ->  Alias to [[add]]   \n\n Adds name and value pair to the buffer
@def +=      ->  Alias to [[add]]   \n\n Adds value with empty name
@def +=@     ->  Alias to [[addAt]] \n\n Adds name and value at given position
@def add     ->  Add name/value     \n\n Adds name and value pair to the buffer
@def add     ->  Add value          \n\n Adds value with empty name
@def addAt   ->  Add name/value at position \n\n Adds name and value at given position

@def name_~  ->  Stream of names
@def value_~ ->  Stream of values
@def pair_~  ->  Stream of name/value pairs

@class Doc -> ### General Instance Documentation

    [[Doc]] is a buffer of (name,value) pairs, describing all instance properties

    Methods `.tag` and `.text` return [[Doc]] description as single and multi line String.

    Note: There are additional convenience methods like:
    ```
        def += (name: String, value: A)
        def add(name: String, value: A)
    ```
    which allow adding name/values pairs without tupling
*/


