package scalqa; package gen; import doc.*; import language.implicitConversions

class Doc protected(owner: Any) extends AnyRef.Buffer[(String, String)] with _core with Product:
  /**/     var id                                                 : String         = owner match{case null => "null"; case s:String => s; case v => v.self.id}
  /**/     def tag                                                : String         = id + '{' + pairStream().makeString(",") + '}'
  /**/     def text                                               : String         = (pairStream().makeString(",\n") + '}').indent(id + "{")
  /**/     def nameStream                                         : Stream[String] = this.stream.map(_._1).drop(_.isEmpty)
  /**/     def valueStream                                        : Stream[String] = this.stream.map(_._2)
  /**/     def pairStream(sep: String = "=")                      : Stream[String] = this.stream.map((n,v) => if (n == null || n.length == 0) Doc.toString(v) else n + sep + Doc.toString(v))

  /**/     def add[A](name:String,value:A)(using d:Any.Def.Tag[A]): Unit           = super.add((name, d.value_tag(value)))
  /**/     def add[A](value: A)           (using d:Any.Def.Tag[A]): Unit           = add("",value)
  /**/     def addAt[A](pos:Int,name:String,value:A)
                                          (using d:Any.Def.Tag[A]): Unit           = addAt(pos,(name, d.value_tag(value)))

  inline   def +=[A] (inline name: String, inline value: A)
                                  (using inline t: Any.Def.Tag[A]): Doc            = { add(name,value); this }
  inline   def += (inline value: String)                          : Doc            = { add(value);      this }
  inline   def +@=[A](inline p:Int,inline n:String,inline v:A)
                                  (using inline t :Any.Def.Tag[A]): Doc            = { addAt(p,n,v);    this }

  /**/     def update[A](name:String, v:A)(using d:Any.Def.Tag[A]): Unit           = nameStream.findPositionOpt(_ == name).forval(i => updateAt(i, (name,d.value_tag(v)))) or J.illegalArgument(name +- "name not found")
  /**/     def update[A](pos: Int, v: A)  (using d:Any.Def.Tag[A]): Unit           = updateAt(pos, (apply(pos)._1,d.value_tag(v)))

  // -------------------------- Product Base  ------------------------------------------------------------------------------
  override def productPrefix                                      : String         = id
  /**/     def productArity                                       : Int            = size
  override def productElementName(i: Int)                         : String         = apply(i)._1
  /**/     def productElement(i: Int)                             : String         = apply(i)._2
  /**/     def canEqual(that: Any)                                : Boolean        = false

object Doc:
  def apply(owner: Any)      : Doc = new Doc(owner)
  def resolve(owner: AnyRef) : Doc = owner match{case v: Able.Doc => v.doc; case v => Doc(v.cast[AnyRef])}
  def product(v: Product)    : Doc = new Doc(v.productPrefix).self(_ ++= v.stream.map(t => (t._1,t._2.tag)))

  private def toString(v: Any): String  =
    val s = if (v == null) "null" else v.toString
    if (s.contains(",")) "[" + s + "]" else s

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type _core = doc._core
  type Tree  = doc.Tree;  transparent inline def Tree = doc.Tree

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Doc -> ### General Instance Documentation

    [[Doc]] is a buffer of (name,value) pairs, describing all instance properties

*/


