package scalqa; package module

object Sorting:

  object default extends Ordering[Module]:
    def compare(x:Module,y:Module): Int = Ordering[String].compare(x.prefix + x.id.toString,y.prefix + y.id.toString)

  object byName extends Ordering[Module]:
    def compare(x:Module,y:Module): Int = Ordering[String].compare(x.name,y.name)

  object root extends Ordering[Module]:
    def compare(x:Module,y:Module): Int = Ordering[String].rank_^{
      case "Lang" => 1
      case "Val"  => 2
      case "Gen"  => 3
      case "J"    => 4
      case "Fx"   => 5
      case _      => 6
    }.compare(x.name,y.name)