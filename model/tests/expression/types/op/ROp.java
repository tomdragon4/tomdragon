
package expression.types.op;



public final class ROp extends expression.types.Op implements tom.library.sl.Visitable  {
  
  private static String symbolName = "ROp";


  private ROp() {}
  private int hashCode;
  private static ROp gomProto = new ROp();
    private expression.types.RightOp _Ope2;

  /**
   * Constructor that builds a term rooted by ROp
   *
   * @return a term rooted by ROp
   */

  public static ROp make(expression.types.RightOp _Ope2) {

    // use the proto as a model
    gomProto.initHashCode( _Ope2);
    return (ROp) factory.build(gomProto);

  }

  /**
   * Initializes attributes and hashcode of the class
   *
   * @param  _Ope2
   * @param hashCode hashCode of ROp
   */
  private void init(expression.types.RightOp _Ope2, int hashCode) {
    this._Ope2 = _Ope2;

    this.hashCode = hashCode;
  }

  /**
   * Initializes attributes and hashcode of the class
   *
   * @param  _Ope2
   */
  private void initHashCode(expression.types.RightOp _Ope2) {
    this._Ope2 = _Ope2;

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
    return "ROp";
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
    ROp clone = new ROp();
    clone.init( _Ope2, hashCode);
    return clone;
  }
  
  /**
   * Appends a string representation of this term to the buffer given as argument.
   *
   * @param buffer the buffer to which a string represention of this term is appended.
   */
  @Override
  public void toStringBuilder(java.lang.StringBuilder buffer) {
    buffer.append("ROp(");
    _Ope2.toStringBuilder(buffer);

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
    ROp tco = (ROp) ao;
    int _Ope2Cmp = (this._Ope2).compareToLPO(tco._Ope2);
    if(_Ope2Cmp != 0) {
      return _Ope2Cmp;
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
    ROp tco = (ROp) ao;
    int _Ope2Cmp = (this._Ope2).compareTo(tco._Ope2);
    if(_Ope2Cmp != 0) {
      return _Ope2Cmp;
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
   * @return true if obj is a ROp and its members are equal, else false
   */
  public final boolean equivalent(shared.SharedObject obj) {
    if(obj instanceof ROp) {

      ROp peer = (ROp) obj;
      return _Ope2==peer._Ope2 && true;
    }
    return false;
  }


   //Op interface
  /**
   * Returns true if the term is rooted by the symbol ROp
   *
   * @return true, because this is rooted by ROp
   */
  @Override
  public boolean isROp() {
    return true;
  }
  
  /**
   * Returns the attribute expression.types.RightOp
   *
   * @return the attribute expression.types.RightOp
   */
  @Override
  public expression.types.RightOp getOpe2() {
    return _Ope2;
  }

  /**
   * Sets and returns the attribute expression.types.Op
   *
   * @param set_arg the argument to set
   * @return the attribute expression.types.RightOp which just has been set
   */
  @Override
  public expression.types.Op setOpe2(expression.types.RightOp set_arg) {
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
      new aterm.ATerm[] {getOpe2().toATerm()});
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a expression.types.Op from it
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static expression.types.Op fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    trm = atConv.convert(trm);
    if(trm instanceof aterm.ATermAppl) {
      aterm.ATermAppl appl = (aterm.ATermAppl) trm;
      if(symbolName.equals(appl.getName()) && !appl.getAFun().isQuoted()) {
        return make(
expression.types.RightOp.fromTerm(appl.getArgument(0),atConv)
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
      case 0: return _Ope2;
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
      case 0: return make((expression.types.RightOp) v);
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
    if (children.length == getChildCount()  && children[0] instanceof expression.types.RightOp) {
      return make((expression.types.RightOp) children[0]);
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
    return new tom.library.sl.Visitable[] { _Ope2};
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
    b = (-1446616689<<8);
    c = getArity();
    /* -------------------------------------- handle most of the key */
    /* ------------------------------------ handle the last 11 bytes */
    a += (_Ope2.hashCode());

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
  public static tom.library.enumerator.F<tom.library.enumerator.Enumeration<expression.types.RightOp>,tom.library.enumerator.Enumeration<expression.types.Op>> funMake() {
    return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<expression.types.RightOp>,tom.library.enumerator.Enumeration<expression.types.Op>>() {
          public tom.library.enumerator.Enumeration<expression.types.Op> apply(final tom.library.enumerator.Enumeration<expression.types.RightOp> t1) {
            return tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.singleton((tom.library.enumerator.F<expression.types.RightOp,expression.types.Op>) 
        new tom.library.enumerator.F<expression.types.RightOp,expression.types.Op>() {
          public expression.types.Op apply(final expression.types.RightOp t1) {
            return make(t1);
          }
        }),t1).pay();
          }
        };
  }

}
