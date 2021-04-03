package scalqa; package `val`; package pro; package observable; import language.implicitConversions

object X:
  private object ChangeEvent

  abstract class Abstract[A] extends pro.X.Abstract[A] with AbstractTrait[A]

  // *****************************************************************************************************************
  trait AbstractTrait[A] extends pro.X.AbstractTrait[A] with Observable[A] with Event.Store.Provider:
    private[observable] def count                     = eventStore.count
    override            def onChange[U](f: () => U)   = eventStore.onEvent0(ChangeEvent, f)
    protected           def fireChange: Int           = eventStore.fireEvent0(ChangeEvent)

  // *****************************************************************************************************************
  trait ActivationAbstractTrait[A] extends AbstractTrait[A]:
    private             var active                    = false
    private             def cnhg(v: Boolean): Unit    = { active = v; if (v) _afterFirstListenerAdded else _afterLastListenerRemoved }
    override            def onChange[U](f: () => U)   = super.onChange(f).^(_ => if (f.isInstanceOf[Event.Id.Cancel]) { if (active && count == 0) cnhg(false) } else if (!active && count > 0) cnhg(true))
    protected override  def fireChange: Int           = super.fireChange.self_^(v => if (active && v == 0) cnhg(false))
    protected           def _afterFirstListenerAdded  = ()
    protected           def _afterLastListenerRemoved = ()

  // *****************************************************************************************************************
  class Basic[A](source: => A) extends observable.X.Abstract[A]:
    def this(source: => A, dependencies: ~[Gen.Observable] = \/) =
      this(source)
      dependencies.foreach(v => Gen.Observable.onObservableChange(v)(() => fireChange))

    //protected          val eventStore        = new Event.Store()
    private            var valueOpt : Opt[A] = \/
    /**/               def apply()           = valueOpt or source.^(valueOpt = _)
    protected override def fireChange: Int   = { valueOpt = \/;  super.fireChange }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object X -> ###  \n\n Object [[X]] defines standard parent type extensions
*/