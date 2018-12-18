package scalqa; package Util; package Future; package Z; package A

private[Future] class Completed[A](v: A) extends Util.Future[A] {
  val result = Out.apply(v)

  def resultOpt = result

  def onComplete(f: Out[A] => Unit)(implicit e: concurrent.ExecutionContext) = f(resultOpt.value)

  override def mapResult[B](f: Out[A] => Out[B])(implicit e: concurrent.ExecutionContext): Future[B] = f(result).convert(new Completed(_), new Failed(_))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
