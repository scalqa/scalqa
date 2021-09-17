package scalqa; package gen; package able; import language.implicitConversions

trait Add[A]:
  /**/                  def add(v: A)            : Unit
  /**/                  def addAll(v: ~[A])      : Unit      = v.foreach(add)

  @tn("add")     inline def += (inline v: A)     : this.type = { add(v);        this }
  @tn("addAll")  inline def ++=(inline v: ~[A])  : this.type = { addAll(v);     this }
  @tn("addOpt")  inline def ++=(inline v: Opt[A]): this.type = { v.forval(add); this }

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

         x.~.TP // ~(1, 2, 3, 4, 5, 6, 7, 8, 9)
      ```

@def ++= -> Alias for [[addAll]]

      Calls addAll and returns container
      ```
        // Generic example
        val x =  Idx.M(1, 2, 3)

        x ++= (4 <> 6) ++= ~~(7, 8, 9)

        x.~.TP // ~(1, 2, 3, 4, 5, 6, 7, 8, 9)
      ```

@def ++= -> Alias for [[addAll]]

      Generally Opt could be added as a stream.

      This overload is sligtly more efficient, but it also required for mapped Opt expressions, where Opt type is harder to resolve and it would not compile.

*/
