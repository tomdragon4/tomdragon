
package expression.types;


public abstract class RightOp extends expression.ExpressionAbstractType  {
  /**
   * Sole constructor.  (For invocation by subclass
   * constructors, typically implicit.)
   */
  protected RightOp() {}



  /**
   * Returns true if the term is rooted by the symbol Factorial
   *
   * @return true if the term is rooted by the symbol Factorial
   */
  public boolean isFactorial() {
    return false;
  }

  /**
   * Returns true if the term is rooted by the symbol Power
   *
   * @return true if the term is rooted by the symbol Power
   */
  public boolean isPower() {
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
   * Returns a expression.types.RightOp from an ATerm without any conversion
   *
   * @param trm ATerm to handle to retrieve a Gom term
   * @return the term from the ATerm
   */
  public static expression.types.RightOp fromTerm(aterm.ATerm trm) {
    return fromTerm(trm,idConv);
  }

  /**
   * Returns a expression.types.RightOp from a String without any conversion
   *
   * @param s String containing the ATerm
   * @return the term from the String
   */
  public static expression.types.RightOp fromString(String s) {
    return fromTerm(atermFactory.parse(s),idConv);
  }

  /**
   * Returns a expression.types.RightOp from a Stream without any conversion
   *
   * @param stream stream containing the ATerm
   * @return the term from the Stream
   * @throws java.io.IOException if a problem occurs with the stream
   */
  public static expression.types.RightOp fromStream(java.io.InputStream stream) throws java.io.IOException {
    return fromTerm(atermFactory.readFromFile(stream),idConv);
  }

  /**
   * Apply a conversion on the ATerm and returns a expression.types.RightOp
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATermConverter used to convert the ATerm
   * @return the Gom term
   * @throws IllegalArgumentException
   */
  public static expression.types.RightOp fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    aterm.ATerm convertedTerm = atConv.convert(trm);
    expression.types.RightOp tmp;
    java.util.ArrayList<expression.types.RightOp> results = new java.util.ArrayList<expression.types.RightOp>();

    tmp = expression.types.rightop.Factorial.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = expression.types.rightop.Power.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    switch(results.size()) {
      case 0:
        throw new IllegalArgumentException(trm + " is not a RightOp");
      case 1:
        return results.get(0);
      default:
        java.util.logging.Logger.getLogger("RightOp").log(java.util.logging.Level.WARNING,"There were many possibilities ({0}) in {1} but the first one was chosen: {2}",new Object[] {results.toString(), "expression.types.RightOp", results.get(0).toString()});
        return results.get(0);
    }
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a expression.types.RightOp from it
   *
   * @param s String containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static expression.types.RightOp fromString(String s, tom.library.utils.ATermConverter atConv) {
    return fromTerm(atermFactory.parse(s),atConv);
  }

  /**
   * Apply a conversion on the ATerm contained in the Stream and returns a expression.types.RightOp from it
   *
   * @param stream stream containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static expression.types.RightOp fromStream(java.io.InputStream stream, tom.library.utils.ATermConverter atConv) throws java.io.IOException {
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
  public expression.types.RightOp reverse() {
    throw new IllegalArgumentException(
      "This "+this.getClass().getName()+" is not a list");
  }

  
  /*
   * Initialize the (cyclic) data-structure
   * in order to generate/enumerate terms
   */

  protected static tom.library.enumerator.Enumeration<expression.types.RightOp> enumRightOp = null;
  public static final tom.library.enumerator.Enumeration<expression.types.RightOp> tmpenumRightOp = new tom.library.enumerator.Enumeration<expression.types.RightOp>((tom.library.enumerator.LazyList<tom.library.enumerator.Finite<expression.types.RightOp>>) null);

  public static tom.library.enumerator.Enumeration<expression.types.RightOp> getEnumeration() {
    if(enumRightOp == null) { 
      enumRightOp = expression.types.rightop.Factorial.funMake().apply(expression.types.RightOp.tmpenumRightOp)
        .plus(expression.types.rightop.Power.funMake().apply(expression.types.RightOp.tmpenumRightOp));


      tmpenumRightOp.p1 = new tom.library.enumerator.P1<tom.library.enumerator.LazyList<tom.library.enumerator.Finite<expression.types.RightOp>>>() {
        public tom.library.enumerator.LazyList<tom.library.enumerator.Finite<expression.types.RightOp>> _1() { return enumRightOp.parts(); }
      };

    }
    return enumRightOp;
  }

}
