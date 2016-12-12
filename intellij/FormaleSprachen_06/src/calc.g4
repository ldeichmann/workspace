grammar calc;

script: (block)*?;

block: variable (';'|';'NL|NL)
| expr (';'|';'NL|NL)
| clear (';'|';'NL|NL)
;

clear: 'clear';

add: '+';
sub: '-';
mul: '*';
div: '/';
pow: '^';
fac: '!';
lt : '<';
gt : '>';

variable: var EQ expr;

expr: val_or_var
|'(' expr ')'
|expr fac
|<assoc=right> expr pow expr
|expr (mul|div) expr
|expr (add|sub) expr
|expr (lt|gt) expr
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

NL:
[\n];

WS:
[ \t\r] -> skip;