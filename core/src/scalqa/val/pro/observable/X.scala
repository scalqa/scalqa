package scalqa; package `val`; package pro; package observable; import language.implicitConversions

object X:
  private object ChangeEvent

  abstract class Abstract[A] extends pro.X.Abstract[A] with Base[A]

  // *****************************************************************************************************************
  trait Base[A] extends pro.X.Base[A] with Observable[A] with Event.Store.Provider:
    private[observable] def count                     = eventStore.count
    override            def onChange[U](f: () => U)   = eventStore.onEvent0(ChangeEvent, f)
    protected           def fireChange: Int           = eventStore.fireEvent0(ChangeEvent)

  // *****************************************************************************************************************
  trait ActivationBase[A] extends Base[A]:
    private             var active                    = false
    private             def cnhg(v: Boolean): Unit    = { active = v; if (v) _afterFirstListenerAdded else _afterLastListenerRemoved }
    override            def onChange[U](f: () => U)   = super.onChange(f).self(_ => if (f.isInstanceOf[Event.Id.Cancel]) { if (active && count == 0) cnhg(false) } else if (!active && count > 0) cnhg(true))
    protected override  def fireChange: Int           = super.fireChange.self(v => if (active && v == 0) cnhg(false))
    protected           def _afterFirstListenerAdded  = ()
    protected           def _afterLastListenerRemoved = ()

  // *****************************************************************************************************************
  class Basic[A](source: => A) extends observable.X.Abstract[A]:
    def this(source: => A, dependencies: Stream[Gen.Observable] =VOID)=
      this(source)
      dependencies.foreach(_.onObservableChange(() => fireChange))

    private            var valueOpt : Opt[A]=VOID
    /**/               def apply()           = valueOpt or source.self(valueOpt = _)
    protected override def fireChange: Int   = { valueOpt=VOID;  super.fireChange }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object X -> ### Type Extentions \n\n This object contains all provided base type implementations
*/