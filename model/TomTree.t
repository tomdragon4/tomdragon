package tomdragon.model;

/**
 * Cette classe contient la liste des sous Expressions de la
 * formule initiale avec leurs ids et la liste des règles
 * à appliquer pour chaque id. La classe contient des méthodes
 * pour manipuler ces listes.
 * @param ids : contient la liste des sous-Exprs et leurs id
 * @param rules : contient la liste de chaque Expr attachée à ses règles
 * @param definedRules : contient la liste des regles définies dans le jeu
 *
 */

import algebraic.logic.types.*;
import tomdragon.model.expression.types.*;
import tom.library.sl.*;
import java.util.*;

public  class TomTree {

  %include { sl.tom }
  %include { expression/Expression.tom }

  private HashMap<String, Expr> ids = new HashMap<>();
  private HashMap<String,ArrayList<Triplet<Expr, Expr, String>>> rules = new HashMap<>();
  private HashMap<String,ArrayList<Triplet<Expr, Expr, String>>> definedRules = new HashMap<>();
  //public RulesConfiguration config;
  private int maxId = 0;
  private String math = "";

    public TomTree (Expr exprIni, Expr victory, String rulesFilePath) {
      RuleParser.readRulesFile(rulesFilePath, definedRules);
    	this.generSousExpr(exprIni, ids);
    	this.generAllRules(id, rules, definedRules);
			this.addExprToIds("100", victory);
    }

     /**
  	 * Clear the Exprs hashmap
  	 */

  	public void cleanIds(){
  		ids.clear();
  	}

  	public void cleanRules(){
  		rules.clear();
  	}

  	public boolean idIsIn(String id){
  		return ids.containsKey(id);
  	}

  	public boolean ruleIsIn(String exprid, int ruleid){
  		if( rules.containsKey(exprid) && rules.get(exprid).size() > ruleid)
  					return true;
  		return false;
  	}

  	public Expr getExprById(String id){
      if (idIsIn(idExpr))
  		  return ids.get(id);
  	}

    public Expr getRoot () {
      return getExprById (0);
    }

    public Expr getVictory () {
      return getExprById (100);
    }

  	public void addExprToIds(String id,Expr expr){
  		ids.put(id, Expr);
  	}

  	public Set<String> getExprIdsKeys(){
  		return ids.keySet();
  	}

  	public ArrayList<Triplet<Expr, Expr, String>> getAnExprRulesById(String idExpr){
      if (idIsIn(idExpr))
  		  return rules.get(idExpr);
      else
        return null;
  	}
/*
    public Rule getAnExprRuleById(String exprid, int idrule){
  		if(idIsIn(exprid) && ruleIsIn(exprid, idrule))
  			return rules.get(exprid).get(idrule).first;
  		return null;
  	}
*/
  	public void addRules(String id, ArrayList<Triplet<Expr, Expr, String>> liste){
  		rules.put(id, liste);
  	}

/*
  	public Rule getRuleById(String exprid, int idrule){
  		if(idIsIn(exprid) && ruleIsIn(exprid, idrule))
  			return rules.get(exprid).get(idrule).first;
  		return null;
  	}
    */

  	public Set<String> getKeyRules(){
  		return rules.keySet();
  	}

