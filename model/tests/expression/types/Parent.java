
package expression.types;


public abstract class Parent extends expression.ExpressionAbstractType  {
  /**
   * Sole constructor.  (For invocation by subclass
   * constructors, typically implicit.)
   */
  protected Parent() {}



  /**
   * Returns true if the term is rooted by the symbol Parenthesis
   *
   * @return true if the term is rooted by the symbol Parenthesis
   */
  public boolean isParenthesis() {
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
   * Returns a expression.types.Parent from an ATerm without any conversion
   *
   * @param trm ATerm to handle to retrieve a Gom term
   * @return the term from the ATerm
   */
  public static expression.types.Parent fromTerm(aterm.ATerm trm) {
    return fromTerm(trm,idConv);
  }

  /**
   * Returns a expression.types.Parent from a String without any conversion
   *
   * @param s String containing the ATerm
   * @return the term from the String
   */
  public static expression.types.Parent fromString(String s) {
    return fromTerm(atermFactory.parse(s),idConv);
  }

  /**
   * Returns a expression.types.Parent from a Stream without any conversion
   *
   * @param stream stream containing the ATerm
   * @return the term from the Stream
   * @throws java.io.IOException if a problem occurs with the stream
   */
  public static expression.types.Parent fromStream(java.io.InputStream stream) throws java.io.IOException {
    return fromTerm(atermFactory.readFromFile(stream),idConv);
  }

  /**
   * Apply a conversion on the ATerm and returns a expression.types.Parent
   *
   * @param trm ATerm to convert into a Gom term
   * @param atConv ATermConverter used to convert the ATerm
   * @return the Gom term
   * @throws IllegalArgumentException
   */
  public static expression.types.Parent fromTerm(aterm.ATerm trm, tom.library.utils.ATermConverter atConv) {
    aterm.ATerm convertedTerm = atConv.convert(trm);
    expression.types.Parent tmp;
    java.util.ArrayList<expression.types.Parent> results = new java.util.ArrayList<expression.types.Parent>();

    tmp = expression.types.parent.Parenthesis.fromTerm(convertedTerm,atConv);
    if(tmp!=null) {
      results.add(tmp);
    }
    switch(results.size()) {
      case 0:
        throw new IllegalArgumentException(trm + " is not a Parent");
      case 1:
        return results.get(0);
      default:
        java.util.logging.Logger.getLogger("Parent").log(java.util.logging.Level.WARNING,"There were many possibilities ({0}) in {1} but the first one was chosen: {2}",new Object[] {results.toString(), "expression.types.Parent", results.get(0).toString()});
        return results.get(0);
    }
  }

  /**
   * Apply a conversion on the ATerm contained in the String and returns a expression.types.Parent from it
   *
   * @param s String containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static expression.types.Parent fromString(String s, tom.library.utils.ATermConverter atConv) {
    return fromTerm(atermFactory.parse(s),atConv);
  }

  /**
   * Apply a conversion on the ATerm contained in the Stream and returns a expression.types.Parent from it
   *
   * @param stream stream containing the ATerm
   * @param atConv ATerm Converter used to convert the ATerm
   * @return the Gom term
   */
  public static expression.types.Parent fromStream(java.io.InputStream stream, tom.library.utils.ATermConverter atConv) throws java.io.IOException {
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
  public expression.types.Parent reverse() {
    throw new IllegalArgumentException(
      "This "+this.getClass().getName()+" is not a list");
  }

  
  /*
   * Initialize the (cyclic) data-structure
   * in order to generate/enumerate terms
   */

  protected static tom.library.enumerator.Enumeration<expression.types.Parent> enumParent = null;
  public static final tom.library.enumerator.Enumeration<expression.types.Parent> tmpenumParent = new tom.library.enumerator.Enumeration<expression.types.Parent>((tom.library.enumerator.LazyList<tom.library.enumerator.Finite<expression.types.Parent>>) null);

  public static tom.library.enumerator.Enumeration<expression.types.Parent> getEnumeration() {
    if(enumParent == null) { 
      enumParent = expression.types.parent.Parenthesis.funMake().apply(expression.types.Parent.tmpenumParent);


      tmpenumParent.p1 = new tom.library.enumerator.P1<tom.library.enumerator.LazyList<tom.library.enumerator.Finite<expression.types.Parent>>>() {
        public tom.library.enumerator.LazyList<tom.library.enumerator.Finite<expression.types.Parent>> _1() { return enumParent.parts(); }
      };

    }
    return enumParent;
  }

}
