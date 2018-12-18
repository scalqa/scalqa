package scalqa; package Util; package Future; package Z; package Control

private class Event[A](executor: concurrent.ExecutionContext, job: Out[A] => Any) extends Runnable {

  private var value: Out[A] = _

  def fire(v: Out[A]): Unit = { value = v; executor.execute(this) }

  def run() = job(value)
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
