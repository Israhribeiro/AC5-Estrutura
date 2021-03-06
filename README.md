# AC5-Estrutura de estrutura

## Integrantes do grupo:

*  Erick Samuel Salazar do Carmo RA 1905066
*  Erik Danton Ozzetti Martins RA 1905319
*  Guilherme Augusto da Silva Costa RA 1905030
*  Gustavo Matoso de Oliveira RA 1905058
*  Israel Tavares Ribeiro RA 1905029
*  Weslley Schunemann RA 1904751



Tarefa 17: exercícios dos slides de 81 a 84

- [x] 2. Qual é a saída (desenho do heap) da seguinte sequência de métodos do TAD fila de prioridade: insert(5, A), insert(4, B), insert(7, I), insert(1, D), removeMin( ), insert(3, J), insert(6, L), removeMin( ), removeMin( ), insert(8, G), removeMin( ), insert(2, H),removeMin(),removeMin()?

![Untitled Diagram drawio](https://user-images.githubusercontent.com/59938696/142961689-e236a85f-099c-4532-90ed-22a9000c6624.png)
- [x] 3. Um aeroporto quer simular o tráfego aéreo com eventos como decolagens e pousos. Os eventos têm um time-stamp com a hora em que o evento acontece. O simulador deve realizar eficientemente as duas operações fundamentais a seguir:

   • inserir um evento com um dado time-stamp (ou seja, inserir um evento futuro);

   • extrair o evento com menor time-stamp (ou seja, determinar o próximo evento a processar); 

     Que estrutura de dados você usaria para suportar essas operações? Justifique sua resposta.

   R: A melhor estrutura para se usar é fila de prioridade, pois poderia utilizar a chave como o timeStamp e com a função removeMin() é possível extrair o menor timeStamp e obter o evento.

- [x] 4. Onde pode estar armazenado o elemento com a maior chave em um heap?


     R: No último nível do heap ou no primeiro nodo

- [x] 5. Seja T uma árvore binária completa em que **v** armazena a entrada (**p**(**v**),0), onde **p**(**v**) é o número do nível de **v**. A árvore T é um heap? Justifique sua resposta.


     R: Não, pois o local onde p(v) é guardado geralmente fica a chave do heap e ,caso haja itens no mesmo nível,causaria um conflito de chaves.

6. Explique por que não se considera o caso do filho direito de **r** ser interno e o filho esquerdo ser externo quando se descreve o processo do down-heap bubbling.

- [x] 7. Existe um heap **T** armazenando sete elementos diferentes de forma que um caminhamento prefixado de **T** apresente os elementos de **T** em ordem crescente ou decrescente? E se for um caminhamento interfixado? E pós -fixado? Se sim, apresente um exemplo; caso contrário, justifique.
	
	 pós fixado
	 
	 ![Arvore](17pos7.jpg)
	 
	infixado
	
	![Arvore](17in7.jpg)
	
	prefixado
	
	![Arvore](17pre7.jpg)
	
	
- [x] 8. Considere **H** um heap que armazena 15 elementos usando uma representação de arranjo de uma árvore binária completa. Qual é a sequência de índices da lista de arranjo que são visitados no caminhamento prefixado de H? E qual é a sequência em um caminhamento interfixado? E em um caminhamento pós-fixado?

	R: 
	
	 prefixado - 1,2,4,8,9,5,10,11,3,6,12,13,7,14,15

	 interfixado - 8,4,9,2,10,5,11,1,12,6,13,3,14,7,15

	 posfixado - 8,9,4,10,11,5,2,12,13,6,14,15,7,3,1

- [x] 9. Bill afirma que um caminhamento prefixado em um heap listará as chaves em ordem não-decrescente. Apresente um exemplo de um heap que prove que ele está errado.
	
	 ![Arvore](tarefa17exer9.jpg)

- [x] 10. Hillary afirma que um caminhamento pós-fixado em um heap listará as chaves em ordem não-crescente. Apresente um exemplo de um heap que prove que ela está errada.

	 ![Arvore](tarefa17exer10.jpg)

11. Apresente todos os passos do algoritmo para remover a chave 16 do heap abaixo:

12. [x] Mostre como implementar o TAD pilha usando apenas uma fila de prioridade e uma variável inteira adicional. 

13. [x] Mostre como implementar o TAD fila (padrão) usando apenas uma fila de prioridade e uma variável inteira adicional.

Tarefa 18: exercícios dos slides 84 a 85

- [x] 1. Qual dos esquemas de tratamento de colisão de tabela hash consegue tolerar um fator de carga superior a 1 e qual não consegue?

     R: O hashing duplo consegue tolerar um  fator de  carga superior a 1  e o que não  eo fator de carga  eo endereçamento aberto.
     
- [x] 2. Qual seria um bom código hash para um número de identificação de veículo que é uma cadeia de caracteres representando números e letras no formato “9X9XX99X9XX999999,” onde um “9” representa um dígito e um “X” representa uma letra?

     R: O numero  mais indicado é 324564517.

- [x] 3. Desenhe a tabela hash com 11 elementos, que resulta a partir do uso da função de hash, h(i) = (3i + 5) mod 11, para colocar as chaves 12, 44, 13, 88, 23, 94, 11, 39, 20, 16 e 5, assumindo que as colisões serão tratadas por encadeamento.
    R: 
    ![1](https://user-images.githubusercontent.com/59938696/142788964-3d2b9789-7761-474e-85e5-c49d2d7b9a4c.png)
- [x] 5. Qual será o resultado do exercício 3 se assumirmos que as colisões serão tratadas por teste linear?
    R:
 ![2](https://user-images.githubusercontent.com/59938696/142791543-2c6876bd-2f1a-4621-a2af-cdc1aee3398e.png)
7. Mostre o resultado do exercício 3 assumindo que as colisões são tratadas por teste quadrático, até o ponto em que o método falha.
8. Qual é o resultado do exercício 3 assumindo que as colisões são tratadas por hashing duplo usando uma função hash secundária h’(k)=7 (k mod 7)?
9. Forneça uma descrição em pseudocódigo da inserção em uma tabela hash que usa teste quadrático para resolver colisões, assumindo que se usa o truque de substituir elementos deletados com um objeto indicando “item desativado”.
- [x] 10. Pesquise sobre o TAD Dicionário e descreva a principal diferença desse TAD com o TAD Mapa.
      
     R: Mapas possuem chaves únicas, entretanto, Dicionários podem possuem vários valores para uma mesma chave.

Tarefa 19: exercícios do slide 16

Tarefa 20: exercícios do slide 29

 - [x] 2. Inserindo-se as entradas (1,A), (2,B), (3,C), (4,D) e (5,E), nessa ordem, em uma árvore de pesquisa binária inicialmente vazia, qual será sua aparência?
  
  	![Arvore](20exer2.png)
 
 3. Define-se uma árvore binária de pesquisa em que as chaves iguais à chave do nodo podem estar ou à esquerda ou à direita da subárvore deste nodo. Suponha que se altere a definição na qual restringimos chaves iguais na subárvore à direita. Qual seria a subárvore de uma árvore binária de pesquisa que contenha somente chaves iguais, como visto neste caso?
 - [x] 4. Insira, em uma árvore binária de pesquisa vazia, itens com as chaves 30, 40, 24, 58, 48, 26, 11, 13 (nesta ordem). Desenhe a árvore após cada inserção.

	
  	![Arvore](vinteponto4.jpg)
	
 - [x] 5. Quantas árvores binárias de pesquisas diferentes podem armazenar as chaves {1,2,3}?

     R:6 Árvores binárias de pesquisas.
	
- [x] 6. O professor Amongus afirma que a ordem na qual um conjunto fixo de itens é inserido em uma árvore binária de pesquisa não interessa — sempre resulta na mesma árvore. Apresente um pequeno exemplo que prove que ele está errado.

     5,3,8,7

	![Arvore](tarefa20exer6part1.png)
	
	
     7,8,3,5
     
     ![Arvore](tarefa20exer6part2.png)
	

Tarefa 21: exercícios dos slides 39 e 40

- [x] 2. Inserindo-se as entradas (1,A), (2,B), (3,C), (4,D) e (5,E), nessa ordem, em uma árvore AVL inicialmente vazia, qual será sua aparência?
	![Arvore](21exer2.png)

- [x] 3. O professor Amongus afirma que a ordem na qual um conjunto fixo de itens é inserido em uma árvore AVL não interessa — sempre resulta na mesma árvore. Apresente um pequeno exemplo que prove que ele está errado.
	
	13,7,5,8,3

	![Arvore](vinteumponto3_1.jpg)
	
	8,3,5,13,7
	
	![Arvore](vinteumponto3_2.jpg)

- [x] 4. Desenhe a árvore AVL resultante da inserção de um elemento com chave 52 na árvore AVL abaixo.
	![Arvore](tarefa21exer4.png)
- [x] 5. Desenhe a árvore AVL resultante da remoção de um elemento com chave 62 na árvore AVL após a inserção da chave 52 na árvore AVL abaixo.

	![Arvore](tarefa21exer5.png)
