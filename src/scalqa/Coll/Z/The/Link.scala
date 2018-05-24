package scalqa; package Coll; package Z; package The

private[Coll] trait Link[A] extends Coll[A] with Able.Info {

  def child: Link[A]

  def value: A

  lazy val size = child.size + 1;

  def allLinks: ~[Link[A]] = if (this.isVoid) \/ else {
    var l = Link.this;
    new ~[Link[A]] { // Redo to Pipe with sizeOpt
      def supplyOpt = l.Opt.run(l = l.child).mapCast[Link[A]]
      def size = l.size
    }
  }

  def all = allLinks.map(_.value)

  protected def info = \/.info ~ ("size", size) ~ ("target", value) ~ ("root", "")

}

private[Coll] object Link extends Able.Void.Companion.Typed[Link](new Link[Nothing] with Void { def child = Fail(); def value = Fail(); override lazy val size = 0 }) {

  def apply[T](childColl: Link[T], lastValue: T) = new AnyRef with Link[T] { def child = childColl; def value = lastValue }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/