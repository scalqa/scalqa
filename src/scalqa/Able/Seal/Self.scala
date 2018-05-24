package scalqa; package Able; package Seal

trait Self {

  protected def isSealed = _sealed; private var _sealed = false

  protected def seal: this.type = { _sealed = true; this }

  protected def _failIfSealed: this.type = { if (isSealed) Fail("Object sealed and cannot be modified"); this }

  protected def _failIfSealed(message: => String): this.type = { if (isSealed) Fail(message); this }

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Self -> '''Generic Able to Seal Self'''
 *
 * @def isSealed -> Returns true if current instance is sealed
 *
 *   From this point any mutation attempt should fail
 *
 * @def seal -> Seals object for future mutations
 *
 *     If the object is already sealed, nothing happens
 *
 * @def _failIfSealed: -> Fails if sealed
 *
 *     Will fail execution, if isSealed
 *
 * @def _failIfSealed( -> Fails if sealed
 *
 *     Will fail execution, if isSealed
 *
 */
