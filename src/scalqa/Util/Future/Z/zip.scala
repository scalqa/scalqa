package scalqa; package Util; package Future; package Z

private[Future] object zip {

  def apply[A, B](fa: Future[A], fb: Future[B])(implicit e: concurrent.ExecutionContext): Future[(A, B)] = {

    val p = Promise.make[(A, B)]

    fa.apply(
      va => fb.resultOpt(_(vb => p.complete((va, vb)))),
      dc => p.complete(dc))

    fb.apply(
      vb => fa.resultOpt(_(va => p.complete((va, vb)))),
      dc => p.complete(dc))

    p.future
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
