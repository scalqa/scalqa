package scalqa; package gen; package event

abstract class Id:
  def id : AnyRef
  private[event] def tag : String = "Id=" + id.^.id + ", target=" + fun.^.id
  private[Id]    def fun : AnyRef = null

object Id:

  def make0[U](          id: AnyRef, f: ()        => U) : ()        => U =  Z.Default0(id,f)
  def make1[A,U](        id: AnyRef, f: (A)       => U) : (A)       => U =  Z.Default1(id,f)
  def make2[A,B,U](      id: AnyRef, f: (A,B)     => U) : (A,B)     => U =  Z.Default2(id,f)
  def make3[A,B,C,U](    id: AnyRef, f: (A,B,C)   => U) : (A,B,C)   => U =  Z.Default3(id,f)
  def make4[A,B,C,D,U](  id: AnyRef, f: (A,B,C,D) => U) : (A,B,C,D) => U =  Z.Default4(id,f)

  def cancel0[U](        id: AnyRef)                    : ()        => U =  Z.Cancel0(id)
  def cancel1[A,U](      id: AnyRef)                    : (A)       => U =  Z.Cancel1(id)
  def cancel2[A,B,U](    id: AnyRef)                    : (A,B)     => U =  Z.Cancel2(id)
  def cancel3[A,B,C,U](  id: AnyRef)                    : (A,B,C)   => U =  Z.Cancel3(id)
  def cancel4[A,B,C,D,U](id: AnyRef)                    : (A,B,C,D) => U =  Z.Cancel4(id)

  def map0[U](          old: AnyRef, f: ()        => U) : ()        => U = old match{ case v:Id.Cancel => cancel0(v.id) case v:Id => make0(v.id,f); case _ => f }
  def map1[A,U](        old: AnyRef, f: (A)       => U) : (A)       => U = old match{ case v:Id.Cancel => cancel1(v.id) case v:Id => make1(v.id,f); case _ => f }
  def map2[A,B,U](      old: AnyRef, f: (A,B)     => U) : (A,B)     => U = old match{ case v:Id.Cancel => cancel2(v.id) case v:Id => make2(v.id,f); case _ => f }
  def map3[A,B,C,U](    old: AnyRef, f: (A,B,C)   => U) : (A,B,C)   => U = old match{ case v:Id.Cancel => cancel3(v.id) case v:Id => make3(v.id,f); case _ => f }
  def map4[A,B,C,D,U](  old: AnyRef, f: (A,B,C,D) => U) : (A,B,C,D) => U = old match{ case v:Id.Cancel => cancel4(v.id) case v:Id => make4(v.id,f); case _ => f }

  // ***************************************************************************************************************************************************************
  private[scalqa] abstract class Cancel extends Id:
    override  def toString = "Event.IdCancel(id=" + id.^.id + ")"
    protected def error    = J.illegalState("Event cancel request was not mapped corectly somewhere in the stack trace below. Cancel id= " + id)

  private[event] object Z:
    class Default0[U](        val id: AnyRef, f: ()        => U) extends Id     with (()        => U) { def apply()                = f();        override def fun=f; }
    class Default1[A,U](      val id: AnyRef, f: (A)       => U) extends Id     with ((A)       => U) { def apply(a:A)             = f(a);       override def fun=f; }
    class Default2[A,B,U](    val id: AnyRef, f: (A,B)     => U) extends Id     with ((A,B)     => U) { def apply(a:A,b:B)         = f(a,b);     override def fun=f; }
    class Default3[A,B,C,U](  val id: AnyRef, f: (A,B,C)   => U) extends Id     with ((A,B,C)   => U) { def apply(a:A,b:B,c:C)     = f(a,b,c);   override def fun=f; }
    class Default4[A,B,C,D,U](val id: AnyRef, f: (A,B,C,D) => U) extends Id     with ((A,B,C,D) => U) { def apply(a:A,b:B,c:C,d:D) = f(a,b,c,d); override def fun=f; }

    class Cancel0[U](         val id: AnyRef)                    extends Cancel with (()        => U) { def apply()                = error}
    class Cancel1[A,U](       val id: AnyRef)                    extends Cancel with ((A)       => U) { def apply(a:A)             = error}
    class Cancel2[A,B,U](     val id: AnyRef)                    extends Cancel with ((A,B)     => U) { def apply(a:A,b:B)         = error}
    class Cancel3[A,B,C,U](   val id: AnyRef)                    extends Cancel with ((A,B,C)   => U) { def apply(a:A,b:B,c:C)     = error}
    class Cancel4[A,B,C,D,U]( val id: AnyRef)                    extends Cancel with ((A,B,C,D) => U) { def apply(a:A,b:B,c:C,d:D) = error}


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
