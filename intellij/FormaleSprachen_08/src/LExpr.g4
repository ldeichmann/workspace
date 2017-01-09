grammar LExpr;

s : e ;

e : '(' e ')'               # Braces
  | <assoc=right> e POW e   # Pow
  | e op=(MUL|DIV) e 		# MulDiv
  | e op=(ADD|SUB) e 		# AddSub
  | e op=(LT|GT) e          # Comp
  | INT        	            # Int
  ;

POW : '^' ;
MUL : '*' ;
ADD : '+' ;
SUB : '-' ;
DIV : '/' ;
LT  : '<' ;
GT  : '>' ;
INT : [0-9]+ ;
WS : [ \t\n]+ -> skip ;