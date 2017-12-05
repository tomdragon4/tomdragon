
package expression.types.exp;



public final class LeftOpExp extends expression.types.Exp implements tom.library.sl.Visitable  {
  
  private static String symbolName = "LeftOpExp";


  private LeftOpExp() {}
  private int hashCode;
  private static LeftOpExp gomProto = new LeftOpExp();
    private expression.types.LeftOp _LOp;
  private expression.types.Exp _Exp1;

  /**
   * Constructor that builds a term rooted by LeftOpExp
   *
   * @return a term rooted by LeftOpExp
   */

  public static LeftOpExp make(expression.types.LeftOp _LOp, expression.types.Exp _Exp1) {

    // use the proto as a model
    gomProto.initHashCode( _LOp,  _Exp1);
    return (LeftOpExp) factory.build(gomProto);

  }

  /**
   * Initializes attributes and hashcode of the class
   *
   * @param  _LOp
   * @param _Exp1
   * @param hashCode hashCode of LeftOpExp
   */
  private void init(expression.types.LeftOp _LOp, expression.types.Exp _Exp1, int hashCode) {
    this._LOp = _LOp;
    this._Exp1 = _Exp1;

    this.hashCode = hashCode;
  }

  /**
   * Initializes attributes and hashcode of the class
   *
   * @param  _LOp
   * @param _Exp1
   */
  private void initHashCode(expression.types.LeftOp _LOp, expression.types.Exp _Exp1) {
    this._LOp = _LOp;
    this._Exp1 = _Exp1;

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
    return "LeftOpExp";
  }

  /**
   * Returns the arity of the symbol
   *
   * @return the arity of the symbol
   */
  private int getArity() {
    return 2;
  }

  /**
   * Copy the object and returns the copy
   *
   * @return a clone of the SharedObject
   */
  public shared.SharedObject duplicate() {
    LeftOpExp clone = new LeftOpExp();
    clone.init( _LOp,  _Exp1, hashCode);
    return clone;
  }
  
