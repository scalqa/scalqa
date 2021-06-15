package scalqa; package api

trait _String:

  extension (x: String)
    def docLabel  : String = if(x.length>2 && x.charAt(0)=='_') x.takeFirst(2).toLowerCase + x.dropFirst(2) else if(x.length>1) x.takeFirst(1).toUpperCase + x.dropFirst(1) else x.toUpperCase

    def nameToId         : String = x match{case "~"=>"stream"; case "~~"=>"stream";  case "<>"=>"range";   case "><"=>"pack";   case "\\/"=>"void";   case v => v.toLowerCase }
    def nameToOp         : String = x match{case "Stream"=>"~";                       case "Range" => "<>"; case "Pack" => "><"; case "VOID" => "\\/"; case _ => x }
    def dropDuplicateEnd : String = x.lastIndexOf_?(".").map_?(i => {
                                        val len = x.length - i - 1
                                        x.lastIndexOf_?(".",i-1).default(-1).take(j => i - j - 1 == len && x.take_<>(i+1,len) == x.take_<>(j+1,len)).map(_ => len+1)
                                    }).map(x.dropLast(_)) or x

    def simpleName: String =
      var v = x
      if(v.endsWith("THIS_TYPE")) v = "this.type"
      v = v.d("scalqa.").d("Lang.").d("Gen.").d("Val.")
           .d("Any.Ref",4).d("Any.Raw",4).d("Any.Opaque",4).d("Any.Self.",4).r("Self.Given.","Self.")
           .d("Calendar.",9).d("Request.",8).d("Util.").d("Number.BigDecimal",7).d("Number.BigInteger",7).d("Number.Rounding",7).d("Time.DayTime",5).d("Time.Period",5)
           .d("J.Json.Array",    2<>6).d("J.Json.Object",2<>6).d("J.File.Path",      2<>6).d("J.Io.",         2<>4)
           .d("J.Util.Benchmark",2<>6).d("J.Util.Random",2<>6).d("J.Util.Concurrent",2<>6).d("J.Util.WeakRef",2<>6)
           .d("J.Vm.Priority",   2<>4).d("J.Vm.Setup",   2<>4).d("J.Vm.Memory",      2<>4).d("J.Vm.Host",     2<>4)
      v = v.r("Root.Package.").r(".G.Util.",".G.").r("Event.Observable","Observable")
           .r("Fx.Control.","Fx.").r("Fx.Scene.","Fx.").r("Fx.Ui.","Fx.")
           .r("__.Package.")
           .r(".Custom.Framework.Companion.Pro.",".Pro.").r(".Custom.Framework.Companion.Collection.",".Collection.").r(".Custom.Framework.Companion.Idx.",".Idx.")
           .r(".Custom.Framework.Companion.",".CFC.").r(".Custom.Framework.",".").r(".CFC.",".Custom.Framework.Companion.")
           .r("THIS_TYPE","this.type").r("this.type.this.type","this.type")
           .r("Array._extension.ARR","ARR").r("ARR.ARR","ARR")

      if(v.endsWith(".Type.type"))  v = v.dropLast(10)

      if(v.endsWith("$")) v=v.dropLast(1)
      v = v match
        case "Boolean.Raw"   => "Raw.Boolean"; case "Byte.Raw"   => "Raw.Byte"; case "Char.Raw"   => "Raw.Char";  case "Short.Raw"    => "Raw.Short"
        case "Boolean.RAW"   => "Raw.Boolean"; case "Byte.RAW"   => "Raw.Byte"; case "Char.RAW"   => "Raw.Char";  case "Short.RAW"    => "Raw.Short"
        case "Int.Raw"       => "Raw.Int";     case "Long.Raw"   => "Raw.Long"; case "Float.Raw"  => "Raw.Float"; case "Double.Raw"   => "Raw.Double"
        case "Int.RAW"       => "Raw.Int";     case "Long.RAW"   => "Raw.Long"; case "Float.RAW"  => "Raw.Float"; case "Double.RAW"   => "Raw.Double"
        case "scala.Boolean" => "Boolean";     case "scala.Byte" => "Byte";     case "scala.Char" => "Char";      case "scala.Short"  => "Short"
        case "scala.Int"     => "Int";         case "scala.Long" => "Long";     case "scala.Float"=> "Float";     case "scala.Double" => "Double"
        case "scala.Any"     => "Any";         case "scala.Unit" => "Unit";     case v            => v
      v = v match
        case "scala.Predef$.String"=> "String";case "scala.Predef.String" => "String"; case "scala.math.Ordering" => "scala.Ordering";case "scala.Array"=> "Array"; case v => v

      //var i = v.indexOf("._");
      //if(i>0){ var j = v.indexOf(".",i+1); if(j>0) v = v.takeFirst(i) + {if(v.take_<>(i+2 <>> j).toUpperCase == v.dropFirst(j+1).toUpperCase) "#" else "."} + v.dropFirst(j+1) }
      v = v.nameToOp
      if(v.startsWith("~.")) v = "~~." + v.dropFirst(2)
//      if(v=="Long.RAW")
//        x.tp
//        J.printStack()
      v.dropDuplicateEnd

    @tn("dropFirst") private def d(v: String)          : String = if(x.startsWith(v)) x.dropFirst(v.length) else x
    @tn("dropFirst") private def d(v: String,len:Int)  : String = if(x.startsWith(v)) x.dropFirst(len) else x
    @tn("dropFirst") private def d(v: String,r: Int.<>): String = if(x.startsWith(v)) x.drop_<>(r) else x
    @tn("replace")   private def r(v: String,w: String): String = x.replace(v,w)
    @tn("remove")    private def r(v : String)         : String = x.remove(v)

