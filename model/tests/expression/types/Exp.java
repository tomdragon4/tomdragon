
package expression.types;


public abstract class Exp extends expression.ExpressionAbstractType  {
  /**
   * Sole constructor.  (For invocation by subclass
   * constructors, typically implicit.)
   */
  protected Exp() {}



  /**
   * Returns true if the term is rooted by the symbol Nombre
   *
   * @return true if the term is rooted by the symbol Nombre
   */
  public boolean isNombre() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Litteral
   *
   * @return true if the term is rooted by the symbol Litteral
   */
  public boolean isLitteral() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol BinOpExp
   *
   * @return true if the term is rooted by the symbol BinOpExp
   */
  public boolean isBinOpExp() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol RigthOpExp
   *
   * @return true if the term is rooted by the symbol RigthOpExp
   */
  public boolean isRigthOpExp() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol LeftOpExp
   *
   * @return true if the term is rooted by the symbol LeftOpExp
   */
  public boolean isLeftOpExp() {
    return false;
  }

  /**
   * Returns the subterm corresponding to the slot ROp
   *
   * @return the subterm corresponding to the slot ROp
   */
  public expression.types.RigthOp getROp() {
    throw new UnsupportedOperationException("This Exp has no ROp");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot ROp
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot ROp is replaced by _arg
   */
  public Exp setROp(expression.types.RigthOp _arg) {
    throw new UnsupportedOperationException("This Exp has no ROp");
  }

  /**
   * Returns the subterm corresponding to the slot OpB
   *
   * @return the subterm corresponding to the slot OpB
   */
  public expression.types.BinOp getOpB() {
    throw new UnsupportedOperationException("This Exp has no OpB");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot OpB
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot OpB is replaced by _arg
   */
  public Exp setOpB(expression.types.BinOp _arg) {
    throw new UnsupportedOperationException("This Exp has no OpB");
  }

  /**
   * Returns the subterm corresponding to the slot Exp1
   *
   * @return the subterm corresponding to the slot Exp1
   */
  public expression.types.Exp getExp1() {
    throw new UnsupportedOperationException("This Exp has no Exp1");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot Exp1
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot Exp1 is replaced by _arg
   */
  public Exp setExp1(expression.types.Exp _arg) {
    throw new UnsupportedOperationException("This Exp has no Exp1");
  }

  /**
   * Returns the subterm corresponding to the slot Exp2
   *
   * @return the subterm corresponding to the slot Exp2
   */
  public expression.types.Exp getExp2() {
    throw new UnsupportedOperationException("This Exp has no Exp2");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot Exp2
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot Exp2 is replaced by _arg
   */
  public Exp setExp2(expression.types.Exp _arg) {
    throw new UnsupportedOperationException("This Exp has no Exp2");
  }

  /**
   * Returns the subterm corresponding to the slot name
   *
   * @return the subterm corresponding to the slot name
   */
  public String getname() {
    throw new UnsupportedOperationException("This Exp has no name");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot name
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot name is replaced by _arg
   */
  public Exp setname(String _arg) {
    throw new UnsupportedOperationException("This Exp has no name");
  }

  /**
   * Returns the subterm corresponding to the slot LOp
   *
   * @return the subterm corresponding to the slot LOp
   */
  public expression.types.LeftOp getLOp() {
    throw new UnsupportedOperationException("This Exp has no LOp");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot LOp
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot LOp is replaced by _arg
   */
  public Exp setLOp(expression.types.LeftOp _arg) {
    throw new UnsupportedOperationException("This Exp has no LOp");
  }

  /**
   * Returns the subterm corresponding to the slot i
   *
   * @return the subterm corresponding to the slot i
   */
  public int geti() {
    throw new UnsupportedOperationException("This Exp has no i");
  }

  /**
   * Returns a new term where the subterm corresponding to the slot i
   * is replaced by the term given in argument.
   * Note that there is no side-effect: a new term is returned and the original term is left unchanged
   *
   * @param _arg the value of the new subterm
   * @return a new term where the subterm corresponding to the slot i is replaced by _arg
   */
  public Exp seti(int _arg) {
    throw new UnsupportedOperationException("This Exp has no i");
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
   * Returns a expression.types.Exp from an ATerm without any conversion
   *
   * @param trm ATerm to handle to retrieve a Gom term
   * @return the term from the ATerm
   */
  public static expression.types.Exp fromTerm(aterm.ATerm trm) {
    return fromTerm(trm,idConv);
  }

  /**
   * Returns a expression.types.Exp from a String without any conversion
   *
   * @param s String containing the ATerm
   * @return the term from the String
   */
  public static expression.types.Exp fromString(String s) {
    return fromTerm(atermFactory.parse(s),idConv);
  }

  /**
   * Returns a expression.types.Exp from a Stream without any conversion
   *
   * @param stream stream containing the ATerm
   * @return the term from the Stream
   * @throws java.io.IOException if a problem occurs with the stream
   */
  public static expression.types.Exp fromStream(java.io.InputStream stream) throws java.io.IOException {
    return fromTerm(atermFactory.readFromFile(stream),idConv);
  }

  /**
   * Apply a conversion on the ATerm and returns a expression.types.Exp
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATermConverter used to convert the ATerm
   * @return the Gom term
   * @throws IllegalArgumentException
   */
  public static expression.types.Exp fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    aterm.ATerm convertedTerm = atConv.convert(trm);
    expression.types.Exp tmp;
    java.util.ArrayList<expression.types.Exp> results = new java.util.ArrayList<expression.types.Exp>();

    tmp = expression.types.exp.Nombre.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = expression.types.exp.Litteral.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = expression.types.exp.BinOpExp.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = expression.types.exp.RigthOpExp.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = expression.types.exp.LeftOpExp.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    switch(results.size()) {
      case 0:
        throw new IllegalArgumentException(trm + " is not a Exp");
      case 1:
        return results.get(0);
      default:
        java.util.logging.Logger.getLogger("Exp").log(java.util.logging.Level.WARNING,"There were many possibilities ({0}) in {1} but the first one was chosen: {2}",new Object[] {results.toString(), "expression.types.Exp", results.get(0).toString()});
        return results.get(0);
    }
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a expression.types.Exp from it
   *
   * @param s String containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static expression.types.Exp fromString(String s, tom.library.utils.ATermConverter atConv) {
    return fromTerm(atermFactory.parse(s),atConv);
  }

  /**
   * Apply a conversion on the ATerm contained in the Stream and returns a expression.types.Exp from it
   *
   * @param stream stream containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static expression.types.Exp fromStream(java.io.InputStream stream, tom.library.utils.ATermConverter atConv) throws java.io.IOException {
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
  public expression.types.Exp reverse() {
    throw new IllegalArgumentException(
      "This "+this.getClass().getName()+" is not a list");
  }

  
  /*
   * Initialize the (cyclic) data-structure
   * in order to generate/enumerate terms
   */

  protected static tom.library.enumerator.Enumeration<expression.types.Exp> enumExp = null;
  public static final tom.library.enumerator.Enumeration<expression.types.Exp> tmpenumExp = new tom.library.enumerator.Enumeration<expression.types.Exp>((tom.library.enumerator.LazyList<tom.library.enumerator.Finite<expression.types.Exp>>) null);

  public static tom.library.enumerator.Enumeration<expression.types.Exp> getEnumeration() {
    if(enumExp == null) { 
      enumExp = expression.types.exp.Nombre.funMake().apply(tom.library.enumerator.Combinators.makeint())
        .plus(expression.types.exp.Litteral.funMake().apply(tom.library.enumerator.Combinators.makeString()))
        .plus(expression.types.exp.BinOpExp.funMake().apply(expression.types.Exp.tmpenumExp).apply(expression.types.BinOp.tmpenumBinOp).apply(expression.types.Exp.tmpenumExp))
        .plus(expression.types.exp.RigthOpExp.funMake().apply(expression.types.Exp.tmpenumExp).apply(expression.types.RigthOp.tmpenumRigthOp))
        .plus(expression.types.exp.LeftOpExp.funMake().apply(expression.types.LeftOp.tmpenumLeftOp).apply(expression.types.Exp.tmpenumExp));

      expression.types.BinOp.getEnumeration();
      expression.types.LeftOp.getEnumeration();
      expression.types.RigthOp.getEnumeration();

      tmpenumExp.p1 = new tom.library.enumerator.P1<tom.library.enumerator.LazyList<tom.library.enumerator.Finite<expression.types.Exp>>>() {
        public tom.library.enumerator.LazyList<tom.library.enumerator.Finite<expression.types.Exp>> _1() { return enumExp.parts(); }
      };

    }
    return enumExp;
  }

}
