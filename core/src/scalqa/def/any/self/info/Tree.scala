package scalqa; package `def`; package any; package self; package info; import language.implicitConversions

class Tree private (val info: Info, val children: ><[Tree]):

  def traverse_~ : ~[(Int, Info)] =
    def stream(l: Int, t: Tree): ~[(Int, Info)] = ~~((l, t.info)) ++ t.children.~.flatMap(stream(l + 1, _))
    stream(0, this)

  def format(indent: String, f: Info => String = _.tag): String = String.Builder().^(b =>
      traverse_~.foreach((lvl, info) => b += (indent * lvl) += f(info) += "\n")
  ).tag

  def text = format("  ")

  override def toString = text

object Tree:
  def apply(t: Info, children: Tree*)  : Tree = new Tree(t, children.~.><)
  def apply(t: Info, children: ~[Tree]): Tree = new Tree(t, children.><)

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/