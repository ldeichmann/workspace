lexer grammar HalsteadLexer;


IGNORE:
COMMENTS
|INCLUDE
|WS
|')'|'}'|']'
|':'|'do'
;

OPERATOR:
SCSPEC|TYPE_QUAL|RESERVED|OPERATORS;

OPERAND:
IDENTIFIER|TYPESPEC|NUMBER|STRING|CHAR;

TYPESPEC:
'bool'|'char'|'double'|'float'|'int'|'long'|'short'|'signed'|'unsigned'|'void';

SCSPEC:
'auto'|'extern'|'inline'|'register'|'static'|'typedef'|'virtual'|'mtuable';

TYPE_QUAL:
'const'|'friend'|'volatile';

RESERVED:
'asm'|'break'|'case'|'class'|'continue'|'default'|'delete'|'while('|'else'|'enum'|'for('
|'goto'|'if('|'new'|'operator'|'private'|'protected'|'public'|'return'
|'sizeof'|'struct'|'switch('|'this'|'union'|'namespace'|'using'|'try'|'catch'
|'throw'|'const_cast'|'static_cast'|'dynamic_cast'|'reiznterpret_cast'
|'typeid'|'template'|'explicit'|'true'|'false'|'typename';

OPERATORS:
'!'|'!='|'%'|'%='|'&'|'&&'|'&='|'('|'*'|'*='
|'+'|'++'|'+='|','|'-'|'--'|'-='|'->'|'...'|'/'
|'/='|'::'|'<'|'<<'|'<<='|'<='|'=='|'>'|'>='|'>>'
|'>>='|'?'|'['|'^'|'^='|'{'|'||'|'='|'~'|';';

INT:
[0-9]+;

NUMBER:
INT['.'INT]?;

IDENTIFIER:
[a-zA-Z_] [a-zA-Z0-9_]*;

STRING:
'"'.*?'"';

CHAR:
['] .*? ['];

INCLUDE:
'#include' [' ']+ '<' IDENTIFIER '.h>';

WS:
[ \t\n\r];

COMMENTS:
'/*'.*?'*/' // ignore comments
|'//'.*?;
