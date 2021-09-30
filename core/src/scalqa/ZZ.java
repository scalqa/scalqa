package scalqa;

import scalqa.val.Stream;
import scala.math.Ordering;
import scala.concurrent.ExecutionContext;
import scalqa.lang.any.def.TypeName;
import scalqa.lang.any.def.Doc;
import scalqa.lang.any.def.Tag;
import scalqa.lang.any.def.z.AnyDef;
import scalqa.lang.any.def.z.PrimitiveDef;
import scalqa.lang.any.def.z.ReferenceNameDef;

public final class ZZ{
    private ZZ(){};
    private static final scalqa.j.vm.z.ZZ_Access            Access                 = new scalqa.j.vm.z.ZZ_Access();
    private static final AnyDef                             AnyDef                 = new AnyDef();
    public  static final ExecutionContext                   Context                = Access.executionContext();

    public  static final Object                             None                   = Access.None();
    public  static final Stream<Object>                     VOID_STREAM            = new scalqa.val.stream.z.x.Void();
    public  static <A>   Stream<A>                          VoidStream()           { return (scalqa.val.Stream<A>)VOID_STREAM; }
    public  static <A>   Doc<Stream<A>>                     streamDoc(Tag<A> v)    { return new scalqa.val.stream.z.util.DocDef(v); }
    public  static final scalqa.val.Pack<Object>            VOID                   = new scalqa.val.pack.z.Void<Object>();
    public  static <A>   scalqa.val.Pack<A>                 Void()                 { return (scalqa.val.Pack<A>)  VOID;   }
    public  static final int                                initSize               = Access.initSize();

    public  static <A>   AnyDef<A>                          Any()                  { return (AnyDef<A>)AnyDef; }
    public  static       scalqa.val.result.Problem          problem(String message){ return new scalqa.val.result.z.DefaultProblem(message); }

    // *********************** Exceptions **************************
    public  static class EO extends IllegalStateException        { public EO(){ super("Method 'get' called on an empty `Opt`");                   }}
    public  static class ES extends IllegalStateException        { public ES(){ super("Aggregate value cannot be calculated for an empty stream");}}
    public  static class LO extends IllegalStateException        { public LO(){ super("Long value (Long.Max - 1) is used as Void and cannot be held by Long.Opt, use Opt[Long] instead");}}
    public  static class UN extends UnsupportedOperationException{ public UN(){ super("");                                                        }}
    public  static class ME extends IllegalStateException        { public ME(String key){ super("Called Map.get method for key='" + key + "', but no value is available");}}

    // *********************** Printing  **************************
    public  static       void tp(boolean v)          { tp(String.valueOf(v));  }
    public  static       void tp(byte v)             { tp(String.valueOf(v));  }
    public  static       void tp(char v)             { tp(String.valueOf(v));  }
    public  static       void tp(short v)            { tp(String.valueOf(v));  }
    public  static       void tp(int v)              { tp(String.valueOf(v));  }
    public  static       void tp(long v)             { tp(String.valueOf(v));  }
    public  static       void tp(float v)            { tp(String.valueOf(v));  }
    public  static       void tp(double v)           { tp(String.valueOf(v));  }
    public  static       void tp(String v)           { Access.Console().println(v); }
    public  static <A>   void tp(A v)                { tp(AnyDef.value_tag(v)); }
    public  static <A>   void tp(A v,       Tag<A> t){ tp(t.value_tag(v)); }
    public  static <A>   void tp(boolean v, Tag<A> t){ tp(tag(v,t));}
    public  static <A>   void tp(byte    v, Tag<A> t){ tp(tag(v,t));}
    public  static <A>   void tp(char    v, Tag<A> t){ tp(tag(v,t));}
    public  static <A>   void tp(short   v, Tag<A> t){ tp(tag(v,t));}
    public  static <A>   void tp(int     v, Tag<A> t){ tp(tag(v,t));}
    public  static <A>   void tp(long    v, Tag<A> t){ tp(tag(v,t));}
    public  static <A>   void tp(float   v, Tag<A> t){ tp(tag(v,t));}
    public  static <A>   void tp(double  v, Tag<A> t){ tp(tag(v,t));}

    public  static <A> String tag(boolean v, Tag<A> t){ return ((Tag<Boolean>)  t).value_tag(java.lang.Boolean  .valueOf(v));}
    public  static <A> String tag(byte    v, Tag<A> t){ return ((Tag<Byte>)     t).value_tag(java.lang.Byte     .valueOf(v));}
    public  static <A> String tag(char    v, Tag<A> t){ return ((Tag<Character>)t).value_tag(java.lang.Character.valueOf(v));}
    public  static <A> String tag(short   v, Tag<A> t){ return ((Tag<Short>)    t).value_tag(java.lang.Short    .valueOf(v));}
    public  static <A> String tag(int     v, Tag<A> t){ return ((Tag<Integer>)  t).value_tag(java.lang.Integer  .valueOf(v));}
    public  static <A> String tag(long    v, Tag<A> t){ return ((Tag<Long>)     t).value_tag(java.lang.Long     .valueOf(v));}
    public  static <A> String tag(float   v, Tag<A> t){ return ((Tag<Float>)    t).value_tag(java.lang.Float    .valueOf(v));}
    public  static <A> String tag(double  v, Tag<A> t){ return ((Tag<Double>)   t).value_tag(java.lang.Double   .valueOf(v));}

    // *********************** Arrays **************************
    public  static final Object[]  emptyObjectArray  = Access.emptyObjectArray();
    public  static final boolean[] emptyBooleanArray = Access.emptyBooleanArray();
    public  static final byte[]    emptyByteArray    = Access.emptyByteArray();
    public  static final char[]    emptyCharArray    = Access.emptyCharArray();
    public  static final short[]   emptyShortArray   = Access.emptyShortArray();
    public  static final int[]     emptyIntArray     = Access.emptyIntArray();
    public  static final long[]    emptyLongArray    = Access.emptyLongArray();
    public  static final float[]   emptyFloatArray   = Access.emptyFloatArray();
    public  static final double[]  emptyDoubleArray  = Access.emptyDoubleArray();
    // *********************** Defs **************************
    public  static final Doc  Boolean = new PrimitiveDef("Boolean");
    public  static final Doc  Byte    = new PrimitiveDef("Byte");
    public  static final Doc  Char    = new PrimitiveDef("Char");
    public  static final Doc  Short   = new PrimitiveDef("Short");
    public  static final Doc  Int     = new PrimitiveDef("Int");
    public  static final Doc  Long    = new PrimitiveDef("Long");
    public  static final Doc  Float   = new PrimitiveDef("Float");
    public  static final Doc  Double  = new PrimitiveDef("Double");
    public  static final Doc  Array   = new scalqa.lang.any.def.z.ArrayDoc();

    public  static final TypeName BooleanName= (TypeName)Boolean;
    public  static final TypeName ByteName   = (TypeName)Byte;
    public  static final TypeName CharName   = (TypeName)Char;
    public  static final TypeName ShortName  = (TypeName)Short;
    public  static final TypeName IntName    = (TypeName)Int;
    public  static final TypeName LongName   = (TypeName)Long;
    public  static final TypeName FloatName  = (TypeName)Float;
    public  static final TypeName DoubleName = (TypeName)Double;

    public  static final ReferenceNameDef RefName = new ReferenceNameDef();
}
