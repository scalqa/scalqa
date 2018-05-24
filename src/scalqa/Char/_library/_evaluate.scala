package scalqa; package Char; package _library

trait _evaluate extends Any with __ {

  def isControl: Boolean = Character.isISOControl(This)
  def isDigit: Boolean = Character.isDigit(This)
  def isLetter: Boolean = Character.isLetter(This)
  def isLetterOrDigit: Boolean = Character.isLetterOrDigit(This)
  def isWhitespace: Boolean = Character.isWhitespace(This)
  def isSpaceChar: Boolean = Character.isSpaceChar(This)

  def isLower: Boolean = Character.isLowerCase(This)
  def isUpper: Boolean = Character.isUpperCase(This)
  def isTitleCase: Boolean = Character.isTitleCase(This)

  def lower: Char = Character.toLowerCase(This)
  def upper: Char = Character.toUpperCase(This)
  def titleCase: Char = Character.toTitleCase(This)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
