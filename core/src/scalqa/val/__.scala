package scalqa

object Val:
  @tn("Stream") type ~[A]           = `val`.Stream[A];    @tn("Stream") transparent inline def ~          = `val`.Stream;
  @tn("Range")  type <>[A]          = `val`.Range[A];     @tn("Range")  transparent inline def <>         = `val`.Range;
  @tn("Pack")   type ><[A]          = `val`.Pack[A];      @tn("Pack")   transparent inline def ><         = `val`.Pack
  /**/          type Buffer[A]      = `val`.Buffer[A];                  transparent inline def Buffer     = `val`.Buffer
  /**/          type Collection[+A] = `val`.Collection[A];              transparent inline def Collection = `val`.Collection
  /**/          type Idx[+A]        = `val`.Idx[A];                     transparent inline def Idx        = `val`.Idx
  /**/          type Lookup[A,+B]   = `val`.Lookup[A,B];                transparent inline def Lookup     = `val`.Lookup
  /**/          type Opt[+A]        = `val`.Opt.TYPE.DEF[A];            transparent inline def Opt        = `val`.Opt
  /**/          type Pro[+A]        = `val`.Pro[A];                     transparent inline def Pro        = `val`.Pro
  /**/          type Promise[+A]    = `val`.Promise[A];                 transparent inline def Promise    = `val`.Promise
  /**/          type Result[+A]     = `val`.Result.TYPE.DEF[A];         transparent inline def Result     = `val`.Result
  /**/          type StableSet[A]   = Collection.StableSet[A];          transparent inline def StableSet  = Collection.StableSet

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Val -> ### Value Container Framework

    Read more in the [Guide](../../guide/features/Containers.html).

    [[Val]] is fully exported to scalqa root, thus all members and aliases of [[Val]] can be called with or without "Val." prefix.

    For example:
    ```
    val v:  Val.~[Int]  = ?_?_?
    // is same as
    val v: ~[Int]       = ?_?_?
    ```

@type Buffer      ->  Type alias      \n\n Shortcut to [[scalqa.val.Buffer  Val.Buffer]]
@def  Buffer      ->  Companion alias \n\n Shortcut to [[scalqa.val.Buffer$ Val.Buffer]]
@type Collection  ->  Type alias      \n\n Shortcut to [[scalqa.val.Collection  Val.Collection]]
@def  Collection  ->  Companion alias \n\n Shortcut to [[scalqa.val.Collection$ Val.Collection]]
@type Idx         ->  Type alias      \n\n Shortcut to [[scalqa.val.Idx  Val.Idx]]
@def  Idx         ->  Companion alias \n\n Shortcut to [[scalqa.val.Idx$ Val.Idx]]
@type ><          ->  Type alias      \n\n Shortcut to [[scalqa.val.Pack  pack]]
@def  ><          ->  Companion alias \n\n Shortcut to [[scalqa.val.Pack$ pack]]
@type Lookup      ->  Type alias      \n\n Shortcut to [[scalqa.val.Lookup  Val.Lookup]]
@def  Lookup      ->  Companion alias \n\n Shortcut to [[scalqa.val.Lookup$ Val.Lookup]]
@type Opt         ->  Type alias      \n\n Shortcut to [[scalqa.val.Opt  Val.Opt]]
@def  Opt         ->  Companion alias \n\n Shortcut to [[scalqa.val.Opt$ Val.Opt]]
@type Pro         ->  Type alias      \n\n Shortcut to [[scalqa.val.Pro  Val.Pro]]
@def  Pro         ->  Companion alias \n\n Shortcut to [[scalqa.val.Pro$ Val.Pro]]
@type Promise     ->  Type alias      \n\n Shortcut to [[scalqa.val.Promise  Val.Promise]]
@def  Promise     ->  Companion alias \n\n Shortcut to [[scalqa.val.Promise$ Val.Promise]]
@type <>          ->  Type alias      \n\n Shortcut to [[scalqa.val.Range  range]]
@def  <>          ->  Companion alias \n\n Shortcut to [[scalqa.val.Range$ range]]
@type Result      ->  Type alias      \n\n Shortcut to [[scalqa.val.Result  Val.Result]]
@def  Result      ->  Companion alias \n\n Shortcut to [[scalqa.val.Result$ Val.Result]]
@type StableSet   ->  Type alias      \n\n Shortcut to [[scalqa.val.collection.StableSet  Val.Collection.StableSet]]
@def  StableSet   ->  Companion alias \n\n Shortcut to [[scalqa.val.collection.StableSet$ Val.Collection.StableSet]]
@type ~           ->  Type alias      \n\n Shortcut to [[scalqa.val.Stream  Val.Stream]]
@def  ~           ->  Companion alias \n\n Shortcut to [[scalqa.val.Stream$ Val.Stream]]

*/
