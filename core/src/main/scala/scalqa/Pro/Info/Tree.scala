package scalqa; package Pro; package Info

class Tree private (val toInfo: Info, val children: Refs[Tree]) {
  def this(t: Info, children: ~[Tree]) = this(t, children.to[Refs])
  def this(t: Info, children: Tree*) = this(t, children.all)

  def all: ~[Info] = children.all.flatMap(_.all).insertAt(0, toInfo)

  def allLeveled: ~[(Int, Info)] = {
    def stream(l: Int, t: Tree): ~[(Int, Info)] = t.children.all.flatMap(stream(l + 1, _)).insertAt(0, (l, t.toInfo))
    stream(0, this)
  }

  override def toString = toText("    ").toString

  def toText(indent: String, f: Info => String = _.toString) = {
    val b = new StringBuilder
    allLeveled.foreach(_((lvl, tg) => b.append(indent * lvl).append(tg).append("\n")))
    b.toString
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Tree -> `Tree of Info`
 *
 *
 */
