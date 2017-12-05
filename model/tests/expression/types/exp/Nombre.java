
package expression.types.exp;



public final class Nombre extends expression.types.Exp implements tom.library.sl.Visitable  {
  
  private static String symbolName = "Nombre";


  private Nombre() {}
  private int hashCode;
  private static Nombre gomProto = new Nombre();
  
private static boolean tom_equal_term_char(char t1, char t2) {return  t1==t2 ;}private static boolean tom_is_sort_char(char t) {return  true ;} private static boolean tom_equal_term_String(String t1, String t2) {return  t1.equals(t2) ;}private static boolean tom_is_sort_String(String t) {return  t instanceof String ;} private static boolean tom_equal_term_int(int t1, int t2) {return  t1==t2 ;}private static boolean tom_is_sort_int(int t) {return  true ;} private static boolean tom_equal_term_BinOp(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_BinOp(Object t) {return  (t instanceof expression.types.BinOp) ;}private static boolean tom_equal_term_LeftOp(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_LeftOp(Object t) {return  (t instanceof expression.types.LeftOp) ;}private static boolean tom_equal_term_RigthOp(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_RigthOp(Object t) {return  (t instanceof expression.types.RigthOp) ;}private static boolean tom_equal_term_Exp(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_Exp(Object t) {return  (t instanceof expression.types.Exp) ;}private static  expression.types.Exp  tom_make_Nombre( int  t0) { return  expression.types.exp.Nombre.make(t0) ;}






























































































































































  private int _i;

  /**
   * Constructor that builds a term rooted by Nombre
   *
   * @return a term rooted by Nombre
   */

    public static expression.types.Exp make(int arg_1) {
  if (true) {    {{if ( true ) {
 return tom_make_Nombre((( int )arg_1)); }}}

}
      return realMake( arg_1);
    }
  
  private static Nombre realMake(int _i) {

    // use the proto as a model
    gomProto.initHashCode( _i);
    return (Nombre) factory.build(gomProto);

  }

  /**
   * Initializes attributes and hashcode of the class
   *
   * @param  _i
   * @param hashCode hashCode of Nombre
   */
  private void init(int _i, int hashCode) {
    this._i = _i;

    this.hashCode = hashCode;
  }

  /**
   * Initializes attributes and hashcode of the class
   *
   * @param  _i
   */
  private void initHashCode(int _i) {
    this._i = _i;

    this.hashCode = hashFunction();
  }

  /* name and arity */

  /**
   * Returns the name of the symbol
   *
   * @return the name of the symbol
   */
  @Override
  public String symbolName() {
    return "Nombre";
  }

  /**
   * Returns the arity of the symbol
   *
   * @return the arity of the symbol
   */
  private int getArity() {
    return 1;
  }

  /**
   * Copy the object and returns the copy
   *
   * @return a clone of the SharedObject
   */
  public shared.SharedObject duplicate() {
    Nombre clone = new Nombre();
    clone.init( _i, hashCode);
    return clone;
  }
  
  /**
   * Appends a string representation of this term to the buffer given as argument.
   *
   * @param buffer the buffer to which a string represention of this term is appended.
   */
  @Override
  public void toStringBuilder(java.lang.StringBuilder buffer) {
    buffer.append("Nombre(");
    buffer.append(_i);

    buffer.append(")");
  }


  /**
   * Compares two terms. This functions implements a total lexicographic path ordering.
   *
   * @param o object to which this term is compared
   * @return a negative integer, zero, or a positive integer as this
   *         term is less than, equal to, or greater than the argument
   * @throws ClassCastException in case of invalid arguments
   * @throws RuntimeException if unable to compare children
   */
  @Override
  public int compareToLPO(Object o) {
    /*
     * We do not want to compare with any object, only members of the module
     * In case of invalid argument, throw a ClassCastException, as the java api
     * asks for it
     */
    expression.ExpressionAbstractType ao = (expression.ExpressionAbstractType) o;
    /* return 0 for equality */
    if (ao == this) { return 0; }
    /* compare the symbols */
    int symbCmp = this.symbolName().compareTo(ao.symbolName());
    if (symbCmp != 0) { return symbCmp; }
    /* compare the children */
    Nombre tco = (Nombre) ao;
    if( this._i != tco._i) {
      return (this._i < tco._i)?-1:1;
    }

    throw new RuntimeException("Unable to compare");
  }

 /**
   * Compares two terms. This functions implements a total order.
   *
   * @param o object to which this term is compared
   * @return a negative integer, zero, or a positive integer as this
   *         term is less than, equal to, or greater than the argument
   * @throws ClassCastException in case of invalid arguments
   * @throws RuntimeException if unable to compare children
   */
  @Override
  public int compareTo(Object o) {
    /*
     * We do not want to compare with any object, only members of the module
     * In case of invalid argument, throw a ClassCastException, as the java api
     * asks for it
     */
    expression.ExpressionAbstractType ao = (expression.ExpressionAbstractType) o;
    /* return 0 for equality */
    if (ao == this) { return 0; }
    /* use the hash values to discriminate */

    if(hashCode != ao.hashCode()) { return (hashCode < ao.hashCode())?-1:1; }

    /* If not, compare the symbols : back to the normal order */
    int symbCmp = this.symbolName().compareTo(ao.symbolName());
    if (symbCmp != 0) { return symbCmp; }
    /* last resort: compare the children */
    Nombre tco = (Nombre) ao;
    if( this._i != tco._i) {
      return (this._i < tco._i)?-1:1;
    }

    throw new RuntimeException("Unable to compare");
  }

 //shared.SharedObject
  /**
   * Returns hashCode
   *
   * @return hashCode
   */
  @Override
  public final int hashCode() {
    return hashCode;
  }

  /**
   * Checks if a SharedObject is equivalent to the current object
   *
   * @param obj SharedObject to test
   * @return true if obj is a Nombre and its members are equal, else false
   */
  public final boolean equivalent(shared.SharedObject obj) {
    if(obj instanceof Nombre) {

      Nombre peer = (Nombre) obj;
      return _i==peer._i && true;
    }
    return false;
  }


   //Exp interface
  /**
   * Returns true if the term is rooted by the symbol Nombre
   *
   * @return true, because this is rooted by Nombre
   */
  @Override
  public boolean isNombre() {
    return true;
  }
  
  /**
   * Returns the attribute int
   *
   * @return the attribute int
   */
  @Override
  public int geti() {
    return _i;
  }

  /**
   * Sets and returns the attribute expression.types.Exp
   *
   * @param set_arg the argument to set
   * @return the attribute int which just has been set
   */
  @Override
  public expression.types.Exp seti(int set_arg) {
    return make(set_arg);
  }
  
  /* AbstractType */
  /**
   * Returns an ATerm representation of this term.
   *
   * @return an ATerm representation of this term.
   */
  @Override
  public aterm.ATerm toATerm() {
    aterm.ATerm res = super.toATerm();
    if(res != null) {
      // the super class has produced an ATerm (may be a variadic operator)
      return res;
    }
    return atermFactory.makeAppl(
      atermFactory.makeAFun(symbolName(),getArity(),false),
      new aterm.ATerm[] {(aterm.ATerm) atermFactory.makeInt(geti())});
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a expression.types.Exp from it
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static expression.types.Exp fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    trm = atConv.convert(trm);
    if(trm instanceof aterm.ATermAppl) {
      aterm.ATermAppl appl = (aterm.ATermAppl) trm;
      if(symbolName.equals(appl.getName()) && !appl.getAFun().isQuoted()) {
        return make(
convertATermToInt(appl.getArgument(0), atConv)
        );
      }
    }
    return null;
  }

  /* Visitable */
  /**
   * Returns the number of children of the term
   *
   * @return the number of children of the term
   */
  public int getChildCount() {
    return 1;
  }

  /**
   * Returns the child at the specified index
   *
   * @param index index of the child to return; must be
             nonnegative and less than the childCount
   * @return the child at the specified index
   * @throws IndexOutOfBoundsException if the index out of range
   */
  public tom.library.sl.Visitable getChildAt(int index) {
        switch(index) {
      case 0: return new tom.library.sl.VisitableBuiltin<java.lang.Integer>(_i);
      default: throw new IndexOutOfBoundsException();
 }
 }

  /**
   * Set the child at the specified index
   *
   * @param index index of the child to set; must be
             nonnegative and less than the childCount
   * @param v child to set at the specified index
   * @return the child which was just set
   * @throws IndexOutOfBoundsException if the index out of range
   */
  public tom.library.sl.Visitable setChildAt(int index, tom.library.sl.Visitable v) {
        switch(index) {
      case 0: return make(geti());
      default: throw new IndexOutOfBoundsException();
 }
  }

  /**
   * Set children to the term
   *
   * @param children array of children to set
   * @return an array of children which just were set
   * @throws IndexOutOfBoundsException if length of "children" is different than 1
   */
  @SuppressWarnings("unchecked")
  public tom.library.sl.Visitable setChildren(tom.library.sl.Visitable[] children) {
    if (children.length == getChildCount()  && children[0] instanceof tom.library.sl.VisitableBuiltin) {
      return make(((tom.library.sl.VisitableBuiltin<java.lang.Integer>)children[0]).getBuiltin());
    } else {
      throw new IndexOutOfBoundsException();
    }
  }

  /**
   * Returns the whole children of the term
   *
   * @return the children of the term
   */
  public tom.library.sl.Visitable[] getChildren() {
    return new tom.library.sl.Visitable[] { new tom.library.sl.VisitableBuiltin<java.lang.Integer>(_i)};
  }

    /**
     * Compute a hashcode for this term.
     * (for internal use)
     *
     * @return a hash value
     */
  protected int hashFunction() {
    int a, b, c;
    /* Set up the internal state */
    a = 0x9e3779b9; /* the golden ratio; an arbitrary value */
    b = (-2132179503<<8);
    c = getArity();
    /* -------------------------------------- handle most of the key */
    /* ------------------------------------ handle the last 11 bytes */
    a += (_i);

    a -= b; a -= c; a ^= (c >> 13);
    b -= c; b -= a; b ^= (a << 8);
    c -= a; c -= b; c ^= (b >> 13);
    a -= b; a -= c; a ^= (c >> 12);
    b -= c; b -= a; b ^= (a << 16);
    c -= a; c -= b; c ^= (b >> 5);
    a -= b; a -= c; a ^= (c >> 3);
    b -= c; b -= a; b ^= (a << 10);
    c -= a; c -= b; c ^= (b >> 15);
    /* ------------------------------------------- report the result */
    return c;
  }

  /**
    * function that returns functional version of the current operator
    * need for initializing the Enumerator
    */
  public static tom.library.enumerator.F<tom.library.enumerator.Enumeration<java.lang.Integer>,tom.library.enumerator.Enumeration<expression.types.Exp>> funMake() {
    return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<java.lang.Integer>,tom.library.enumerator.Enumeration<expression.types.Exp>>() {
          public tom.library.enumerator.Enumeration<expression.types.Exp> apply(final tom.library.enumerator.Enumeration<java.lang.Integer> t1) {
            return tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.singleton((tom.library.enumerator.F<java.lang.Integer,expression.types.Exp>) 
        new tom.library.enumerator.F<java.lang.Integer,expression.types.Exp>() {
          public expression.types.Exp apply(final java.lang.Integer t1) {
            return make(java.lang.Integer.valueOf(t1));
          }
        }),t1).pay();
          }
        };
  }

}
