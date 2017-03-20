/**
 * Author:  Paulo
 * Created: 19/03/2017
 */

CREATE TABLE reclamacao
(
    id INTEGER NOT NULL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(90) NOT NULL,
    descricao VARCHAR(90) NOT NULL,
    status INTEGER NOT NULL DEFAULT 0
);