lexer grammar HalsteadLexer;

OPERAND:
'bool'|'char'|'double'|'float'|'int'|'long'|'short'|'signed'|'unsigned'|'void';

OPERATOR:
'auto'|'extern'|'inline'|'register'|'static'|'typedef'|'virtual'|'mtuable'
|'const'|'friend'|'volatile'
|'asm'|'break'|'case'|'class'|'continue'|'default'|'delete'|'while('|'else'|'enum'|'for('
|'goto'|'if('|'new'|'operator'|'private'|'protected'|'public'|'return'
|'sizeof'|'struct'|'switch('|'this'|'union'|'namespace'|'using'|'try'|'catch'
|'throw'|'const_cast'|'static_cast'|'dynamic_cast'|'reiznterpret_cast'
|'typeid'|'template'|'explicit'|'true'|'false'|'typename'
|'!'|'!='|'%'|'%='|'&'|'&&'|'&='|'('|'*'|'*='
|'+'|'++'|'+='|','|'-'|'--'|'-='|'->'|'...'|'/'
|'/='|'::'|'<'|'<<'|'<<='|'<='|'=='|'>'|'>='|'>>'
|'>>='|'?'|'['|'^'|'^='|'{'|'||'|'='|'~'|';';

IGNORE:
[a-zA-Z]+ // match 1-or-more upper or lowercase letters
|')'|'}'|']'
|':'|'do'|'#include'
|[ \t\r\n]
|[0-9]+|'\''|'\\'|'"'|'.h';
