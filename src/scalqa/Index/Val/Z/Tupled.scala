package scalqa; package Index; package Val; package Z

private object Tupled {
  class _1[A](val v0: A) extends TupledLike[A] {
    def size = 1; def apply(i: Int): A = { Assert.idxSized(i, 1); v0 }
    override def +(v: A)(implicit t: Tag[A] = \/): Val[A] = new _2(v0, v)
  }
  class _2[A](val v0: A, val v1: A) extends TupledLike[A] {
    def size = 2; def apply(i: Int): A = i match { case 0 => v0; case 1 => v1; case i => Fail.idxSized(i, size) }
    override def +(v: A)(implicit t: Tag[A] = \/): Val[A] = new _3(v0, v1, v)
  }
  class _3[A](val v0: A, val v1: A, val v2: A) extends TupledLike[A] {
    def size = 3; def apply(i: Int): A = i match { case 0 => v0; case 1 => v1; case 2 => v2; case i => Fail.idxSized(i, size) }
    override def +(v: A)(implicit t: Tag[A] = \/): Val[A] = new _4(v0, v1, v2, v)
  }
  class _4[A](val v0: A, val v1: A, val v2: A, val v3: A) extends TupledLike[A] {
    def size = 4; def apply(i: Int): A = i match { case 0 => v0; case 1 => v1; case 2 => v2; case 3 => v3; case i => Fail.idxSized(i, size) }
    override def +(v: A)(implicit t: Tag[A] = \/): Val[A] = new _5(v0, v1, v2, v3, v)
  }
  class _5[A](val v0: A, val v1: A, val v2: A, val v3: A, val v4: A) extends TupledLike[A] {
    def size = 5; def apply(i: Int): A = i match { case 0 => v0; case 1 => v1; case 2 => v2; case 3 => v3; case 4 => v4; case i => Fail.idxSized(i, size) }
    override def +(v: A)(implicit t: Tag[A] = \/): Val[A] = new _6(v0, v1, v2, v3, v4, v)
  }
  class _6[A](val v0: A, val v1: A, val v2: A, val v3: A, val v4: A, val v5: A) extends TupledLike[A] {
    def size = 6; def apply(i: Int): A = i match { case 0 => v0; case 1 => v1; case 2 => v2; case 3 => v3; case 4 => v4; case 5 => v5; case i => Fail.idxSized(i, size) }
    override def +(v: A)(implicit t: Tag[A] = \/): Val[A] = new _7(v0, v1, v2, v3, v4, v5, v)
  }
  class _7[A](val v0: A, val v1: A, val v2: A, val v3: A, val v4: A, val v5: A, val v6: A) extends TupledLike[A] {
    def size = 7; def apply(i: Int): A = i match { case 0 => v0; case 1 => v1; case 2 => v2; case 3 => v3; case 4 => v4; case 5 => v5; case 6 => v6; case i => Fail.idxSized(i, size) }
    override def +(v: A)(implicit t: Tag[A] = \/): Val[A] = new _8(v0, v1, v2, v3, v4, v5, v6, v)
  }
  class _8[A](val v0: A, val v1: A, val v2: A, val v3: A, val v4: A, val v5: A, val v6: A, val v7: A) extends TupledLike[A] {
    def size = 8; def apply(i: Int): A = i match { case 0 => v0; case 1 => v1; case 2 => v2; case 3 => v3; case 4 => v4; case 5 => v5; case 6 => v6; case 7 => v7; case i => Fail.idxSized(i, size) }
    override def +(v: A)(implicit t: Tag[A] = \/): Val[A] = new _9(v0, v1, v2, v3, v4, v5, v6, v7, v)
  }
  class _9[A](val v0: A, val v1: A, val v2: A, val v3: A, val v4: A, val v5: A, val v6: A, val v7: A, val v8: A) extends TupledLike[A] {
    def size = 9; def apply(i: Int): A = i match { case 0 => v0; case 1 => v1; case 2 => v2; case 3 => v3; case 4 => v4; case 5 => v5; case 6 => v6; case 7 => v7; case 8 => v8; case i => Fail.idxSized(i, size) }
    override def +(v: A)(implicit t: Tag[A] = \/): Val[A] = new _10(v0, v1, v2, v3, v4, v5, v6, v7, v8, v)
  }
  class _10[A](val v0: A, val v1: A, val v2: A, val v3: A, val v4: A, val v5: A, val v6: A, val v7: A, val v8: A, val v9: A) extends TupledLike[A] {
    def size = 10; def apply(i: Int): A = i match {
      case 0 => v0; case 1 => v1; case 2 => v2; case 3 => v3; case 4 => v4; case 5 => v5; case 6 => v6; case 7 => v7; case 8 => v8; case 9 => v9; case i => Fail.idxSized(i, size)
    }
    override def +(v: A)(implicit t: Tag[A] = \/): Val[A] = new _11(v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v)
  }
  class _11[A](val v0: A, val v1: A, val v2: A, val v3: A, val v4: A, val v5: A, val v6: A, val v7: A, val v8: A, val v9: A, val v10: A) extends TupledLike[A] {
    def size = 11; def apply(i: Int): A = i match {
      case 0 => v0; case 1 => v1; case 2 => v2; case 3 => v3; case 4 => v4; case 5 => v5; case 6 => v6; case 7 => v7; case 8 => v8; case 9 => v9; case 10 => v10; case i => Fail.idxSized(i, size)
    }
    override def +(v: A)(implicit t: Tag[A] = \/): Val[A] = new _12(v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v)
  }
  class _12[A](val v0: A, val v1: A, val v2: A, val v3: A, val v4: A, val v5: A, val v6: A, val v7: A, val v8: A, val v9: A, val v10: A, val v11: A) extends TupledLike[A] {
    def size = 12; def apply(i: Int): A = i match {
      case 0 => v0; case 1 => v1; case 2 => v2; case 3 => v3; case 4 => v4; case 5 => v5; case 6 => v6; case 7 => v7; case 8 => v8; case 9 => v9; case 10 => v10; case 11 => v11; case i => Fail.idxSized(i, size)
    }
    override def +(v: A)(implicit t: Tag[A] = \/): Val[A] = new ArrayBased({
      val a = Tag.AnyRef[A].newArrayRaw[A](13); a(0) = v0; a(1) = v1; a(2) = v2; a(3) = v3; a(4) = v4; a(5) = v5; a(6) = v6; a(7) = v7; a(8) = v8; a(9) = v9; a(10) = v10; a(11) = v11; a(12) = v; a
    })
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/