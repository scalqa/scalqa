package scalqa; package j; package util; package concurrent

import Deque.Z.*

class Deque[A] extends Collection[A]:
  private val head  : Concurrent.Ref[Entry] = Ref[Entry](Root)
  private val tail  : Concurrent.Ref[Entry] = Ref[Entry](Root)
  /**/    def stream: Stream[A]             = new Stream[A](head.get)
  /**/    def size  : Int                   = head.get.size

  def push(a: A): Unit =
    while(true)
      val e=head.get
      val v=Entry(a,e)
      if(head.tryChange(e,v)){ v.next.prior=v; return ()}

  def popOpt : Opt[A] =
    while(true)
      val e=tail.get
      val v= if(e.ok) e else head.get.last
      if(tail.tryChange(e,v.prior)) return v.popOpt[A]
    VOID

private object Deque:

  object Z:

    class Entry(val value: Any, val next: Entry) extends Able.Doc:
      var prior    : Entry    = Root
      var ok       : Boolean  = true
      def last     : Entry    = { var e=this; while(e.next.ok) e=e.next; e }
      def size     : Int      = { var e=this; var i=0; while(e.ok){ i+=1; e=e.next}; i }
      def popOpt[A]: Opt[A]   = ok ? { ok = false; value.cast[A]}
      def doc      : Doc      = Doc("Entry:"+this.self.hash) += ("thisOk",ok) += ("nextOk",next.ok) += ("priorOk",prior.ok) += ("size",size) += ("value",value.toString)

    object Root extends Entry(null, null):
      override val next              = this
      override def prior             = this
      override def ok                = false
      override def last              = this
      override def size              = 0
      override def popOpt[A]: Opt[A]=VOID
      override def doc               = Doc("Entry:Void")

    class Stream[A](v: Entry) extends Val.Stream[A]:
      private         var e      : Entry  = v
      def readOpt : Opt[A] = e.ok ? {val v=e.value.cast[A]; e=e.next; v }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Deque  -> ###

    Thread safe linked list Deque implementation.

@def push -> Add first

    Adds element to the first position

@def popOpt -> Remove last

    Removes and returns the last element or void option if empty

*/