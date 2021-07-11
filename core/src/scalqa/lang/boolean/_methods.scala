package scalqa; package lang; package boolean; import language.implicitConversions

transparent trait _methods:
  extension    (inline x: Boolean) @tn("Opt") inline def ?                   : Boolean.Opt = if(x) G.Opt.TRUE else G.Opt.FALSE
  extension[A] (inline x: Boolean) @tn("Opt") inline def ?(inline v: => A)   : Val.Opt[A]  = if(x) v else ZZ.BoolNone.cast[Val.Opt[A]]
  extension    (inline x: Boolean)            inline def not                 : Boolean     = !x
  extension    (inline x: Boolean)            inline def Int                 : Int         = if(x) 1 else 0

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _methods -> ### Boolean Extension Methods \n\n Extension methods universaly avaialble for type scala.Boolean

@def ? ->  To option

    Returns Boolean.Opt for current value
    ```
      val o: Boolean.Opt = true.?
    ```

@def ? ->  To given value option

    Returns given value option if base Boolean is `true`, and void option if `false`
    ```
      var b = true

      (b ? "Foo").TP  // Prints   Opt(Foo)

      b = false

      (b ? "Foo").TP  // Prints   Opt(\/)
    ```

    Note: This operation can be used as a conditional function

    ```
      var b = true

      (b ? "Foo" or "Bar").TP  // Prints   Foo

      b = false

      (b ? "Foo" or "Bar").TP  // Prints   Bar
    ```

@def not ->  Reversed Boolean

    This is a postfix operation equivalent to !, ie. ``true.not == !true``

    ```
      var b = true

      b.not  // Prints   false

      b = false

      b.not  // Prints   true
    ```

    Note: This operation is inlined and can be used without performance worries

@def Int -> Make Int

         Int constructor attached to Boolean

         `true` is converted to `1`, `false` to `0`
*/