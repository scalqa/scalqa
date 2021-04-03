package scalqa; package `def`; package any; package ref; package custom; package framework; package companion; import language.implicitConversions

class Opt[A]:
  def apply[A](v: A)                        : Val.Opt[A]  = Val.Opt(v)
  def option[A]  (v: scala.Option[A])       : Val.Opt[A]  = Val.Opt.option(v)
  def optional[A](v: java.util.Optional[A]) : Val.Opt[A]  = Val.Opt.optional(v)

private[scalqa] object Opt extends Opt[AnyRef]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
