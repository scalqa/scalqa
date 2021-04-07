---
layout: doc-page
title: H2O Structure
---
### Hierarchical Objects Organization Structure

From a user prospective Scalqa does not have packages. There is just one single root package 'scalqa' 
(always fully imported as `import scalqa._`), which contains 5 root member objects:

- [`Def`](../../api/scalqa/Def$.html) holds language extensions
- [`Gen`](../../api/scalqa/Gen$.html) holds general utilities
- [`Fx`](../../api/scalqa/Fx$.html)   holds GUI API
- [`J`](../../api/scalqa/J$.html)     holds Java utilities
- [`Val`](../../api/scalqa/Val$.html) holds generic containers framework
  
These root objects also contain members of their own. Those members can have their members and so it goes as deep as required.

The trick is that parent name is an essential part of member name and this member can be meaningfully called from the root 
without any imports.
For example:

- [`Def.Int.G.Buffer`](../../api/scalqa/def/int/g/Buffer.html) is a generic buffer specialized for Int primitives  
- [`Val.Collection.Mutable`](../../api/scalqa/val/collection/Mutable.html) is a mutable collection interface   

Some hierarchy members can also have 'aliases' (shortcuts), so they can also be called 
with shorter names. For instance, all root object members (except for [scalqa.J](../../api/scalqa/J$.html)) have aliases in 'scalqa' package and the above 
example can be accessed as:
 
- [`Int.G.Buffer`](../../api/scalqa/def/int/g/Buffer.html) 
- [`Collection.Mutable`](../../api/scalqa/val/collection/Mutable.html)    

### Justification

One of the most precious resources in todays programming is name space. Every imaginable piece of functionality, we might need, 
already exists somewhere. The challenge is to make accessing it cheaper, then the potential benefits. 
Often times 'import' statements are not justified to bring in trivial functionality

In Scalqa code there are practically no imports (except for rare conflict resolutions). All the functionality is available from the root,
but few levels of hierarchy provide unlimited naming opportunities for even the most trivial methods

### Implementation        

Of cause there are packages on implementation level, but they are not a part of public API and should not be called directly. 
All public functionality is exposed as objects, which can be imported (if required) the same way packages are 