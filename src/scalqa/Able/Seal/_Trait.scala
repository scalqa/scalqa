package scalqa; package Able; package Seal

trait _Trait extends Self {

  override def isSealed = super.isSealed

  override def seal = super.seal

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> '''Generic Able to Seal'''
 *
 *   Classes implementing Able to Seal allow some sort of mutation only until ''seal'' method is called
 *
 *   From this point any mutation attempt should fail
 *
 *
 */
