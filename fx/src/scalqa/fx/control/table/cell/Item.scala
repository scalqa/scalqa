package scalqa; package fx; package control; package table; package cell; import language.implicitConversions

class Item[ROW,V,A](val row: ROW, val setup: Cell.Setup[ROW,V,A], @tn("valueOpt") val value_? : Opt[A]) extends Able.Info:
  /**/           def value            : A             = value_?.get
  @tn("textOpt") def text_?           : String.Opt    = value_?.map(v => if (!setup.voidTag.isVoid(v)) setup.funFormat(v) else setup.funFormatVoid(row)) or setup.funFormatVoid(row)
  /**/           def make(v: Opt[A])  : Item[ROW,V,A] = new Item(row, setup, v)
  /**/           def info             : Info          = Info(this) += ("text", text_?) += ("value", value_?)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
