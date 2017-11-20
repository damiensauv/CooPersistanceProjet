create table coo_tp_personne (
id number(20) primary key,
nom varchar(50),
prenom varchar(50),
eval varchar(50),
idPere number(20),
FOREIGN KEY (idPere) REFERENCES coo_tp_personne(id)
);

INSERT INTO coo_tp_personne(id,nom,prenom,eval) VALUES (1,'sauvalle','damien','');
INSERT INTO coo_tp_personne(id,nom,prenom,eval, ID_PERE) VALUES (2,'parmentier','arthur','Bien', 1);
INSERT INTO coo_tp_personne(id,nom,prenom,eval, ID_PERE) VALUES (3,'bruce','wayne','Sombre','1');
INSERT INTO coo_tp_personne(id,nom,prenom,eval, ID_PERE) VALUES (4,'clark','kent','Bien','2');
