package scalqa; package `val`; package range; package x; import language.implicitConversions

abstract class Abstract[A, THIS <: Range[A]] extends Range[A]:
  self : THIS =>
  type THIS_TYPE  = THIS

  @tn("join")       def join(v: A)                 : THIS_TYPE      = X.join(self,v,makeNew(_,_,_))
  @tn("join")       def join(r: Range[A])          : THIS_TYPE      = X.join(self,r,makeNew(_,_,_))
  /**/              def overlaps (r: Range[A])     : Boolean        = X.overlaps(self,r)
  @tn("overlap_Opt")def overlap_?(r: Range[A])     : Opt[THIS_TYPE] = X.overlap_?(self,r,makeNew(_,_,_))

  protected         def makeNew(s:A,e:A,in:Boolean): THIS_TYPE


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object X -> ### Type Extentions \n\n This object contains all provided base type implementations
*/