package POP

/**
 *  If an object becomes really complex, it becomes hard to maintain it as a single program unit
 *
 *  Creating [[Package_Type Package Type]] allows splitting single definition into many standardized [[Package_Type.Type_Trait Type Traits]],
 *  reducing overall complex functionality to trivial components.
 *  If split is not sufficient, each [[Package_Type.Type_Trait Type Trait]] can be developed as a [[Package_Type Package Type]] itself
 *
 *  The largest example of complexity reduction in Scalqa is the [[scalqa.Stream Stream]], which is split into [[scalqa.Stream._extend._Trait extend]],
 *  [[scalqa.Stream._iterate._Trait iterate]], [[scalqa.Stream._consume._Trait consume]], and [[scalqa.Stream._info._Trait info]] traits.  Some of those traits are split further.
 *  From usage prospective, [[scalqa.Stream Stream]] is still a single integral object definition
 *
 */
class Complexity_Reduction { val sort_1 = () }
