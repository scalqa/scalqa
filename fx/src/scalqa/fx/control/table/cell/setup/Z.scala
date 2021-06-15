package scalqa; package fx; package control; package table; package cell; package setup; import language.implicitConversions

private object Z:

  def voidFun[ROW,A]: ROW => Pro.O[Opt[A]] = VoidFunction.cast[ROW => Pro.O[Opt[A]]]

  def voidPro[A] : Pro.O[Opt[A]] = VoidPro.cast[Pro.O[Opt[A]]]

  // ******************************************************************
  private object VoidFunction extends (Any => Pro.O[Opt[Any]]):
    def apply(v: Any) = voidPro

  // ******************************************************************
  private object VoidPro extends Pro.O[Any] with Gen.Void:
    def apply()                  = Opt.void
    def onChange[U](el: () => U) = \/

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
