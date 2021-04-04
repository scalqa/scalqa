package scalqa

object Doc extends doc._registry:

  def fail(v: Any): Nothing = throw new RuntimeException(""+v)

  def generate(v: String): Nothing = ???

  def isHiddenName(owner: Member, name: String): Boolean = owner.name match
    case "Opt"                               => name == "withFilter" || name == "foreach" || name == "flatMap"
    case "Result"                            => name == "withFilter" || name == "foreach" || name == "flatMap"
    case "Promise"                           => name == "withFilter" || name == "foreach" || name == "flatMap"
    case "TwoWayFun"                         => name == "andThen"    || name == "compose"
    case "Ordering" if owner.kind.isTypeLike => name.startsWith("thenComparing") || !name.in("compare","reverse","on","join","+") && !name.contains("^")
    case _                                   => name == "withFilter" || name == "toString" || name.startsWith("thenComparing")

  def isTypeLikeAlias(m: Member): Boolean =
    val s = m.signature
    if(!m.kind.isTypeLike || s.isEmpty) return false
    s.head match
      case v: String  => v.trim == "<:"
      case _          => false

  def isMakerMethod(owner: String, name: String) = owner match
    case "Gen"    => false
    case "Opaque" => false
    case _        => makerNameSet.contains(name)

  private val makerNameSet = String.StableSet("Byte","Char","Short","Int","Long","Float","Double","Number",
      "ByteCount","Year","Big","Percent","Week","Weeks","Day","Days","Hour","Hours","Minute","Minutes","Second","Seconds","Millis","Micros","Nanos",
      "Problem")

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  val Menu = doc.Menu
  val Path = doc.Path

