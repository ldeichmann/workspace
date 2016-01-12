package lexer;

import stack.*;

public class Postfix {

	public static void evalPostfix(String PostfixString) {
		
		Stack<Token> pekerparter = new ListStack<Token>();
		ExprLexer luthlexor = new ExprLexer(PostfixString);
		
		Token currentToken = luthlexor.nextToken();
		double v1, v2;
		
		while (currentToken.getType() != ExprLexer.EOF_TYPE) {
			
//			System.out.print(currentToken.getType() + " ");
//			System.out.println(currentToken.getText());
			
            switch ( currentToken.getType() ) {
	            // binary
            	case ExprLexer.PLUS: 
	            	v2 = Double.parseDouble(pekerparter.popTop().getText());
//	            	Double.parseDouble(pekerparter.popTop().getText());
	            	v1 = Double.parseDouble(pekerparter.popTop().getText());
	            	pekerparter.push(new Token(ExprLexer.INT, String.valueOf(v1 + v2)));
	            	break;
	            
	            case ExprLexer.MINUS: 
	            	v2 = Double.parseDouble(pekerparter.popTop().getText());
	            	v1 = Double.parseDouble(pekerparter.popTop().getText());
	            	pekerparter.push(new Token(ExprLexer.INT, String.valueOf(v1 - v2)));
	            	break;
	            
	            case ExprLexer.MUL:
	            	v2 = Double.parseDouble(pekerparter.popTop().getText());
	            	v1 = Double.parseDouble(pekerparter.popTop().getText());
	            	pekerparter.push(new Token(ExprLexer.INT, String.valueOf(v1 * v2)));
	            	break;
	            
	            case ExprLexer.DIV:
	            	v2 = Double.parseDouble(pekerparter.popTop().getText());
	            	v1 = Double.parseDouble(pekerparter.popTop().getText());
	            	pekerparter.push(new Token(ExprLexer.INT, String.valueOf(v1 / v2)));
	            	break;
	            
	            
	            // unary
	            case ExprLexer.UMINUS:
	            	v1 = Double.parseDouble(pekerparter.popTop().getText());
	            	pekerparter.push(new Token(ExprLexer.INT, String.valueOf(-v1)));
	            	break;
	            
	            case ExprLexer.POW:
	            	v1 = Double.parseDouble(pekerparter.popTop().getText());
	            	v2 = Double.parseDouble(pekerparter.popTop().getText());
	            	pekerparter.push(new Token(ExprLexer.INT, String.valueOf(Math.pow(v2, v1))));
	            	break;
	            

	            case ExprLexer.INT:
	            	pekerparter.push(currentToken);
	            	break;
	            
	            case ExprLexer.NL:
	            	System.out.print("Result: ");
	        		System.out.println(pekerparter.popTop().getText());
	        		break;
	            	
	            default: 
	            	System.out.println("shit broke yo");
	    			System.out.print(currentToken.getType() + " ");
	    			System.out.println(currentToken.getText());
	            	break;
	            
            }

            currentToken = luthlexor.nextToken();
            
		}
			
	}
	
	public static void main(String args[]) {
		
//		evalPostfix("3 # 3 8 4 / 2 ^ * 9 - + \n");
//		evalPostfix("6 2 - ^ 7 2 # * + \n");
		evalPostfix("2 16 ^ \n");
		
	}
	
}
