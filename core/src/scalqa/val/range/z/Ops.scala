package scalqa; package `val`; package range; package z; import language.implicitConversions

object Ops:
  inline def contains[A](x: Range[A], r: Range[A])   : Boolean       = !(r.start <* x) && !(r.end.*>(r.endIsIn,x))
  inline def contains[A](x: Range[A], v: A)          : Boolean       = !(v <* x) && !(v *> x)
  inline def isEmpty [A](x: Range[A])                : Boolean       = x.start *> x
  inline def join    [A](x: Range[A], v: A)
                                    (mk: X.Base[A,_]): Range[A]      = if(v <* x) mk(v,x.end,x.endIsIn,x.ordering) else if(v *> x) mk(x.start,v,true,x.ordering) else x
  inline def join    [A](x: Range[A], r: Range[A])
                                    (mk: X.Base[A,_]): Range[A]      = if(r.start <* x){ if(r.end.*>(r.endIsIn,x)) mk(r.start,r.end,r.endIsIn,x.ordering) else mk(r.start,x.end,x.endIsIn,x.ordering)}
                                                                       else if(r.end.*>(r.endIsIn,x)) mk(x.start,r.end,r.endIsIn,x.ordering) else x
  inline def overlaps  [A](x: Range[A], r: Range[A]) : Boolean       = if(r.start <* x) !(x.start *> r) else !(r.start *> x)
  /**/   def overlapOpt[A](x: Range[A], r: Range[A])
                                    (mk: X.Base[A,_]): Opt[Range[A]] = if(r.start <* x){ if(r.end.*>(r.endIsIn,x)) x else if(x.start *> r) \/ else mk(x.start,r.end,r.endIsIn,x.ordering)}
                                                                       else if(x.end.*>(x.endIsIn,r)) r else if(r.start *> x) \/ else mk(r.start,x.end,x.endIsIn,x.ordering)

  // Privates -----------------------------------------------------------------------------------
  extension[A](inline x: A)
    inline   def <* (r:Range[A])                     : Boolean       = r.ordering.compare(x,r.start) < 0
    inline   def *> (inline r:Range[A])              : Boolean       = x.*>(true,r)
    inline   def *> (inline xIn: Boolean, r:Range[A]): Boolean       = {val i=r.ordering.compare(x,r.end); i>0 || i==0 && (xIn && !r.endIsIn)}

  def maker[A] = DefaultMaker.cast[X.Base[A,_]]
  private object DefaultMaker extends X.Base[Any,Range[Any]]:
    def make(s:Any, e:Any, in:Boolean)(using Ordering  [Any]): Range[Any] = Range(s,e,in)
    def ordering= J.unsupportedOperation()
    def start   = J.unsupportedOperation()
    def end     = J.unsupportedOperation()
    def endIsIn = false
/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
