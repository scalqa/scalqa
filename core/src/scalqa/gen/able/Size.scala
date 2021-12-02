package scalqa; package gen; package able; import language.implicitConversions

trait Size:
  def size: Int

object Size:

  extension(inline x: Size)
    inline def isEmpty : Boolean = x.size == 0
    inline def nonEmpty: Boolean = x.size != 0

  def sizeOpt(v: AnyRef) : Int.Opt  =
    v match
       case v: Size     => v.size.?
       case v: Opt      => v.sizeOpt
       case v: Long     => v.sizeLong.?.mapOpt(v => if(v <= Int.max) v.toInt else VOID :Int.Opt)
       case v: Opt.Long => v.sizeLongOpt.mapOpt(v => if(v <= Int.max) v.toInt else VOID :Int.Opt)
       case _           => VOID

  def sizeLongOpt(v: AnyRef): Long.Opt =
    v match
       case v: Long     => v.sizeLong.?
       case v: Opt.Long => v.sizeLongOpt
       case v: Size     => v.size.toLong.?
       case v: Opt      => v.sizeOpt.map(_.toLong)
       case _           => VOID

  // ************************************************************************************
  trait Long:
    def sizeLong: scala.Long

  extension(inline x: Long)
    inline def isEmpty : Boolean = x.sizeLong == 0L
    inline def nonEmpty: Boolean = x.sizeLong != 0L

  // ************************************************************************************
  trait Zero extends Size:
    final override def size    = 0

  // ************************************************************************************
  trait Opt:
    def sizeOpt : Int.Opt

  object Opt:
    trait Long:
      def sizeLongOpt : Long.Opt

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Size -> Able of providing size

@def size -> Element count

   Retuns element count

@trait Zero -> Able of providing size hardcodded as 0

@def size -> Returns 0

*/