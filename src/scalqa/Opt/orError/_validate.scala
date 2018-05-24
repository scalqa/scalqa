package scalqa; package Opt; package orError

trait _validate[+A] extends Any with __[A] {

  def validate(f: A => Boolean, errorMessage: String = \/): orError[A] = if (_isVal && !f(_val)) Fail.validate(errorMessage) else This

  def validateMap[B](f: A => Opt[B], errorMessage: String = \/): orError[B] = if (!_isVal) This else f(_val).map(new orError[B](_)) or Fail.validate(errorMessage)

  def validateAs[B](clazz: Class[B], errorMessage: String = \/): orError[B] =
    if (_isVal && clazz.isInstance(_val)) This.cast else Fail.validate(errorMessage.Opt or _val.Class.label + " is not instance of " + Any.Class.get(clazz).label)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _validate -> '''Validate Interface'''
 *
 *
 *
 */
