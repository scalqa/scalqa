package scalqa; package api

trait _String:

  extension (x: String)
    def docLabel  : String = if(x.length>2 && x.charAt(0)=='_') x.takeFirst(2).toLowerCase + x.dropFirst(2) else if(x.length>1) x.takeFirst(1).toUpperCase + x.dropFirst(1) else x.toUpperCase
    def nameToId  : String = x match{case "~"=>"stream"; case "~~"=>"stream";  case "<>"=>"range";  case "><"=>"pack";    case v => v.toLowerCase }
    def nameToOp  : String = x match{case "Stream"=>"~"; case "Range" => "<>"; case "Pack" => "><"; case "VOID" => "\\/"; case _ => x }

    def simpleName: String =
      var n = x
      if(n.endsWith("THIS_TYPE")) n = "this.type"

      n = n.d("Lang.").d("Gen.").d("Val.")
           .d("Any.Ref",4).d("Any.Raw",4).d("Any.Opaque",4).d("Any.Self.Def",9).d("Any.Self.Doc",9).d("Any.Self.Shape",9).d("Any.Self.Void",9)
           .d("Calendar.",9).d("Request.",8).d("Util.").d("Number.BigDecimal",7).d("Number.BigInteger",7).d("Number.Rounding",7).d("Time.DayTime",5).d("Time.Period",5)
           .d("J.Json.Array",    2<>6).d("J.Json.Object",2<>6).d("J.File.Path",      2<>6).d("J.Io.",         2<>4)
           .d("J.Util.Benchmark",2<>6).d("J.Util.Random",2<>6).d("J.Util.Concurrent",2<>6).d("J.Util.WeakRef",2<>6)
           .d("J.Vm.Priority",   2<>4).d("J.Vm.Setup",   2<>4).d("J.Vm.Memory",      2<>4).d("J.Vm.Host",     2<>4)
      n = n.r("Root.Package.").r(".G.Util.",".G.").r("Event.Observable","Observable")
           .r("Fx.Control.","Fx.").r("Fx.Scene.","Fx.").r("Fx.Ui.","Fx.")
           .r("__.Package.").r(".Custom.Framework.Companion.",".").r(".Custom.Framework.",".").r("THIS_TYPE","this.type")

      if(n.endsWith(".Opt.type"))  n = n.dropLast(5)
      if(n.endsWith("$")) n=n.dropLast(1)
      n = n match{case "Boolean.Raw"   => "Raw.Boolean"; case "Byte.Raw"   => "Raw.Byte"; case "Char.Raw"    => "Raw.Char";  case "Short.Raw"    => "Raw.Short";
                  case "Int.Raw"       => "Raw.Int";     case "Long.Raw"   => "Raw.Long"; case "Float.Raw"   => "Raw.Float"; case "Double.Raw"   => "Raw.Double";
                  case "scala.Boolean" => "Boolean";     case "scala.Byte" => "Byte";     case "scala.Char"  => "Char";      case "scala.Short"  => "Short";
                  case "scala.Int"     => "Int";         case "scala.Long" => "Long";     case "scala.Float" => "Float";     case "scala.Double" => "Double";
                  case "scala.Predef$.String"=>"String"; case n => n}
      //var i = n.indexOf("._");
      //if(i>0){ var j = n.indexOf(".",i+1); if(j>0) n = n.takeFirst(i) + {if(n.take_<>(i+2 <>> j).toUpperCase == n.dropFirst(j+1).toUpperCase) "#" else "."} + n.dropFirst(j+1) }
      n.nameToOp


    @tn("dropFirst") private def d(v: String)             : String = if(x.startsWith(v)) x.dropFirst(v.length) else x
    @tn("dropFirst") private def d(v: String,len:Int)     : String = if(x.startsWith(v)) x.dropFirst(len) else x
    @tn("dropFirst") private def d(v: String,r: Int.<>)   : String = if(x.startsWith(v)) x.drop_<>(r) else x
    @tn("replace")   private def r(v1: String,v2: String) : String = x.replace(v1,v2)
    @tn("remove")    private def r(v : String)            : String = x.remove(v)

