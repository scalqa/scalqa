package scalqa; package Any; package Enum

abstract class Companion[ENUM <: Enum[ENUM]] protected extends Able.Seal.Self with Package[ENUM] {
  private var voidOpt: Opt[ENUM] = \/
  private var _items: Index.Val[ENUM] = \/
  private[Enum] override lazy val _names = allFields.map(_._1).to[Index.Val]

  def items: Index[ENUM] = _items

  protected def allFields = {
    seal
    classOf[Enum[_]].I.to(cls => getClass.getDeclaredMethods.all.
      let(v => cls.isAssignableFrom(v.getReturnType)).
      let(_.getName.charAt(0).isUpper).
      let(_.getParameterCount == 0).
      map(f => (f.getName, f.invoke(this).cast[ENUM])).
      sortBy(_._2).
      peekIdx((i, t) => Assert(getByOrdinal(i) == t._2, "Reflected instances do not match created get instances for " + this.Class.label)))
  }

  private[Enum] def register(v: ENUM): Int = {
    _failIfSealed;
    if (v.isVoid) { Assert(!voidOpt, "Second Void value"); voidOpt = v }
    _items.size.I.run(_items += v)
  }

  import scala.language.implicitConversions

  implicit def zzGet(v: \/.type): ENUM = voidOpt or Fail("No Void value setup for: ", this.Class.label)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
