package scalqa

object Val:
  @tn("Stream") val ~          = `val`.Stream;      @tn("Stream") type ~[A]           = `val`.Stream[A]
  @tn("Range")  val <>         = `val`.Range;       @tn("Range")  type <>[A]          = `val`.Range[A]
  @tn("Pack")   val ><         = `val`.Pack;        @tn("Pack")   type ><[A]          = `val`.Pack[A]
  @fast    lazy val Buffer     = `val`.Buffer;                    type Buffer[A]      = `val`.Buffer[A]
  @fast    lazy val Collection = `val`.Collection;                type Collection[+A] = `val`.Collection[A]
  /**/          val Idx        = `val`.Idx;                       type Idx[+A]        = `val`.Idx[A]
  /**/          val Lookup     = `val`.Lookup;                    type Lookup[A,+B]   = `val`.Lookup[A,B]
  /**/          val Opt        = `val`.Opt;                       type Opt[+A]        = `val`.Opt.opaque.`type`[A]
  /**/          val Pro        = `val`.Pro;                       type Pro[+A]        = `val`.Pro[A]
  @fast    lazy val Promise    = `val`.Promise;                   type Promise[+A]    = `val`.Promise[A]
  /**/   inline def Result     = `val`.Result;                    type Result[+A]     = `val`.Result.opaque.`type`[A]
  /**/   inline def StableSet  = Collection.StableSet;            type StableSet[A]   = Collection.StableSet[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Val -> ### Value Container Framework

    Note: Half the members are collections: Buffer, Collection, Idx, ><, and Lookup

    [[Val]] is fully exported to scalqa root, thus all members and aliases of [[Val]] can be called with or without "Val." prefix.

    For example:
    ```
    val v:  Val.~[Int]  = ?_?_?
    // is same as
    val v: ~[Int]       = ?_?_?
    ```

@type Buffer      ->  Type alias      \n\n Shortcut to [[scalqa.val.Buffer  Val.Buffer]]
@val  Buffer      ->  Companion alias \n\n Shortcut to [[scalqa.val.Buffer$ Val.Buffer]]
@type Collection  ->  Type alias      \n\n Shortcut to [[scalqa.val.Collection  Val.Collection]]
@val  Collection  ->  Companion alias \n\n Shortcut to [[scalqa.val.Collection$ Val.Collection]]
@type Idx         ->  Type alias      \n\n Shortcut to [[scalqa.val.Idx  Val.Idx]]
@val  Idx         ->  Companion alias \n\n Shortcut to [[scalqa.val.Idx$ Val.Idx]]
@type ><          ->  Type alias      \n\n Shortcut to [[scalqa.val.Pack  pack]]
@val  ><          ->  Companion alias \n\n Shortcut to [[scalqa.val.Pack$ pack]]
@type Lookup      ->  Type alias      \n\n Shortcut to [[scalqa.val.Lookup  Val.Lookup]]
@val  Lookup      ->  Companion alias \n\n Shortcut to [[scalqa.val.Lookup$ Val.Lookup]]
@type Opt         ->  Type alias      \n\n Shortcut to [[scalqa.val.Opt  Val.Opt]]
@val  Opt         ->  Companion alias \n\n Shortcut to [[scalqa.val.Opt$ Val.Opt]]
@type Pro         ->  Type alias      \n\n Shortcut to [[scalqa.val.Pro  Val.Pro]]
@val  Pro         ->  Companion alias \n\n Shortcut to [[scalqa.val.Pro$ Val.Pro]]
@type Promise     ->  Type alias      \n\n Shortcut to [[scalqa.val.Promise  Val.Promise]]
@val  Promise     ->  Companion alias \n\n Shortcut to [[scalqa.val.Promise$ Val.Promise]]
@type <>          ->  Type alias      \n\n Shortcut to [[scalqa.val.Range  range]]
@val  <>          ->  Companion alias \n\n Shortcut to [[scalqa.val.Range$ range]]
@type Result      ->  Type alias      \n\n Shortcut to [[scalqa.val.Result  Val.Result]]
@def  Result      ->  Companion alias \n\n Shortcut to [[scalqa.val.Result$ Val.Result]]
@type StableSet   ->  Type alias      \n\n Shortcut to [[scalqa.val.collection.StableSet  Val.Collection.StableSet]]
@def  StableSet   ->  Companion alias \n\n Shortcut to [[scalqa.val.collection.StableSet$ Val.Collection.StableSet]]
@type ~           ->  Type alias      \n\n Shortcut to [[scalqa.val.Stream  Val.Stream]]
@val  ~           ->  Companion alias \n\n Shortcut to [[scalqa.val.Stream$ Val.Stream]]

*/
