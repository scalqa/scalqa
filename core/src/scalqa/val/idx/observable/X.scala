package scalqa; package `val`; package idx; package observable

object X:

  abstract class Abstract[A] extends Observable[A]

  trait Base[A] extends Observable[A] with Gen.Event.Store.Provider:
    /**/      def onChange[U](l: Pack[Event[A]] => U) : Gen.Event.Control = eventStore.onEvent1(EventId,l)
    protected def fireChange(v:  Pack[Event[A]])      : Unit              = if (!v.isEmpty) eventStore.fireEvent1(EventId,v)

  private object EventId

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object X -> ### Type Extentions \n\n This object contains all provided base type implementations
*/