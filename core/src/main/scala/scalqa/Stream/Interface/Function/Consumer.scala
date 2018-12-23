package scalqa; package Stream; package Interface; package Function

trait Consumer[@specialized(DATA) -A] {

  def accept(v: A): Unit

}

object Consumer {

  private object Void extends Consumer[Any] { @inline final def accept(v: Any) = () }

  implicit def zzMakeVoid[@specialized(DATA) A](v: \/): Consumer[A] = Void.asInstanceOf[Consumer[A]]

  // ****************************************************************************************************
  trait Idx[@specialized(DATA) A] {

    def accept(i: Int, v: A): Unit

  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Consumer -> `Consumer[A]` &nbsp; is a specialized equivalent of &nbsp; `A => Unit` &nbsp; function and can be used in similar manner including syntactic sugar
 *
 *   {{{
 *     def foreach(f : Consumer[Int]): Unit
 *
 *     foreach(v => println(v))
 *   }}}
 *
 * @trait Idx -> `Consumer.Idx[A]` &nbsp; is a specialized equivalent of &nbsp; `(Int, A) => Unit` &nbsp; function and can be used in similar manner including syntactic sugar
 *
 *   {{{
 *     def foreach(f : Consumer.Idx[String]): Unit
 *
 *     foreach((i,str) => println(i + ":" + str))
 *   }}}
 */
