package scalqa; package api; package _signature

object dropPrivate:

  def apply(x: Signature) : Signature   =
    var p   = false
    var in  = 0
    var sig = x.~.drop {
                  case s: String => { if(p) s.trim match{case "[" => in+=1; case "]" => in-=1; case _ => ()}; p }
                  case v: Link   => { if(in==0) p = v.isPrivate; p}
                }.toSeq
    while(sig.nonEmpty && sig.last.?.takeType[String].take(_.trim in ("extends","with"))) sig = sig.dropRight(1)
    sig

