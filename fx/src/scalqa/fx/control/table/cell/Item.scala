package scalqa; package fx; package control; package table; package cell; import language.implicitConversions

class Item[ROW,V,A](val row: ROW, val setup: Cell.Setup[ROW,V,A], val valueOpt : Opt[A]) extends Able.Doc:
  def value            : A             = valueOpt.get
  def textOpt          : Opt[String]   = valueOpt.map(v => if (!setup.voidDef.value_isVoid(v)) setup.funFormat(v) else setup.funFormatVoid(row)) or setup.funFormatVoid(row)
  def make(v: Opt[A])  : Item[ROW,V,A] = new Item(row, setup, v)
  def doc              : Doc           = Doc(this) += ("text", textOpt) += ("value", valueOpt)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
