package scalqa; package gen; package event; package observable; import language.implicitConversions

object X:
  private object AnyChangeEvent

  abstract class Abstract extends Base

  trait Base extends Observable with Event.Store.Provider:
    /**/      def onObservableChange[U](f: () => U): Event.Control = eventStore.onEvent0(AnyChangeEvent, f)
    protected def fireAnyChange                    : Int           = eventStore.fireEvent0(AnyChangeEvent)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object X -> ### Type Extentions \n\n This object contains all provided base type implementations
*/