package scalqa; package lang; package anyref; package g; import language.implicitConversions

import `val`.{ Range as RANGE }
import `val`.range.z.ops

class Range[A](val start:A, val end:A, val endIsIn: Boolean)(using val ordering:Ordering[A]) extends Range.X.Abstract[A]

object Range:

  object X:

    // *************************************************************************************************************
    abstract class Base[A, THIS <: RANGE[A]] extends RANGE[A]:
      self : THIS =>
      type THIS_TYPE  = THIS
      @tn("join")       def join(v: A)                 : THIS_TYPE      = ops.join(self,v,self.makeNew(_,_,_))
      @tn("join")       def join(r: RANGE[A])          : THIS_TYPE      = ops.join(self,r,self.makeNew(_,_,_))
      /**/              def overlaps (r: RANGE[A])     : Boolean        = ops.overlaps(self,r)
      @tn("overlap_Opt")def overlap_?(r: RANGE[A])     : Opt[THIS_TYPE] = ops.overlap_?(self,r,self.makeNew(_,_,_))
      protected         def makeNew(s:A,e:A,in:Boolean): THIS_TYPE

    // *************************************************************************************************************
    abstract class Abstract[A] extends X.Base[A,RANGE[A]]:
      def makeNew(s:A, e:A, in:Boolean): RANGE[A] = RANGE(s,e,in)(using this.ordering)


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object X -> ### Type Extentions \n\n This object contains all provided base type implementations
*/