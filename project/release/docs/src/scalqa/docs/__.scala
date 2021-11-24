package scalqa

object Docs:

  def fail(v: Any): Nothing = throw new RuntimeException(""+v)

  def isHiddenName(owner: Member, name: String): Boolean =
    name.startsWith("z_") || name.in("withFilter","toString","THIS_TYPE","THIS_OPAQUE") || name.startsWith("thenComparing")
      || { owner.name match
                      case "Doc"            => name.startsWith("product")
                      case "Opt"            => name in ("foreach", "flatMap")
                      case "Result"         => name in ("foreach", "flatMap")
                      case "Promise"        => name in ("foreach", "flatMap")
                      case "Collection"     => name in ("foreach", "flatMap", "map")
                      case "Range"          => name in ("foreach", "flatMap", "map")
                      case "TwoWayFunction" => name in ("andThen","compose")
                      case "Ordering" if owner.kind.isTypeLike && !owner.dri.location.contains("stream") =>
                          name.startsWith("thenComparing") || name.notIn("compare","compareOpt","reverse","on","join","+","map") && !name.contains("^")
                      case _                                   => name == "toOpaque"
    }

  def isTypeLikeAlias(m: Member): Boolean =
    if(!m.kind.isTypeLike) false
    else m.signature.map(_.toString.trim()).exists(s => s=="<:" || s=="|")

  def isMakerMethod(owner: String, name: String) = owner match
    case "Lang"   => false
    case "Gen"    => false
    case "Opaque" => false
    case _        => makerNameSet.contains(name)

  private val makerNameSet = String.Set("Byte","Char","Short","Int","Long","Float","Double","Number",
      "ByteCount","Year","Big","Percent","Week","Weeks","Day","Days","Hour","Hours","Minute","Minutes","Second","Seconds","Millis","Micros","Nanos",
      "Problem")


  def filterSignature(s: Signature) : Signature = s

  def memberSignature(member: Member): Signature =
    import dotty.tools.scaladoc.translators.*
    ScalaSignatureProvider.rawSignature(member, InlineSignatureBuilder()).asInstanceOf[InlineSignatureBuilder].names.reverse

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  val Menu = docs.Menu
  val Path = docs.Path

