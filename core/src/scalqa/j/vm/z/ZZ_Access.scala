package scalqa; package j; package vm; package z

import concurrent.ExecutionContext

private[scalqa] class ZZ_Access:

  def Console          : scala.Console.type    = scala.Console
  def None             : Ref                   = scalqa.`val`.Opt.None
  def initSize         : Int                   = Setup.arrayInitSize_*()
  def executionContext : ExecutionContext      = Setup.defaultExecutionContext

  def emptyObjectArray : Array[Ref]            = scala.Array.emptyObjectArray
  def emptyBooleanArray: Array[Boolean]        = scala.Array.emptyBooleanArray
  def emptyByteArray   : Array[Byte]           = scala.Array.emptyByteArray
  def emptyCharArray   : Array[Char]           = scala.Array.emptyCharArray
  def emptyShortArray  : Array[Short]          = scala.Array.emptyShortArray
  def emptyIntArray    : Array[Int]            = scala.Array.emptyIntArray
  def emptyLongArray   : Array[Long]           = scala.Array.emptyLongArray
  def emptyFloatArray  : Array[Float]          = scala.Array.emptyFloatArray
  def emptyDoubleArray : Array[Double]         = scala.Array.emptyDoubleArray
