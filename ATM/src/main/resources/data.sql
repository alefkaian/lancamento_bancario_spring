INSERT INTO categorias (codigo, nome, ativo) VALUES (1, 'Lazer', true);
INSERT INTO categorias (codigo, nome, ativo) VALUES (2, 'Alimentação', true);
INSERT INTO categorias (codigo, nome, ativo) VALUES (3, 'Supermercado', true);
INSERT INTO categorias (codigo, nome, ativo) VALUES (4, 'Farmácia', true);
INSERT INTO categorias (codigo, nome, ativo) VALUES (5, 'Assinaturas', true);
INSERT INTO categorias (codigo, nome, ativo) VALUES (6, 'Finanças', true);


INSERT INTO pessoas (codigo, nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES (1, 'João Silva', 'Rua do Abacaxi', '10', 'casa', 'Bairro das Frutas', '32000-050', 'São Paulo', 'SP', true);
INSERT INTO pessoas (codigo, nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES (2, 'Maria Rita', 'Rua do Sabiá', '13', 'apto 101', 'Bairro dos Pássaros', '50000-010', 'Recife', 'PB', true);
INSERT INTO pessoas (codigo, nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES (3, 'Carlos Santana', 'Rua Lofredo', '505', 'casa', 'Centro', '58000-000', 'Belo Horizonte', 'MG', true);

INSERT INTO lancamentos (codigo, descricao, data_vencimento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) VALUES (1, 'Salário mensal', '2017-06-10', 6500, 'Distribuição de lucros', 'RECEITA', 6, 1);
INSERT INTO lancamentos (codigo, descricao, data_vencimento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) VALUES (2, 'Bahamas', '2017-02-10', 100.32, 'Esperar último dia para pagamento' ,'DESPESA', 3, 2);
INSERT INTO lancamentos (codigo, descricao, data_vencimento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) VALUES (3, 'Netflix', '2017-06-10', 60, 'Débito automático', 'DESPESA', 5, 3);