package scalqa; import language.implicitConversions

object J:
  /**/    def scheduleEvery  [U](period: Time.Length, f: => U)                      : Event.Control = j.vm.z.Schedule.everyIn(period, period,    () => f)
  /**/    def scheduleEveryIn[U](period: Time.Length, initDelay:Time.Length, f: =>U): Event.Control = j.vm.z.Schedule.everyIn(period, initDelay, () => f)
  /**/    def scheduleIn[U](delay: Time.Length, job: => U)                          : Event.Control = j.vm.z.Schedule.in(delay, () => job)
  /**/    def schedule[U](f: => U)                                                  : Unit          = j.vm.z.Schedule(() => f)
  /**/    def sleep(tl: Time.Length)                                                : Unit          = java.lang.Thread.sleep(tl.millisTotal, (tl.micros * 1000 + tl.nanos).Int)

  inline  def initSize                                                    : Int         = ZZ.initSize
  inline  def toDo(                inline message: String = \/)           : Nothing     = throw new UnsupportedOperationException("J.toDo. "+message)
  inline  def unsupportedOperation(inline message: String = \/)           : Nothing     = throw new UnsupportedOperationException(message)
  inline  def illegalState(        inline message: String = \/)           : Nothing     = throw new IllegalStateException(message)
  inline  def illegalArgument(     inline message: String = \/)           : Nothing     = throw new IllegalArgumentException(message)
  /**/    def printStack(sizeLimit: Int.Opt = \/, label: String.Opt = \/) : Unit        = { new Exception().getStackTrace().~.take_<>(1 <> sizeLimit.or(5000)).zipIndex(1)
    /**/                                                                                    .map("\t" + _.toString.padEndTo(3) + " " + _).joinAt(0,label or "J.printStack").foreach(println) }
  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  @fast lazy val File          = j.File;                          type File             = j.File.opaque.`type`
  @fast lazy val Path          = j.file.Path;                     type Path             = j.file.Path.opaque.`type`
  @fast lazy val Url           = j.Url;                           type Url              = j.Url.opaque.`type`
  /**/                                                            type Printer          = java.io.PrintStream
  @fast lazy val Io            = j.Io
  @fast lazy val Input         = j.io.Input;                      type Input            = j.io.Input.opaque.`type`
  @fast lazy val Output        = j.io.Output;                     type Output           = j.io.Output.opaque.`type`

  @fast lazy val Json          = j.Json
  @fast lazy val Object        = j.json.Object;                   type Object           = j.json.Object
  @fast lazy val Array         = j.json.Array;                    type Array            = j.json.Array

  @fast lazy val Zip           = j.Zip

  @fast lazy val Util          = j.Util
  @fast lazy val Benchmark     = j.util.Benchmark
  @fast lazy val Random        = j.util.Random
  /**/                                                            type Test             = j.util.Test
  @fast lazy val Concurrent    = j.util.Concurrent
  @fast lazy val WeakRef       = j.util.WeakRef;                  type WeakRef[A]       = j.util.WeakRef.opaque.`type`[A]

  @fast lazy val Vm            = j.Vm
  @fast lazy val Priority      = j.vm.Priority;                   type Priority         = j.vm.Priority.opaque.`type`
  @fast lazy val Setup         = j.vm.Setup
  @fast lazy val Memory        = j.vm.Memory
  @fast lazy val Host          = j.vm.Host

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object J -> ### Java Extension API


@def illegalArgument -> Fail with illegal argument

    Inlines `throw new IllegalArgumentException()`

    The only benefit is reducing boilerplate code

@def illegalState -> Fail with illegal state

    Inlines `throw new IllegalStateException()`

    The only benefit is reducing boilerplate code

@def unsupportedOperation -> Fail unsupported

    Inlines `throw new UnsupportedOperationException()`

    The only benefit is reducing boilerplate code

@def toDo -> To Do tag

    Inlines `throw new UnsupportedOperationException()`

    'J.toDo' is the tag to leave in code to search for later.

    Never use `?_?_?`, which is for debugging and short term playing around

@def sleep -> Pauses current execution thread

     ```
     J.sleep(10.Millis) // Pauses for 10 milliseconds

     J.sleep(2.Seconds) // Pauses for 2 seconds

     J.sleep(1.Minute)  // Pauses for 1 minute
     ```

@def scheduleIn -> Schedule one time job

       Schedules a one time job with given delay
       ```
          // Prints "Hello" in 3 seconds
           J.scheduleIn(3.Seconds, "Hello".TP)
       ```

@def scheduleEvery ->  Schedule job

       Schedules a job to run every given `period`

       ```
          // Prints time every 1 second for the rest of the day

          val day = Day()

          App.Concurrent.runEvery(1.Seconds, Time().TP).cancelIf(day != Day())
       ```


@def scheduleEveryIn -> Schedule start of job

       Schedules a job with given `initDelay`, which will run every given `period`

       ```
          // In 10 minutes, this will start printing time every 1 second for one hour
          Schedule.everyIn(1.Second, 10.Minutes, Time().TP).expireIn(1.Hour)
       ```

@type Input       ->  Type alias \n\n Shortcut to [[scalqa.j.io.Input  J.Io.Input]]
@val  Input       ->  Companion alias \n\n Shortcut to [[scalqa.j.io.Input$ J.Io.Input]]
@type Output      ->  Type alias \n\n Shortcut to [[scalqa.j.io.Output  J.Io.Output]]
@val  Output      ->  Companion alias \n\n Shortcut to [[scalqa.j.io.Output$ J.Io.Output]]
@type Path        ->  Type alias \n\n Shortcut to [[scalqa.j.file.Path  J.File.Path]]
@val  Path        ->  Companion alias \n\n Shortcut to [[scalqa.j.file.Path$ J.File.Path]]
@type Array       ->  Type alias \n\n Shortcut to [[scalqa.j.json.Array  J.Json.Array]]
@val  Array       ->  Companion alias \n\n Shortcut to [[scalqa.j.json.Array$ J.Json.Array]]
@type Object      ->  Type alias \n\n Shortcut to [[scalqa.j.json.Object  J.Json.Object]]
@val  Object      ->  Companion alias \n\n Shortcut to [[scalqa.j.json.Object$ J.Json.Object]]
@type Printer     ->  Type alias \n\n Shortcut to java.io.PrintStream
@type Test        ->  Type alias \n\n Shortcut to [[scalqa.j.util.Test  J.Util.Test]]
@val  Benchmark   ->  Alias \n\n Shortcut to [[scalqa.j.util.Benchmark$ J.Util.Benchmark]]
@val  Random      ->  Companion alias \n\n Shortcut to [[scalqa.j.util.Random$ J.Util.Random]]
@type WeakRef     ->  Type alias \n\n Shortcut to [[scalqa.j.util.WeakRef  J.Util.WeakRef]]
@val  WeakRef     ->  Companion alias \n\n Shortcut to [[scalqa.j.util.WeakRef$ J.Util.WeakRef]]
@type Priority    ->  Type alias \n\n Shortcut to [[scalqa.j.vm.Priority  J.Vm.Priority]]
@val  Priority    ->  Companion alias \n\n Shortcut to [[scalqa.j.vm.Priority$ J.Vm.Priority]]
@val  Host        ->  Companion alias \n\n Shortcut to [[scalqa.j.vm.Host$ J.Vm.Host]]
@val  Setup       ->  Companion alias \n\n Shortcut to [[scalqa.j.vm.Setup$ J.Vm.Setup]]
@val  Memory      ->  Companion alias \n\n Shortcut to [[scalqa.j.vm.Memory$ J.Vm.Memory]]

*/
