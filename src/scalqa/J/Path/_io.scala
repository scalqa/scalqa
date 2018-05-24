package scalqa; package J; package Path

trait _io extends Any with __ {

  def openOutput: J.Output = {
    Output.get(real.toFile)
  }

  def writeString(s: String) = {
    This.fileOpt(_.delete);
    This.copyShort(1).directoryMake
    openOutput.asText.writeAllAndClose(s)
  }

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def openOutput -> Creates [[J.Output]]
 *
 *     Creates [[J.Output]] to the file specified by this [[Path]]
 *
 *     {{{
 *        // if C: is current root, creates J.Output to C:\Temp\Test.txt
 *
 *        J.Path.get.root + "Temp" + "Test.txt" openOutput
 *     }}}
 *
 * @def writeString -> Write String
 *
 *     Writes give String to the file specified by this [[Path]]
 *
 *     {{{
 *         // if C: is current root, writes String to C:\Temp\Test.txt
 *
 *        J.Path.get.root + "Temp" + "Test.txt" writeString "Test Test Test "
 *     }}}
 *
 */