  /**
   * Appends a string representation of this term to the buffer given as argument.
   *
   * @param buffer the buffer to which a string represention of this term is appended.
   */
  @Override
  public void toStringBuilder(java.lang.StringBuilder buffer) {
    buffer.append("LeftOpExp(");
    _LOp.toStringBuilder(buffer);
buffer.append(",");
    _Exp1.toStringBuilder(buffer);

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
    LeftOpExp tco = (LeftOpExp) ao;
    int _LOpCmp = (this._LOp).compareToLPO(tco._LOp);
    if(_LOpCmp != 0) {
      return _LOpCmp;
    }

    int _Exp1Cmp = (this._Exp1).compareToLPO(tco._Exp1);
    if(_Exp1Cmp != 0) {
      return _Exp1Cmp;
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
    LeftOpExp tco = (LeftOpExp) ao;
    int _LOpCmp = (this._LOp).compareTo(tco._LOp);
    if(_LOpCmp != 0) {
      return _LOpCmp;
    }

    int _Exp1Cmp = (this._Exp1).compareTo(tco._Exp1);
    if(_Exp1Cmp != 0) {
      return _Exp1Cmp;
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
   * @return true if obj is a LeftOpExp and its members are equal, else false
   */
  public final boolean equivalent(shared.SharedObject obj) {
    if(obj instanceof LeftOpExp) {

      LeftOpExp peer = (LeftOpExp) obj;
      return _LOp==peer._LOp && _Exp1==peer._Exp1 && true;
    }
    return false;
  }


   //Exp interface
  /**
   * Returns true if the term is rooted by the symbol LeftOpExp
   *
   * @return true, because this is rooted by LeftOpExp
   */
  @Override
  public boolean isLeftOpExp() {
    return true;
  }
  
  /**
   * Returns the attribute expression.types.LeftOp
   *
   * @return the attribute expression.types.LeftOp
   */
  @Override
  public expression.types.LeftOp getLOp() {
    return _LOp;
  }

  /**
   * Sets and returns the attribute expression.types.Exp
   *
   * @param set_arg the argument to set
   * @return the attribute expression.types.LeftOp which just has been set
   */
  @Override
  public expression.types.Exp setLOp(expression.types.LeftOp set_arg) {
    return make(set_arg, _Exp1);
  }
  
  /**
   * Returns the attribute expression.types.Exp
   *
   * @return the attribute expression.types.Exp
   */
  @Override
  public expression.types.Exp getExp1() {
    return _Exp1;
  }

  /**
   * Sets and returns the attribute expression.types.Exp
   *
   * @param set_arg the argument to set
   * @return the attribute expression.types.Exp which just has been set
   */
  @Override
  public expression.types.Exp setExp1(expression.types.Exp set_arg) {
    return make(_LOp, set_arg);
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
      new aterm.ATerm[] {getLOp().toATerm(), getExp1().toATerm()});
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
expression.types.LeftOp.fromTerm(appl.getArgument(0),atConv), expression.types.Exp.fromTerm(appl.getArgument(1),atConv)
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
    return 2;
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
      case 0: return _LOp;
      case 1: return _Exp1;
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
      case 0: return make((expression.types.LeftOp) v, _Exp1);
      case 1: return make(_LOp, (expression.types.Exp) v);
      default: throw new IndexOutOfBoundsException();
 }
  }

  /**
   * Set children to the term
   *
   * @param children array of children to set
   * @return an array of children which just were set
   * @throws IndexOutOfBoundsException if length of "children" is different than 2
   */
  @SuppressWarnings("unchecked")
  public tom.library.sl.Visitable setChildren(tom.library.sl.Visitable[] children) {
    if (children.length == getChildCount()  && children[0] instanceof expression.types.LeftOp && children[1] instanceof expression.types.Exp) {
      return make((expression.types.LeftOp) children[0], (expression.types.Exp) children[1]);
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
    return new tom.library.sl.Visitable[] { _LOp,  _Exp1};
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
    b = (-1253728155<<8);
    c = getArity();
    /* -------------------------------------- handle most of the key */
    /* ------------------------------------ handle the last 11 bytes */
    a += (_LOp.hashCode() << 8);
    a += (_Exp1.hashCode());

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
  public static tom.library.enumerator.F<tom.library.enumerator.Enumeration<expression.types.LeftOp>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<expression.types.Exp>,tom.library.enumerator.Enumeration<expression.types.Exp>>> funMake() {
    return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<expression.types.LeftOp>,tom.library.enumerator.F<tom.library.enumerator.Enumeration<expression.types.Exp>,tom.library.enumerator.Enumeration<expression.types.Exp>>>() {
          public tom.library.enumerator.F<tom.library.enumerator.Enumeration<expression.types.Exp>,tom.library.enumerator.Enumeration<expression.types.Exp>> apply(final tom.library.enumerator.Enumeration<expression.types.LeftOp> t1) {
            return 
        new tom.library.enumerator.F<tom.library.enumerator.Enumeration<expression.types.Exp>,tom.library.enumerator.Enumeration<expression.types.Exp>>() {
          public tom.library.enumerator.Enumeration<expression.types.Exp> apply(final tom.library.enumerator.Enumeration<expression.types.Exp> t2) {
            return tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.apply(tom.library.enumerator.Enumeration.singleton((tom.library.enumerator.F<expression.types.LeftOp,tom.library.enumerator.F<expression.types.Exp,expression.types.Exp>>) 
        new tom.library.enumerator.F<expression.types.LeftOp,tom.library.enumerator.F<expression.types.Exp,expression.types.Exp>>() {
          public tom.library.enumerator.F<expression.types.Exp,expression.types.Exp> apply(final expression.types.LeftOp t1) {
            return 
        new tom.library.enumerator.F<expression.types.Exp,expression.types.Exp>() {
          public expression.types.Exp apply(final expression.types.Exp t2) {
            return make(t1,t2);
          }
        };
          }
        }),t1),t2).pay();
          }
        };
          }
        };
  }

}
