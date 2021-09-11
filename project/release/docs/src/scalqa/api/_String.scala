package scalqa; package api

trait _String:

  extension (x: String)
    def docLabel  : String =
      if(x.length>2 && x.charAt(0)=='_') x.takeFirst(2).toLowerCase + x.dropFirst(2)
      else if(x == "anyref") "AnyRef"
      else if(x.length>1) x.takeFirst(1).toUpperCase + x.dropFirst(1)
      else x.toUpperCase

    def nameToId         : String = x match{case "~"=>"stream"; case "~~"=>"stream";  case "<>"=>"range";   case "><"=>"pack";   case "\\/"=>"void";   case v => v.toLowerCase }
    def nameToOp         : String = x match{case "Stream"=>"~";                       case "Range" => "<>"; case "Pack" => "><"; case "VOID" => "\\/"; case _ => x }
    def dropDuplicateEnd : String = x.lastIndexOf_?(".").map_?(i => {
                                        val len = x.length - i - 1
                                        x.lastIndexOf_?(".",i-1).default(-1).take(j => i - j - 1 == len && x.take_<>(i+1,len) == x.take_<>(j+1,len)).map(_ => len+1)
                                    }).map(x.dropLast(_)) or x

    def simpleName(owner: Opt[Member] = \/, heading: Boolean = false): String =
      val in: Boolean = heading || owner.take(_.dri.location=="scalqa.lang.Any$")
      var v = x
      if(!in) v = v.d("Val.")
      v = v.d("scalqa.").d("Lang.").d("Gen.")
           .d("Calendar.",9).d("Request.",8).d("Util.").d("Math.Ordering",5).d("Math.BigDecimal",5).d("Math.BigInteger",5).d("Number.Rounding",7).d("Time.DayTime",5).d("Time.Period",5)
           .d("J.Json.Array",    2<>6).d("J.Json.Object",2<>6).d("J.File.Path",      2<>6).d("J.Io.",         2<>4)
           .d("J.Util.Benchmark",2<>6).d("J.Util.Random",2<>6).d("J.Util.Concurrent",2<>6).d("J.Util.WeakRef",2<>6)
           .d("J.Vm.Priority",   2<>4).d("J.Vm.Setup",   2<>4).d("J.Vm.Memory",      2<>4).d("J.Vm.Host",     2<>4)
      v = v.r(".G.Math.",".G.").r("Event.Observable","Observable")
           .r(".Containers.Companion",".#CC#.").r(".G.Containers.",".").r(".Containers.",".").r(".#CC#.",".Containers.Companion")
           .r("Fx.Control.","Fx.").r("Fx.Scene.","Fx.").r("Fx.Base.","Fx.")
           .r("THIS_TYPE","this.type")
           .r("Array._methods.ARR","ARR").r("ARR.ARR","ARR")
           .r("Opt._methods.OPT","OPT")
           .r("Boolean.Raw","Any.Boolean").r("Byte.Raw","Any.Byte").r("Char.Raw","Any.Char").r("Short.Raw","Any.Short").r("Int.Raw","Any.Int").r("Long.Raw","Any.Long").r("Float.Raw","Any.Float").r("Double.Raw","Any.Double")
           .r("Any.Specialized","Specialized").r("Specialized.Array","A.Array").r("Specialized.Primitive.<>","A.<>").r("Specialized.Primitive.><","A.><")

      if(v.endsWith(".Type.type"))  v = v.dropLast(10)
      if(v.endsWith("$")) v=v.dropLast(1)
      if(v.startsWith("scala.") && !in) v = v match
          case "scala.Any"     => "Any";
          case "scala.AnyRef"  => "AnyRef";  case "scala.AnyVal"        => "AnyVal";
          case "scala.Boolean" => "Boolean"; case "scala.Predef$.String"=> "String";
          case "scala.Byte"    => "Byte";    case "scala.Predef.String" => "String";
          case "scala.Char"    => "Char";    case "scala.Ordering"      => "Ordering";
          case "scala.Short"   => "Short";   case "scala.math.Ordering" => "Ordering";
          case "scala.Int"     => "Int";     case "scala.Array"         => "Array";
          case "scala.Long"    => "Long";
          case "scala.Float"   => "Float";
          case "scala.Double"  => "Double";  case "scala.Unit"          => "Unit";
          case v               => v

      v = v.nameToOp
      if(v.startsWith("~."))              v = "~~." + v.dropFirst(2)
      else if(v.endsWith(".DEF"))         v = v.dropLast(4)
      else if(v.endsWith("THIS_TYPE"))    v = "this.type"
      else if(v.endsWith(".THIS_OPAQUE")) v = "THIS_OPAQUE"
      else if(v.endsWith(".REAL"))        v = "REAL"
      else if(v.endsWith(".T.~"))         v = "T.~"
      else if(v.endsWith(".A.~"))         v = "A.~"
      else if(v.endsWith(".T.Opt"))       v = "T.Opt"
      else if(v.endsWith(".A.Opt"))       v = "A.Opt"
      v.dropDuplicateEnd

    @tn("dropFirst") private def d(v: String)          : String = if(x.startsWith(v)) x.dropFirst(v.length) else x
    @tn("dropFirst") private def d(v: String,len:Int)  : String = if(x.startsWith(v)) x.dropFirst(len) else x
    @tn("dropFirst") private def d(v: String,r: Int.<>): String = if(x.startsWith(v)) x.drop_<>(r) else x
    @tn("replace")   private def r(v: String,w: String): String = x.replace(v,w)
    @tn("remove")    private def r(v : String)         : String = x.remove(v)

