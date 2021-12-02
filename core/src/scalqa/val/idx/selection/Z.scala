package scalqa; package `val`; package idx; package selection; import language.implicitConversions

private[idx] object Z:

  class Basic[A](targetIndex: Idx[A], idx: Idx[Int]) extends Selection[A]:
    def target  = targetIndex
    def indexes = idx

  object Void extends Selection[Any] with Gen.Void:
    def target =VOID
    def indexes=VOID

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
