package tomdragon.model;

/**
 * Cette classe contient la liste des sous Expressions de la
 * formule initiale avec leurs ids et la liste des règles
 * à appliquer pour chaque id. La classe contient des méthodes
 * pour manipuler ces listes.
 * @param ids : contient la liste des sous-Exprs et leurs id
 * @param rules : contient la liste de chaque Expr attachée à ses règles
 * @author Fortunat
 *
 */

import tomdragon.model.expr.term.types.*;
import tom.library.sl.*;
import java.util.*;

public  class Expr {

  %include { sl.tom }

    public Expr () {

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
          Eq(l1*,l2*) -> { return `Eq(`l1*,`l2*); }
          Plus(v@val(_)) -> { return `v; }
          Mult(v@val(_)) -> { return `v; }
        }
      }

      %strategy AutoEvalExpr() extends Identity() {
        visit Expr {

          Plus(l1*,Nombre(x),l2*,Nombre(y),l3*) -> { return `Plus(l1*,l2*,l3*,Nombre(x + y)); }
          Mult(l1*,Nombre(x),l2*,Nombre(y),l3*) -> { return `Mult(l1*,l2*,l3*,Nombre(x * y)); }
          Eq(l1*,l2*) -> { return `Eq(`l1*,`l2*); }
          Plus(v@val(_)) -> { return `v; }
          Mult(v@val(_)) -> { return `v; }
        }
      }

}
