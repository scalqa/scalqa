package scalqa; package `val`; package range; import language.implicitConversions

object X:

  abstract class Base[A, THIS <: Range[A]] extends Range[A]:
    self : THIS =>
    type THIS_TYPE  = THIS

    @tn("join")       def join(v: A)              : THIS_TYPE      = z.Ops.join(self,v)(self).cast[THIS_TYPE]
    @tn("join")       def join(r: Range[A])       : THIS_TYPE      = z.Ops.join(self,r)(self).cast[THIS_TYPE]
    /**/              def overlaps (r: Range[A])  : Boolean        = z.Ops.overlaps(self,r)
    @tn("overlap_Opt")def overlap_?(r: Range[A])  : Opt[THIS_TYPE] = z.Ops.overlapOpt[A](self,r)(self).cast[THIS_TYPE]

    // ------------------------------------------------------------------------------------------
    protected         def make(s:A, e:A, in:Boolean)(using Ordering[A]): THIS_TYPE
    private[range]    def apply (s:A, e:A, in:Boolean, c:Ordering[A])  : THIS_TYPE = make(s,e,in)(using c)


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object X -> ### Type Extention
*/