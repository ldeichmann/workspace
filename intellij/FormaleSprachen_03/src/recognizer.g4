grammar recognizer;

expr: INT | ID
|'(' expr ')'
|expr FAC
|<assoc=right> expr POW expr
|expr MUL expr
|expr DIV expr
|expr ADD expr
|expr SUB expr
|expr LT expr
|expr GT expr
|ID EQ expr
;

INT:
[0-9]+;

ADD:
'+';

SUB:
'-';

MUL:
'*';

DIV:
'/';

POW:
'^';

FAC:
'!';

LT:
'<';

GT:
'>';

EQ:
'=';

ID:
[a-zA-Z]+;

WS:
[ \t\r\n] -> skip;