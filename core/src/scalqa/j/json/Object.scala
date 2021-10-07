package scalqa; package j; package json; import language.implicitConversions

trait Object extends `val`.Lookup[String, Any] with Able.Doc:
  /**/              def jObject  (name: String) : J.Object       = jObject_?(name).get
  @tn("object_Opt") def jObject_?(name: String) : Opt[J.Object]  = get_?(name).takeType[J.Object]
  /**/              def jArray(   name: String) : J.Array        = jArray_?(name).get
  @tn("array_Opt")  def jArray_?( name: String) : Opt[J.Array]   = get_?(name).takeType[J.Array]

  /**/              def string(   name: String) : String         = string_?(name).get
  @tn("string_Opt") def string_?( name: String) : Opt[String]    = get_?(name).drop(_.isInstanceOf[Object]).drop(_.isInstanceOf[Array]).map(_.toString)
  /**/              def int(      name: String) : Int            = int_?(name).get
  /**/              def long(     name: String) : Long           = long_?(name).get
  /**/              def double(   name: String) : Double         = double_?(name).get
  @tn("int_Opt")    def int_?(    name: String) : Int.Opt        = get_?(name).map_?{case v:Int   => v; case s:String => s.toInt_?;    case v:Number => v.intValue;    case _ => \/ :Int.Opt}
  @tn("long_Opt")   def long_?(   name: String) : Long.Opt       = get_?(name).map_?{case v:Long  => v; case s:String => s.toLong_?;   case v:Number => v.longValue;   case _ => \/ :Long.Opt}
  @tn("double_Opt") def double_?( name: String) : Double.Opt     = get_?(name).map_?{case v:Double=> v; case s:String => s.toDouble_?; case v:Number => v.doubleValue; case _ => \/ :Double.Opt}
  /**/              def boolean(  name: String) : Boolean        = string(name).toBoolean

  /**/              def doc                     : Doc            = Doc(this) ++= pair_~.map(t => (t._1,t._2.tag))
  override          def tag                     : String         = Json.format(this)

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