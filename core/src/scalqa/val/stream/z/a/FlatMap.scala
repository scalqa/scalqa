package scalqa; package `val`; package stream; package z; package a; import language.implicitConversions

object FlatMap:
  abstract class ToRef[A](x: Ref) extends Pipe[A](x):
    private            var cur       : ~[A]             = \/;   private var open=true
    protected          def fewOpt    : Opt[~[A]]
    private            def fetchOpt  : Opt[A]           = fewOpt.fornil{cur = \/; open = false}.map_?(v => { cur = v; cur.read_?})
    @tn("read_Opt")    def read_?    : Opt[A]           = cur.read_? or_? { var o = fetchOpt; while(open && o.isEmpty) o = fetchOpt; o }

  abstract class ToBoolean[A<:Any.Raw.Boolean](x: Ref) extends `def`.boolean.Z.Pipe[A](x):
    private            var cur       : Boolean.G.~[A]   = \/;   private var open=true
    protected          def fewOpt    : Opt[~[A]]
    private            def fetchOpt  : Boolean.G.Opt[A] = fewOpt.fornil{cur = \/; open = false}.map_?(v => { cur = v.raw; cur.readRaw_?})
    @tn("readRaw_Opt") def readRaw_? : Boolean.G.Opt[A] = cur.readRaw_? or_? { var o = fetchOpt; while(open && o.isEmpty) o = fetchOpt; o }

  abstract class ToByte[A<:Any.Raw.Byte](x: Ref) extends `def`.byte.Z.Pipe[A](x):
    private            var cur       : Byte.G.~[A]      = \/;   private var open=true
    protected          def fewOpt    : Opt[~[A]]
    private            def fetchOpt  : Byte.G.Opt[A]    = fewOpt.fornil{cur = \/; open = false}.map_?(v => { cur = v.raw; cur.readRaw_?})
    @tn("readRaw_Opt") def readRaw_? : Byte.G.Opt[A]    = cur.readRaw_? or_? { var o = fetchOpt; while(open && o.isEmpty) o = fetchOpt; o }

  abstract class ToChar[A<:Any.Raw.Char](x: Ref) extends `def`.char.Z.Pipe[A](x):
    private            var cur       : Char.G.~[A]      = \/;   private var open=true
    protected          def fewOpt    : Opt[~[A]]
    private            def fetchOpt  : Char.G.Opt[A]    = fewOpt.fornil{cur = \/; open = false}.map_?(v => { cur = v.raw; cur.readRaw_?})
    @tn("readRaw_Opt") def readRaw_? : Char.G.Opt[A]    = cur.readRaw_? or_? { var o = fetchOpt; while(open && o.isEmpty) o = fetchOpt; o }

  abstract class ToShort[A<:Any.Raw.Short](x: Ref) extends `def`.short.Z.Pipe[A](x):
    private            var cur       : Short.G.~[A]     = \/;   private var open=true
    protected          def fewOpt    : Opt[~[A]]
    private            def fetchOpt  : Short.G.Opt[A]   = fewOpt.fornil{cur = \/; open = false}.map_?(v => { cur = v.raw; cur.readRaw_?})
    @tn("readRaw_Opt") def readRaw_? : Short.G.Opt[A]   = cur.readRaw_? or_? { var o = fetchOpt; while(open && o.isEmpty) o = fetchOpt; o }

  abstract class ToInt[A<:Any.Raw.Int](x: Ref) extends `def`.int.Z.Pipe[A](x):
    private            var cur       : Int.G.~[A]       = \/;   private var open=true
    protected          def fewOpt    : Opt[~[A]]
    private            def fetchOpt  : Int.G.Opt[A]     = fewOpt.fornil{cur = \/; open = false}.map_?(v => { cur = v.raw; cur.readRaw_?})
    @tn("readRaw_Opt") def readRaw_? : Int.G.Opt[A]     = cur.readRaw_? or_? { var o = fetchOpt; while(open && o.isEmpty) o = fetchOpt; o }

  abstract class ToLong[A<:Any.Raw.Long](x: Ref) extends `def`.long.Z.Pipe[A](x):
    private            var cur       : Long.G.~[A]      = \/;   private var open=true
    protected          def fewOpt    : Opt[~[A]]
    private            def fetchOpt  : Long.G.Opt[A]    = fewOpt.fornil{cur = \/; open = false}.map_?(v => { cur = v.raw; cur.readRaw_?})
    @tn("readRaw_Opt") def readRaw_? : Long.G.Opt[A]    = cur.readRaw_? or_? { var o = fetchOpt; while(open && o.isEmpty) o = fetchOpt; o }

  abstract class ToFloat[A<:Any.Raw.Float](x: Ref) extends `def`.float.Z.Pipe[A](x):
    private            var cur       : Float.G.~[A]     = \/;   private var open=true
    protected          def fewOpt    : Opt[~[A]]
    private            def fetchOpt  : Float.G.Opt[A]   = fewOpt.fornil{cur = \/; open = false}.map_?(v => { cur = v.raw; cur.readRaw_?})
    @tn("readRaw_Opt") def readRaw_? : Float.G.Opt[A]   = cur.readRaw_? or_? { var o = fetchOpt; while(open && o.isEmpty) o = fetchOpt; o }

  abstract class ToDouble[A<:Any.Raw.Double](x: Ref) extends `def`.double.Z.Pipe[A](x):
    private            var cur       : Double.G.~[A]    = \/;   private var open=true
    protected          def fewOpt    : Opt[~[A]]
    private            def fetchOpt  : Double.G.Opt[A]  = fewOpt.fornil{cur = \/; open = false}.map_?(v => { cur = v.raw; cur.readRaw_?})
    @tn("readRaw_Opt") def readRaw_? : Double.G.Opt[A]  = cur.readRaw_? or_? { var o = fetchOpt; while(open && o.isEmpty) o = fetchOpt; o }

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
