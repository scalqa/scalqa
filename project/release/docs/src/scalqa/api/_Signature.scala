package scalqa; package api

trait _Signature:

  extension (x: Signature)
    def tag               : String      = x.map{case s: String => s; case l: Link => l.dri.label}.~.makeString()


    def dropPrivate       : Signature   =
      var p   = false
      var in  = 0
      var seq = x.~.drop(_ match{
        case s : String => { if(p) s.trim match{case "[" => in+=1; case "]" => in-=1; case _ => ()}; p }
        case v : Link   => { if(in==0) p = v.isPrivate; p}})
      .toSeq
      while(seq.nonEmpty && seq.last.?.takeType[String].take(_.trim in ("extends","with"))) seq = seq.dropRight(1)
      //if(x.exists{case v: String => false; case v: Link => v.isPrivate}) ("----------------------------------\n" + x.tag +" \n" + seq.~.toSeq.tag +" \n" + seq.size + "\n" + x.~.makeString("|") + "\n" + seq.~.makeString("|")).tp
      seq.~.toSeq


    def dropOPAQUE : Signature   =
      def s = x.~.map{case l: Link => l.name.trim; case v => v.toString.trim}.dropVoid

      if(!s.equalsStart(_Signature.OPAQUE)) x
      else x.drop(x.~.findPosition_?(_.toString.trim == "]").map(_ + 1) or 0)


object _Signature:

  val OPAQUE = String.><("[", "THIS_OPAQUE", "<:" /*, "Opaque"*/)

