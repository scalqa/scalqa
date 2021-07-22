---
layout: doc-page
title: H2O Structure
---
### Hierarchical Objects Organization Structure

From a user prospective Scalqa does not have packages. There is just one single root package 'scalqa' 
(always fully imported as `import scalqa.*`), which contains 5 root member objects:

- [`Lang`](../../api/scalqa/Lang$.html) holds language extensions
- [`Val`](../../api/scalqa/Val$.html)   holds generic containers framework
- [`Gen`](../../api/scalqa/Gen$.html)   holds general utilities
- [`J`](../../api/scalqa/J$.html)       holds Java utilities
- [`Fx`](../../api/scalqa/Fx$.html)     holds GUI API
  
These root objects also contain members of their own. Those members can have their members and so it goes as deep as required.

The trick is that parent name is an essential part of member name and this member can be meaningfully called from the root 
without any imports.
For example:

- [`Lang.Int.G.Buffer`](../../api/scalqa/lang/int/g/Buffer.html) is a generic buffer specialized for Int primitives  
- [`Val.Collection.Mutable`](../../api/scalqa/val/collection/Mutable.html) is a mutable collection interface   

Some hierarchy members can also have 'aliases' (shortcuts), so they can also be called 
with shorter names. For instance, when calling members of [Lang](../../api/scalqa/Lang$.html), [Val](../../api/scalqa/Val$.html), and [Gen](../../api/scalqa/Gen$.html)
prefix is not required:
 
- [`Int.G.Buffer`](../../api/scalqa/lang/int/g/Buffer.html) 
- [`Collection.Mutable`](../../api/scalqa/val/collection/Mutable.html)    

### Justification

One of the most precious resources in today's programming is name space. Every imaginable piece of functionality, we might need, 
already exists somewhere. The challenge is to make accessing it cheaper, then the potential benefits. 
Often times 'import' statements are not justified to bring in trivial functionality.

In Scalqa code there are practically no imports (except for rare conflict resolutions). All the functionality is available from the root,
but few levels of hierarchy provide unlimited naming opportunities for even the most trivial resources.

### Implementation        

Of course there are packages on implementation level, but they are not a part of public API and should not be called directly. 
All public functionality is exposed as objects, which can be imported (when required) the same way packages are.

### Should users follow H2O structure?

Probably "no". It is better to write programs the regular way.
It would take months of considerable effort before first benefits are realized. 
And even then, H2O is mostly beneficial for large, very interconnected library type code.
        
