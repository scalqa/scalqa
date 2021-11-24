package scalqa; package `val`; package stream; package z; package x; import language.implicitConversions

abstract class FlatMap[A](x: AnyRef) extends Pipe[A](x):
    private            var cur       : Stream[A]           = \/
    private            var open      : Boolean             = true
    protected          def fewOpt    : Opt[Stream[A]]
    private            def fetchOpt  : Opt[A]              = fewOpt.fornil{cur = \/; open = false}.mapOpt(v => { cur = v; cur.readOpt})
    def readOpt    : Opt[A]              = cur.readOpt orOpt { var o = fetchOpt; while(open && !o) o = fetchOpt; o }

object FlatMap:
  abstract class AsBoolean(x: AnyRef) extends Pipe.asBoolean(x):
    private            var cur       : Boolean.Stream      = \/
    private            var open      : Boolean             = true
    protected          def fewOpt    : Opt[Boolean.Stream]
    private            def fetchOpt  : Boolean.Opt         = fewOpt.fornil{cur = \/; open = false}.mapOpt(v => { cur = v; cur.readRawOpt})
    def readRawOpt : Boolean.Opt         = cur.readRawOpt orOpt { var o = fetchOpt; while(open && !o) o = fetchOpt; o }

  abstract class AsByte(x: AnyRef) extends Pipe.asByte(x):
    private            var cur       : Byte.Stream         = \/
    private            var open      : Boolean             = true
    protected          def fewOpt    : Opt[Byte.Stream]
    private            def fetchOpt  : Byte.Opt            = fewOpt.fornil{cur = \/; open = false}.mapOpt(v => { cur = v; cur.readRawOpt})
    def readRawOpt : Byte.Opt            = cur.readRawOpt orOpt { var o = fetchOpt; while(open && !o) o = fetchOpt; o }

  abstract class AsChar(x: AnyRef) extends Pipe.asChar(x):
    private            var cur       : Char.Stream         = \/
    private            var open      : Boolean             = true
    protected          def fewOpt    : Opt[Char.Stream]
    private            def fetchOpt  : Char.Opt            = fewOpt.fornil{cur = \/; open = false}.mapOpt(v => { cur = v; cur.readRawOpt})
    def readRawOpt : Char.Opt            = cur.readRawOpt orOpt { var o = fetchOpt; while(open && !o) o = fetchOpt; o }

  abstract class AsShort(x: AnyRef) extends Pipe.asShort(x):
    private            var cur       : Short.Stream        = \/
    private            var open      : Boolean             = true
    protected          def fewOpt    : Opt[Short.Stream]
    private            def fetchOpt  : Short.Opt           = fewOpt.fornil{cur = \/; open = false}.mapOpt(v => { cur = v; cur.readRawOpt})
    def readRawOpt : Short.Opt           = cur.readRawOpt orOpt { var o = fetchOpt; while(open && !o) o = fetchOpt; o }

  abstract class AsInt(x: AnyRef) extends Pipe.asInt(x):
    private            var cur       : Int.Stream          = \/
    private            var open      : Boolean             = true
    protected          def fewOpt    : Opt[Int.Stream]
    private            def fetchOpt  : Int.Opt             = fewOpt.fornil{cur = \/; open = false}.mapOpt(v => { cur = v; cur.readRawOpt})
    def readRawOpt : Int.Opt             = cur.readRawOpt orOpt { var o = fetchOpt; while(open && !o) o = fetchOpt; o }

  abstract class AsLong(x: AnyRef) extends Pipe.asLong(x):
    private            var cur       : Long.Stream         = \/
    private            var open      : Boolean             = true
    protected          def fewOpt    : Opt[Long.Stream]
    private            def fetchOpt  : Long.Opt            = fewOpt.fornil{cur = \/; open = false}.mapOpt(v => { cur = v; cur.readRawOpt})
    def readRawOpt : Long.Opt            = cur.readRawOpt orOpt { var o = fetchOpt; while(open && !o) o = fetchOpt; o }

  abstract class AsFloat(x: AnyRef) extends Pipe.asFloat(x):
    private            var cur       : Float.Stream        = \/
    private            var open      : Boolean             = true
    protected          def fewOpt    : Opt[Float.Stream]
    private            def fetchOpt  : Float.Opt           = fewOpt.fornil{cur = \/; open = false}.mapOpt(v => { cur = v; cur.readRawOpt})
    def readRawOpt : Float.Opt           = cur.readRawOpt orOpt { var o = fetchOpt; while(open && !o) o = fetchOpt; o }

  abstract class AsDouble(x: AnyRef) extends Pipe.asDouble(x):
    private            var cur       : Double.Stream       = \/
    private            var open      : Boolean             = true
    protected          def fewOpt    : Opt[Double.Stream]
    private            def fetchOpt  : Double.Opt          = fewOpt.fornil{cur = \/; open = false}.mapOpt(v => { cur = v; cur.readRawOpt})
    def readRawOpt : Double.Opt          = cur.readRawOpt orOpt { var o = fetchOpt; while(open && !o) o = fetchOpt; o }

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
