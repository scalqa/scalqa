package scalqa; package `val`; package idx; package selection; import language.implicitConversions

trait Observable[A] extends Selection[A] with gen.event.Observable:
  self =>
  type THIS_TYPE <: Observable[A]
  /**/      def onChange[U](f: THIS_TYPE => U)   : Event.Control
  /**/      def onChangeRun[U](f: => U)          : Event.Control  = onChange(_ => f)
  protected def onObservableChange[U](l: () => U): Event.Control  = onChange(Event.Id.map1(l,_ => l()))
  override  def property(dflt: A)                : Pro.O[A]       = new Pro.O[A] { def apply() = indexes.at_?(0).map(self.apply) or dflt; def onChange[U](l: () => U) = self.onChange(_ => l()) }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
