
package expression.types;


public abstract class BinOp extends expression.ExpressionAbstractType  {
  /**
   * Sole constructor.  (For invocation by subclass
   * constructors, typically implicit.)
   */
  protected BinOp() {}



  /**
   * Returns true if the term is rooted by the symbol Plus
   *
   * @return true if the term is rooted by the symbol Plus
   */
  public boolean isPlus() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Mult
   *
   * @return true if the term is rooted by the symbol Mult
   */
  public boolean isMult() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Eq
   *
   * @return true if the term is rooted by the symbol Eq
   */
  public boolean isEq() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Moins
   *
   * @return true if the term is rooted by the symbol Moins
   */
  public boolean isMoins() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Divide
   *
   * @return true if the term is rooted by the symbol Divide
   */
  public boolean isDivide() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Diff
   *
   * @return true if the term is rooted by the symbol Diff
   */
  public boolean isDiff() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Inf
   *
   * @return true if the term is rooted by the symbol Inf
   */
  public boolean isInf() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Sup
   *
   * @return true if the term is rooted by the symbol Sup
   */
  public boolean isSup() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Infegal
   *
   * @return true if the term is rooted by the symbol Infegal
   */
  public boolean isInfegal() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Supegal
   *
   * @return true if the term is rooted by the symbol Supegal
   */
  public boolean isSupegal() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Or
   *
   * @return true if the term is rooted by the symbol Or
   */
  public boolean isOr() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol And
   *
   * @return true if the term is rooted by the symbol And
   */
  public boolean isAnd() {
    return false;
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
   * Returns a expression.types.BinOp from an ATerm without any conversion
   *
   * @param trm ATerm to handle to retrieve a Gom term
   * @return the term from the ATerm
   */
  public static expression.types.BinOp fromTerm(aterm.ATerm trm) {
    return fromTerm(trm,idConv);
  }

  /**
   * Returns a expression.types.BinOp from a String without any conversion
   *
   * @param s String containing the ATerm
   * @return the term from the String
   */
  public static expression.types.BinOp fromString(String s) {
    return fromTerm(atermFactory.parse(s),idConv);
  }

  /**
   * Returns a expression.types.BinOp from a Stream without any conversion
   *
   * @param stream stream containing the ATerm
   * @return the term from the Stream
   * @throws java.io.IOException if a problem occurs with the stream
   */
  public static expression.types.BinOp fromStream(java.io.InputStream stream) throws java.io.IOException {
    return fromTerm(atermFactory.readFromFile(stream),idConv);
  }

  /**
   * Apply a conversion on the ATerm and returns a expression.types.BinOp
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATermConverter used to convert the ATerm
   * @return the Gom term
   * @throws IllegalArgumentException
   */
  public static expression.types.BinOp fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    aterm.ATerm convertedTerm = atConv.convert(trm);
    expression.types.BinOp tmp;
    java.util.ArrayList<expression.types.BinOp> results = new java.util.ArrayList<expression.types.BinOp>();

    tmp = expression.types.binop.Plus.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = expression.types.binop.Mult.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = expression.types.binop.Eq.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = expression.types.binop.Moins.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = expression.types.binop.Divide.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = expression.types.binop.Diff.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = expression.types.binop.Inf.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = expression.types.binop.Sup.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = expression.types.binop.Infegal.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = expression.types.binop.Supegal.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = expression.types.binop.Or.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = expression.types.binop.And.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    switch(results.size()) {
      case 0:
        throw new IllegalArgumentException(trm + " is not a BinOp");
      case 1:
        return results.get(0);
      default:
        java.util.logging.Logger.getLogger("BinOp").log(java.util.logging.Level.WARNING,"There were many possibilities ({0}) in {1} but the first one was chosen: {2}",new Object[] {results.toString(), "expression.types.BinOp", results.get(0).toString()});
        return results.get(0);
    }
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a expression.types.BinOp from it
   *
   * @param s String containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static expression.types.BinOp fromString(String s, tom.library.utils.ATermConverter atConv) {
    return fromTerm(atermFactory.parse(s),atConv);
  }

  /**
   * Apply a conversion on the ATerm contained in the Stream and returns a expression.types.BinOp from it
   *
   * @param stream stream containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static expression.types.BinOp fromStream(java.io.InputStream stream, tom.library.utils.ATermConverter atConv) throws java.io.IOException {
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
  public expression.types.BinOp reverse() {
    throw new IllegalArgumentException(
      "This "+this.getClass().getName()+" is not a list");
  }

  
  /*
   * Initialize the (cyclic) data-structure
   * in order to generate/enumerate terms
   */

  protected static tom.library.enumerator.Enumeration<expression.types.BinOp> enumBinOp = null;
  public static final tom.library.enumerator.Enumeration<expression.types.BinOp> tmpenumBinOp = new tom.library.enumerator.Enumeration<expression.types.BinOp>((tom.library.enumerator.LazyList<tom.library.enumerator.Finite<expression.types.BinOp>>) null);

  public static tom.library.enumerator.Enumeration<expression.types.BinOp> getEnumeration() {
    if(enumBinOp == null) { 
      enumBinOp = expression.types.binop.Plus.funMake().apply(expression.types.BinOp.tmpenumBinOp)
        .plus(expression.types.binop.Mult.funMake().apply(expression.types.BinOp.tmpenumBinOp))
        .plus(expression.types.binop.Eq.funMake().apply(expression.types.BinOp.tmpenumBinOp))
        .plus(expression.types.binop.Moins.funMake().apply(expression.types.BinOp.tmpenumBinOp))
        .plus(expression.types.binop.Divide.funMake().apply(expression.types.BinOp.tmpenumBinOp))
        .plus(expression.types.binop.Diff.funMake().apply(expression.types.BinOp.tmpenumBinOp))
        .plus(expression.types.binop.Inf.funMake().apply(expression.types.BinOp.tmpenumBinOp))
        .plus(expression.types.binop.Sup.funMake().apply(expression.types.BinOp.tmpenumBinOp))
        .plus(expression.types.binop.Infegal.funMake().apply(expression.types.BinOp.tmpenumBinOp))
        .plus(expression.types.binop.Supegal.funMake().apply(expression.types.BinOp.tmpenumBinOp))
        .plus(expression.types.binop.Or.funMake().apply(expression.types.BinOp.tmpenumBinOp))
        .plus(expression.types.binop.And.funMake().apply(expression.types.BinOp.tmpenumBinOp));


      tmpenumBinOp.p1 = new tom.library.enumerator.P1<tom.library.enumerator.LazyList<tom.library.enumerator.Finite<expression.types.BinOp>>>() {
        public tom.library.enumerator.LazyList<tom.library.enumerator.Finite<expression.types.BinOp>> _1() { return enumBinOp.parts(); }
      };

    }
    return enumBinOp;
  }

}
