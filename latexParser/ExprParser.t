package tomdragon.latexparser;

/**
 * Cette classe est chargée de parser les expressions
 * algébriques en expressions du langage tom et
 * vice-versa
 * @author fortunat
 *
 */

import java.util.ArrayList;
import libreDragon.model.*;
import java.io.InputStream;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import algebraic.logic.types.*;
import tomdragon.model.term.types.*;

public class ExprParser {

  %include { sl.tom }
  %include { term/Term.tom }

  public static int readExpressionsJouables(String filePath, ArrayList<Pair<Expr,Expr>> liste ){
		BufferedReader lecteurAvecBuffer = null;
		String ligne,expression,resultat;
		int i, nbExpr=0;
		try {
			lecteurAvecBuffer = new BufferedReader(new FileReader(filePath));
		}
		catch(FileNotFoundException exc){
			System.out.println("Erreur d'ouverture");
      return -1;
		}
		try {
			while ((ligne = lecteurAvecBuffer.readLine()) != null){
				i = 0;
				while (i+2 < ligne.length() && ligne.substring(i,i+2).compareTo("=>") != 0){
					i++;
				}
				expression = ligne.substring(0, i-1);
				resultat = ligne.substring(i+2);
				liste.add(new Pair(algebraToExpr(expression), algebraToExpr(resultat)));
			}
      nbExpr++;
		}
		catch (IOException e){
			e.printStackTrace();
      return -1;
		}
    return nbExpr;
	}

  public static Expr algebraToExpr(String algebra) {
    Expr expr;
    return expr;
  }

  public static String exprToAlgebra(Expr expr) {
    %match(expr) {
      Nombre(a) -> {return a+"";}
      Litteral(x) -> {return x+"";}
      Plus(x) -> {return exprToAlgebra(`x) ;}
      Plus(x, l1*) -> {return exprToAlgebra(`x) + "+" + exprToAlgebra(l1*) ;}
      Mult(x) -> {return exprToAlgebra(`x) ;}
      Mult(x, l1*) -> {return exprToAlgebra(`x) + "*" + exprToAlgebra(l1*) ;}
      Eq(x, y) -> {return exprToAlgebra(`x)+"="+exprToAlgebra(`y) ;}
      Parenthesis(x) -> {return "("+exprToAlgebra(`x)+")" ;}
    }
  }

  public static String exprToAlgebraJson(Expr expr) {
    %match(expr) {
      Nombre(a) -> {return a+"";}
      Litteral(x) -> {return x+"";}
      Plus(x) -> {return exprToAlgebra(`x) ;}
      Plus(x, l1*) -> {return exprToAlgebra(`x) + "+" + exprToAlgebra(l1*) ;}
      Mult(x) -> {return exprToAlgebra(`x) ;}
      Mult(x, l1*) -> {return exprToAlgebra(`x) + "*" + exprToAlgebra(l1*) ;}
      Eq(x, y) -> {return exprToAlgebra(`x)+"="+exprToAlgebra(`y) ;}
      Parenthesis(x) -> {return "("+exprToAlgebra(`x)+")" ;}
    }
  }

  public static int exprFileToAlgebra () {
    
  }

}