  	/**
  	 * Cette méthode prend en parametre une expression
  	 * puis produit la liste de toutes les sous expressions
  	 * avec leurs ids qu'elle renvoit ensuite
  	 * @param expr : expression dont on souhaite morceler
  	 * @return la liste des sous expressions
  	 */

/*
  	public static void generSousExpr (Expr expr, HashMap<String, Expr> sousExprList) {
  		//HashMap <String, Expr> sousExprList = new HashMap<>();
      //int nbSsExpr=0;
      //++maxId;
  		//sousExprList.add(++maxId, expr);
  		//partie Tom
      %match(expr) {
        Nombre(a) -> {
          sousExprList.add("0" + maxId++, `Nombre(a));
          math = "\\cssId{exp" + maxId + "}{" + ExprParser.exprToAlgebra(`Nombre(a)) + "}";
        }

        Litteral(x) -> {
          sousExprList.add("0" + maxId++, `Litteral(x));
          math = "\\cssId{exp" + maxId + "}{" + ExprParser.exprToAlgebra(`Litteral(x)) + "}";
        }

        Plus(Nombre(a)) -> {
          sousExprList.add("0" + maxId++, `Nombre(a));
          math = "\\cssId{exp" + maxId + "}{" + ExprParser.exprToAlgebra(`Nombre(a)) + "}";
        }
        Plus(Litteral(a)) -> {
          sousExprList.add("0" + maxId++, `Litteral(a));
          math = "\\cssId{exp" + maxId + "}{" + ExprParser.exprToAlgebra(`Litteral(a)) + "}";
        }
        Plus(x, y) -> {
          sousExprList.add("0" + maxId++, `Plus(x, y));
          math = "\\cssId{exp" + maxId + "}{" + generSousExpr(x) + "+" + generSousExpr(y) + "}";
          //generSousExpr(x);
          //generSousExpr(y);
        }
        Plus(x, y, l1*) -> {
          sousExprList.add("0" + maxId++, `Plus(x, Plus(y, l1*)));
          math = "\\cssId{exp" + maxId + "}{" + generSousExpr(x) + "+" + generSousExpr(y) + "}";
          //generSousExpr(x);
          //generSousExpr(y);
          generSousExpr(`Plus(Plus(x,y), l1*));
        }

        Mult(Nombre(a)) -> {
          sousExprList.add(++maxId+"", `Nombre(a));
          math = "\\cssId{exp" + maxId + "}{" + ExprParser.exprToAlgebra(`Nombre(a)) + "}";
        }
        Mult(Litteral(a)) -> {
          sousExprList.add(++maxId+"", `Litteral(a));
          math = "\\cssId{exp" + maxId + "}{" + ExprParser.exprToAlgebra(`Litteral(a)) + "}";
        }
        Mult(x, y) -> {
          sousExprList.add(++maxId+"", `Mult(x, y));
          math = "\\cssId{exp" + maxId + "}{" + generSousExpr(x) + "*" + generSousExpr(y) + "}";
          //generSousExpr(x);
          //generSousExpr(y);
        }
        Mult(x, y, l1*) -> {
          sousExprList.add(++maxId+"", `Mult(x, Mult(y, l1*)));
          math = "\\cssId{exp" + maxId + "}{" + generSousExpr(x) + "*" + generSousExpr(y) + "}";
          //generSousExpr(x);
          //generSousExpr(y);
          generSousExpr(`Mult(Mult(x,y), l1*));
        }

        Div(x, y) -> {
          sousExprList.add(++maxId+"", `Div(x, y));
          math = "\\cssId{exp" + maxId + "}{" + generSousExpr(x) + "\\over" + generSousExpr(y) + "}";
          //generSousExpr(x);
          //generSousExpr(y);
        }

        Eq(x, y) -> {
          //Expr result_x = (Expr) `InnermostId(generRules()).visit(x);
          //Expr result_y = (Expr) `InnermostId(generRules()).visit(y);
          sousExprList.add(++maxId+"", `Eq(x, y));
          math = "\\cssId{exp" + maxId + "}{" + generSousExpr(x) + "=" + generSousExpr(y) + "}";
          //generSousExpr(x);
          //generSousExpr(y);
        }

        Parenthesis(x) -> {
          //Expr result_x = (Expr) `InnermostId(generRules()).visit(x);
          sousExprList.add(++maxId+"", `Parenthesis(x));
          math = "\\cssId{exp" + maxId + "}{(" + generSousExpr(x) + ")}";
        }
      }

  	}
*/

    public static void generSousExpr (Expr expr, HashMap<String, Expr> sousExprList) {

      %match(expr) {
        Nombre(a) -> {
          sousExprList.add("0" + maxId++, `Nombre(a));
          math = "\\cssId{exp0" + maxId + "}{" + ExprParser.exprToAlgebra(`Nombre(a)) + "}";
        }

        Litteral(x) -> {
          sousExprList.add("0" + maxId++, `Litteral(x));
          math = "\\cssId{exp0" + maxId + "}{" + ExprParser.exprToAlgebra(`Litteral(x)) + "}";
        }

        BinOpExp(x, z, y) -> {
          sousExprList.add("0" + maxId++, `BinOpExp(x, z, y));
          //prendre le signe de l'operateur
          math = "\\cssId{exp0" + maxId + "}{" + generSousExpr(x) + "+" + generSousExpr(y) + "}";
        }

        RightOpExp(x, z) -> {
          sousExprList.add("0" + maxId++, `RightOpExp(x, z));
          //prendre le signe de l'operateur
          math = "\\cssId{exp0" + maxId + "}{" + z + generSousExpr(x) + "}";
        }

        LeftOpExp(z, x) -> {
          sousExprList.add("0" + maxId++, `LeftOpExp(z, x));
          //prendre le signe de l'operateur
          math = "\\cssId{exp0" + maxId + "}{" + z + generSousExpr(x) + "}";
        }

        ParentOp(z, x) -> {
          sousExprList.add("0" + maxId++, `ParentOp(z, x));
          //prendre le signe de l'operateur
          math = "\\cssId{exp0" + maxId + "}{(" + z + generSousExpr(x) + ")}";
        }
      }

  	}



  	/**
  	 * cette méthode met à jour la liste des sous expressions
  	 * de l'expression initiale. il faut noter que l'expression
  	 * initiale fait elle meme partie de cette liste
  	 * @param ids
  	 */

  	public void generAllExpr (Expr expr) {

  		this.ids = (HashMap) this.generSousExpr(expr).clone();
  	}


