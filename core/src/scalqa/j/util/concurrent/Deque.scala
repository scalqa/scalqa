package scalqa; package j; package util; package concurrent

import Deque.*

class Deque[A] extends Collection[A]:
  private val head  = Ref[Entry](Root)
  private val tail  = Ref[Entry](Root)

  /**/           def push(a: A) : Unit   = while(true){ val e=head.get; val v=Entry(a,e); if(head.change(e,v)){ v.next.prior=v; return ()}}
  @tn("pop_Opt") def pop_?      : Opt[A] ={while(true){ val e=tail.get; val v=if(e.ok) e else head.get.last; if(tail.change(e,v.prior)) return v.popOpt[A]}; \/}
  @tn("stream")  def ~          : ~[A]   = new Stream[A](head.get)
  /**/           def size       : Int    = head.get.size

object Deque:

  class Entry(val value: Any, val next: Entry) extends Able.Doc:
    var prior    : Entry   = Root
    var ok       : Boolean = true
    def last     : Entry   = { var e=this; while(e.next.ok) e=e.next; e }
    def size     : Int     = { var e=this; var i=0; while(e.ok){ i+=1; e=e.next}; i }
    def popOpt[A]: Opt[A]  = ok ? { ok = false; value.cast[A]}
    def doc     : Doc    = Doc("Entry:"+this.^.hash) += ("thisOk",ok) += ("nextOk",next.ok) += ("priorOk",prior.ok) += ("size",size) += ("value",value.toString)

  object Root extends Entry(null, null):
    override val next  = this
    override def prior = this
    override def ok    = false
    override def last  = this
    override def size  = 0
    override def popOpt[A]: Opt[A] = \/
    override def doc  = Doc("Entry:Void")

  class Stream[A](v: Entry) extends ~[A]:
    private         var e      : Entry  = v
    @tn("read_Opt") def read_? : Opt[A] = e.ok ? {val v=e.value.cast[A]; e=e.next; v }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
