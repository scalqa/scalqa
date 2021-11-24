package scalqa

object Val:
  type Stream[+A]     = `val`.Stream[A];          transparent inline def Stream     = `val`.Stream
  type Range[A]       = `val`.Range[A];           transparent inline def Range      = `val`.Range
  type Pack[A]        = `val`.Pack[A];            transparent inline def Pack       = `val`.Pack
  type Buffer[A]      = `val`.Buffer[A];          transparent inline def Buffer     = `val`.Buffer
  type Collection[+A] = `val`.Collection[A];      transparent inline def Collection = `val`.Collection
  type Idx[+A]        = `val`.Idx[A];             transparent inline def Idx        = `val`.Idx
  type Lookup[A,+B]   = `val`.Lookup[A,B];        transparent inline def Lookup     = `val`.Lookup
  type Opt[+A]        = `val`.Opt.TYPE.DEF[A];    transparent inline def Opt        = `val`.Opt
  type Pro[+A]        = `val`.Pro[A];             transparent inline def Pro        = `val`.Pro
  type Promise[+A]    = `val`.Promise[A];         transparent inline def Promise    = `val`.Promise
  type Result[+A]     = `val`.Result.TYPE.DEF[A]; transparent inline def Result     = `val`.Result
  type Set[A]         = `val`.Set[A];             transparent inline def Set        = `val`.Set

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Val -> ### Value Container Framework

    Read more in the [Guide](../../guide/features/Containers.html).

    [[Val]] is fully exported to scalqa root, thus all members of [[Val]] can be called with or without "Val." prefix.

    For example:
    ```
    val v:  Val.Stream[Int]  = ?_?_?
    // is same as
    val v: Stream[Int]       = ?_?_?
    ```

@type Buffer      ->  Type alias             \n\n Shortcut to [[scalqa.val.Buffer  Val.Buffer]]
@def  Buffer      ->  Type companion alias   \n\n Shortcut to [[scalqa.val.Buffer$ Val.Buffer]]
@type Collection  ->  Type alias             \n\n Shortcut to [[scalqa.val.Collection  Val.Collection]]
@def  Collection  ->  Type companion alias   \n\n Shortcut to [[scalqa.val.Collection$ Val.Collection]]
@type Idx         ->  Type alias             \n\n Shortcut to [[scalqa.val.Idx  Val.Idx]]
@def  Idx         ->  Type companion alias   \n\n Shortcut to [[scalqa.val.Idx$ Val.Idx]]
@type Pack        ->  Pack type alias        \n\n Shortcut to [[scalqa.val.Pack  value pack]]
@def  Pack        ->  Pack companion alias   \n\n Shortcut to [[scalqa.val.Pack$ value pack]]
@type Lookup      ->  Type alias             \n\n Shortcut to [[scalqa.val.Lookup  Val.Lookup]]
@def  Lookup      ->  Type companion alias   \n\n Shortcut to [[scalqa.val.Lookup$ Val.Lookup]]
@type Opt         ->  Type alias             \n\n Shortcut to [[scalqa.val.Opt  Val.Opt]]
@def  Opt         ->  Type companion alias   \n\n Shortcut to [[scalqa.val.Opt$ Val.Opt]]
@type Pro         ->  Type alias             \n\n Shortcut to [[scalqa.val.Pro  Val.Pro]]
@def  Pro         ->  Type companion alias   \n\n Shortcut to [[scalqa.val.Pro$ Val.Pro]]
@type Promise     ->  Type alias             \n\n Shortcut to [[scalqa.val.Promise  Val.Promise]]
@def  Promise     ->  Type companion alias   \n\n Shortcut to [[scalqa.val.Promise$ Val.Promise]]
@type Range       ->  Range type alias       \n\n Shortcut to [[scalqa.val.Range  value range]]
@def  Range       ->  Range companion alias  \n\n Shortcut to [[scalqa.val.Range$ value range]]
@type Result      ->  Type alias             \n\n Shortcut to [[scalqa.val.Result  Val.Result]]
@def  Result      ->  Type companion alias   \n\n Shortcut to [[scalqa.val.Result$ Val.Result]]
@type Set         ->  Type alias             \n\n Shortcut to [[scalqa.val.Set  Val.Set]]
@def  Set         ->  Type companion alias   \n\n Shortcut to [[scalqa.val.Set$ Val.Set]]
@type Stream      ->  Stream type alias      \n\n Shortcut to [[scalqa.val.Stream  Val.Stream]]
@def  Stream      ->  Stream companion alias \n\n Shortcut to [[scalqa.val.Stream$ Val.Stream]]

*/
