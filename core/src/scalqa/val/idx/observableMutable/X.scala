package scalqa; package `val`; package idx; package observableMutable; import language.implicitConversions

object X:

  abstract class Abstract[A] extends Idx.M.X.Abstract[A] with ObservableMutable[A]

  // ***************************************************************************************************************************************************************************
  class Basic[A](target: Mutable[A]) extends X.Abstract[A]:
    def this(initSize: Int = 0) = this(Mutable[A](initSize))

    protected val eventStore = Event.Store()

    /**/      def apply(i: Int)                           : A             = target(i)
    /**/      def size                                    : Int           = target.size
    /**/      def onChange[U](l: Pack[Idx.O.Event[A]] =>U): Event.Control = eventStore.onEvent1(Basic.ChangeEvent,l)
    protected def fireChange( l: Pack[Idx.O.Event[A]])    : Unit          = if (!l.isEmpty) eventStore.fireEvent1(Basic.ChangeEvent,l)
    override  def addAt(i: Int, a: A)                     : Unit          = modify(_.addAt(i, a))
    override  def addAllAt(i: Int, s: Stream[A])          : Unit          = modify(_.addAllAt(i, s))
    /**/      def removeRange(i: Int.Range)               : Unit          = if (i.size > 0) modify(_.removeRange(i))
    override  def updateAt(i: Int, a: A)                  : Unit          = modify(_.update(i, a))
    override  def reposition(v: Idx.Permutation)          : Unit          = modify(_.reposition(v))
    override  def sort             (using c: Ordering[A]) : Unit          = modify(_.sort(using c))
    /**/      def refreshRange(r: Int.Range)              : Unit          = fireChange(Pack(Idx.Event.Update.refresh(r, this.rangeView(r))))
    /**/      def modify(updates: Idx.M[A] => Unit)       : Unit          = fireChange(new Idx.Event.Recorder[A](target).self(updates).pack)

  object Basic:
     private object ChangeEvent

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object X -> ### Type Extentions \n\n This object contains all provided base type implementations
*/