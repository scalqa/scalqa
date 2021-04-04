package scalqa; package `def`; package any; package self; import info.*; import language.implicitConversions

class Info protected(owner: Any) extends Any.Ref.Buffer[(String, String)] with Able.Tag with Product:
  /**/                   var id                                                                      : String    = owner match{case null => "null"; case s:String => s; case v => v.^.id}
  /**/                   def tag                                                                     : String    = id + '{' + pair_~().makeString(",") + '}'
  /**/                   def text                                                                    : String    = (pair_~().makeString(",\n") + '}').indent(id + "{")
  @tn("name_Stream")     def name_~                                                                  : ~[String] = this.~.map(_._1).drop(_.isEmpty)
  @tn("value_Stream")    def value_~                                                                 : ~[String] = this.~.map(_._2)
  @tn("pair_Stream")     def pair_~(sep: String = "=")                                               : ~[String] = this.~.map((n,v) => if (n == null || n.length == 0) Info.toString(v) else n + sep + Info.toString(v))

  /**/                   def add[A](name: String, value: A)                        (using t: Tag[A]) : Unit      = super.add((name, t.tag(value)))
  /**/                   def add[A](value: A)                                      (using t: Tag[A]) : Unit      = add("",value)
  /**/                   def addAt[A](pos: Int, name: String, value: A)            (using t: Tag[A]) : Unit      = addAt(pos,(name, t.tag(value)))

  @tn("add_Op")   inline def +=[A] (inline name: String, inline value: A)(using inline t: Tag[A])    : Info      = { add(name,value); this }
  @tn("add_Op")   inline def +=    (inline value: String)                                            : Info      = { add(value);      this }
  @tn("addAt_Op") inline def +=@[A](inline p:Int, inline n:String, inline v:A)(using inline t:Tag[A]): Info      = { addAt(p,n,v);    this }

  // -------------------------- Product AbstractTrait ------------------------------------------------------------------------------
  /**/          override def productPrefix                                                           : String    = id
  /**/                   def productArity                                                            : Int       = size
  /**/          override def productElementName(i: Int)                                              : String    = apply(i)._1
  /**/                   def productElement(i: Int)                                                  : String    = apply(i)._2
  /**/                   def canEqual(that: Any)                                                     : Boolean   = false

object Info:
  def apply(owner: Any)   : Info = new Info(owner)
  def resolve(owner: Ref) : Info = owner match{case v: Able.Info => v.info; case v => Info(v.cast[Ref])}
  def product(v: Product) : Info = new Info(v.productPrefix).^(_ ++= v.~.map(t => (t._1,t._2.tag)))

  private def toString(v: Any): String  =
    val s = if (v == null) "null" else v.toString
    if (s.contains(",")) "[" + s + "]" else s

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  @fast lazy val Specialized = info.Specialized; type Specialized = info.Specialized
  inline     def Tree        = info.Tree;        type Tree        = info.Tree
  /**/       val Tag         = info.Tag;         type Tag[-A]     = info.Tag[A]

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

@class Info -> ### Instance Documentation

    [[Info]] is a buffer of (name,value) tuples, describing all instance properties

    Note: There are additional convenience methods like:
    ```
        def += (name: String, value: A)
        def add(name: String, value: A)
    ```
    which allow adding name/values pairs without tupling
*/


