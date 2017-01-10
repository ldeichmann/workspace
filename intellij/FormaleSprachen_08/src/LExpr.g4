grammar LExpr;

s : e ;

e : '(' e ')'               # Braces
  | <assoc=right> e POW e   # Pow
  | e op=(MUL|DIV) e 		# MulDiv
  | e op=(ADD|SUB) e 		# AddSub
  | e op=(LT|GT) e          # Comp
  | INT        	            # Int
  | ID                      # Variable
  | ID EQ e                 # Assignment
  ;

POW : '^' ;
MUL : '*' ;
ADD : '+' ;
SUB : '-' ;
DIV : '/' ;
LT  : '<' ;
GT  : '>' ;
EQ  : '=' ;
INT : [0-9]+ ;
ID  : [a-zA-Z]+ ;
WS : [ \t\n]+ -> skip ;