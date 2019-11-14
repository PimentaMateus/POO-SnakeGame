## PROJETO	DE	UM	JOGO USANDO	PROGRAMAÇÃO	ORIENTADA	A	OBJETOS
1. O	jogo	ocorre	em	um	território	retangular cujas	dimensões	podem	ser	
modificadas	a	qualquer	momento pelo	usuário.
2. Há	duas	classes A	e	B de	objetos	que	se	movimentam	dentro	do	território:
a. A	cada	instante,	há	uma	quantidade	qualquer	de	objetos	da	classe
A.
b. Durante	todo	o	jogo,	há	somente	um	objeto	da	classe B,	o	qual	
representa	o	jogador.
3. Todo	objeto	pode	se movimentar	por	todo	o	território,	mas	nunca	pode
sair	do	território.
a. Um	objeto	da	classe A movimenta-se constantemente,	seguindo	
algum	padrão	de	movimento	(por	exemplo,	em	diagonal).
b. O objeto da	classe B movimenta-se de	acordo	com	eventos	
provenientes de uma	das	seguintes	fontes:
i. teclado	(por	exemplo,	setas)
ii. mouse
iii. joystick
4. Toda	colisão	entre	dois	objetos	deve	ser	detectada	e,	como	consequência,
deve	ocorrer	alguma	ação.
a. Uma	colisão	entre	o	objeto	da	classe B	(jogador)	e	um	objeto	da	
classe A	deve	ter	impacto	no	resultado	do	jogo.
b. Uma	colisão	entre	dois	objetos	da	classe	A	deve ter	impacto	nos	
próprios	objetos.
5. Deve	haver	uma	regra	para	o	término	do	jogo.
6. Quando	o	jogo	termina,	deve	ser	exibida	a	pontuação	do	jogador.
7. Devem	ser	fornecidos	externamente os	seguintes	parâmetros	para	a	
execução	do	jogo:
a. Tamanho	inicial	do	território
b. Ritmo	do	jogo
c. Quantidade	de	objetos da	classe	A	criados	durante	o	jogo
d. Pontuação	máxima	permitida
8. As	classes	A	e	B	devem	ser	derivadas	de	uma	mesma	classe abstrata C.
9. A	classe	C	deve	definir	um	método	abstrato,	ao	menos.
10. Deve	haver	ao	menos	uma	classe derivada	da	classe	Exception.
11. Os	parâmetros	devem	ser	configuráveis	através	de	interface	gráfica	
baseada	em	formulário	e	devem	ser	armazenados	como	objetos	
persistentes.