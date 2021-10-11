package scalqa; package gen; package able; import language.implicitConversions

trait Size extends Empty:
  /**/     def size   : Int
  override def isEmpty: Boolean = size == 0

object Size:

  @tn("size_Opt")  def size_?(v: AnyRef) : Int.Opt  =
    v match
       case v: Size     => v.size.?
       case v: Opt      => v.size_?
       case v: Long     => v.sizeLong.?.map_?(v => if(v <= Int.max) v.toInt else \/ :Int.Opt)
       case v: Opt.Long => v.sizeLong_?.map_?(v => if(v <= Int.max) v.toInt else \/ :Int.Opt)
       case _           => \/

  @tn("sizeLong_Opt") def sizeLong_?(v: AnyRef): Long.Opt =
    v match
       case v: Long     => v.sizeLong.?
       case v: Opt.Long => v.sizeLong_?
       case v: Size     => v.size.toLong.?
       case v: Opt      => v.size_?.map(_.toLong)
       case _           => \/

  // ************************************************************************************
  trait Long extends Empty:
    /**/     def sizeLong: scala.Long
    override def isEmpty : Boolean      = sizeLong == 0L

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