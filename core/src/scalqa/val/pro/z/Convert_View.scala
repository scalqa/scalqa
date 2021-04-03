package scalqa; package `val`; package pro; package z; import language.implicitConversions

private[`val`] class Convert_View[A,B](protected val real: Pro[A], f: A => B) extends pro.X.Abstract[B]:

  def apply() = f(real())

  override def info = super.info += ("real", real)

private[pro] object Convert_View:

  class O[A,B](protected override val real: Pro.Observable[A], as: A => B) extends Convert_View[A,B](real, as) with Pro.Observable[B]:
    def onChange[U](f: () => U) = real.onChange(f)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
