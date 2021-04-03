package scalqa; package gen; package able; import language.implicitConversions

trait Size extends Empty:
  def size   : Int
  def isEmpty: Boolean = size == 0

object Size:

  // ************************************************************************************
  trait Long extends Empty:
    def sizeLong: scala.Long
    def isEmpty : Boolean      = sizeLong == 0L

  // ************************************************************************************
  trait Zero extends Size:
    final override def size    = 0
    final override def isEmpty = true

  // ************************************************************************************
  trait Opt:
    @tn("size_Opt") def size_? : Int.Opt

  object Opt:
    trait Long:
      @tn("sizeLong_Opt") def sizeLong_? : Long.Opt

  // ------------------------------------------------------------------------------------
  @tn("size_Opt")  def size_?(v: Ref) : Int.Opt  = v match
    case v: Size     => v.size.?
    case v: Opt      => v.size_?
    case v: Long     => v.sizeLong.?.map_?[Int.Opt](v => if(v <= Int.max) v.Int else \/)
    case v: Opt.Long => v.sizeLong_?.map_?[Int.Opt](v => if(v <= Int.max) v.Int else \/)
    case _           => \/

  @tn("sizeLong_Opt") def sizeLong_?(v: Ref): Long.Opt = v match
    case v: Long     => v.sizeLong.?
    case v: Opt.Long => v.sizeLong_?
    case v: Size     => v.size.Long.?
    case v: Opt      => v.size_?.map(_.Long)
    case _           => \/

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

*/