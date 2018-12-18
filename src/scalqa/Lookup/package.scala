package scalqa

package object Lookup {
  type I[A, B] = I._Trait[A, B]
  type M[A, B] = M._Trait[A, B]
  type O[A, B] = O._Trait[A, B]
  type OM[A, B] = OM._Trait[A, B]

  def make[A, B](a: ~[(A, B)]): Lookup[A, B] = new Custom.Proxy.Lookup[A, B](M.make(a))

  def makeSealable[A, B](lazySource: A => Opt[B]): Lookup[A, B] = new Z.A.Basic(lazySource)
  
  
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