      /**
      * EvalExpr est un système de réécriture qui simplifie les Exprs.
      * Il est destiné à être appliqué sur n'importe quelle sous-Expr d'un plus grand,
      * pas seulement dans la tête.
      *
      * Utilisation de EvalExpr
      * Nous choisissons d'appliquer le système de réécriture de la manière la plus interne
      * (Appel par valeur). La stratégie InnermostId fait le
      * travail et s'arrête lorsqu'un point de repère est atteint.
      * Etant donne que la méthode de visite des stratégies renvoie un Visitable,
      * nous devons caster le résultat.
      * Soit : e = 2 + x + 3*4 + y + 5
      * Expr e = `plus(Nombre(2),Litteral("x"),mult(Nombre(3),val(4)),Litteral("y"),Nombre(5));
      * Expr res = (Expr) `InnermostId(EvalExpr()).visit(e);
      * res = x + y + 19
      */

    %strategy EvalExpr() extends Identity() {
      visit Expr {

        Plus(l1*,Nombre(x),l2*,Nombre(y),l3*) -> { return `Plus(l1*,l2*,l3*,Nombre(x + y)); }
        Mult(l1*,Nombre(x),l2*,Nombre(y),l3*) -> { return `Mult(l1*,l2*,l3*,Nombre(x * y)); }
        //Eq(l1*,l2*) -> { return `Eq(`l1*,`l2*); }
        Plus(v@Nombre(_)) -> { return `v; }
        Plus(v@Litteral(_)) -> { return `v; }
        Mult(v@Nombre(_)) -> { return `v; }
        Mult(v@Litteral(_)) -> { return `v; }
      }

    }

    %strategy CompareExprStruct(Expr entree, Expr sortie) extends Identity() {
      visit Compare {
        entree -> return sortie;
      }
    }


    /**
    * Cette méthode prend en paramètre une expression
    * et produit la liste de ses variantes accompagné de
    * leurs ids puis renvoie cette liste
    * @param expr
    * @return
    */

    public void generRules (Expr expr, ArrayList<<Triplet<Expr, Expr, String>> variantes, HashMap<String,ArrayList<Triplet<Expr, Expr, String>>> definedRules) {
    	//ArrayList<Pair<Expr, String>> variantes = new ArrayList<>();
    	//partie Tom

      /*
      %match(expr) {
        Nombre(a) -> {variantes.add(new Triplet(expr, `Parenthesis(Nombre(a)), "contextMenu"));}
        Litteral(x) -> {sousExprList.add(new Triplet(expr, `Parenthesis(Litteral(x)), "contextMenu"));}

        Plus(x, y) -> {sousExprList.add(new Triplet(expr, `Plus(y, x), "contextMenu"));}

        Mult(x, y) -> {sousExprList.add(new Triplet(expr, `Mult(y, x), "contextMenu"));}

        Eq(x, y) -> {sousExprList.add(new Triplet(expr, `Eq(x, y), "contextMenu"));}
        Parenthesis(x) -> {sousExprList.add(new Triplet(expr, `Parenthesis(x), "contextMenu"));}
      }
      */

      ArrayList<Triplet<Expr, Expr, String>> generatedRules = new ArrayList<Triplet<Expr, Expr, String>>();
  		Set<String> rulesContextKeyList = definedRules.keySet();
  		Iterator<String> iterateur = rulesContextKeyList.iterator();
  		String key;
      Set<String> rulesKeyList;
      Iterator<String> iterateur2;
      String key2;
      Triplet rule;
  		while(iterateur.hasNext()) {
  			key = iterateur.next();
        rulesKeyList = definedRules.get(key).keySet();
        iterateur2 = rulesKeyList.iterator();
        while (iterateur2.hasNext()) {
          key2 = iterateur.next();
          rule = definedRules.get(key).get(key2);
          variantes.add(new Triplet(expr, `TopDown(CompareExprStruct(rule.getFirst, rule.getSecond)).visit(expr), rule.getTree));
        }
  		}

  		//return variantes;
  	}

  	/**
  	 * cette méthode met à jour la liste des regles associées
  	 * à chaque expression pris dans la liste ids
  	 */

  	public void generAllRules (HashMap<String, Expr> expressions, HashMap<String,ArrayList<Triplet<Expr, Expr, String>>> rules, HashMap<String,ArrayList<Triplet<Expr, Expr, String>>> definedRules) {
      ArrayList<Triplet<Expr, Expr, String>> generatedRules = new ArrayList<Triplet<Expr, Expr, String>>();
  		Set<String> exprKeyList = expressions.keySet();
  		Iterator<String> iterateur = exprKeyList.iterator();
  		String key;
  		while(iterateur.hasNext()) {
  			key = iterateur.next();
  			this.generRules(expressions.get(key), generatedRules, definedRules);
  			this.addRule(key, new ArrayList<Triplet<Expr, Expr, String>>(generatedRules));
        generatedRules.clean();
  		}
  	}

  	//*
  	public TomTree cloneTomTree () {
  		/*TomTree clone = new TomTree(globalRules);
  		clone.setRoot(this.root.cloneExpr());
  		clone.setVictory(this.victory.cloneExpr());
  		return clone;*/
  	}
  	//*/

  	public boolean victoryTest(){
  		return getExprById("0") == getExprById("100");

  	}

    public String generAllTreeIdJason () {
      String jason;
    }
}
