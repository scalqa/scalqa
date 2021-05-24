package example.fx.table;  import scalqa.{*, given};  import language.implicitConversions

import Fx.*

object TrySortWithHeaderFooter extends Fx.Application(600, 400, "Try Sort With Header and Footer"):

  object View extends Table[Int]:

    new Column[Int]   ("Ints",    50, v => v)
    new Column[Double]("Doubles", 70, _.toDouble)
    new Column[String]("Strings", 70, "str_" + _)

    headerFooter = (~~(1000, 1000, 1000), ~~(2000))

    items += 5 += 4 += 1 += 3 += 2


