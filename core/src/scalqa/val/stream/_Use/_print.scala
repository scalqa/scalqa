package scalqa; package `val`; package stream; package _use; import language.implicitConversions

transparent trait _print:

  extension[A](x: ~[A])
    /**/                def print   (using Given.DocDef[A]) : Unit = z._use._print(x, false,false)
    /**/                def printId (using Given.DocDef[A]) : Unit = z._use._print(x, true,false)
    @tn("print_Number") def print_# (using Given.DocDef[A]) : Unit = z._use._print(x, false,true)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _print -> ### Stream Printing Interface

@def print -> Print to console

    Prints stream elements in a table like structure

    Tuples, case classes, products, and [[scalqa.gen.able.Doc Able.Doc]] object properties are formatted as table columns

    ```

    ('A' <> 'F').~.map(v => (v.Int, v)).print

    // Output
    -- --
    _1 _2
    -- --
    65 A
    66 B
    67 C
    68 D
    69 E
    70 F
    -- --

    // -----------------------------------------------------
    case class Case(int: Int, name: String, odd: Boolean):
        def this(i: Int) = this(i, "Name"+i, i%2==0)

    (1 <> 10).~.map(new Case(_)).print

    // Output
    --- ------ -----
    int name   odd
    --- ------ -----
    1   Name1  false
    2   Name2  true
    3   Name3  false
    4   Name4  true
    5   Name5  false
    6   Name6  true
    7   Name7  false
    8   Name8  true
    9   Name9  false
    10  Name10 true
    --- ------ -----
  ```

@def printId -> Print to console with rows indexed

    Same as regular [[print]], but with added index as first column identifying the object

    ```

    ('A' <> 'F').~.map(v => (v.Int, v)).print

    // Output
    ----------------- -- --
    Id                _1 _2
    ----------------- -- --
    scala.Tuple2@dzkr 65 A
    scala.Tuple2@zn1  66 B
    scala.Tuple2@71j3 67 C
    scala.Tuple2@562u 68 D
    scala.Tuple2@c8tt 69 E
    scala.Tuple2@p0m8 70 F
    ----------------- -- --
    ```

@def print_# -> Print to console with rows numbered

    Same as regular [[print]], but with added row number as first column

    ```
    ('A' <> 'F').~.map(v => (v.Int, v)).print_#

    // Output
    -- -- --
    #  _1 _2
    -- -- --
    0  65 A
    1  66 B
    2  67 C
    3  68 D
    4  69 E
    5  70 F
    -- -- --
    ```

    Note: Number is mostly usefull for longer or even infinite streams
*/

