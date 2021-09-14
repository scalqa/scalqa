---
layout: doc-page
title: Containers
---

Scalqa features a unified [value container framework](../../api/scalqa/Val$.html), 
which includes traditional collections and other value holding objects like: stream, property, option, etc. 

All containers are designed with a single vision, have consistent naming, are interoperable and (in most cases) specializable for primitives. 

## Value Container Framework

Top level collections include:

- [Collection](../../api/scalqa/val/Collection.html) is the framework root trait
- [Idx](../../api/scalqa/val/Idx.html) is index accessible collection of values (trait)
- [Lookup](../../api/scalqa/val/Lookup.html) is key accessible collection of values (trait) 
- [Buffer](../../api/scalqa/val/Buffer.html) is growable indexed collection (class)
- [><](../../api/scalqa/val/Pack.html) is immutable pack of values, indexed collection (class)

Top level non-collections include:

- [~](../../api/scalqa/val/Stream.html) - stream of values interface
- [<>](../../api/scalqa/val/Range.html) - abstract range of values 
- [Pro](../../api/scalqa/val/Pro.html) - value provider (holds a single value)  
- [Opt](../../api/scalqa/val/Opt.html) - value option  (holds value or is empty)
- [Result](../../api/scalqa/val/Result.html) - value result (holds value or problem) 
- [Promise](../../api/scalqa/val/Promise.html) - future calculated value 

