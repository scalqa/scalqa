package scalqa; package lang; package anyref; package g; package customized; package companion; import language.implicitConversions

class Opt[A]:
  def apply[A](v: A)                        : Val.Opt[A]  = Val.Opt(v)
  def option[A]  (v: scala.Option[A])       : Val.Opt[A]  = Val.Opt.fromScala(v)
  def optional[A](v: java.util.Optional[A]) : Val.Opt[A]  = Val.Opt.fromJava(v)

object Opt extends Opt[AnyRef]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
