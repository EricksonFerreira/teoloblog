INSERT INTO funcao (nome) VALUES ('ADMINISTRADOR');
INSERT INTO funcao (nome) VALUES ('GERENTE');
INSERT INTO funcao (nome) VALUES ('NORMAL');

INSERT INTO autor (nome,descricao,imagem) VALUES ('Calvino','Teólogo calvinista','calvino.svg');
INSERT INTO autor (nome,descricao,imagem) VALUES ('Arminio','Teólogo arminiano','arminio.svg');

INSERT INTO etiqueta (nome) VALUES ('Ateísmo');
INSERT INTO etiqueta (nome) VALUES ('Criacionismo');

INSERT INTO USUARIO (NOME,PASSWORD,USERNAME,FUNCAO_ID) VALUES ('ERICKSON','123','ERICKSON',1);
INSERT INTO USUARIO (NOME,PASSWORD,USERNAME,FUNCAO_ID) VALUES ('ERINSTON','456','ERINSTON',2);
INSERT INTO USUARIO (NOME,PASSWORD,USERNAME,FUNCAO_ID) VALUES ('LUIGI','789','LUIGI',3);

INSERT INTO publicacao (titulo,texto,data,autor_codigo) VALUES ('Lorem4','Lorem Ipsum4','10/10/2010',1);
INSERT INTO publicacao (titulo,texto,data,autor_codigo) VALUES ('Lorem3','Lorem Ipsum3','10/10/2010',2);

INSERT INTO comentario (texto,data,usuario_id,publicacao_id) VALUES ('Lorem1','Lorem Ipsum1',1,1);
INSERT INTO comentario (texto,data,usuario_id,publicacao_id) VALUES ('Lorem2','Lorem Ipsum2',1,2);

INSERT INTO referencia (texto,publicacao_codigo) VALUES ('Lorem4',1);
INSERT INTO referencia (texto,publicacao_codigo) VALUES ('Lorem3',2);

INSERT INTO etiqueta_publicacao (etiqueta_codigo,publicacao_codigo) VALUES (1,1);
INSERT INTO etiqueta_publicacao (etiqueta_codigo,publicacao_codigo) VALUES (2,2);