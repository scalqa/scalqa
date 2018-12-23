package Features

/**
 *   Scalqa properties define 4 basic types:
 *
 *     - `[[scalqa.Pro    Pro]]`    - read-only property
 *     - `[[scalqa.Pro.M  Pro.M]]`  - mutable  property
 *     - `[[scalqa.Pro.O  Pro.O]]`  - observable property
 *     - `[[scalqa.Pro.OM Pro.OM]]` - observable and mutable property
 *
 *   and they are hierarchical:
 *   {{{
 *            Pro.O
 *          /       \
 *      Pro           Pro.OM
 *          \       /
 *            Pro.M
 *   }}}
 *
 *   Observable properties are the base for development of GUI event based controls
 */
class Observable_Properties { val sort_15 = () }
