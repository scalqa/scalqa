package scalqa; package `val`; import lookup.*; import language.implicitConversions

trait Lookup[A, +B] extends Collection[B]:
  def getOpt(key: A)            : Opt[B]
  def getStream(keys: Stream[A]): Stream[B]       = keys.mapOpt(k => getOpt(k))
  def get(v: A)                 : B               = getOpt(v) or (throw ZZ.ME(v.tag))
  def pairStream                : Stream[(A, B)]
  def keyStream                 : Stream[A]       = pairStream.map(_._1)
  def stream                    : Stream[B]       = pairStream.map(_._2)

object Lookup:
  /**/                  def lazySource[A,B](createFunOpt:A=>Opt[B]): Lookup[A,B] = Z.Basic(createFunOpt)
  /**/                  def apply[A,B](v: Stream[(A, B)])          : Lookup[A,B] = Stable(v)
  /**/                  def apply[A,B](vs: (A, B)*)                : Lookup[A,B] = Stable(vs)
  @tn("getVoid") inline def void[A,B]                              : Lookup[A,B] = Stable.void
  implicit       inline def implicitRequest[A,B](v:VOID)           : Lookup[A,B] = void[A,B]

  extension[A,B] (x: Lookup[A,B])
    def mapView[C](f: B => C) : Lookup[A,C]               = Z.Convert_View(x, f)
    def toMapView             : scala.collection.Map[A,B] = Z.ScalaMap_View(x)
    def toPartialFunctionView : PartialFunction[A,B]      = Z.PartialFunction_View(x)

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def Stable  = lookup.Stable;   type Stable[A,B]  = lookup.Stable[A,B]
  transparent inline def Mutable = lookup.Mutable;  type Mutable[A,B] = lookup.Mutable[A,B]
  transparent inline def M       = Mutable;         type M[A,B]       = Mutable[A,B]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Lookup -> ### Lookup Collection

      In [[Lookup]] collection every element is stored with a 'key' and can be accessed (looked up) with this 'key'

      It is a greatly simplified equivalent of scala.Map


@def get ->  Element by key

      Returns element associated with the given `key`

      Note. This operation will fail, if value is not found. Thus, use safer [[getOpt]] in most cases

@def getOpt -> Optional element by key

      Optionally returns element associated with the given `key`

@def getStream -> Multi key lookup

      Returns a stream of values for given stream of keys.

      Note: There may be less values, than keys. Keys with no assosiated values are ignored.

@def pairStream  -> Key/value pair stream

      Returns a [[Stream]] of all key/value pairs for this [[Lookup]]


@def keyStream -> Key stream

      Returns a [[Stream]] of all keys for this [[Lookup]]


@def stream -> Value stream

      Returns a [[Stream]] of all values for this [[Lookup]]

@def void  -> Get void instance

@def implicitRequest   -> General void instance request \n\n It is possible to use general request VOID to get void instance of this type, thanks to this implicit conversion.

*/
