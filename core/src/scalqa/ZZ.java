package scalqa;

import scala.Tuple2;
import scala.Tuple3;
import scalqa.val.Stream;
import scala.math.Ordering;
import scala.concurrent.ExecutionContext;
import scalqa.lang.any.self.def.Doc;
import scalqa.lang.any.self.def.z.DefaultDef;
import scalqa.lang.any.self.def.z.PrimitiveDef;
import scalqa.lang.any.self.def.z.ReferenceType;

public final class ZZ{
    private ZZ(){};
    private static int cnt = 0;
    public  static final int count(){ cnt +=1; return cnt;}
    private static final scalqa.j.vm.z.ZZ_Access            Access                 = new scalqa.j.vm.z.ZZ_Access();
    private static final DefaultDef                         DefaultDef             = new DefaultDef();
    public  static final scalqa.val.result.Problem          NullProblem            = new scalqa.val.result.problem.z.DefaultProblem("Null value");
    public  static final scalqa.val.result.Problem          DefaultProblem         = new scalqa.val.result.problem.z.DefaultProblem("No Message");
    public  static final scalqa.val.result.Problem          WithFilterProblem      = new scalqa.val.result.problem.z.DefaultProblem("For-Comprehension predicate is not satisfied");
    public  static final ExecutionContext                   Context                = Access.executionContext();

    public  static final Object                             None                   = Access.None();
    public  static final Object                             BoolNone               = None;
    public  static final scalqa.val.stream.z.a.Void<Object> VOID_STREAM            = new scalqa.val.stream.z.a.Void();
    public  static final scalqa.val.Pack<Object>            VOID_LIST              = new scalqa.val.pack.z.Void<Object>();
    public  static final int                                initSize               = Access.initSize();

    public  static <A>   DefaultDef<A>                      Doc()                  { return (DefaultDef<A>)DefaultDef; }
    public  static <A>   scalqa.val.stream.z.a.Void<A>      voidStream()           { return (scalqa.val.stream.z.a.Void<A>)VOID_STREAM; }
    public  static <A>   scalqa.val.Pack<A>                 voidPack()             { return (scalqa.val.Pack<A>)         VOID_LIST;   }
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
    public  static <A>   void tp(A v)                { tp(DefaultDef.tag(v)); }
    public  static <A>   void tp(A v,       Doc<A> t){ tp(t.tag(v)); }
    public  static <A>   void tp(boolean v, Doc<A> t){ tp(((Doc<Boolean>)  t).tag(Boolean  .valueOf(v)));}
    public  static <A>   void tp(byte    v, Doc<A> t){ tp(((Doc<Byte>)     t).tag(Byte     .valueOf(v)));}
    public  static <A>   void tp(char    v, Doc<A> t){ tp(((Doc<Character>)t).tag(Character.valueOf(v)));}
    public  static <A>   void tp(short   v, Doc<A> t){ tp(((Doc<Short>)    t).tag(Short    .valueOf(v)));}
    public  static <A>   void tp(int     v, Doc<A> t){ tp(((Doc<Integer>)  t).tag(Integer  .valueOf(v)));}
    public  static <A>   void tp(long    v, Doc<A> t){ tp(((Doc<Long>)     t).tag(Long     .valueOf(v)));}
    public  static <A>   void tp(float   v, Doc<A> t){ tp(((Doc<Float>)    t).tag(Float    .valueOf(v)));}
    public  static <A>   void tp(double  v, Doc<A> t){ tp(((Doc<Double>)   t).tag(Double   .valueOf(v)));}

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
    public  static final Doc BooleanDef = new PrimitiveDef("Boolean");
    public  static final Doc ByteDef    = new PrimitiveDef("Byte");
    public  static final Doc CharDef    = new PrimitiveDef("Char");
    public  static final Doc ShortDef   = new PrimitiveDef("Short");
    public  static final Doc IntDef     = new PrimitiveDef("Int");
    public  static final Doc LongDef    = new PrimitiveDef("Long");
    public  static final Doc FloatDef   = new PrimitiveDef("Float");
    public  static final Doc DoubleDef  = new PrimitiveDef("Double");
    public  static final Doc ArrayDoc   = new scalqa.lang.any.self.def.z.ArrayDoc();
    public  static final Doc MathDoc    = new scalqa.lang.any.self.def.z.MathDoc();

    public  static final ReferenceType RefType = new scalqa.lang.any.self.def.z.ReferenceType();
}
