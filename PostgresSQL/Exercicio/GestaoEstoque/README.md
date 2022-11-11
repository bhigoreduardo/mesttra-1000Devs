De acordo com a estrutura do banco de dados abaixo elabore as Regras solicitadas: 
Seguem as descrições das tabelas:

*Produto (Codigo_P, Descricao, Quantidade, Valor_Unit, EstoqueMinimo);
 
*Cliente (Codigo_C, Nome, Endereco, CPF);

*Fornecedor (Codigo_F, Razao_Social, CPNJ);

*Compra (Codigo_Comp, Data_C, Codigo_F, Valor_Total);

*Itens_Compra (Codigo_Comp, Codigo_P, Quantidade, Valor_Unit);

*Venda (Codigo_V, Data_V, Codigo_C, Valor_Total, Parcelas);

*Itens_Venda (Codigo_V, Codigo_P, Quantidade, Valor_Unit);

*Historico_Valor_Produto (Codigo_H, Codigo_P, Valor_Unit, Data_Alteracao);

*Pagamento (Codigo_V, Nro_Parcela, Data_Venc, Data_Pagto, Valor_Parc, Valor_Pago);


REGRAS:

Produtos não devem aceitar Valor_Unit menor que 0 (zero);
Produtos ao atingirem Quantidade inferior ao EstoqueMinimo devem apresentar uma mensagem informando o estoque mínimo;
Produtos não devem aceitar Quantidade menor que 0 (zero);
Compras devem acrescentar a Quantidade de Produtos ao estoque;
Valor_Total de Compra deve ser gerado automaticamente ao lançar Itens_Compra;
Valor_Total de Venda deve ser gerado automaticamente ao lançar Itens_Venda;
Parcelas em Venda deve gerar automaticamente lançamentos em Pagamento de acordo com a quantidade de parcelas solicitadas;
Itens_Venda deve reduzir Quantidade de Produto, caso a quantidade em estoque não seja suficiente, não deve aceitar o lançamento, informando não existir produtos suficientes em estoque;
Itens_Venda deve buscar Valor_Unit de Produto;
Ao excluir Itens_Venda ou Itens_Compra, os valores de Venda e Compra devem ser atualizados;
A cada alteração no Valor_Unit de Produto, deve ser armazenado no Historico_Valor_Produto;
