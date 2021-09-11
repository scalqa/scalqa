package scalqa;

import scala.Tuple2;
import scala.Tuple3;
import scalqa.val.Stream;
import scala.math.Ordering;
import scala.concurrent.ExecutionContext;
import scalqa.lang.any.def.TypeName;
import scalqa.lang.any.def.Doc;
import scalqa.lang.any.def.z.Default;
import scalqa.lang.any.def.z.Primitive;
import scalqa.lang.any.def.z.ReferenceName;

public final class ZZ{
    private ZZ(){};
    private static int cnt = 0;
    public  static final int count(){ cnt +=1; return cnt;}
    private static final scalqa.j.vm.z.ZZ_Access            Access                 = new scalqa.j.vm.z.ZZ_Access();
    private static final Default                            Default                = new Default();
    public  static final ExecutionContext                   Context                = Access.executionContext();

    public  static final Object                             None                   = Access.None();
    public  static final Stream<Object>                     VOID_STREAM            = new scalqa.val.stream.z.x.Void();
    public  static <A>   Stream<A>                          VoidStream()           { return (scalqa.val.Stream<A>)VOID_STREAM; }
    public  static <A>   Doc<Stream<A>>                     streamDoc(Doc<A> v)    { return new scalqa.val.stream.z.util.DocDef(v); }
    public  static final scalqa.val.Pack<Object>            VOID                   = new scalqa.val.pack.z.Void<Object>();
    public  static <A>   scalqa.val.Pack<A>                 Void()                 { return (scalqa.val.Pack<A>)  VOID;   }
    public  static final int                                initSize               = Access.initSize();

    public  static <A>   Default<A>                         Def()                  { return (Default<A>)Default; }
    public  static       scalqa.val.result.Problem          problem(String message){ return new scalqa.val.result.problem.z.DefaultProblem(message); }

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
    public  static <A>   void tp(A v)                { tp(Default.value_tag(v)); }
    public  static <A>   void tp(A v,       Doc<A> t){ tp(t.value_tag(v)); }
    public  static <A>   void tp(boolean v, Doc<A> t){ tp(tag(v,t));}
    public  static <A>   void tp(byte    v, Doc<A> t){ tp(tag(v,t));}
    public  static <A>   void tp(char    v, Doc<A> t){ tp(tag(v,t));}
    public  static <A>   void tp(short   v, Doc<A> t){ tp(tag(v,t));}
    public  static <A>   void tp(int     v, Doc<A> t){ tp(tag(v,t));}
    public  static <A>   void tp(long    v, Doc<A> t){ tp(tag(v,t));}
    public  static <A>   void tp(float   v, Doc<A> t){ tp(tag(v,t));}
    public  static <A>   void tp(double  v, Doc<A> t){ tp(tag(v,t));}

    public  static <A> String tag(boolean v, Doc<A> t){ return ((Doc<Boolean>)  t).value_tag(Boolean  .valueOf(v));}
    public  static <A> String tag(byte    v, Doc<A> t){ return ((Doc<Byte>)     t).value_tag(Byte     .valueOf(v));}
    public  static <A> String tag(char    v, Doc<A> t){ return ((Doc<Character>)t).value_tag(Character.valueOf(v));}
    public  static <A> String tag(short   v, Doc<A> t){ return ((Doc<Short>)    t).value_tag(Short    .valueOf(v));}
    public  static <A> String tag(int     v, Doc<A> t){ return ((Doc<Integer>)  t).value_tag(Integer  .valueOf(v));}
    public  static <A> String tag(long    v, Doc<A> t){ return ((Doc<Long>)     t).value_tag(Long     .valueOf(v));}
    public  static <A> String tag(float   v, Doc<A> t){ return ((Doc<Float>)    t).value_tag(Float    .valueOf(v));}
    public  static <A> String tag(double  v, Doc<A> t){ return ((Doc<Double>)   t).value_tag(Double   .valueOf(v));}

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
    public  static final Doc      BooleanDoc = new Primitive("Boolean");
    public  static final Doc      ByteDoc    = new Primitive("Byte");
    public  static final Doc      CharDoc    = new Primitive("Char");
    public  static final Doc      ShortDoc   = new Primitive("Short");
    public  static final Doc      IntDoc     = new Primitive("Int");
    public  static final Doc      LongDoc    = new Primitive("Long");
    public  static final Doc      FloatDoc   = new Primitive("Float");
    public  static final Doc      DoubleDoc  = new Primitive("Double");
    public  static final Doc      ArrayDoc   = new scalqa.lang.any.def.z.ArrayDoc();
    public  static final Doc      MathDoc    = new scalqa.lang.any.def.z.MathDoc();

    public  static final TypeName BooleanName= (TypeName)BooleanDoc;
    public  static final TypeName ByteName   = (TypeName)ByteDoc;
    public  static final TypeName CharName   = (TypeName)CharDoc;
    public  static final TypeName ShortName  = (TypeName)ShortDoc;
    public  static final TypeName IntName    = (TypeName)IntDoc;
    public  static final TypeName LongName   = (TypeName)LongDoc;
    public  static final TypeName FloatName  = (TypeName)FloatDoc;
    public  static final TypeName DoubleName = (TypeName)DoubleDoc;

    public  static final ReferenceName RefName = new ReferenceName();
}
