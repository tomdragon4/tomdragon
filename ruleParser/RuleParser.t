package tomdragon.ruleparse;

import java.util.ArrayList;
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

import tomdragon.model.*;

import algebraic.logic.types.*;
import tomdragon.model.term.types.*;
import tom.library.sl.*;


public class RuleParser {
  public RuleParser () {

  }

  public static int readRulesFile (String filePath, HashMap<String,ArrayList<Triplet<Expr, Expr, String>>> listeRegles) {
    Charset charset = Charset.forName("UTF_8");
    ArrayList<Triplet<Expr, Expr, String>> listeContext = new ArrayList<>();
    ArrayList<Triplet<Expr, Expr, String>> listeDragNDrop = new ArrayList<>();
    int nbRule = 0;

    String files [] = filePath.split("+");

    for (int i=0; i<files.length; ++i) {
      try (BufferedReader reader = Files.newBufferedReader(file[i], charset)) {
        String line = null;
        Triplet rule;
        while ((line = reader.readLine()) != null) {
          //System.out.println(line); //----------------- operation de conversion vers tom
          rule = algebraToRule(line);
          if (rule.getThird.equals("contextMenu"))
          listeContext.add(new Triplet(rule.getFirst, rule.getSecond, rule.getThird));
          else
          listeDragNDrop.add(new Triplet(rule.getFirst, rule.getSecond, rule.getThird));
          nbRule++;
        }
        reader.close();
    } catch (IOException x) {
      System.err.format("IOException: %s%n", x);
      return -1;
    }
  }
  listeRegles.add("contextMenu", listeContext);
  listeRegles.add("drag_and_drop", listeContext);
  return nbRule;
}

  public static int writeRulesFile (String filePath, Triplet<Expr, Expr, String> rule) {
    Charset charset = Charset.forName("UTF_8");
    int nbWrite = 0;
    String s = ruleToAlgrebra (rule);
    try (BufferedWriter writer = Files.newBufferedWriter(filePath, charset)) {
      writer.write(s, 0, s.length());
      writer.close();
    } catch (IOException x) {
      System.err.format("IOException: %s%n", x);
    }
  }

  public static String ruleToAlgebra (Triplet<Expr, Expr, String> rule) {
    return ExprParser.exprToAlgebra(rule.getFirst) + "=(§" + ExprParser.exprToAlgebra(rule.getThird) + ")=>" + ExprParser.exprToAlgebra(rule.getSecond);
  }

  public static Triplet<Expr, Expr, String> algebraToRule (String rule) {
    rule = rule.replaceAll("\\s+","");
    String paths [] = rule.split("=");
    String even;
    return new Triplet( , , paths[1].substring(2, paths[1].length-2));
  }

  %strategy EvalExpr() extends Identity() {
    visit Expr {

      Plus(l1*,Nombre(x),l2*,Nombre(y),l3*) -> { return `Plus(l1*,l2*,l3*,Nombre(x + y)); }
      Mult(l1*,Nombre(x),l2*,Nombre(y),l3*) -> { return `Mult(l1*,l2*,l3*,Nombre(x * y)); }
      Eq(l1*,l2*) -> { return `Eq(`l1*,`l2*); }
      Plus(v@val(_)) -> { return `v; }
      Mult(v@val(_)) -> { return `v; }
    }
  }

}
