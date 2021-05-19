package scalqa; package j; package json; import language.implicitConversions

trait Array extends `val`.Idx[Any]:
  /**/     def jObject(i: Int) : J.Object = apply(i).cast[J.Object]
  /**/     def jArray (i: Int) : J.Array  = apply(i).cast[J.Array]

  /**/     def string (i: Int) : String   = apply(i).toString
  /**/     def double (i: Int) : Double   = string(i).toDouble
  /**/     def boolean(i: Int) : Boolean  = string(i).toBoolean
  /**/     def long   (i: Int) : Long     = string(i).toLong
  /**/     def int    (i: Int) : Int      = string(i).toInt

  override def toString        : String   = Json.format(this)


object Array extends Self.Void.Setup[Array](z.Void.Array):
  type M = Mutable; inline def M = Mutable

  trait Mutable extends Array with `val`.idx.Mutable[Any]

  object Mutable:
    def apply(): Mutable = X.Basic()

    object X:
      class Basic extends Any.Ref.Buffer[Any] with Mutable

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object X -> ###  \n\n Object [[X]] defines standard parent type extensions
*/