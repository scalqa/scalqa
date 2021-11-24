package scalqa; package api

trait _String:

  extension (x: String)
    def docLabel  : String =
      if(x.length>2 && x.charAt(0)=='_') x.takeFirst(2).toLowerCase + x.dropFirst(2)
      else if(x == "anyref") "AnyRef"
      else if(x.length>1) x.takeFirst(1).toUpperCase + x.dropFirst(1)
      else x.toUpperCase

    def lowerNoOp        : String = x match{case "~"=>"stream"; case "\\/"=>"void";   case v => v.toLowerCase }
    def withOp           : String = x match{case "VOID" => "\\/"; case _ => x }

    def simpleName(brief: Boolean = true): String =
      var v = x
      if(brief) v = v.d("Val.").d("Gen.").d("Lang.",5)

      v = v.d("scalqa.")
           .d("Calendar.",9).d("Request.",8).d("Util.").d("Math.Ordering",5).d("Math.BigDecimal",5).d("Math.BigInteger",5).d("Number.Rounding",7).d("Time.DayTime",5).d("Time.Period",5)
           .d("J.Json.Array",    2<>6).d("J.Json.Object",2<>6).d("J.File.Path",      2<>6).d("J.Io.",         2<>4)
           .d("J.Util.Benchmark",2<>6).d("J.Util.Random",2<>6).d("J.Util.Concurrent",2<>6).d("J.Util.WeakRef",2<>6)
           .d("J.Vm.Priority",   2<>4).d("J.Vm.Setup",   2<>4).d("J.Vm.Memory",      2<>4).d("J.Vm.Host",     2<>4)
      v = v.r(".G.Math.",".G.").r("Event.Observable","Observable")
           .r("Fx.Control.","Fx.").r("Fx.Scene.","Fx.").r("Fx.Base.","Fx.")
           .r("THIS_TYPE","this.type")
           .r("Boolean.Raw",  "Any.Boolean").r("Byte.Raw",  "Any.Byte").r("Char.Raw",  "Any.Char").r("Short.Raw",  "Any.Short").r("Int.Raw",  "Any.Int").r("Long.Raw",  "Any.Long").r("Float.Raw",  "Any.Float").r("Double.Raw",  "Any.Double")
           .r("Boolean.Primitive","Boolean").r("Byte.Primitive","Byte").r("Char.Primitive","Char").r("Short.Primitive","Short").r("Int.Primitive","Int").r("Long.Primitive","Long").r("Float.Primitive","Float").r("Double.Primitive","Double")
           .r("Any.Specialized","Specialized")

      if(v.endsWith("$")) v=v.dropLast(1)
      if(v.startsWith("scala.")) v= v.r("scala.annotation.targetName","targetName").r("scala.Predef$.String","String").r("scala.Predef.String","String")
        .r("scala.math.Ordering","Ordering").r("scala.Ordering","Ordering").r("scala.AnyVal","AnyVal").r("scala.Unit","Unit")
        .r("scala.Any","Any").r("scala.AnyRef","AnyRef").r("scala.Array" ,"Array")
        .r("scala.Boolean","Boolean").r("scala.Byte","Byte") .r("scala.Char","Char").r("scala.Short","Short").r("scala.Int","Int").r("scala.Long","Long").r("scala.Float","Float").r("scala.Double","Double")

      v = v.withOp
      if(v.startsWith("~."))                 v = "Val." + v
      if(v.endsWith(".DEF"))                 v = v.dropLast(4)
      else if(v.endsWith(".this.type"))      v = "this.type"
      else if(v.endsWith(".THIS_OPAQUE"))    v = "THIS_OPAQUE"
      else if(v.endsWith(".REAL"))           v = "REAL"
      else if(v.endsWith(".Containers.A"))   v = if(v.startsWith("AnyRef")) "String" else v.takeBefore(".")
      else if(v.endsWith(".KEY"))            v = "KEY"
      else if(v.endsWith(".A"))              v = "A"

      v.dropDuplicateEnd

    @tn("dropFirst") private def d(v: String)             : String = if(x.startsWith(v)) x.dropFirst(v.length) else x
    @tn("dropFirst") private def d(v: String,len:Int)     : String = if(x.startsWith(v)) x.dropFirst(len) else x
    @tn("dropFirst") private def d(v: String,r: Int.Range): String = if(x.startsWith(v)) x.dropRange(r) else x
    @tn("replace")   private def r(v: String,w: String)   : String = x.replace(v,w)
    @tn("remove")    private def r(v : String)            : String = x.remove(v)

    def dropDuplicateEnd : String = x.lastIndexOfOpt(".").mapOpt(i => {
      val len = x.length - i - 1
      x.lastIndexOfOpt(".",i-1).default(-1).take(j => i - j - 1 == len && x.takeRange(i+1,len) == x.takeRange(j+1,len)).map(_ => len+1)
    }).map(x.dropLast(_)) or x
