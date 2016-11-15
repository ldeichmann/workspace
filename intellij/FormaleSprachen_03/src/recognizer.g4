grammar recognizer;

script: (block)*?;

block: variable ';'
| expr ';'
| comparison ';'
;

variable: var EQ expr;

comparison: expr lt expr
|expr gt expr;

add: '+';
sub: '-';
mul: '*';
div: '/';
pow: '^';
fac: '!';
lt : '<';
gt : '>';

expr: val_or_var
|'(' expr ')'
|expr fac
|<assoc=right> expr pow expr
|expr mul expr
|expr div expr
|expr add expr
|expr sub expr
;

val_or_var: val | var;

val: INT;
var: ID;

INT:
[0-9]+;

EQ:
'=';

ID:
[a-zA-Z]+;

WS:
[ \t\r\n] -> skip;