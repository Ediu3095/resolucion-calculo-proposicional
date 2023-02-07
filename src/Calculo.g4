grammar Calculo;

formula
: ATOMO                                     #atomo
| CONECTIVO_UNARIO formula                  #unario
| '(' formula conectivo_binario formula ')' #binario
| '(' formula (AND formula)+ ')'            #conjuncion
| '(' formula (OR  formula)+ ')'            #disyuncion
;

conectivo_binario
: AND
| OR
| IMPLIES
| IFF
| XOR
| NAND
| NOR
;

AND
: '∧'
;
OR
: '∨'
;
IMPLIES
: '→'
;
IFF
: '↔'
;
XOR
: '⊕'
;
NAND
: '|'
;
NOR
: '↓'
;

CONECTIVO_UNARIO
: '¬'
;

ATOMO
: [a-z]
;

LC
: ';' ~[\n\r]* -> skip
;

WS
: [ \t\n\r]+ -> skip
;
