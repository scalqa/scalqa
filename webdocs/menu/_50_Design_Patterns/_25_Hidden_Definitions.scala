package Design_Patterns

/**
 *  `Hidden` is any 'def', which by design will never be public
 *
 *  `Hidden` names are prefixed with underscore
 *
 *  This pattern is quite successful in Scalqa code, solving several problems:
 *
 *  It reuses names, differentiating public and hidden definitions
 *
 *  {{{
 *    class My {
 *      private var _size : Int = 0
 *
 *      def size = _size
 *    }
 *  }}}
 *
 *  When inheriting logic, leading underscore gives a good clue to the internal nature of the method
 *
 *  {{{
 *    class My extends Any.Ref.Extra{
 *
 *      def store(name: String) = _addEntry("names", name)
 *
 *      // _addEntry is for internal use and by design should never be made public
 *    }
 *  }}}
 *
 *  In API documentation `hidden` definitions can be put in a separate category, differentiating implementation details from public interface
 *
 */
class Hidden_Definitions { val sort_25 = () }
