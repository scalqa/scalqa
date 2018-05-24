package scalqa; package Pipe; package Z; package evaluate

private[Pipe] object count {

  def andTime[A](src: Flow[A], f: (Int, Time.Length) => Any): Unit = (Time.get, src.synchronize.count()) apply ((t, c) => f(c, t.age))

  def few[A](src: Flow[A], f: A => Boolean*): Index[Int] = Array.get[Int](f.size).I.to(array => {
    {
      src.foldAsOpt[Array[Int]](
        array,
        (a, v) => { var i = 0; while (i < a.size) { if (f(i)(v)) a(i) += 1; i += 1 }; a },
        (a, b) => { var i = 0; while (i < a.size) { a(i) += b(i); i += 1 }; a })
    } orElse new Index.The.Proxy(array) with Void
  })

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/