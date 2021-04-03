package scalqa; package gen; package able; import language.implicitConversions

trait Add[A]:

  /**/                  def add(v: A)                 : Unit
  /**/                  def addAll(v: ~[A])           : Unit      = v.foreach(add)
  @tn("add_Opt")        def add_?(o: Opt[A])          : Unit      = o.forval(add)

  @tn("add")     inline def += (inline v: A | Opt[A]) : this.type = { inline v match{ case v: Opt[A] => add_?(v); case v:A => add(v)}; this}
  @tn("addAll")  inline def ++=(inline v: ~[A])       : this.type = { addAll(v); this }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Add -> ### Generic Add

       Adding elements to some target container

@def add ->  Add

      Adds given value to target container
      ```
        // Generic example
        val x =  Idx.M(1, 2, 3)

         x.add(4)
         x.add(5)
         x.add(6)

         x.~.TP // Prints ~(1, 2, 3, 4, 5, 6)
      ```

@def += -> Alias for [[add]]

      Calls add and returns container
      ```
        // Generic example
        val x =  Idx.M(1, 2, 3)

         x += 4 += 5 += 6

         x.~.TP // Prints ~(1, 2, 3, 4, 5, 6)
      ```

@def addAll -> Add many

      Adds given stream of elements to target container
      ```
        // Generic example
        val x =  Idx.M(1, 2, 3)

         x.addAll(4 <> 6)
         x.addAll( ~~(7,8,9))

         x.~.TP // Stream(1, 2, 3, 4, 5, 6, 7, 8, 9)
      ```

@def ++= -> Alias for [[addAll]]

      Calls addAll and returns container
      ```
        // Generic example
        val x =  Idx.M(1, 2, 3)

        x ++= (4 <> 6) ++= Stream(7, 8, 9)

        x.~.TP // ~~(1, 2, 3, 4, 5, 6, 7, 8, 9)
      ```

@def add_? -> Optional add

    Adds element if option has value, does nothing for void option

*/
