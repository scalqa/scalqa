package scalqa; package lang; package any; package self; package doc; import language.implicitConversions

class Tree private (val doc: Doc, val children: ><[Tree]):

  def traverse_~ : ~[(Int, Doc)] =
    def stream(l: Int, t: Tree): ~[(Int, Doc)] = ~~((l, t.doc)) ++ t.children.~.flatMap(stream(l + 1, _))
    stream(0, this)

  def format(indent: String, f: Doc => String = _.tag): String = String.Builder().^(b =>
      traverse_~.foreach((lvl, doc) => b += (indent * lvl) += f(doc) += "\n")
  ).tag

  def text = format("  ")

  override def toString = text

object Tree:
  def apply(t: Doc, children: Tree*)  : Tree = new Tree(t, children.~.><)
  def apply(t: Doc, children: ~[Tree]): Tree = new Tree(t, children.><)

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/