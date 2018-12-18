package scalqa; package Any; package Able

trait Seal {
  private var _sealed = false

  def isSealed = _sealed

  def seal: this.type = { _sealed = true; this }

  protected def _failIfSealed: this.type = { if (isSealed) App.Fail("Object sealed and cannot be modified"); this }

  protected def _failIfSealed(message: => String): this.type = { if (isSealed) App.Fail(message); this }

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Seal -> `Generic Able to Seal`
 *
 *   Classes implementing Able to Seal allow some sort of mutation only until `seal` method is called
 *
 *   From this point any mutation attempt should fail
 *
 * @def isSealed -> Sealed check
 *
 *    Returns `true` if `this` is sealed and can be no longer modified
 *
 * @def seal -> Seal object
 *
 *    Seals `this` object so it can be no longer modified
 *
 */
