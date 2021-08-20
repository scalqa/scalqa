package scalqa

object Docs:

  def fail(v: Any): Nothing = throw new RuntimeException(""+v)

  def generate(v: String): Nothing = ???

  def isHiddenName(owner: Member, name: String): Boolean = name.startsWith("zz") || name == "withFilter" || name == "toString" || name.startsWith("thenComparing") || {
    owner.name match
      case "Doc"                               => name.startsWith("product")
      case "Opt"                               => name == "withFilter" || name == "foreach" || name == "flatMap"
      case "Result"                            => name == "withFilter" || name == "foreach" || name == "flatMap"
      case "Promise"                           => name == "withFilter" || name == "foreach" || name == "flatMap"
      case "Collection"                        => name == "withFilter" || name == "foreach" || name == "flatMap" || name == "map"
      case "ReversibleFunction"                => name == "andThen"    || name == "compose"
      case "Ordering" if owner.kind.isTypeLike => name.startsWith("thenComparing") || !name.in("compare","reverse","on","join","+") && !name.contains("^")
      case _                                   => false
  }

  def isTypeLikeAlias(m: Member): Boolean =
    if(!m.kind.isTypeLike) false
    else m.signature.map(_.toString.trim()).exists(s => s=="<:" || s=="|")

  def isMakerMethod(owner: String, name: String) = owner match
    case "Lang"   => false
    case "Gen"    => false
    case "Opaque" => false
    case _        => makerNameSet.contains(name)

  private val makerNameSet = String.StableSet("Byte","Char","Short","Int","Long","Float","Double","Number",
      "ByteCount","Year","Big","Percent","Week","Weeks","Day","Days","Hour","Hours","Minute","Minutes","Second","Seconds","Millis","Micros","Nanos",
      "Problem")


  def filterSignature(s: Signature) : Signature = s



  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  val Menu = docs.Menu
  val Path = docs.Path

