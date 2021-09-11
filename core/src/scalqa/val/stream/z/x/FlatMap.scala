package scalqa; package `val`; package stream; package z; package x; import language.implicitConversions

abstract class FlatMap[A](x: AnyRef) extends Pipe[A](x):
    private            var cur       : ~[A]        = \/
    private            var open      : Boolean     = true
    protected          def fewOpt    : Opt[~[A]]
    private            def fetchOpt  : Opt[A]      = fewOpt.fornil{cur = \/; open = false}.map_?(v => { cur = v; cur.read_?})
    @tn("read_Opt")    def read_?    : Opt[A]      = cur.read_? or_? { var o = fetchOpt; while(open && !o) o = fetchOpt; o }

object FlatMap:
  abstract class AsBoolean(x: AnyRef) extends Pipe.asBoolean(x):
    private            var cur       : Boolean.~   = \/
    private            var open      : Boolean     = true
    protected          def fewOpt    : Opt[Boolean.~]
    private            def fetchOpt  : Boolean.Opt = fewOpt.fornil{cur = \/; open = false}.map_?(v => { cur = v; cur.readRaw_?})
    @tn("readRaw_Opt") def readRaw_? : Boolean.Opt = cur.readRaw_? or_? { var o = fetchOpt; while(open && !o) o = fetchOpt; o }

  abstract class AsByte(x: AnyRef) extends Pipe.asByte(x):
    private            var cur       : Byte.~      = \/
    private            var open      : Boolean     = true
    protected          def fewOpt    : Opt[Byte.~]
    private            def fetchOpt  : Byte.Opt    = fewOpt.fornil{cur = \/; open = false}.map_?(v => { cur = v; cur.readRaw_?})
    @tn("readRaw_Opt") def readRaw_? : Byte.Opt    = cur.readRaw_? or_? { var o = fetchOpt; while(open && !o) o = fetchOpt; o }

  abstract class AsChar(x: AnyRef) extends Pipe.asChar(x):
    private            var cur       : Char.~      = \/
    private            var open      : Boolean     = true
    protected          def fewOpt    : Opt[Char.~]
    private            def fetchOpt  : Char.Opt    = fewOpt.fornil{cur = \/; open = false}.map_?(v => { cur = v; cur.readRaw_?})
    @tn("readRaw_Opt") def readRaw_? : Char.Opt    = cur.readRaw_? or_? { var o = fetchOpt; while(open && !o) o = fetchOpt; o }

  abstract class AsShort(x: AnyRef) extends Pipe.asShort(x):
    private            var cur       : Short.~     = \/
    private            var open      : Boolean     = true
    protected          def fewOpt    : Opt[Short.~]
    private            def fetchOpt  : Short.Opt   = fewOpt.fornil{cur = \/; open = false}.map_?(v => { cur = v; cur.readRaw_?})
    @tn("readRaw_Opt") def readRaw_? : Short.Opt   = cur.readRaw_? or_? { var o = fetchOpt; while(open && !o) o = fetchOpt; o }

  abstract class AsInt(x: AnyRef) extends Pipe.asInt(x):
    private            var cur       : Int.~       = \/
    private            var open      : Boolean     = true
    protected          def fewOpt    : Opt[Int.~]
    private            def fetchOpt  : Int.Opt     = fewOpt.fornil{cur = \/; open = false}.map_?(v => { cur = v; cur.readRaw_?})
    @tn("readRaw_Opt") def readRaw_? : Int.Opt     = cur.readRaw_? or_? { var o = fetchOpt; while(open && !o) o = fetchOpt; o }

  abstract class AsLong(x: AnyRef) extends Pipe.asLong(x):
    private            var cur       : Long.~      = \/
    private            var open      : Boolean     = true
    protected          def fewOpt    : Opt[Long.~]
    private            def fetchOpt  : Long.Opt    = fewOpt.fornil{cur = \/; open = false}.map_?(v => { cur = v; cur.readRaw_?})
    @tn("readRaw_Opt") def readRaw_? : Long.Opt    = cur.readRaw_? or_? { var o = fetchOpt; while(open && !o) o = fetchOpt; o }

  abstract class AsFloat(x: AnyRef) extends Pipe.asFloat(x):
    private            var cur       : Float.~     = \/
    private            var open      : Boolean     = true
    protected          def fewOpt    : Opt[Float.~]
    private            def fetchOpt  : Float.Opt   = fewOpt.fornil{cur = \/; open = false}.map_?(v => { cur = v; cur.readRaw_?})
    @tn("readRaw_Opt") def readRaw_? : Float.Opt   = cur.readRaw_? or_? { var o = fetchOpt; while(open && !o) o = fetchOpt; o }

  abstract class AsDouble(x: AnyRef) extends Pipe.asDouble(x):
    private            var cur       : Double.~    = \/
    private            var open      : Boolean     = true
    protected          def fewOpt    : Opt[Double.~]
    private            def fetchOpt  : Double.Opt  = fewOpt.fornil{cur = \/; open = false}.map_?(v => { cur = v; cur.readRaw_?})
    @tn("readRaw_Opt") def readRaw_? : Double.Opt  = cur.readRaw_? or_? { var o = fetchOpt; while(open && !o) o = fetchOpt; o }

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
