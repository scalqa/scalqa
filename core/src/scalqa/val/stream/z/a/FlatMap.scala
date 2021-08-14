package scalqa; package `val`; package stream; package z; package a; import language.implicitConversions

object FlatMap:
  abstract class ToRef[A](x: AnyRef) extends Pipe[A](x):
    private            var cur       : ~[A]             = \/
    private            var open      : Boolean          = true
    protected          def fewOpt    : Opt[~[A]]
    private            def fetchOpt  : Opt[A]           = fewOpt.fornil{cur = \/; open = false}.map_?(v => { cur = v; cur.read_?})
    @tn("read_Opt")    def read_?    : Opt[A]           = cur.read_? or_? { var o = fetchOpt; while(open && o.isEmpty) o = fetchOpt; o }

  abstract class ToBoolean[A<:Boolean.Raw](x: AnyRef) extends Pipe.ofBoolean[A](x):
    private            var cur       : Boolean.G.~[A]   = \/
    private            var open      : Boolean          = true
    protected          def fewOpt    : Opt[~[A]]
    private            def fetchOpt  : Boolean.G.Opt[A] = fewOpt.fornil{cur = \/; open = false}.map_?(v => { cur = v.raw; cur.readRaw_?})
    @tn("readRaw_Opt") def readRaw_? : Boolean.G.Opt[A] = cur.readRaw_? or_? { var o = fetchOpt; while(open && o.isEmpty) o = fetchOpt; o }

  abstract class ToByte[A<:Byte.Raw](x: AnyRef) extends Pipe.ofByte[A](x):
    private            var cur       : Byte.G.~[A]      = \/
    private            var open      : Boolean          = true
    protected          def fewOpt    : Opt[~[A]]
    private            def fetchOpt  : Byte.G.Opt[A]    = fewOpt.fornil{cur = \/; open = false}.map_?(v => { cur = v.raw; cur.readRaw_?})
    @tn("readRaw_Opt") def readRaw_? : Byte.G.Opt[A]    = cur.readRaw_? or_? { var o = fetchOpt; while(open && o.isEmpty) o = fetchOpt; o }

  abstract class ToChar[A<:Char.Raw](x: AnyRef) extends Pipe.ofChar[A](x):
    private            var cur       : Char.G.~[A]      = \/
    private            var open      : Boolean          = true
    protected          def fewOpt    : Opt[~[A]]
    private            def fetchOpt  : Char.G.Opt[A]    = fewOpt.fornil{cur = \/; open = false}.map_?(v => { cur = v.raw; cur.readRaw_?})
    @tn("readRaw_Opt") def readRaw_? : Char.G.Opt[A]    = cur.readRaw_? or_? { var o = fetchOpt; while(open && o.isEmpty) o = fetchOpt; o }

  abstract class ToShort[A<:Short.Raw](x: AnyRef) extends Pipe.ofShort[A](x):
    private            var cur       : Short.G.~[A]     = \/
    private            var open      : Boolean          = true
    protected          def fewOpt    : Opt[~[A]]
    private            def fetchOpt  : Short.G.Opt[A]   = fewOpt.fornil{cur = \/; open = false}.map_?(v => { cur = v.raw; cur.readRaw_?})
    @tn("readRaw_Opt") def readRaw_? : Short.G.Opt[A]   = cur.readRaw_? or_? { var o = fetchOpt; while(open && o.isEmpty) o = fetchOpt; o }

  abstract class ToInt[A<:Int.Raw](x: AnyRef) extends Pipe.ofInt[A](x):
    private            var cur       : Int.G.~[A]       = \/
    private            var open      : Boolean          = true
    protected          def fewOpt    : Opt[~[A]]
    private            def fetchOpt  : Int.G.Opt[A]     = fewOpt.fornil{cur = \/; open = false}.map_?(v => { cur = v.raw; cur.readRaw_?})
    @tn("readRaw_Opt") def readRaw_? : Int.G.Opt[A]     = cur.readRaw_? or_? { var o = fetchOpt; while(open && o.isEmpty) o = fetchOpt; o }

  abstract class ToLong[A<:Long.Raw](x: AnyRef) extends Pipe.ofLong[A](x):
    private            var cur       : Long.G.~[A]      = \/
    private            var open      : Boolean          = true
    protected          def fewOpt    : Opt[~[A]]
    private            def fetchOpt  : Long.G.Opt[A]    = fewOpt.fornil{cur = \/; open = false}.map_?(v => { cur = v.raw; cur.readRaw_?})
    @tn("readRaw_Opt") def readRaw_? : Long.G.Opt[A]    = cur.readRaw_? or_? { var o = fetchOpt; while(open && o.isEmpty) o = fetchOpt; o }

  abstract class ToFloat[A<:Float.Raw](x: AnyRef) extends Pipe.ofFloat[A](x):
    private            var cur       : Float.G.~[A]     = \/
    private            var open      : Boolean          = true
    protected          def fewOpt    : Opt[~[A]]
    private            def fetchOpt  : Float.G.Opt[A]   = fewOpt.fornil{cur = \/; open = false}.map_?(v => { cur = v.raw; cur.readRaw_?})
    @tn("readRaw_Opt") def readRaw_? : Float.G.Opt[A]   = cur.readRaw_? or_? { var o = fetchOpt; while(open && o.isEmpty) o = fetchOpt; o }

  abstract class ToDouble[A<:Double.Raw](x: AnyRef) extends Pipe.ofDouble[A](x):
    private            var cur       : Double.G.~[A]    = \/
    private            var open      : Boolean          = true
    protected          def fewOpt    : Opt[~[A]]
    private            def fetchOpt  : Double.G.Opt[A]  = fewOpt.fornil{cur = \/; open = false}.map_?(v => { cur = v.raw; cur.readRaw_?})
    @tn("readRaw_Opt") def readRaw_? : Double.G.Opt[A]  = cur.readRaw_? or_? { var o = fetchOpt; while(open && o.isEmpty) o = fetchOpt; o }

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
