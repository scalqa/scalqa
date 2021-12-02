package scalqa; package `val`; package opt; import language.implicitConversions;

object Z:

  def collect[A,B](x:Opt[A],f:PartialFunction[A,B]): Opt[B]                = {var o:Opt[B]=VOID;if(x.nonEmpty){val w=x.`val`; if(f.isDefinedAt(w)) o=f(w)}; o}
  def stream [A]  (x:Opt[A])                       : Stream[A]             = if(x.nonEmpty) Stream(x.`val`) else Stream.void
  def get    [A]  (x:Opt[A])                       : A                     = {if(x.isEmpty) throw new ZZ.EO(); x.cast[A]}
  def toScala[A]  (x:Opt[A])                       : scala.Option[A]       = if(x.nonEmpty) scala.Some(x.`val`) else scala.None
  def toJava [A]  (x:Opt[A])                       : java.util.Optional[A] = if(x.nonEmpty) java.util.Optional.of(x.`val`) else java.util.Optional.empty

  // ***********************************************************************************
  object None:
    override def equals(v:Any) = false
    override def toString      = "Opt(VOID)"

  object Def extends Any.Def.Void[Opt[Any]] with Any.Def.Empty[Opt[Any]]:
    inline def value_isVoid( v:Opt[Any]) = v.isEmpty
    inline def value_isEmpty(v:Opt[Any]) = v.isEmpty

  class Doc[A :Any.Def.Tag] extends Any.Def.Doc[Opt[A]]:
    def value_doc(v: Opt[A]) = Gen.Doc("Opt") += ("value", v.map(_.tag).or( "VOID"))
    def value_tag(v: Opt[A]) = "Opt(" + v.map(_.tag).or( "VOID") + ")"

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
