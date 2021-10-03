package scalqa; package `val`; package pro; package observable; import language.implicitConversions

object X:
  private object ChangeEvent

  abstract class Base[A] extends pro.X.Base[A] with Basis[A]

  // *****************************************************************************************************************
  trait Basis[A] extends pro.X.Basis[A] with Observable[A] with Event.Store.Provider:
    private[observable] def count                     = eventStore.count
    override            def onChange[U](f: () => U)   = eventStore.onEvent0(ChangeEvent, f)
    protected           def fireChange: Int           = eventStore.fireEvent0(ChangeEvent)

  // *****************************************************************************************************************
  trait ActivationBasis[A] extends Basis[A]:
    private             var active                    = false
    private             def cnhg(v: Boolean): Unit    = { active = v; if (v) _afterFirstListenerAdded else _afterLastListenerRemoved }
    override            def onChange[U](f: () => U)   = super.onChange(f).^(_ => if (f.isInstanceOf[Event.Id.Cancel]) { if (active && count == 0) cnhg(false) } else if (!active && count > 0) cnhg(true))
    protected override  def fireChange: Int           = super.fireChange.self_^(v => if (active && v == 0) cnhg(false))
    protected           def _afterFirstListenerAdded  = ()
    protected           def _afterLastListenerRemoved = ()

  // *****************************************************************************************************************
  class Basic[A](source: => A) extends observable.X.Base[A]:
    def this(source: => A, dependencies: ~[Gen.Observable] = \/) =
      this(source)
      dependencies.foreach(_.onObservableChange(() => fireChange))

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
@object X -> ### Implemented Type Extentions
*/