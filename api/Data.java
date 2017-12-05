package tomdragon.api;

import java.util.ArrayList;
import java.util.HashMap;

import tomdragon.latexParser.GraphicExpressionFactory;
import tomdragon.latexParser.LatexConfiguration;
import tomdragon.model.Configuration;
import tomdragon.model.Expression;
import tomdragon.model.Pair;
import tomdragon.model.RulesConfiguration;

import tomdragon.ruleParser.RuleParser;

import algebraic.logic.types.*;
import tomdragon.model.term.types.*;
import tom.library.sl.*;


/**
 * Classe regroupant toutes les données du serveur.
 * @author malo
 *
 */
public class Data {

	/**
	 * Permet de savoir si l'initialisation du serveur a été faite.
	 */
	private static boolean init = false;

	/**
	 *  Configuration graphique du serveur.
	 */
	//-----------------------private static GraphicExpressionFactory config = null; // A revoir

	/**
	 * Liste de sessions indéxées par leurs ids.
	 */
	private static HashMap<String, Session> sessions = new HashMap<>();

	/**
	 * Liste des expressions jouables et les résultat a obtenir pour finir la session de jeu.
	 */
	private static ArrayList<Pair<Expr,Expr>> expressionJouable = new ArrayList();


	/**
	 * Initialisation de la configuration graphique et lecture des expressions jouables
	 */
	public static void initialize(){
		//------------------config = new LatexConfiguration();
		//------------------Configuration.init(config);
		ExprParser.readExpressionsJouables("config/formula.cfg", expressionJouable); //-----------------------remplacer cette methode par la nouvelle
		init = true;
	}

	/**
	 * Créé une nouvelle session.
	 * @param customRules booleen : si oui ou non on utilise les règle custom.
	 * @param indice de l'expression jouable.
	 * @return id de la session.
	 */
	public static String addSession(Boolean customRules, int indice){
		Session session;
		if(!init){
			initialize();
		}
		session = new Session(customRules, getExpression(indice), getExpressionVictory(indice));
		sessions.put(session.gameId.toString(), session);
		return session.gameId.toString();
	}

	/**
	 * @return Nombre d'expressions jouables.
	 */
	public static int getNbExpressions(){
		if(!init){
			initialize();
		}
		return expressionJouable.size();
	}

	/**
	 * @return L'expression jouable d'indice i.
	 */
	public static Expr getExpression(int i){
		if(!init){
			initialize();
		}
		if(i < expressionJouable.size())
			return expressionJouable.get(i).first;
		return expressionJouable.get(0).first;
	}

	/**
	 * @return L'expression a atteindre pour finir la session de jeu lorsque l'on
	 * a commencé avec l'expression jouable d'indice i.
	 */
	public static Expr getExpressionVictory(int i){
		if(!init){
			initialize();
		}
		if(i < expressionJouable.size())
			return expressionJouable.get(i).second;
		return expressionJouable.get(0).second;
	}

	/**
	 * Ferme la session si elle existe.
	 * @param id  : id de la session id à fermer.
	 */
	public static void closeSession(String id){
		if(sessions.containsKey(id))
			sessions.remove(id);
	}
	/**
	 * @param id : id de la session à retourner.
	 * @return la session
	 */
	public static Session getSession(String id){
		if(!init){
			initialize();
		}
		return sessions.get(id);
	}

	/**
	 * Renvoit true si la session existe
	 * @param id : id de la session
	 * @return booleen
	 */
	public static boolean isIn(String id){
		if(!init){
			initialize();
		}
		return sessions.containsKey(id);
	}

	/**
	 * @return la liste des expressions jouables et leurs resultats
	 */
	public static ArrayList<Pair<Expr,Expr>> getExpressionsList(){
		if(!init){
			initialize();
		}
		return expressionJouable;
	}
}
