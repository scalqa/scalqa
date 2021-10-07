package scalqa; package `val`; package idx; package observable; package event; package recorder; import language.implicitConversions

private[observable] object Z:

  class Add[A](val start: Int)  extends Event.Add[A] with Mutable[A]

  class Remove[A](val start: Int) extends Event.Remove[A] with Mutable[A]

  class Update[A](val start: Int)  extends Event.Update[A] with Mutable[A]:
    private       val olds                     : Idx.M[A]  =  NEW
    /**/          def oldItems                 : Idx[A]    = olds.readOnly_^
    /**/          def isRefresh                : Boolean   = false
    @tn("add")    def +=(itm: A, old: A)       : this.type = { range += 1; olds += old; real += itm; this }
    @tn("addAll") def ++=(itm: ~[A], old: ~[A]): this.type = { val sz = size
      /**/                                                        olds ++= old
      /**/                                                        real ++= itm
      /**/                                                        range += (size - sz)
      /**/                                                        assert(real.size == olds.size)
      /**/                                                        this
      /**/                                                   }

  trait Mutable[A] extends Event[A] with J.Util.Proxy.Idx.Base[A]:
    /**/          val real          : Idx.M[A]  = NEW
    /**/          def start         : Int
    /**/          var range         : Int.<>    = start <>> start
    /**/          def items         : Idx[A]    = this
    @tn("add")    def +=(v: A)      : this.type = { range += 1; real += v; this }
    @tn("addAll") def ++=(v: ~[A])  : this.type = { val sz = size; real ++= v; range += (size - sz); this }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
