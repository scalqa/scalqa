package scalqa; package j; package json; import language.implicitConversions

trait Object extends `val`.Lookup[String, Any] with Able.Doc:
  def jObject   (name: String) : J.Object       = jObjectOpt(name).get
  def jObjectOpt(name: String) : Opt[J.Object]  = getOpt(name).takeType[J.Object]
  def jArray(    name: String) : J.Array        = jArrayOpt(name).get
  def jArrayOpt( name: String) : Opt[J.Array]   = getOpt(name).takeType[J.Array]

  def string(    name: String) : String         = stringOpt(name).get
  def stringOpt( name: String) : Opt[String]    = getOpt(name).drop(_.isInstanceOf[Object]).drop(_.isInstanceOf[Array]).map(_.toString)
  def int(       name: String) : Int            = intOpt(name).get
  def long(      name: String) : Long           = longOpt(name).get
  def double(    name: String) : Double         = doubleOpt(name).get
  def intOpt(    name: String) : Int.Opt        = getOpt(name).mapOpt{case v:Int   => v; case s:String => s.toIntOpt;    case v:Number => v.intValue;    case _ => VOID :Int.Opt}
  def longOpt(   name: String) : Long.Opt       = getOpt(name).mapOpt{case v:Long  => v; case s:String => s.toLongOpt;   case v:Number => v.longValue;   case _ => VOID :Long.Opt}
  def doubleOpt( name: String) : Double.Opt     = getOpt(name).mapOpt{case v:Double=> v; case s:String => s.toDoubleOpt; case v:Number => v.doubleValue; case _ => VOID :Double.Opt}
  def boolean(   name: String) : Boolean        = string(name).toBoolean

  def doc                      : Doc            = Doc(this) ++= pairStream.map(t => (t._1,t._2.tag))
  override def tag             : String         = Json.format(this)

object Object extends Gen.Void.Setup[AnyRef](z.Void.Object):
  type M = Mutable; inline def M = Mutable

  trait Mutable extends Object with Lookup.Mutable[String, Any]:
    def put(name: String, a: Any) : Unit
    def add(v: (String, Any))     : Unit = put(v._1, v._2)

  object Mutable:
    def apply(): Mutable = X.Basic()

    object X:
      class Basic extends Lookup.Mutable.X.Basic[String, Any] with Mutable

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object X -> ### Type Extentions \n\n This object contains all provided base type implementations
*/