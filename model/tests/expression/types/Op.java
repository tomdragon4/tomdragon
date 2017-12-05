
package expression.types;


public abstract class Op extends expression.ExpressionAbstractType  {
  /**
   * Sole constructor.  (For invocation by subclass
   * constructors, typically implicit.)
   */
  protected Op() {}



  /**
   * Returns true if the term is rooted by the symbol BOp
   *
   * @return true if the term is rooted by the symbol BOp
   */
  public boolean isBOp() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol ROp
   *
   * @return true if the term is rooted by the symbol ROp
   */
  public boolean isROp() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol LOp
   *
   * @return true if the term is rooted by the symbol LOp
   */
  public boolean isLOp() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Par
   *
   * @return true if the term is rooted by the symbol Par
   */
  public boolean isPar() {
    return false;
  }

  /**
   * Returns the subterm corresponding to the slot Ope3
   *
   * @return the subterm corresponding to the slot Ope3
   */
  public expression.types.LeftOp getOpe3() {
    throw new UnsupportedOperationException("This Op has no Ope3");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot Ope3
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot Ope3 is replaced by _arg
   */
  public Op setOpe3(expression.types.LeftOp _arg) {
    throw new UnsupportedOperationException("This Op has no Ope3");
  }

  /**
   * Returns the subterm corresponding to the slot Ope2
   *
   * @return the subterm corresponding to the slot Ope2
   */
  public expression.types.RightOp getOpe2() {
    throw new UnsupportedOperationException("This Op has no Ope2");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot Ope2
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot Ope2 is replaced by _arg
   */
  public Op setOpe2(expression.types.RightOp _arg) {
    throw new UnsupportedOperationException("This Op has no Ope2");
  }

  /**
   * Returns the subterm corresponding to the slot Ope1
   *
   * @return the subterm corresponding to the slot Ope1
   */
  public expression.types.BinOp getOpe1() {
    throw new UnsupportedOperationException("This Op has no Ope1");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot Ope1
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot Ope1 is replaced by _arg
   */
  public Op setOpe1(expression.types.BinOp _arg) {
    throw new UnsupportedOperationException("This Op has no Ope1");
  }

  /**
   * Returns the subterm corresponding to the slot Ope4
   *
   * @return the subterm corresponding to the slot Ope4
   */
  public expression.types.Parent getOpe4() {
    throw new UnsupportedOperationException("This Op has no Ope4");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot Ope4
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot Ope4 is replaced by _arg
   */
  public Op setOpe4(expression.types.Parent _arg) {
    throw new UnsupportedOperationException("This Op has no Ope4");
  }

  protected static tom.library.utils.IdConverter idConv = new tom.library.utils.IdConverter();

  /**
   * Returns an ATerm representation of this term.
   *
   * @return null to indicate to sub-classes that they have to work
   */
  public aterm.ATerm toATerm() {
    // returns null to indicate sub-classes that they have to work
    return null;
  }

  /**
   * Returns a expression.types.Op from an ATerm without any conversion
   *
   * @param trm ATerm to handle to retrieve a Gom term
   * @return the term from the ATerm
   */
  public static expression.types.Op fromTerm(aterm.ATerm trm) {
    return fromTerm(trm,idConv);
  }

  /**
   * Returns a expression.types.Op from a String without any conversion
   *
   * @param s String containing the ATerm
   * @return the term from the String
   */
  public static expression.types.Op fromString(String s) {
    return fromTerm(atermFactory.parse(s),idConv);
  }

  /**
   * Returns a expression.types.Op from a Stream without any conversion
   *
   * @param stream stream containing the ATerm
   * @return the term from the Stream
   * @throws java.io.IOException if a problem occurs with the stream
   */
  public static expression.types.Op fromStream(java.io.InputStream stream) throws java.io.IOException {
    return fromTerm(atermFactory.readFromFile(stream),idConv);
  }

  /**
   * Apply a conversion on the ATerm and returns a expression.types.Op
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATermConverter used to convert the ATerm
   * @return the Gom term
   * @throws IllegalArgumentException
   */
  public static expression.types.Op fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    aterm.ATerm convertedTerm = atConv.convert(trm);
    expression.types.Op tmp;
    java.util.ArrayList<expression.types.Op> results = new java.util.ArrayList<expression.types.Op>();

    tmp = expression.types.op.BOp.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = expression.types.op.ROp.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = expression.types.op.LOp.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = expression.types.op.Par.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    switch(results.size()) {
      case 0:
        throw new IllegalArgumentException(trm + " is not a Op");
      case 1:
        return results.get(0);
      default:
        java.util.logging.Logger.getLogger("Op").log(java.util.logging.Level.WARNING,"There were many possibilities ({0}) in {1} but the first one was chosen: {2}",new Object[] {results.toString(), "expression.types.Op", results.get(0).toString()});
        return results.get(0);
    }
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a expression.types.Op from it
   *
   * @param s String containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static expression.types.Op fromString(String s, tom.library.utils.ATermConverter atConv) {
    return fromTerm(atermFactory.parse(s),atConv);
  }

  /**
   * Apply a conversion on the ATerm contained in the Stream and returns a expression.types.Op from it
   *
   * @param stream stream containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static expression.types.Op fromStream(java.io.InputStream stream, tom.library.utils.ATermConverter atConv) throws java.io.IOException {
    return fromTerm(atermFactory.readFromFile(stream),atConv);
  }

  /**
   * Returns the length of the list
   *
   * @return the length of the list
   * @throws IllegalArgumentException if the term is not a list
   */
  public int length() {
    throw new IllegalArgumentException(
      "This "+this.getClass().getName()+" is not a list");
  }

  /**
   * Returns an inverted term
   *
   * @return the inverted list
   * @throws IllegalArgumentException if the term is not a list
   */
  public expression.types.Op reverse() {
    throw new IllegalArgumentException(
      "This "+this.getClass().getName()+" is not a list");
  }

  
  /*
   * Initialize the (cyclic) data-structure
   * in order to generate/enumerate terms
   */

  protected static tom.library.enumerator.Enumeration<expression.types.Op> enumOp = null;
  public static final tom.library.enumerator.Enumeration<expression.types.Op> tmpenumOp = new tom.library.enumerator.Enumeration<expression.types.Op>((tom.library.enumerator.LazyList<tom.library.enumerator.Finite<expression.types.Op>>) null);

  public static tom.library.enumerator.Enumeration<expression.types.Op> getEnumeration() {
    if(enumOp == null) { 
      enumOp = expression.types.op.BOp.funMake().apply(expression.types.BinOp.tmpenumBinOp)
        .plus(expression.types.op.ROp.funMake().apply(expression.types.RightOp.tmpenumRightOp))
        .plus(expression.types.op.LOp.funMake().apply(expression.types.LeftOp.tmpenumLeftOp))
        .plus(expression.types.op.Par.funMake().apply(expression.types.Parent.tmpenumParent));

      expression.types.BinOp.getEnumeration();
      expression.types.LeftOp.getEnumeration();
      expression.types.RightOp.getEnumeration();
      expression.types.Parent.getEnumeration();

      tmpenumOp.p1 = new tom.library.enumerator.P1<tom.library.enumerator.LazyList<tom.library.enumerator.Finite<expression.types.Op>>>() {
        public tom.library.enumerator.LazyList<tom.library.enumerator.Finite<expression.types.Op>> _1() { return enumOp.parts(); }
      };

    }
    return enumOp;
  }

}
