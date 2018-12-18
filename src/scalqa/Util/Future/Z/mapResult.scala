package scalqa; package Util; package Future; package Z

private[Future] object mapResult {

  def apply[A, B](f: Future[A], m: Out[A] => Out[B])(implicit e: concurrent.ExecutionContext): Future[B] = {

    val p = Promise.make[B]

    f.onComplete(r => p.tryComplete(m(r)))

    p.future
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
