CREATE TABLE bon_entree ( -- exemple : BESG202311121243214 (SG+heure en timestamp)
    -- identifiant_b_e VARCHAR(25),
    numero_b_e VARCHAR(100),
    libelle_bon_entree VARCHAR(255),
    date_bon_entree DATE,
    observation_bon_entree VARCHAR(255),
    -- identifiant_b_l VARCHAR(25),
    date_enregistrement TIMESTAMP,
    code_corps_agent VARCHAR(3),
    nom du prestataire
    PRIMARY KEY (identifiant_b_e),
    CONSTRAINT FK_bon_entree_bordereau_livraison FOREIGN KEY (identifiant_b_l) REFERENCES bordereau_livraison(identifiant_b_l)
);
message : le be est saisi

saisi article
griser : id be

page ecrire le nombre de l''article sur la page

CREATE TABLE article_bon_entree (
    identifiant_b_e VARCHAR(25),
    code_article_bon_entree INT, 

    -- code_type_objet VARCHAR(5),
    -- libelle_article_bon_entree VARCHAR(255), sauf pour vehicule

    -- quantite_entree INT, sauf pour vehicule et arm
    date_enregistrement TIMESTAMP,
    matricule_agent VARCHAR(7),
    code_corps_agent VARCHAR(3),
    
    PRIMARY KEY (identifiant_b_e, code_article_bon_entree),
    CONSTRAINT FK_article_bon_entree_bon_entree FOREIGN KEY (identifiant_b_e) REFERENCES bon_entree(identifiant_b_e),
    CONSTRAINT FK_article_bon_entree_type_objet FOREIGN KEY (code_type_objet) REFERENCES type_objet(code_type_objet),
    CONSTRAINT FK_article_bon_entree_agent FOREIGN KEY (matricule_agent, code_corps_agent) REFERENCES agent(matricule_agent, code_corps_agent)
);





UTILISATEUR
mot de passe
matricule_agent dans la table agent : prenom, nom ...
code_section qui peut etre 'null' le directeur qui est un agent : pas de section (bureau)




interface de saisi de prestataire (prestation de service) : liste secteur + 



bon_entree : colonne prestataire (liste) sauf arme 
    identifiant_b_l recopie


article_bon_entree :
    id be à griser au debut
    nombre article avant sa saisi
    pour vehicule, pas afficher libelle_article_bon_entree (concat : marque + model + n° serie)


CREATE TABLE secteur_activite ( -- armement, mecanique, mobilier
    code_secteur_activite VARCHAR(10),
    libelle_secteur_activite VARCHAR(255),
    PRIMARY KEY (code_secteur_activite)
);

CREATE TABLE prestataires (
    ninea VARCHAR(20),
    raison_sociale VARCHAR(512),
    numero_telephone INT,
    adresse VARCHAR(512),
    PRIMARY KEY (ninea)
);

CREATE TABLE prestataires_secteur (
    ninea VARCHAR(20),
    code_secteur_activite VARCHAR(10),
    PRIMARY KEY (ninea, code_secteur_activite),
    CONSTRAINT FK_prestataires_secteur_prestataires FOREIGN KEY (ninea) REFERENCES prestataires(ninea),
    CONSTRAINT FK_prestataires_secteur_secteur_activite FOREIGN KEY (code_secteur_activite) REFERENCES secteur_activite(code_secteur_activite)
);
 









bordereau_livraison prestataire







