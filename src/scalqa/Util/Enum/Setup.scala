package scalqa; package Util; package Enum

abstract class Setup[ENUM <: Enum[ENUM]] protected extends Package[ENUM] {
  private var isSealed = false
  private var voidOpt: Opt[ENUM] = \/
  private var _items: Refs[ENUM] = \/
  private[Enum] override lazy val _names = allFields.map(_._1).to[Refs]

  def items: Idx[ENUM] = _items

  protected def allFields: ~[(String, ENUM)] = {
    isSealed = true
    val cls = classOf[Enum[_]]
    getClass.getDeclaredMethods.all.
      let(v => cls.isAssignableFrom(v.getReturnType)).
      let(_.getName.charAt(0).isUpper).
      let(_.getParameterCount == 0).
      map(f => (f.getName, f.invoke(this).asInstanceOf[ENUM])).
      sortBy(_._2).
      peekIdx((i, t) => assert(items(i) == t._2, "Reflected instances do not match created get instances for " + this.Class.label))
  }

  private[Enum] def register(v: ENUM): Int = {
    if (isSealed) App.Fail("Enum sealed and cannot be modified")
    if (v.isVoid) { assert(!voidOpt, "Second Void value: " + v.Class + ", " + voidOpt.value.Class); voidOpt = v }
    _items += v
    _items.size - 1
  }

  implicit def zzMake(v: \/): ENUM = voidOpt or App.Fail("No Void value setup for: ", this.Class.label)

  implicit val Ordering: Ordering[ENUM] = _Ordering

  private object _Ordering extends Custom.Ordering[ENUM] { def compare(x: ENUM, y: ENUM) = x.ordinal - y.ordinal }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
