
package expression.types;


public abstract class RigthOp extends expression.ExpressionAbstractType  {
  /**
   * Sole constructor.  (For invocation by subclass
   * constructors, typically implicit.)
   */
  protected RigthOp() {}



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
   * Returns a expression.types.RigthOp from an ATerm without any conversion
   *
   * @param trm ATerm to handle to retrieve a Gom term
   * @return the term from the ATerm
   */
  public static expression.types.RigthOp fromTerm(aterm.ATerm trm) {
    return fromTerm(trm,idConv);
  }

  /**
   * Returns a expression.types.RigthOp from a String without any conversion
   *
   * @param s String containing the ATerm
   * @return the term from the String
   */
  public static expression.types.RigthOp fromString(String s) {
    return fromTerm(atermFactory.parse(s),idConv);
  }

  /**
   * Returns a expression.types.RigthOp from a Stream without any conversion
   *
   * @param stream stream containing the ATerm
   * @return the term from the Stream
   * @throws java.io.IOException if a problem occurs with the stream
   */
  public static expression.types.RigthOp fromStream(java.io.InputStream stream) throws java.io.IOException {
    return fromTerm(atermFactory.readFromFile(stream),idConv);
  }

  /**
   * Apply a conversion on the ATerm and returns a expression.types.RigthOp
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATermConverter used to convert the ATerm
   * @return the Gom term
   * @throws IllegalArgumentException
   */
  public static expression.types.RigthOp fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    aterm.ATerm convertedTerm = atConv.convert(trm);
    expression.types.RigthOp tmp;
    java.util.ArrayList<expression.types.RigthOp> results = new java.util.ArrayList<expression.types.RigthOp>();

    tmp = expression.types.rigthop.Factorial.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    tmp = expression.types.rigthop.Power.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    switch(results.size()) {
      case 0:
        throw new IllegalArgumentException(trm + " is not a RigthOp");
      case 1:
        return results.get(0);
      default:
        java.util.logging.Logger.getLogger("RigthOp").log(java.util.logging.Level.WARNING,"There were many possibilities ({0}) in {1} but the first one was chosen: {2}",new Object[] {results.toString(), "expression.types.RigthOp", results.get(0).toString()});
        return results.get(0);
    }
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a expression.types.RigthOp from it
   *
   * @param s String containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static expression.types.RigthOp fromString(String s, tom.library.utils.ATermConverter atConv) {
    return fromTerm(atermFactory.parse(s),atConv);
  }

  /**
   * Apply a conversion on the ATerm contained in the Stream and returns a expression.types.RigthOp from it
   *
   * @param stream stream containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static expression.types.RigthOp fromStream(java.io.InputStream stream, tom.library.utils.ATermConverter atConv) throws java.io.IOException {
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
  public expression.types.RigthOp reverse() {
    throw new IllegalArgumentException(
      "This "+this.getClass().getName()+" is not a list");
  }

  
  /*
   * Initialize the (cyclic) data-structure
   * in order to generate/enumerate terms
   */

  protected static tom.library.enumerator.Enumeration<expression.types.RigthOp> enumRigthOp = null;
  public static final tom.library.enumerator.Enumeration<expression.types.RigthOp> tmpenumRigthOp = new tom.library.enumerator.Enumeration<expression.types.RigthOp>((tom.library.enumerator.LazyList<tom.library.enumerator.Finite<expression.types.RigthOp>>) null);

  public static tom.library.enumerator.Enumeration<expression.types.RigthOp> getEnumeration() {
    if(enumRigthOp == null) { 
      enumRigthOp = expression.types.rigthop.Factorial.funMake().apply(expression.types.RigthOp.tmpenumRigthOp)
        .plus(expression.types.rigthop.Power.funMake().apply(expression.types.RigthOp.tmpenumRigthOp));


      tmpenumRigthOp.p1 = new tom.library.enumerator.P1<tom.library.enumerator.LazyList<tom.library.enumerator.Finite<expression.types.RigthOp>>>() {
        public tom.library.enumerator.LazyList<tom.library.enumerator.Finite<expression.types.RigthOp>> _1() { return enumRigthOp.parts(); }
      };

    }
    return enumRigthOp;
  }

}
