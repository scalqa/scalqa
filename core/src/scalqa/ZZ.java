package scalqa;

import scala.Tuple2;
import scala.Tuple3;
import scalqa.val.Stream;
import scala.math.Ordering;
import scala.concurrent.ExecutionContext;
import scalqa.gen.given.DocTag;
import scalqa.gen.given.z.DefaultTag;
import scalqa.gen.given.z.PrimitiveTag;
import scalqa.gen.given.z.ReferenceNameTag;

public final class ZZ{
    private ZZ(){};
    private static int cnt = 0;
    public  static final int count(){ cnt +=1; return cnt;}
    private static final scalqa.j.vm.z.ZZ_Access            Access                 = new scalqa.j.vm.z.ZZ_Access();
    private static final DefaultTag                         DefaultTag             = new DefaultTag();
    public  static final scalqa.val.result.Problem          NullProblem            = new scalqa.val.result.problem.z.DefaultProblem("Null value");
    public  static final scalqa.val.result.Problem          DefaultProblem         = new scalqa.val.result.problem.z.DefaultProblem("No Message");
    public  static final scalqa.val.result.Problem          WithFilterProblem      = new scalqa.val.result.problem.z.DefaultProblem("For-Comprehension predicate is not satisfied");
    public  static final ExecutionContext                   Context                = Access.executionContext();

    public  static final Object                             None                   = Access.None();
    public  static final Object                             BoolNone               = None;
    public  static final scalqa.val.stream.z.a.Void<Object> VOID_STREAM            = new scalqa.val.stream.z.a.Void();
    public  static final scalqa.val.Pack<Object>            VOID_LIST              = new scalqa.val.pack.z.Void<Object>();
    public  static final int                                initSize               = Access.initSize();

    public  static <A>   DefaultTag<A>                      Tag()                  { return (DefaultTag<A>)DefaultTag; }
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
    public  static <A>   void tp(A v)                { tp(DefaultTag.tag(v)); }
    public  static <A>   void tp(A v,       DocTag<A> t){ tp(t.tag(v)); }
    public  static <A>   void tp(boolean v, DocTag<A> t){ tp(((DocTag<Boolean>)  t).tag(Boolean  .valueOf(v)));}
    public  static <A>   void tp(byte    v, DocTag<A> t){ tp(((DocTag<Byte>)     t).tag(Byte     .valueOf(v)));}
    public  static <A>   void tp(char    v, DocTag<A> t){ tp(((DocTag<Character>)t).tag(Character.valueOf(v)));}
    public  static <A>   void tp(short   v, DocTag<A> t){ tp(((DocTag<Short>)    t).tag(Short    .valueOf(v)));}
    public  static <A>   void tp(int     v, DocTag<A> t){ tp(((DocTag<Integer>)  t).tag(Integer  .valueOf(v)));}
    public  static <A>   void tp(long    v, DocTag<A> t){ tp(((DocTag<Long>)     t).tag(Long     .valueOf(v)));}
    public  static <A>   void tp(float   v, DocTag<A> t){ tp(((DocTag<Float>)    t).tag(Float    .valueOf(v)));}
    public  static <A>   void tp(double  v, DocTag<A> t){ tp(((DocTag<Double>)   t).tag(Double   .valueOf(v)));}

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
    // *********************** Tags **************************
    public  static final DocTag BooleanTag = new PrimitiveTag("Boolean");
    public  static final DocTag ByteTag    = new PrimitiveTag("Byte");
    public  static final DocTag CharTag    = new PrimitiveTag("Char");
    public  static final DocTag ShortTag   = new PrimitiveTag("Short");
    public  static final DocTag IntTag     = new PrimitiveTag("Int");
    public  static final DocTag LongTag    = new PrimitiveTag("Long");
    public  static final DocTag FloatTag   = new PrimitiveTag("Float");
    public  static final DocTag DoubleTag  = new PrimitiveTag("Double");
    public  static final DocTag ArrayTag   = new scalqa.gen.given.z.ArrayTag();
    public  static final DocTag MathTag    = new scalqa.gen.given.z.MathTag();

    public  static final ReferenceNameTag RefNameTag = new ReferenceNameTag();
}
