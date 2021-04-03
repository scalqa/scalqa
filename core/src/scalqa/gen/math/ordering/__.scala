package scalqa; package gen; package math; import ordering.*; import language.implicitConversions

trait Ordering[A] extends scala.math.Ordering[A]:

  override def compare(x:A,y:A) : Int
//  override def reverse          : scala.math.Ordering[A]
//  override def on[B](f: B => A) : scala.math.Ordering[B]

  ///**/                   def on[B](f: B => A)                       : Ordering[B]      = z.View.Fun[A,B](x,f)
  /**/                   def join(c: Ordering[A])                   : Ordering[A]      = if (this.^.isVoid) c.cast[Ordering[A]] else if (c.^.isVoid) this else z.View.Joined[A](this, c)
  @tn("_join")           def +   (c: Ordering[A])                   : Ordering[A]      = this.join(c)
  @tn("prioritized_View")def prioritized_^(priority: A => Int)      : Ordering[A]      = z.View.Prioritized[A](this, priority)
  @tn("opt_View")        def opt_^(voidPosition: Int)               : Ordering[Opt[A]] = z.View.Option[A, Opt[A]](this, voidPosition)
  @tn("voidFirst_View")  def voidFirst_^   (using Info.Tag.Void[A]) : Ordering[A]      = z.View.VoidPositionFirst[A](this)
  @tn("voidLast_View")   def voidLast_^    (using Info.Tag.Void[A]) : Ordering[A]      = z.View.VoidPositionLast[A](this)


object Ordering:
  inline def apply[A](using inline o: scala.Ordering[A]): scala.Ordering[A] = o
  /**/   def anyAsString                                : Ordering[Any]     = Z.AnyAsString
  /**/   def number                                     : Ordering[Number]  = Z.Number

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //type _extension = ordering._extension

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
